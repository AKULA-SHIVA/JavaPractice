package com.sonata.OtherJDBC;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class MetaDataExample {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCExample", "root",
					"admin@123");
			DatabaseMetaData dm = con.getMetaData();
			System.out.println(dm.getDatabaseMajorVersion());
			System.out.println(dm.getDriverName());
			System.out.println(dm.getDriverMajorVersion());

			PreparedStatement ps = con.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rms = rs.getMetaData();

			System.out.println(rms.getColumnCount());
			System.out.println(rms.getColumnName(2));

		} catch (ClassNotFoundException e1) {
			System.out.println(e1);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}

}
