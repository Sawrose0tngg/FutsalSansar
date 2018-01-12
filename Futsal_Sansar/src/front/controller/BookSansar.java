package front.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdsDao;
import dao.BookDao;
import dao.ContactDao;

/**
 * Servlet implementation class BookSansar
 */
@WebServlet("/BookSansar")
public class BookSansar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSansar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("cw", ContactDao.selectWeb("select * from contactweb"));
		request.setAttribute("bc", BookDao.selectContent("select * from bookcontent"));
		request.setAttribute("book", BookDao.selectLocalBook("select * from book"));
		request.setAttribute("mb", BookDao.selectMemberBook("select * from member"));
		request.setAttribute("ad", AdsDao.select("select * from ads"));
		request.setAttribute("rc", BookDao.selectRight("select * from bookright"));
		request.setAttribute("nc", BookDao.selectNotice("select * from notice"));
		request.setAttribute("cc", ContactDao.selectContent("select * from contact"));
		RequestDispatcher rd = request.getRequestDispatcher("book.jsp");
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
