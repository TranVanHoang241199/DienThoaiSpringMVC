package org.o7planning.hellospringmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class KN_SQL {
	// "com.microsoft.sqlserver.jdbc.SQLServerDriver"
	// "jdbc:sqlserver://DESKTOP-QMJMONB\\SQLEXPRESS:1433;databaseName=Database_QLSach;user=sa;
	// password=123"
	public Connection cn;

	public void ketNoi() throws Exception {
		// B1 : xác định csdl
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Đã xác định!");
		// B2 : kết nối csdl
		String url = "jdbc:sqlserver://DESKTOP-QMJMONB\\SQLEXPRESS:1433;databaseName=Database_BanDienThoai;user=sa;password=123";
		cn = DriverManager.getConnection(url);
		System.out.println("đã kết nối!");
	}
}
