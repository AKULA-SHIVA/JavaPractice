package com.sonata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementExample {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCExample", "root",
					"admin@123");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from employee");
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getDouble(3));
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e1) {
			System.out.println(e1);
		}
	}
}
