package com.sist.main;
import java.util.*;

import com.sist.dbconn.CreateDatabase;

import java.sql.*;

public class MainClass {
	
	public static void main(String[] args) {
		CreateDatabase db =new CreateDatabase();
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn = db.getConnection();
			String sql = "SELECT empno, ename, job "
						+ "FROM emp ";
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}
			rs.close();
					
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			db.disConnection(conn, ps);
		}
	}
}
