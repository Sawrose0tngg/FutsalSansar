package front.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.CostDao;
import database.connection.CreateDbConnection;
import login.controller.Signup;
import model.CostModel;
import time.calculation.TimeEvaluate;

/**
 * Servlet implementation class ChangeProfile
 */
@WebServlet("/ChangeProfile")
@MultipartConfig(maxFileSize = 16177215)
public class ChangeProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InputStream inputStream = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public ChangeProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Statement stmt = null;
		String sql = null;
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String newPassword = request.getParameter("newpassword");
		String cpassword = request.getParameter("cpassword");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String member = request.getParameter("memberType");
		String payment = request.getParameter("pay");
		String time = request.getParameter("time");

		int paid = 0;

		Connection conn = CreateDbConnection.createConnection();
		if (request.getParameter("id") != null) {
			int id = Integer.parseInt(request.getParameter("id"));

			try {
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from member where id = '" + id + "'");
				if (rs.next()) {
					paid = rs.getInt("payment");
					if (password != null) {
						if (!rs.getString("password").equals(Signup.encryption(password))) {
							request.setAttribute("message", "Password Doesn't Match??");
							request.setAttribute("url", "../../../../FutsalSansar/ChangeProfile?id=" + id);
							request.getRequestDispatcher("errorpage.jsp").forward(request, response);
						}
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			Part img = request.getPart("image");
			if (img != null) {
				inputStream = img.getInputStream();
				if (inputStream.toString().contains("FileInputStream")) {
					try {
						PreparedStatement pst = conn.prepareStatement("update member set photo = ? where id = ?");
						pst.setBlob(1, inputStream);
						pst.setInt(2, id);
						int row = pst.executeUpdate();
						if (row > 0)
							response.sendRedirect("../../../../FutsalSansar/LoginControl?id=" + id + "&link=profile");
						else
							System.out.println("Saved Failed...");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			} else {
				if (name != null) {
					sql = "update member set name = '" + name + "' where id = '" + id + "'";
				} else if (gender != null) {
					sql = "update member set gender = '" + gender + "' where id = '" + id + "'";
				} else if (phone != null) {
					sql = "update member set phone = '" + phone + "' where id = '" + id + "'";
				} else if (member != null && payment != null) {
					int totalCost = 0;
					ArrayList<CostModel> costList = CostDao.select("select * from cost where id = 1");
					if (member.equals("Weekly")) {
						totalCost = costList.get(0).getWeek();
					} else if (member.equals("Monthly")) {
						totalCost = costList.get(0).getMonth();
					} else if (member.equals("Yearly")) {
						totalCost = costList.get(0).getYear();
					}
					if (request.getParameter("idd") != null) {
						int idd = Integer.parseInt(request.getParameter("idd"));
						int alreadyPaid = 0;
						try {
							ResultSet rs = stmt.executeQuery("select * from secondarymember where id = '" + idd + "'");
							if (rs.next()) {
								alreadyPaid = rs.getInt("payment");
							}
						} catch (SQLException e) {
							e.printStackTrace();
						}
						int temp = alreadyPaid + Integer.parseInt(payment);
						sql = "update secondarymember set memberType = '" + member + "', payment='" + temp
								+ "', totalCost = '" + totalCost + "' where id = '" + idd + "'";
					} else if (request.getParameter("iddd") != null) {
						int idd = Integer.parseInt(request.getParameter("iddd"));
						int temp = paid + Integer.parseInt(payment);
						sql = "update member set memberType = '" + member + "', payment='" + temp + "', totalCost = '"
								+ totalCost + "' where id = '" + idd + "'";
					}

				} else if (email != null && password != null) {
					sql = "update member set email = '" + email + "' where id = '" + id + "' and password = '"
							+ Signup.encryption(password) + "'";
				} else if (question != null && answer != null && password != null) {
					sql = "update member set question = '" + question + "', answer = '" + answer + "' where id = '" + id
							+ "' and password = '" + Signup.encryption(password) + "'";
				} else if (newPassword != null && cpassword != null && password != null) {
					if (!newPassword.equals(cpassword)) {
						request.setAttribute("message", "Password Doesn't Match??");
						request.setAttribute("url", "../../../../FutsalSansar/LoginControl?link=profile");
						request.getRequestDispatcher("errorpage.jsp").forward(request, response);
					} else {
						sql = "update member set password = '" + Signup.encryption(cpassword) + "' where id = '" + id
								+ "' and password = '" + Signup.encryption(password) + "'";
					}
				} else if (time != null) {
					long temp = 0;
					String mem = request.getParameter("member");
					String date = request.getParameter("date");
					int idd = Integer.parseInt(request.getParameter("mid"));
					int flag = 0;
					String duration = null, durationdb = null;
					if (mem.equals("Weekly")) {
						duration = "7";
					} else if (mem.equals("Monthly")) {
						duration = "30";
					} else if (mem.equals("Yearly")) {
						duration = "365";
					}
					try {
						stmt = conn.createStatement();
						ResultSet rs1 = stmt
								.executeQuery("select startDate,startTime,memberType from member where startTime = '"
										+ time + "' order by startTime asc");
						if (rs1.next()) {
							while (rs1.next()) {
								if (rs1.getString("memberType").equals("Weekly")) {
									durationdb = "7";
								} else if (rs1.getString("memberType").equals("Monthly")) {
									durationdb = "30";
								} else if (rs1.getString("memberType").equals("Yearly")) {
									durationdb = "365";
								}
								Date date1 = null;
								long d1 = 0, d2 = 0;
								try {
									date1 = sdf.parse(rs1.getString("startDate"));
									d1 = date1.getTime();
									d2 = d1 + Integer.parseInt(durationdb) * 86400000;
								} catch (ParseException e) {
									e.printStackTrace();
								}
								if (temp == 0) {
									temp = d1;
								}
								if (TimeEvaluate.dateCalculate1(date, duration, rs1.getString("startDate"),
										durationdb)) {
									flag = 0;
									break;
								} else if (TimeEvaluate.dateCalculate2(date, duration, temp,
										rs1.getString("startDate"))) {
									flag = 0;
									break;
								} else {
									flag = 1;
								}
								temp = d2;
							}
						} else {
							flag = 1;
						}
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
					if (flag == 1) {
						sql = "update member set startTime = '" + time + "' where id = '" + idd + "'";
					} else {
						request.setAttribute("message", "This Book Isn't Available; Alreadt Booked??");
						request.setAttribute("url", "../../../../FutsalSansar/LoginControl?id=" + id + "&link=profile");
						request.getRequestDispatcher("errorpage.jsp").forward(request, response);
					}
				}
				try {
					stmt = conn.createStatement();
					int row = stmt.executeUpdate(sql);
					if (row == 1) {
						request.setAttribute("message", "Successfully Changed??");
						request.setAttribute("url", "../../../../FutsalSansar/LoginControl?id=" + id + "&link=profile");
						request.getRequestDispatcher("errorpage.jsp").forward(request, response);
					} else {
						request.setAttribute("message", "This Book Isn't Available; Alreadt Booked??");
						request.setAttribute("url", "../../../../FutsalSansar/LoginControl?id=" + id + "&link=profile");
						request.getRequestDispatcher("errorpage.jsp").forward(request, response);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			// response.sendRedirect("../../../../FutsalSansar/LoginControl?id=" + id +
			// "&link=profile");
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			request.getRequestDispatcher("../../../../FutsalSansar/LoginControl?link=home").forward(request, response);
		}

	}
}
