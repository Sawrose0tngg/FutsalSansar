package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.connection.CreateDbConnection;
import model.CostModel;

public class CostDao {

	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	public static ArrayList<CostModel> select(String sql) {

		ArrayList<CostModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new CostModel(rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static int select_Cost(String sql) {

		int cost = 0;
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				cost = rs.getInt("nonmember");
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cost;
	}
}
