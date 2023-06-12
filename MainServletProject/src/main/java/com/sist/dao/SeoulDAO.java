package com.sist.dao;

import java.sql.*;
import java.util.*;

public class SeoulDAO {
	//연결객체
		private Connection conn;
		//송수신
		private PreparedStatement ps;
		//오라클 URL
		private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
		//싱글턴
		private static SeoulDAO dao;
		//1. 드라이버 등록 => 한번 수행 => 시작과 동시에 한번 수행, 멤버변수 초기화 : 생성자
		public SeoulDAO() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				//ClassNotFoundException => 체크예외처리 => 반드시 예외처리 한다
				//java.io, java.net, java.sql
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		//2. 오라클 연결
		public void getConnection() {
			try {
				conn=DriverManager.getConnection(URL, "hr", "happy");
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		//3. 오라클 해제
		public void disConnection() {
			try {
				if(ps!=null)
					ps.close();
				if(conn!=null) 
					conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		//4. 싱글턴 설정 
		//메모리 누수 현상을 방지
		//싱글턴은 데이터베이스에서는 필수 조건
		public static SeoulDAO newInstance() {
			if(dao==null)
				dao=new SeoulDAO();
			
			return dao;
		}
		
		//5. 기능
		//목록 => SQL(인라인뷰 => 페이징 기법)
		public List<SeoulVO> seoulListData(int page){
			List<SeoulVO> list = new ArrayList<SeoulVO>();
			
			try {
				getConnection();
				String sql = "SELECT no,title,poster,num "
							+ "FROM (SELECT no,title,poster,rownum as num "
							+ "FROM (SELECT no,title,poster "
							+ "FROM seoul_location ORDER BY no ASC)) "
							+ "WHERE num BETWEEN ? AND ?";
				//rownum => 가상 컬럼(오라클에 지원)
				//단점 => 중간에 데이터를 추출할 수 없다 => Top-N
				ps = conn.prepareStatement(sql);
				int rowSize=12;
				int start = (page-1)*rowSize+1;
				int end = page*rowSize;
				ps.setInt(1, start);
				ps.setInt(2, end);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					SeoulVO vo = new SeoulVO();
					vo.setNo(rs.getInt(1));
					vo.setTitle(rs.getString(2));
					vo.setPoster(rs.getString(3));
					list.add(vo);
				}
				rs.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				disConnection();
			}
			
			return list;
		}
		
		public List<SeoulVO> seoulShopListData(int page) {
			List<SeoulVO> list = new ArrayList<SeoulVO>();
			
			try {
				getConnection();
				String sql ="SELECT no, poster, title, num "
							+ "FROM (SELECT no, poster, title, rownum as num "
							+ "FROM (SELECT no, poster, title "
							+ "FROM seoul_shop ORDER BY no)) "
							+ "WHERE num BETWEEN ? AND ?";
				ps = conn.prepareStatement(sql);
				int rowSize=12;
				int start = (page-1)*rowSize+1;
				int end = page*rowSize;
				ps.setInt(1, start);
				ps.setInt(2, end);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					SeoulVO vo = new SeoulVO();
					vo.setNo(rs.getInt(1));
					vo.setPoster(rs.getString(2));
					vo.setTitle(rs.getString(3));
					list.add(vo);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				disConnection();
			}
			
			return list;
		}
		
		
}
