package payment.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.connection.CreateDbConnection;

/**
 * Servlet implementation class MemberCost
 */
@WebServlet("/MemberCost")
public class MemberCost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberCost() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Statement stmt = null;
		String week = request.getParameter("weekCost");
		String month = request.getParameter("monthCost");
		String year = request.getParameter("yearCost");
		String nonmember = request.getParameter("gameCost");

		Connection conn = CreateDbConnection.createConnection();
		String sql = null;
		if (week != null) {
			sql = "update cost set week = '" + week + "' where id = 1";
		} else if (month != null) {
			sql = "update cost set month = '" + month + "' where id = 1";
		} else if (year != null) {
			sql = "update cost set year = '" + year + "' where id = 1";
		} else if (nonmember != null) {
			sql = "update cost set nonmember = '" + nonmember + "' where id = 1";
		}
		try {
			stmt = conn.createStatement();
			stmt.execute(sql);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("../../FutsalSansar/AdminSession?link=edit-cost-content");
	}
}
