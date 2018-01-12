package database.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class CreateDbConnection {

	private static Connection conn = null;
	private static final String dbUrl = "jdbc:mysql://localhost:3306/futsalsansar?createDatabaseIfNotExist=true";
	private static final String user = "root";
	private static final String password = "";

	public CreateDbConnection() {
		createConnection();

	}

	public static Connection createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(dbUrl, user, password);
			System.out.println("Success");
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, "Unable To Load Database", "Connection Error",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		return conn;
	}

	public static void main(String args[]) {
		new CreateDbConnection();
	}

}
