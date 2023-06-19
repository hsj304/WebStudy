package com.sist.dao;
import java.util.*;

import oracle.jdbc.OracleType;
import oracle.jdbc.internal.OracleTypes;

import java.sql.*;
public class StudentDAO {
	private Connection conn;
	private CallableStatement cs;
	private final String URL="jdbc:oracle:thin:211.238.142.111:1521:xe";
	private static StudentDAO dao;
	
	public StudentDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static StudentDAO newInstance() {
		if(dao==null)
			dao = new StudentDAO();
		return dao;
	}
	
	//데이터 추가
	/*
		CREATE OR REPLACE PROCEDURE studentInsert(
		    pName student.name%TYPE,
		    pKor student.kor%TYPE,
		    pEng student.eng%TYPE,
		    pMath student.math%TYPE
		)
		IS
		BEGIN
		    INSERT INTO student VALUES(
		        (SELECT NVL(max(hakbun)+1, 1) FROM student),
		        pName, pKor, pEng, pMath
		    );
		    COMMIT;
		END;
	 */
	public void studentInsert(StudentVO vo) {
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
			String sql="{CALL studentInsert(?,?,?,?)}";
			cs=conn.prepareCall(sql);//ERP => 메뉴얼
			cs.setString(1, vo.getName());
			cs.setInt(2, vo.getKor());
			cs.setInt(3, vo.getEng());
			cs.setInt(4, vo.getMath());
			cs.executeQuery();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(cs!=null)
					cs.close();
				if(conn!=null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	//데이터 수정
	/*
		CREATE OR REPLACE PROCEDURE studentUpdate(
		    pHakbun student.hakbun%TYPE,
		    pName student.name%TYPE,
		    pKor student.kor%TYPE,
		    pEng student.eng%TYPE,
		    pMath student.math%TYPE
		)
		IS
		BEGIN
		    UPDATE student SET
		    name=pName, kor=pKor, eng=pEng, math=pMath
		    WHERE hakbun=pHakbun;
		    COMMIT;
		END;
	 */
	public void studentUpdate(StudentVO vo) {
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
			String sql="{CALL studentUpdate(?,?,?,?,?)}";
			cs=conn.prepareCall(sql);
			cs.setInt(1, vo.getHakbun());
			cs.setString(2, vo.getName());
			cs.setInt(3, vo.getKor());
			cs.setInt(4, vo.getEng());
			cs.setInt(5, vo.getMath());
			cs.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(cs!=null)
					cs.close();
				if(conn!=null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	//데이터 삭제
	public void studentDelete(int hakbun) {
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
			String sql="{CALL studentDelete(?)}";
			cs=conn.prepareCall(sql);
			cs.setInt(1, hakbun);
			cs.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(cs!=null)
					cs.close();
				if(conn!=null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	//데이터 상세
	/*
		CREATE OR REPLACE PROCEDURE studentDetailData(
		    pHakbun IN student.hakbun%TYPE,
		    pName OUT student.name%TYPE,
		    pKor OUT student.kor%TYPE,
		    pEng OUT student.eng%TYPE,
		    pMath OUT student.math%TYPE
		)
		IS
		BEGIN
		    SELECT name,kor,eng,math INTO pName,pKor,pEng,pMath
		    FROM student
		    WHERE hakbun=pHakbun;
		END;
	 */
	public StudentVO studentDetail(int hakbun) {
		StudentVO vo = new StudentVO();
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
			String sql="{CALL studentDetailData(?,?,?,?,?)}";
			cs=conn.prepareCall(sql);
			cs.setInt(1, hakbun);
			cs.registerOutParameter(2, OracleTypes.VARCHAR);
			cs.registerOutParameter(3, OracleTypes.INTEGER);
			cs.registerOutParameter(4, OracleTypes.INTEGER);
			cs.registerOutParameter(5, OracleTypes.INTEGER);
			cs.executeQuery();
			vo.setName(cs.getString(2));
			vo.setKor(cs.getInt(3));
			vo.setEng(cs.getInt(4));
			vo.setMath(cs.getInt(5));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(cs!=null)
					cs.close();
				if(conn!=null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return vo;
	}
	
	//데이터 전체
	/*
		CREATE OR REPLACE PROCEDURE studentListData(
		    pResult OUT SYS_REFCURSOR 
		)
		IS
		BEGIN
		    OPEN pResult FOR
		        SELECT * FROM student;
		END;
	 */
	public List<StudentVO> studentListData() {
		List<StudentVO> list = new ArrayList<StudentVO>();
		
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
			String sql= "{CALL studentListData(?)}";
			cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.executeQuery();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			//Cursor => ResultSet변환
			while(rs.next()) {
				StudentVO vo = new StudentVO();
				vo.setHakbun(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setKor(rs.getInt(3));
				vo.setEng(rs.getInt(4));
				vo.setMath(rs.getInt(5));
				vo.setTotal(rs.getInt(6));
				vo.setAvg(rs.getDouble(7));
				list.add(vo);
			}	
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(cs!=null)
					cs.close();
				if(conn!=null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return list;
	}
	//중복 코드가 있는 여부 => 공통 모듈(메소드화 처리, 클래스화)
	
}
