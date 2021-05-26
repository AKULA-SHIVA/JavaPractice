package com.sonata.OtherJDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CallableUpdateExample {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/JDBCexample","root","admin@123");
			
			CallableStatement cs = con.prepareCall("{call UPD(?,?)}");
			cs.setInt(1, 400);
			cs.setDouble(2, 100000.120);
			int rs = cs.executeUpdate();
			System.out.println("the number of records updated are"+rs);
			
		} catch (ClassNotFoundException ce) {
			System.out.println(ce);
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
	}
}
