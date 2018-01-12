package front.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AboutDao;
import dao.ContactDao;
import dao.HomeDao;

/**
 * Servlet implementation class HomeSansar
 */
@WebServlet("/HomeSansar")
public class HomeSansar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeSansar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("hc", HomeDao.select());
		request.setAttribute("cw", ContactDao.selectWeb("select * from contactweb"));
		request.setAttribute("wc", HomeDao.selectWelcome("select * from homewelcome"));
		request.setAttribute("mc", HomeDao.selectContent("select * from homecontent"));
		request.setAttribute("ac", AboutDao.selectRight("select * from homeadmin"));
		request.setAttribute("cc", ContactDao.selectContent("select * from contact"));
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
