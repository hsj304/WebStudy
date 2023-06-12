package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.dbconn.*;

public class SeoulDAO {
	private String[] tables = {
			"seoul_location", "seoul_nature", "seoul_shop", "seoul_hotel"
	};
	private Connection conn;
	private PreparedStatement ps;
	private CreateDatabase db=new CreateDatabase();
	private static SeoulDAO dao;
	
	//1. 리스트
	public List<SeoulVO> seoulListData(int page, int type){
		List<SeoulVO> list = new ArrayList<SeoulVO>();
		
		try {
			conn = db.getConnection();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			db.disConnection(conn, ps);
		}
		
		return list;
	}
	
	//2. 총페이지 구하기
	public int seoulTotalPage(int type) {
		int total=0;
		
		try {
			conn = db.getConnection();
			String sql="SELECT CEIL(COUNT(*)/12.0) "
					+ "FROM "+tables[type];
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			total = rs.getInt(1);
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			db.disConnection(conn, ps);
		}
		
		return total;
	}
	
	//3. 상세보기
	public SeoulVO seoulDetailData(int no, int type) {
		SeoulVO vo = new SeoulVO();
		
		try {
			conn = db.getConnection();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			db.disConnection(conn, ps);
		}
		
		return vo;
	}
}
