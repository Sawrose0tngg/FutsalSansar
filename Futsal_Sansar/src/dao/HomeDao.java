package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.connection.CreateDbConnection;
import model.HomeTitleModel;
import model.HomeWelcomeModel;

public class HomeDao {

	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	public static ArrayList<HomeTitleModel> select_by_id(int hid) {
		ArrayList<HomeTitleModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();

		String sql = "SELECT * FROM homehead WHERE id=" + hid;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				list.add(new HomeTitleModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(6)));
			}
			conn.close();
			System.out.println("Query Executed");
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public static ArrayList<HomeTitleModel> select() {

		ArrayList<HomeTitleModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from homehead");
			while (rs.next()) {
				list.add(new HomeTitleModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(6)));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<HomeWelcomeModel> selectWelcome(String sql) {

		ArrayList<HomeWelcomeModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new HomeWelcomeModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5)));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<HomeWelcomeModel> selectContent(String sql) {

		ArrayList<HomeWelcomeModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new HomeWelcomeModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
