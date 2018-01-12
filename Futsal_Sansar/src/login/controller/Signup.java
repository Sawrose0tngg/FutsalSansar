package login.controller;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.CostDao;
import database.connection.CreateDbConnection;
import model.CostModel;
import time.calculation.TimeEvaluate;

@WebServlet("/Signup")
@MultipartConfig(maxFileSize = 16177215)
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InputStream inputStream = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public Signup() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<String> questionList = new ArrayList<>();
		questionList.add("What is the first name of the person you first kissed?");
		questionList.add("What is the last name of the teacher who gave you your first failing grade?");
		questionList.add("What was your first job?");
		questionList.add("What is your dream?");
		questionList.add("In what city or town does your nearest sibling live?");
		questionList.add("What is your pet name?");

		ArrayList<String> memberType = new ArrayList<>();
		memberType.add("Weekly");
		memberType.add("Monthly");
		memberType.add("Yearly");

		String date = sdf.format(new Date(new Date().getTime()));

		request.setAttribute("ql", questionList);
		request.setAttribute("ml", memberType);
		request.setAttribute("date", date);
		RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
		rd.forward(request, response);

	}

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		Connection conn = CreateDbConnection.createConnection();

		Statement stmt;
		String pass = null;
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("cpassword");
		String mobile = request.getParameter("contact");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		String gender = request.getParameter("gender");
		String member = request.getParameter("member");
		Part img = request.getPart("image");
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

		if (img != null) {
			inputStream = img.getInputStream();
		}
		String sql = "select email from member where email = '" + email + "'";
		if (!password.equals(cpassword)) {
			request.setAttribute("message", "Password Doesn't Match??");
			request.getRequestDispatcher("loginfail.jsp").forward(request, response);
		} else {
			pass = encryption(password);
		}
		try {

			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				request.setAttribute("message", "Member already exists???");
				request.getRequestDispatcher("loginfail.jsp").forward(request, response);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
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
		String query = "select * from member where startTime = '" + time + "' order by startTime asc";
		try {
			new CreateDbConnection();
			stmt = conn.createStatement();
			ResultSet rs1 = stmt.executeQuery(query);
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
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		int totalCash = 10000;
		if (flag == 1) {
			if (inputStream.toString().contains("FileInputStream")) {
				try {
					PreparedStatement pst = conn.prepareStatement(
							"insert into member(name,email,password,phone,question,answer,gender,memberType,startDate,startTime,payment,totalCost,photo,notice) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					pst.setString(1, name);
					pst.setString(2, email);
					pst.setString(3, pass);
					pst.setString(4, mobile);
					pst.setString(5, question);
					pst.setString(6, answer);
					pst.setString(7, gender);
					pst.setString(8, member);
					pst.setString(9, date);
					pst.setString(10, time);
					pst.setInt(11, Integer.parseInt(payment));
					pst.setInt(12, totalCost);
					pst.setBlob(13, inputStream);
					pst.setString(14, "");

					int row = pst.executeUpdate();
					if (row > 0)
						System.out.println("success saved...");
					else
						System.out.println("Saved Failed...");
					inputStream.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("message", "Successfully Saved??");
				request.getRequestDispatcher("loginfail.jsp").forward(request, response);
			}

		} else {
			request.setAttribute("message", "Failed?? Please Check Date/Time and Try Again");
			request.getRequestDispatcher("loginfail.jsp").forward(request, response);
		}
	}

	public static String encryption(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(password.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashText = number.toString(16);
			while (hashText.length() < 32) {
				hashText = "0" + hashText;
			}
			password = hashText;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return password;
	}

}
