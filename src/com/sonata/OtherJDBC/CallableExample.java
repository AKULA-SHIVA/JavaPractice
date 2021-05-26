package com.sonata.OtherJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.CallableStatement;

public class CallableExample {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCExample", "root",
					"admin@123");
			CallableStatement cs = con.prepareCall("{call SA(?,?,?)}");
			cs.setInt(1, 322);
			cs.setString(2, "execution");
			cs.setDouble(3, 3456.0);

			int rs = cs.executeUpdate();
			System.out.println("The number of record inserted is " + rs);
		} catch (ClassNotFoundException e1) {
			System.out.println(e1);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}
}
