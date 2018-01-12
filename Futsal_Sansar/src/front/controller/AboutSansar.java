package front.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AboutDao;
import dao.AdsDao;
import dao.ContactDao;
import dao.HomeDao;

/**
 * Servlet implementation class AboutSansar
 */
@WebServlet("/AboutSansar")
public class AboutSansar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AboutSansar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("cw", ContactDao.selectWeb("select * from contactweb"));
		request.setAttribute("ac", HomeDao.selectContent("select * from aboutcontent"));
		request.setAttribute("ad", AdsDao.select("select * from ads"));
		request.setAttribute("ic", AboutDao.selectImg("select * from imagecontent"));
		request.setAttribute("lc", AboutDao.selectLeft("select * from aboutleft"));
		request.setAttribute("rc", AboutDao.selectRight("select * from aboutright"));
		request.setAttribute("cc", ContactDao.selectContent("select * from contact"));
		RequestDispatcher rd = request.getRequestDispatcher("about.jsp");
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
