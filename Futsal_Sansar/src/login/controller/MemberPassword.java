package login.controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.connection.CreateDbConnection;

/**
 * Servlet implementation class MemberPassword
 */
@WebServlet("/MemberPassword")
public class MemberPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberPassword() {
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
		if (request.getParameter("email") != null && request.getParameter("question") != null) {
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from member where email = '" + request.getParameter("email")
						+ "' and question = '" + request.getParameter("question") + "' and answer = '"
						+ request.getParameter("answer") + "'");
				if (rs.next()) {
					request.setAttribute("email", request.getParameter("email"));
					request.getRequestDispatcher("changepassword.jsp").forward(request, response);
				} else {
					request.setAttribute("message", "Invalid Information");
					request.setAttribute("url", "../../../../FutsalSansar/forget.jsp");
					request.getRequestDispatcher("errorpage.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
