package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericCon {

	public static Connection getConnection()
	{
		Connection con=null;
		

	
		try {
			Class.forName ("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection ("jdbc:mysql://mysql10057-env-7710340.underjelastic.com.br/AVALIA","root", "FKVvvr01298");
			//con = DriverManager.getConnection ("jdbc:mysql://127.0.0.1/AVALIA","root", "123456");
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
		
	}
	
	
	
}
