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
@WebServlet("/EventRight")
public class EventRight extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EventRight() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int status = 1;
		byte[] imgData = null;
		imgData = RetrieveImage.getImage("select image from eventright where active='" + status + "' and id='"
				+ request.getParameter("id") + "'");
		response.setContentType("image/jpg");
		OutputStream o = response.getOutputStream();
		o.write(imgData);
		o.flush();
		o.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
