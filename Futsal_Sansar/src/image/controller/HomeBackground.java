package image.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.connection.CreateDbConnection;

@WebServlet("/HomeBackground")
public class HomeBackground extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeBackground() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Blob image = null;
		Connection conn = null;
		byte[] imgData = null;
		Statement stmt = null;
		ResultSet rs = null;
		String status = "checked";
		try {
			conn = CreateDbConnection.createConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select bgImage from homehead where active='" + status + "'");
			while (rs.next()) {
				image = rs.getBlob(1);
				imgData = image.getBytes(1, (int) image.length());
			}
			response.setContentType("image/jpg");
			OutputStream o = response.getOutputStream();
			o.write(imgData);
			o.flush();
			o.close();
		} catch (Exception e) {
			System.out.println("Unable To Display image");
			System.out.println("Image Display Error=" + e.getMessage());
			return;
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
