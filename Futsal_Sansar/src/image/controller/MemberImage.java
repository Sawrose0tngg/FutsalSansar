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
@WebServlet("/MemberImage")
public class MemberImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberImage() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("id") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			byte[] imgData = null;
			imgData = RetrieveImage.getImage("select photo from member where id='" + id + "'");
			response.setContentType("image/jpg");
			OutputStream o = response.getOutputStream();
			o.write(imgData);
			o.flush();
			o.close();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
