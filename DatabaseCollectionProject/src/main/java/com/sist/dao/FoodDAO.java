package com.sist.dao;
import java.util.*;

import java.sql.*;

public class FoodDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:xe";
	private static FoodDAO dao;
	
	public FoodDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static FoodDAO newInstance() {
		if(dao==null)
			dao=new FoodDAO();
		return dao;
	}
	
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL, "hr", "happy");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
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
	
	//category 추가
	public void food_category_insert(CategoryVO vo) {
		try {
			getConnection();
			String sql="INSERT INTO foodCategory VALUES("
					 + "pc_cno_seq.nextval, ?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getPoster());
			ps.setString(4, vo.getLink());
			ps.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			disConnection();
		}
	}
	
	public List<CategoryVO> food_category_data(){
		List<CategoryVO> list = new ArrayList<CategoryVO>();
		try {
			getConnection();
			String sql="SELECT /*+INDEX_ASC(foodCategory pc_cno_pk)*/cno, title, subject, poster, link "
					  +"FROM foodCategory ";
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				CategoryVO vo = new CategoryVO();
				vo.setCno(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setSubject(rs.getString(3));
				String p=rs.getString(4);
				p.replace("#", "&");
				vo.setPoster(p);
				vo.setLink(rs.getString(5));
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
