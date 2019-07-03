package demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_employee_tracker?useSSL=false&serverTimezone=UTC";
		String user="hbemployee";
		String pass="hbemployee";
		
		
		try {
			Connection myConn=
					DriverManager.getConnection(jdbcUrl, user, pass);
			
			
			System.out.println("Connecting to database: " +jdbcUrl);
			
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
