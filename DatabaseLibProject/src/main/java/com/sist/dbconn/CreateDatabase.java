package com.sist.dbconn;
import java.util.*;
import java.sql.*;

public class CreateDatabase {
	private Connection conn;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	public CreateDatabase() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//연결
	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(URL, "hr", "happy");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conn;
	}
	
	//해제
	public void disConnection(Connection conn, PreparedStatement ps) {
		
		try {
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
