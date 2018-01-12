package payment.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CostDao;
import database.connection.CreateDbConnection;
import time.calculation.TimeEvaluate;

@WebServlet("/Payment")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Payment() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int flag = 0;
		int testValue = 1;
		if (Integer.parseInt(request.getParameter("bid")) == 1) {
			Connection conn = CreateDbConnection.createConnection();
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String date = request.getParameter("date");
			String time = request.getParameter("time");
			String pay = request.getParameter("pay");
			String duration = request.getParameter("duration");

			int cost = CostDao.select_Cost("select nonmember from cost where id = 1");
			int total = Integer.parseInt(duration) * cost;
			System.out.println(cost);

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

						new CreateDbConnection();
						try {
							PreparedStatement pst = conn.prepareStatement(
									"insert into book(name,email,phone,date,time,duration,pay,total) values(?,?,?,?,?,?,?,?)");
							pst.setString(1, name);
							pst.setString(2, email);
							pst.setString(3, phone);
							pst.setString(4, date);
							pst.setString(5, time);
							pst.setInt(6, Integer.parseInt(duration));
							pst.setInt(7, Integer.parseInt(pay));
							pst.setInt(8, total);
							flag = pst.executeUpdate();

						} catch (SQLException e) {
							e.printStackTrace();
						}
						response.sendRedirect("success.jsp");

					} else {
						response.sendRedirect("fail.jsp");
					}
				} else {
					response.sendRedirect("fail.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
