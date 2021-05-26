package com.sonata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class UpdatePrepareExample {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCExample", "root",
					"admin@123");
			PreparedStatement ps = con.prepareStatement("update Employee set empSAL=? where empId=?");
			ps.setDouble(1, 6000.98);
			ps.setInt(2, 100);
			int a = ps.executeUpdate();
			System.out.println("The number of records updated are " + a);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e1) {
			System.out.println(e1);
		}
	}

}
