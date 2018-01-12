package login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.connection.SQLRequest;

/**
 * Servlet implementation class ChangeMemberPassword
 */
@WebServlet("/ChangeMemberPassword")
public class ChangeMemberPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeMemberPassword() {
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

		String pass = request.getParameter("password");
		String cpass = request.getParameter("cpassword");
		String email = request.getParameter("email");

		if (pass != null && cpass != null && email != null) {
			if (request.getParameter("password").equals(request.getParameter("cpassword"))) {
				SQLRequest.update("update member set password = '" + Signup.encryption(pass) + "' where email = '"
						+ request.getParameter("email") + "'");
				request.setAttribute("message", "Successfully Changed");
				request.setAttribute("url", "../../../../FutsalSansar/futsalsansar.jsp");
				request.getRequestDispatcher("errorpage.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "Password Doesn't Match??");
				request.setAttribute("url", "../../../../FutsalSansar/forget.jsp");
				request.getRequestDispatcher("errorpage.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("message", "Unable To Change. Please Try Again??");
			request.setAttribute("url", "../../../../FutsalSansar/forget.jsp");
			request.getRequestDispatcher("errorpage.jsp").forward(request, response);
		}

	}

}
