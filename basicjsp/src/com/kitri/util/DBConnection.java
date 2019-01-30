package com.kitri.util;

import java.sql.*;

public class DBConnection {
	public static Connection makeConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.33:1521:xe", "kitri", "kitri");
	}
}
