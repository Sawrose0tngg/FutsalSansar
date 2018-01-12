package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.connection.CreateDbConnection;
import model.ContactModel;

public class ContactDao {

	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	public static ArrayList<ContactModel> selectContent(String sql) {
		ArrayList<ContactModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new ContactModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
			conn.close();
			System.out.println("Query Executed");
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public static ArrayList<ContactModel> selectWeb(String sql) {

		ArrayList<ContactModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new ContactModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<ContactModel> selectMap(String sql) {

		ArrayList<ContactModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new ContactModel(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
