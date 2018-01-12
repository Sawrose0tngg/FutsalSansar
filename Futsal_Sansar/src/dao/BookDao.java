package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import database.connection.CreateDbConnection;
import model.AboutImageModel;
import model.BookContentModel;
import model.MemberModel;
import model.NoticeModel;

public class BookDao {

	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	public static ArrayList<BookContentModel> selectContent(String sql) {
		ArrayList<BookContentModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				list.add(new BookContentModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6)));
			}
			conn.close();
			System.out.println("Query Executed");
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public static ArrayList<AboutImageModel> selectRight(String sql) {

		ArrayList<AboutImageModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new AboutImageModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(5)));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<MemberModel> selectMemberBook(String sql) {

		ArrayList<MemberModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				/* Time from one format to another */
				SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");
				SimpleDateFormat df = new SimpleDateFormat("HH:mm");
				try {
					Date time = df.parse(rs.getString(11));
					String t = sdf.format(time);
					list.add(new MemberModel(rs.getInt(1), rs.getString(2), rs.getString(5), t));
				} catch (ParseException e) {
					e.printStackTrace();
				}

			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<MemberModel> selectLocalBook(String sql) {

		ArrayList<MemberModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				/* Time from one format to another */

				Date currentDate = new Date();
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				long date1 = 0, date2 = 0;
				String str = sdf1.format(currentDate);

				try {
					date1 = sdf1.parse(str).getTime();
					Date date = sdf1.parse(rs.getString(5));
					date2 = date.getTime();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				if (date2 >= date1) {
					SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");
					SimpleDateFormat df = new SimpleDateFormat("HH:mm");
					try {
						Date time = df.parse(rs.getString(6));
						String startTime = sdf.format(time);
						long endTime = time.getTime() + 19800000 + rs.getInt(7) * 3600000;
						long minute = (endTime / (1000 * 60)) % 60;
						long hour = (endTime / (1000 * 60 * 60)) % 24;
						String eTime = String.format("%02d:%02d", hour, minute);
						Date tim = df.parse(eTime);
						String t = startTime + " to " + sdf.format(tim);

						list.add(new MemberModel(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(5), t));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<MemberModel> selectRecentEvent(String sql) {

		ArrayList<MemberModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				/* Time from one format to another */

				Date currentDate = new Date();
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				long date1 = 0, date2 = 0;
				String str = sdf1.format(currentDate);

				try {
					date1 = sdf1.parse(str).getTime();
					Date date = sdf1.parse(rs.getString(5));
					date2 = date.getTime();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				if ((date1 == date2)) {
					SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");
					SimpleDateFormat df = new SimpleDateFormat("HH:mm");
					try {
						Date time = df.parse(rs.getString(6));
						String startTime = sdf.format(time);
						long endTime = time.getTime() + 19800000 + rs.getInt(7) * 3600000;
						long minute = (endTime / (1000 * 60)) % 60;
						long hour = (endTime / (1000 * 60 * 60)) % 24;
						String eTime = String.format("%02d:%02d", hour, minute);
						Date tim = df.parse(eTime);
						String t = startTime + " to " + sdf.format(tim);

						list.add(new MemberModel(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(5), t));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<MemberModel> selectYesterdayEvent(String sql) {

		ArrayList<MemberModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				/* Time from one format to another */

				Date currentDate = new Date();
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				long date1 = 0, date2 = 0;
				String str = sdf1.format(currentDate);

				try {
					date1 = sdf1.parse(str).getTime();
					Date date = sdf1.parse(rs.getString(5));
					date2 = date.getTime();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				if ((date1 - date2) == 86400000) {
					SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");
					SimpleDateFormat df = new SimpleDateFormat("HH:mm");
					try {
						Date time = df.parse(rs.getString(6));
						String startTime = sdf.format(time);
						long endTime = time.getTime() + 19800000 + rs.getInt(7) * 3600000;
						long minute = (endTime / (1000 * 60)) % 60;
						long hour = (endTime / (1000 * 60 * 60)) % 24;
						String eTime = String.format("%02d:%02d", hour, minute);
						Date tim = df.parse(eTime);
						String t = startTime + " to " + sdf.format(tim);

						list.add(new MemberModel(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(5), t));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<MemberModel> selectTomorrowEvent(String sql) {

		ArrayList<MemberModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				/* Time from one format to another */

				Date currentDate = new Date();
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				long date1 = 0, date2 = 0;
				String str = sdf1.format(currentDate);

				try {
					date1 = sdf1.parse(str).getTime();
					Date date = sdf1.parse(rs.getString(5));
					date2 = date.getTime();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				if ((date1 + 86400000) == date2) {
					SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");
					SimpleDateFormat df = new SimpleDateFormat("HH:mm");
					try {
						Date time = df.parse(rs.getString(6));
						String startTime = sdf.format(time);
						long endTime = time.getTime() + 19800000 + rs.getInt(7) * 3600000;
						long minute = (endTime / (1000 * 60)) % 60;
						long hour = (endTime / (1000 * 60 * 60)) % 24;
						String eTime = String.format("%02d:%02d", hour, minute);
						Date tim = df.parse(eTime);
						String t = startTime + " to " + sdf.format(tim);
						list.add(new MemberModel(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getString(5), t));
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<NoticeModel> selectNotice(String sql) {

		ArrayList<NoticeModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new NoticeModel(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
