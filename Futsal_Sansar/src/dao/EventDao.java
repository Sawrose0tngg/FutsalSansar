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
import model.EventModel;
import model.HomeWelcomeModel;

public class EventDao {

	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	public static ArrayList<EventModel> selectContent(String sql) {
		ArrayList<EventModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new EventModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
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

	public static ArrayList<HomeWelcomeModel> selectSlider(String sql) {

		ArrayList<HomeWelcomeModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new HomeWelcomeModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(5)));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static int getUpcominEvent() {
		int count = 0;
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from event");
			while (rs.next()) {
				System.out.println(rs.getString("title"));
				Date currentDate = new Date();
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				long date1 = 0, date2 = 0;
				String str = sdf1.format(currentDate);

				try {
					date1 = sdf1.parse(str).getTime();
					Date date = sdf1.parse(rs.getString("endDate"));
					date2 = date.getTime();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				if (date1 <= date2) {
					System.out.println(rs.getString("title"));
					count++;
				}

			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public static int getCompletedEvent() {
		int count = 0;
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from event");
			while (rs.next()) {
				Date currentDate = new Date();
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				long date1 = 0, date2 = 0;
				String str = sdf1.format(currentDate);

				try {
					date1 = sdf1.parse(str).getTime();
					Date date = sdf1.parse(rs.getString("startDate"));
					date2 = date.getTime();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				if (date1 > date2) {
					count++;
				}
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public static ArrayList<EventModel> upComingEvent(int pause) {
		String sql = "select * from event where active = 1 order by startDate asc";
		ArrayList<EventModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		int count = 0;

		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				Date currentDate = new Date();
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				long date1 = 0, date2 = 0;
				String str = sdf1.format(currentDate);
				try {
					date1 = sdf1.parse(str).getTime();
					Date date = sdf1.parse(rs.getString("endDate"));
					date2 = date.getTime();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				if (date1 <= date2) {
					count++;
					if (count < pause * 2 - 1) {
						continue;
					}
					list.add(new EventModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
					if (list.size() == 2) {
						break;
					}
				}

			}
			conn.close();
			System.out.println("Query Executed");
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public static ArrayList<EventModel> completedEvent(int pause) {
		String sql = "select * from event where active = 1 order by startDate asc";
		ArrayList<EventModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		int count = 0;

		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				Date currentDate = new Date();
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				long date1 = 0, date2 = 0;
				String str = sdf1.format(currentDate);
				try {
					date1 = sdf1.parse(str).getTime();
					Date date = sdf1.parse(rs.getString("endDate"));
					date2 = date.getTime();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				if (date1 > date2) {
					count++;
					if (count < pause * 2 - 1) {
						continue;
					}
					list.add(new EventModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
					if (list.size() == 2) {
						break;
					}
				}

			}
			conn.close();
			System.out.println("Query Executed");
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public static void main(String args[]) {
		ArrayList<EventModel> list = EventDao.upComingEvent(3);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getTitle());
		}
	}

}
