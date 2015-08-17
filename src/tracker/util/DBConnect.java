package tracker.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect {

	private final static String URL = "jdbc:mysql://localhost:3306/tracker_db";
	private final static String user = "root";
	private final static String password = "saiteja123";
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection connector() {
		
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, user, password);
			System.out.println("Connection to Database Succesful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeConnection(PreparedStatement ps, ResultSet rs, Connection con){
		
			try {
				if(ps != null)
					ps.close();
				
				if(rs != null) 
					rs.close();
				
				if(con != null) 
					con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
