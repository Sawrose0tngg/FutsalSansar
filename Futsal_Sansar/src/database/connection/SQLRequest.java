package database.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLRequest {

	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static Connection conn = null;

	public static void delete(String sql) {
		conn = CreateDbConnection.createConnection();

		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			conn.close();
			System.out.println("Successfully Deleted.");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void update(String sql) {
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			conn.close();
			System.out.println("Data Updated");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void remove(String select_Sql, String update_Sql) {
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(select_Sql);
			while (rs.next()) {
				update(update_Sql);
			}
			conn.close();
			System.out.println("Active Removed");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
