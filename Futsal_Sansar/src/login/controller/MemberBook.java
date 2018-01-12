package login.controller;

import java.io.IOException;
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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CostDao;
import database.connection.CreateDbConnection;
import model.CostModel;
import time.calculation.TimeEvaluate;

/**
 * Servlet implementation class MemberBook
 */
@WebServlet("/MemberBook")
public class MemberBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection conn = CreateDbConnection.createConnection();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Statement stmt;
		int mid = Integer.parseInt(request.getParameter("id"));
		String member = request.getParameter("member");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String payment = request.getParameter("pay");
		int totalCost = 0;
		ArrayList<CostModel> costList = CostDao.select("select * from cost where id = 1");
		if (member.equals("Weekly")) {
			totalCost = costList.get(0).getWeek();
		} else if (member.equals("Monthly")) {
			totalCost = costList.get(0).getMonth();
		} else if (member.equals("Yearly")) {
			totalCost = costList.get(0).getYear();
		}

		long temp = 0;
		int flag = 0;
		String duration = null, durationdb = null;
		if (member.equals("Weekly")) {
			duration = "7";
		} else if (member.equals("Monthly")) {
			duration = "30";
		} else if (member.equals("Yearly")) {
			duration = "365";
		}
		String query = "select startDate,startTime,memberType from member where startTime = '" + time
				+ "' order by startTime asc";
		try {
			new CreateDbConnection();
			stmt = conn.createStatement();
			ResultSet rs1 = stmt.executeQuery(query);
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
					long d1, d2 = 0;
					try {
						date1 = sdf.parse(rs1.getString("startDate"));
						d1 = date1.getTime();
						d2 = d1 + Integer.parseInt(duration) * 86400000;
					} catch (ParseException e) {
						e.printStackTrace();
					}

					if (temp == 0) {
						temp = d2;
					}
					if (TimeEvaluate.dateCalculate1(date, duration, rs1.getString("startDate"), durationdb)) {
						flag = 0;
						break;
					} else if (TimeEvaluate.dateCalculate2(date, duration, temp, rs1.getString("startDate"))) {
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
			String sql = "select startDate,startTime,memberType from secondarymember where startTime = '" + time
					+ "' order by startTime asc";
			try {
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {
					while (rs.next()) {
						if (rs.getString("memberType").equals("Weekly")) {
							durationdb = "7";
						} else if (rs.getString("memberType").equals("Monthly")) {
							durationdb = "30";
						} else if (rs.getString("memberType").equals("Yearly")) {
							durationdb = "365";
						}
						Date date1 = null;
						long d1 = 0, d2 = 0;
						try {
							date1 = sdf.parse(rs.getString("startDate"));
							d1 = date1.getTime();
							d2 = d1 + Integer.parseInt(duration) * 86400000;
						} catch (ParseException e) {
							e.printStackTrace();
						}
						if (temp == 0) {
							temp = d1;
						}
						if (TimeEvaluate.dateCalculate1(date, duration, rs.getString("startDate"), durationdb)) {
							flag = 0;
							break;
						} else if (TimeEvaluate.dateCalculate2(date, duration, temp, rs.getString("startDate"))) {
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
		}
		if (flag == 1) {
			try {
				PreparedStatement pst = conn.prepareStatement(
						"insert into secondarymember(mId,memberType,startDate,startTime,payment,totalCost) values(?,?,?,?,?,?)");
				pst.setInt(1, mid);
				pst.setString(2, member);
				pst.setString(3, date);
				pst.setString(4, time);
				pst.setInt(5, Integer.parseInt(payment));
				pst.setInt(6, totalCost);

				int row = pst.executeUpdate();
				if (row > 0) {
					request.setAttribute("message", "Successfully Booked??");
					request.setAttribute("url", "../../FutsalSansar/LoginControl?id=" + mid + "&link=profile");
					request.getRequestDispatcher("errorpage.jsp").forward(request, response);
				} else {
					request.setAttribute("message", "Failed?? Please Check Date/Time and Try Again!!!");
					request.setAttribute("url", "../../FutsalSansar/LoginControl?id=" + mid + "&link=profile");
					request.getRequestDispatcher("errorpage.jsp").forward(request, response);
				}
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			request.setAttribute("message", "Failed?? Please Check Date/Time and Try Again!!!");
			request.setAttribute("url", "../../FutsalSansar/LoginControl?id=" + mid + "&link=profile");
			request.getRequestDispatcher("errorpage.jsp").forward(request, response);
		}
	}

}
