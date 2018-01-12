package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.connection.CreateDbConnection;
import login.controller.Signup;

public class UserDao {

	public boolean login(String email, String password) {
		boolean test = false;
		try {
			if (loginUser("select email,password from member where email = '" + email + "' and password = '"
					+ Signup.encryption(password) + "'"))
				test = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return test;
	}

	public boolean loginAdmin(String email, String password) {
		boolean test = false;
		try {
			if (loginUser("select email,password from admin where email = '" + email + "' and password = '"
					+ Signup.encryption(password) + "'"))
				test = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return test;
	}

	public boolean loginUser(String sql) throws SQLException {
		boolean temp = false;
		Connection conn = CreateDbConnection.createConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if (rs.next()) {
			temp = true;
		}
		return temp;
	}

	public static int getUserID(String sql) {
		int flag = 0;
		Connection conn = CreateDbConnection.createConnection();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				flag = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static String getUserName(String sql) {
		String name = null;
		Connection conn = CreateDbConnection.createConnection();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				name = rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}

}
