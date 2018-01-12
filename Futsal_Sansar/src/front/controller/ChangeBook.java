package front.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import database.connection.SQLRequest;
import model.CostModel;
import time.calculation.TimeEvaluate;

/**
 * Servlet implementation class ChangeBook
 */
@WebServlet("/ChangeBook")
public class ChangeBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("id") != null && request.getParameter("action").equals("Delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			SQLRequest.delete("delete from book where id = '" + id + "'");
			response.sendRedirect("../../FutsalSansar/ChangeProfile?id=" + request.getParameter("idd"));

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int flag = 0;
		int testValue = 1;
		int idd = Integer.parseInt(request.getParameter("memId"));
		int id = Integer.parseInt(request.getParameter("bookId"));
		Connection conn = CreateDbConnection.createConnection();
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String duration = request.getParameter("duration");

		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			String date1 = sdf.format(now);
			Date dat = sdf.parse(date1);
			String date2 = date + " " + time;
			Date dat1 = sdf.parse(date2);
			if (dat.getTime() < dat1.getTime()) {
				String sql = "select time,duration from book where date = '" + date + "' order by time asc";
				Statement stmt = null;
				String temp = "0";
				try {
					stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while (rs.next()) {
						testValue = 0;
						if (temp == "0") {
							temp = rs.getString("time");
						}
						if (TimeEvaluate.timeCalculate(time, duration, rs.getString("time"),
								String.valueOf(rs.getInt("duration")))) {
							flag = 0;
							break;
						} else if (TimeEvaluate.timeCalculat2(time, duration, temp, rs.getString("time"))) {
							flag = 0;
							break;
						} else {
							flag = 1;
						}
						temp = rs.getString("time");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				if (testValue == 1) {
					flag = 1;
				}
				if (flag == 1) {
					int cost = 0;
					new CreateDbConnection();
					System.out.println("Hello");
					ArrayList<CostModel> costList = CostDao.select("select * from cost where id = 1");
					cost = costList.get(0).getNonmember() * Integer.parseInt(duration);

					SQLRequest.update("update book set time = '" + time + "', duration = '" + Integer.parseInt(duration)
							+ "', total = '" + cost + "' where id = '" + id + "'");

					response.sendRedirect("ChangeProfile?id=" + idd);

				} else {
					System.out.println("Bye");
					response.sendRedirect("ChangeProfile?id=" + idd);
				}
			} else {
				System.out.println("Kra");
				response.sendRedirect("ChangeProfile?id=" + idd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
