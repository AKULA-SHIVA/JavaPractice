package com.sonata.OtherJDBC;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class TransactionControllExample {

	public static void main(String[] args) throws SQLException{
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCExample", "root", "admin@123");
			PreparedStatement ps = con.prepareStatement("insert into Employee values(?,?,?)");
			con.setAutoCommit(false);
			ps.setInt(1, 180);
			ps.setString(2, "sonata1");
			ps.setDouble(3, 2345.01);
			int a = ps.executeUpdate();
			con.commit();
			System.out.println("The number of records updated are " + a);

		} catch (ClassNotFoundException e1) {
			System.out.println(e1);
		} catch (SQLException e2) {
			e2.printStackTrace();
			con.rollback();
		} finally {
			con.close();
		}
	}
}