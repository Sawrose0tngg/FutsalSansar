package image.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowAdmin
 */
@WebServlet("/Ad")
public class Ads extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Ads() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int status = 1;
		byte[] imgData = null;
		String sql = null;
		if (request.getParameter("location").equals("About")) {
			sql = "select image from ads where active='" + status + "' and id='" + request.getParameter("id") + "'";
		} else if (request.getParameter("location").equals("Book")) {
			sql = "select image from ads where active='" + status + "' and id='" + request.getParameter("id") + "'";
		} else if (request.getParameter("location").equals("Event")) {
			sql = "select image from ads where active='" + status + "' and id='" + request.getParameter("id") + "'";
		}
		
		imgData = RetrieveImage.getImage(sql);
		response.setContentType("image/jpg");
		OutputStream o1 = response.getOutputStream();
		o1.write(imgData);
		o1.flush();
		o1.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
