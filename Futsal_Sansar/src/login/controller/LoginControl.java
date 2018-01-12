package login.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AboutDao;
import dao.AdsDao;
import dao.BookDao;
import dao.ContactDao;
import dao.EventDao;
import dao.HeaderDao;
import dao.HomeDao;
import dao.ProfileDao;
import dao.UserDao;
import database.connection.CreateDbConnection;
import model.User;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		if (action == null) {
			User user = checkCookie(request);
			if (user == null) {
				String link = request.getParameter("link");
				if (link.equalsIgnoreCase("event")) {
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
					for (int i = 0; i <= noOfRecords; i++) {
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
					RequestDispatcher rd = request.getRequestDispatcher("event.jsp?loc=event");
					rd.forward(request, response);
				} else
					response.sendRedirect("HomeSansar");
			} else {
				UserDao dao = new UserDao();
				if (dao.login(user.getEmail(), user.getPassword())) {
					session.setAttribute("id", user.getId());
					if (request.getParameter("link") != null) {
						String temp = request.getParameter("link");
						if (temp.equalsIgnoreCase("home")) {
							request.setAttribute("hc", HomeDao.select());
							request.setAttribute("cw", ContactDao.selectWeb("select * from contactweb"));
							request.setAttribute("wc", HomeDao.selectWelcome("select * from homewelcome"));
							request.setAttribute("mc", HomeDao.selectContent("select * from homecontent"));
							request.setAttribute("ac", AboutDao.selectRight("select * from homeadmin"));
							request.setAttribute("cc", ContactDao.selectContent("select * from contact"));
							request.setAttribute("notice", HeaderDao
									.getNotification("select notice from member where id = '" + user.getId() + "'"));
							RequestDispatcher rd = request.getRequestDispatcher("home.jsp?loc=home");
							rd.forward(request, response);
						} else if (temp.equalsIgnoreCase("about")) {
							request.setAttribute("cw", ContactDao.selectWeb("select * from contactweb"));
							request.setAttribute("ac", HomeDao.selectContent("select * from aboutcontent"));
							request.setAttribute("ad", AdsDao.select("select * from ads"));
							request.setAttribute("ic", AboutDao.selectImg("select * from imagecontent"));
							request.setAttribute("lc", AboutDao.selectLeft("select * from aboutleft"));
							request.setAttribute("rc", AboutDao.selectRight("select * from aboutright"));
							request.setAttribute("cc", ContactDao.selectContent("select * from contact"));
							request.setAttribute("notice", HeaderDao
									.getNotification("select notice from member where id = '" + user.getId() + "'"));
							RequestDispatcher rd = request.getRequestDispatcher("about.jsp?loc=about");
							rd.forward(request, response);
						} else if (temp.equalsIgnoreCase("book")) {
							request.setAttribute("cw", ContactDao.selectWeb("select * from contactweb"));
							request.setAttribute("bc", BookDao.selectContent("select * from bookcontent"));
							request.setAttribute("book", BookDao.selectLocalBook("select * from book"));
							request.setAttribute("mb", BookDao.selectMemberBook("select * from member"));
							request.setAttribute("ad", AdsDao.select("select * from ads"));
							request.setAttribute("rc", BookDao.selectRight("select * from bookright"));
							request.setAttribute("nc", BookDao.selectNotice("select * from notice"));
							request.setAttribute("cc", ContactDao.selectContent("select * from contact"));
							request.setAttribute("notice", HeaderDao
									.getNotification("select notice from member where id = '" + user.getId() + "'"));
							RequestDispatcher rd = request.getRequestDispatcher("book.jsp?loc=book");
							rd.forward(request, response);
						} else if (temp.equalsIgnoreCase("event")) {
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
							for (int i = 0; i <= noOfRecords; i++) {
								if (id == i) {
									System.out.println("Hello");
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
							request.setAttribute("notice", HeaderDao
									.getNotification("select notice from member where id = '" + user.getId() + "'"));
							RequestDispatcher rd = request.getRequestDispatcher("event.jsp?loc=event");
							rd.forward(request, response);
						} else if (temp.equalsIgnoreCase("contact")) {
							request.setAttribute("cw", ContactDao.selectWeb("select * from contactweb"));
							request.setAttribute("cc", ContactDao.selectContent("select * from contact"));
							request.setAttribute("cw", ContactDao.selectWeb("select * from contactweb"));
							request.setAttribute("notice", HeaderDao
									.getNotification("select notice from member where id = '" + user.getId() + "'"));
							RequestDispatcher rd = request.getRequestDispatcher("contact.jsp?loc=contact");
							rd.forward(request, response);
						} else if (temp.equalsIgnoreCase("profile")) {
							request.setAttribute("cw", ContactDao.selectWeb("select * from contactweb"));
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							ArrayList<String> questionList = new ArrayList<>();
							questionList.add("What is the first name of the person you first kissed?");
							questionList
									.add("What is the last name of the teacher who gave you your first failing grade?");
							questionList.add("What was your first job?");
							questionList.add("What is your dream?");
							questionList.add("In what city or town does your nearest sibling live?");
							questionList.add("What is your pet name?");

							ArrayList<String> memberType = new ArrayList<>();
							memberType.add("Weekly");
							memberType.add("Monthly");
							memberType.add("Yearly");

							Connection conn = CreateDbConnection.createConnection();
							if (request.getParameter("id") != null) {
								int id = Integer.parseInt(request.getParameter("id"));
								try {
									int c = 0;
									Statement stmt = conn.createStatement();
									ResultSet rs = stmt
											.executeQuery("select email from member where id = '" + id + "'");
									while (rs.next()) {
										c++;
										request.setAttribute("pc",
												ProfileDao.selectMemberBookList("select * from member where email = '"
														+ rs.getString("email") + "' order by id desc"));
										request.setAttribute("bc", ProfileDao.selectBookList(
												"select * from book where email = '" + rs.getString("email") + "'"));
										request.setAttribute("memT", ProfileDao.getMemberList(
												"SELECT * from member where id = '" + user.getId() + "'", "id"));
										request.setAttribute("mList", ProfileDao.getMemberList(
												"SELECT * from secondarymember where mid = '" + user.getId() + "'",
												"id"));
									}
									request.setAttribute("count", c);
								} catch (SQLException e) {
									e.printStackTrace();
								}
								String date = sdf.format(new Date(new Date().getTime()));
								request.setAttribute("date", date);
								request.setAttribute("notice", HeaderDao.getNotification(
										"select notice from member where id = '" + user.getId() + "'"));
								request.setAttribute("noticeText", HeaderDao.getNotificationText(
										"select notice from member where id = '" + user.getId() + "'"));
								request.setAttribute("question", questionList);
								request.setAttribute("member", memberType);
								request.setAttribute("id", id);
								RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
								rd.forward(request, response);
							}
						}
					} else {
						request.setAttribute("hc", HomeDao.select());
						request.setAttribute("cw", ContactDao.selectWeb("select * from contactweb"));
						request.setAttribute("wc", HomeDao.selectWelcome("select * from homewelcome"));
						request.setAttribute("mc", HomeDao.selectContent("select * from homecontent"));
						request.setAttribute("ac", AboutDao.selectRight("select * from homeadmin"));
						request.setAttribute("notice", HeaderDao
								.getNotification("select notice from member where id = '" + user.getId() + "'"));
						RequestDispatcher rd = request.getRequestDispatcher("home.jsp?loc=home");
						rd.forward(request, response);
					}
				} else {
					request.setAttribute("message", "Password Doesn't Match??");
					request.setAttribute("url", "../../../../Futsal_Sansar/HomeSansar");
					request.getRequestDispatcher("errorpage.jsp").forward(request, response);
				}
			}

		} else {
			if (action.equalsIgnoreCase("logout")) {
				session.removeAttribute("id");
				Cookie[] cookies = request.getCookies();
				for (Cookie ck : cookies) {
					if (ck.getName().equalsIgnoreCase("email")) {
						ck.setMaxAge(0);
						response.addCookie(ck);
					}
					if (ck.getName().equalsIgnoreCase("password")) {
						ck.setMaxAge(0);
						response.addCookie(ck);
					}
					if (ck.getName().equalsIgnoreCase("id")) {
						ck.setMaxAge(0);
						response.addCookie(ck);
					}
				}
				response.sendRedirect("HomeSansar");
			}
		}

	}

	private User checkCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		User user = null;
		if (cookies == null) {
			return null;
		} else {
			String email = "", password = "", id = "";
			for (Cookie ck : cookies) {
				if (ck.getName().equalsIgnoreCase("email"))
					email = ck.getValue();
				if (ck.getName().equalsIgnoreCase("password"))
					password = ck.getValue();
				if (ck.getName().equalsIgnoreCase("id"))
					id = ck.getValue();
			}
			if ((!email.isEmpty() || email == null) && (!password.isEmpty() || password == null)
					&& (!id.isEmpty() || id == null))
				user = new User(id, email, password);
		}
		return user;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		UserDao dao = new UserDao();
		if (action == null) {
			String email = request.getParameter("email").trim();
			String password = request.getParameter("password").trim();
			if (dao.login(email, password)) {
				int id = UserDao.getUserID("select id from member where email = '" + email + "'");
				session.setAttribute("id", id);

				Cookie ckuser = new Cookie("email", email);
				ckuser.setMaxAge(3600);
				response.addCookie(ckuser);
				Cookie ckpass = new Cookie("password", password);
				ckpass.setMaxAge(3600);
				response.addCookie(ckpass);
				Cookie ckid = new Cookie("id", String.valueOf(id));
				ckid.setMaxAge(3600);
				response.addCookie(ckid);

				request.setAttribute("hc", HomeDao.select());
				request.setAttribute("cw", ContactDao.selectWeb("select * from contactweb"));
				request.setAttribute("wc", HomeDao.selectWelcome("select * from homewelcome"));
				request.setAttribute("mc", HomeDao.selectContent("select * from homecontent"));
				request.setAttribute("ac", AboutDao.selectRight("select * from homeadmin"));

				RequestDispatcher rd = request.getRequestDispatcher("home.jsp?loc=home");
				rd.forward(request, response);

			} else {
				request.setAttribute("message", "Password Doesn't Match??");
				request.setAttribute("url", "../../../../Futsal_Sansar/HomeSansar");
				request.getRequestDispatcher("errorpage.jsp").forward(request, response);
			}
		}
	}
}
