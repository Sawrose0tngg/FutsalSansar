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
import model.BookStatusModel;
import model.MemberModel;

public class ProfileDao {

	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	public static ArrayList<MemberModel> selectContent(String sql) {
		ArrayList<MemberModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new MemberModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<MemberModel> selectAdminProfile(String sql) {
		ArrayList<MemberModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				list.add(new MemberModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(10)));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<MemberModel> selectAdmin(String sql) {
		ArrayList<MemberModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new MemberModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5),
						rs.getString(8), rs.getInt(10)));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<MemberModel> selectFutSalMember(String sql) {
		ArrayList<MemberModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new MemberModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getInt(12), rs.getInt(13)));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<BookStatusModel> selectBookContent(String sql) {
		ArrayList<BookStatusModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new BookStatusModel(rs.getString("date"), rs.getString("time"), rs.getInt("duration"),
						rs.getInt("pay")));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<BookStatusModel> selectBookList(String sql) {
		ArrayList<BookStatusModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		int count = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {

				Date currentDate = new Date();
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				long date1 = 0, date2 = 0;
				String str = sdf1.format(currentDate);

				try {
					date1 = sdf1.parse(str).getTime();
					Date date = sdf1.parse(rs.getString("date"));
					date2 = date.getTime();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				if (date1 <= date2) {
					count++;
					list.add(new BookStatusModel(rs.getInt("id"), rs.getString("date"), rs.getString("time"),
							rs.getInt("duration"), rs.getInt("pay"), rs.getInt("total") - rs.getInt("pay")));

				}
			}
			if (count == 0) {
				list.add(new BookStatusModel(0, "-", "-", 0, 0, 0));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<MemberModel> selectMemberBookList(String sql) {
		ArrayList<MemberModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		int count = 0, id = 0;
		String name = null, email = null, phone = null, gender = null, memberType = null, question = null,
				answer = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				id = rs.getInt(1);
				name = rs.getString(2);
				email = rs.getString(3);
				phone = rs.getString(5);
				question = rs.getString(6);
				answer = rs.getString(7);
				gender = rs.getString(8);
				memberType = rs.getString(9);

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

				if (date1 <= date2) {
					count++;
					list.add(new MemberModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
							rs.getString(11), rs.getInt(12), rs.getInt(13) - rs.getInt(12)));
				}
			}
			if (count == 0) {
				list.add(new MemberModel(id, name, email, phone, question, answer, gender, memberType, "-", "-", 0, 0));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<MemberModel> getMemberList(String sql, String id) {
		ArrayList<MemberModel> list = new ArrayList<>();
		conn = CreateDbConnection.createConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new MemberModel(rs.getInt(id), rs.getString("memberType")));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
