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
import dao.EventDao;

/**
 * Servlet implementation class EventSansar
 */
@WebServlet("/EventSansar")
public class EventSansar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventSansar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("cw", ContactDao.selectWeb("select * from contactweb"));
		int page = 1;
		int noOfRecords = EventDao.getUpcominEvent();
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / 2);
		request.setAttribute("noOfPages", noOfPages);
		int id = 1;
		int idd = 1;
		if (request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id"));
		}
		for (int i = 0; i <=noOfRecords; i++) {
			if (id == i) {
				request.setAttribute("ec", EventDao.upComingEvent(id));
				break;
			}
		}
		int noOfComplete = EventDao.getCompletedEvent();
		int noOfCPages = (int) Math.ceil(noOfComplete * 1.0 / 2);
		request.setAttribute("noOfCPages", noOfCPages);

		if (request.getParameter("idd") != null) {
			idd = Integer.parseInt(request.getParameter("idd"));
		}
		for (int i = 0; i < noOfComplete; i++) {
			if (idd == i) {
				request.setAttribute("ce", EventDao.completedEvent(idd));
				break;
			}
		}
		request.setAttribute("ad", AdsDao.select("select * from ads"));
		request.setAttribute("rc", EventDao.selectRight("select * from eventright"));
		request.setAttribute("ic", EventDao.selectSlider("select * from imageslider"));
		request.setAttribute("today", BookDao.selectRecentEvent("select * from book"));
		request.setAttribute("yesterday", BookDao.selectYesterdayEvent("select * from book"));
		request.setAttribute("tommorrow", BookDao.selectTomorrowEvent("select * from book"));
		request.setAttribute("currentPage", page);
		request.setAttribute("cc", ContactDao.selectContent("select * from contact"));
		RequestDispatcher rd = request.getRequestDispatcher("event.jsp");
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
