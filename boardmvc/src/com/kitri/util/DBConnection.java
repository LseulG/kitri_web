package com.kitri.util;

import java.sql.*;

public class DBConnection {
	// 클래스가 읽혀지는 순간 딱 1번 호출, 생성자는 new 할 때마다 호출
	static {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");	
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static Connection makeConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@192.168.18.33:1521:xe", "kitri", "kitri");
		//return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "board_user", "lim");
	}
}
