package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.connection.CreateDbConnection;
import model.AboutImageModel;

public class AboutDao {

	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	public static ArrayList<AboutImageModel> select(String sql) {

		ArrayList<AboutImageModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new AboutImageModel(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getInt(5)));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static ArrayList<AboutImageModel> selectImg(String sql) {

		ArrayList<AboutImageModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new AboutImageModel(rs.getInt(1), rs.getString(2), rs.getInt(4)));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<AboutImageModel> selectLeft(String sql) {

		ArrayList<AboutImageModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new AboutImageModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
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

}
