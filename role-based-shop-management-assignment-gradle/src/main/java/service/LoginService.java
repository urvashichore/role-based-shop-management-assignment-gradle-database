package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService {

	public boolean check(String uname,String pass) {
		String dbUrl = "jdbc:postgresql://localhost:5432/hrdb";
		String dbUser = "uchore";
		String dbPass = "";
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			PreparedStatement query = con.prepareStatement("SELECT * FROM userinfo WHERE uname = ? AND pass = ?");
			query.setString(1, uname);
			query.setString(2, pass);
			ResultSet queryResult = query.executeQuery();
			if (queryResult.next()) {
				return true;
			}
		}
		catch(Exception e) {
			System.out.print(e.getMessage());
		}
		return false;
	}
}
