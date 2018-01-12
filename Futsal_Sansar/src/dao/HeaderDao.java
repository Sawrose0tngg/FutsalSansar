package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.connection.CreateDbConnection;

public class HeaderDao {

	public static String getNotification(String sql) {
		String flag = null;
		Connection conn = CreateDbConnection.createConnection();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				if (rs.getString("notice") != null)
					flag = "New";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static String getNotificationText(String sql) {
		String flag = null;
		Connection conn = CreateDbConnection.createConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				flag = rs.getString("notice");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

}
