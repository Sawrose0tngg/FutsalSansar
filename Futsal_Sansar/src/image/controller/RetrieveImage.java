package image.controller;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import database.connection.CreateDbConnection;

public class RetrieveImage {

	public static byte[] getImage(String sql) {

		Blob image = null;
		Connection conn = null;
		Statement stmt = null;
		byte[] imgData = null;
		ResultSet rs = null;
		try {
			conn = CreateDbConnection.createConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				image = rs.getBlob(1);
				imgData = image.getBytes(1, (int) image.length());
			}
			conn.close();
		} catch (Exception e) {
			System.out.println("Unable To Display image");
			System.out.println("Image Display Error=" + e.getMessage());
		}
		return imgData;
	}

}
