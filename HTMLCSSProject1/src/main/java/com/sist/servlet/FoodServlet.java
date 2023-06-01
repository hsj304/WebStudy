package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;
/*
 * 	new FoodServlet() => 톰캣
 * 1)init() : 변수 초기화, 필요한 값을 읽는 경우
 * 				자동 로그인, 보안..
 * 2)service() : 사용자가 요청한 HTML을 만드는 위치
 * 		= doGet() => GET
 * 		= doPost() => POST
 * 		= 브라우저로 HTML을 전송하는 위치
 * 		---------------------------JSP(메소드 영역)
 * 3)destory() : 메모리 해제
 * 	 => 페이지 이동 / 새로고침 / 브라우저 종료시
 * 
 * JSP => 호출시에 자동으로 Servlet으로 변경(한개의 클래스를 만든다)
 * a.jsp => a_jsp.java
 * 			----------
 * 			HTML / Java 분리
 * 			<%
 * 			%>
 * 			HTML
 * 			=> 서블릿(스프링 라이브러리가 서블릿으로 제작됨)
 */
@WebServlet("/FoodServlet")
public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		FoodDAO dao = FoodDAO.newInstance();
		List<FoodVO> list = dao.foodAllData();
		
		PrintWriter out = response.getWriter();
		//브라우저에 출력하는 내용물 => HTML
		out.println("<html>");
		out.println("<head>");
		
		out.println("<script src=\"http://code.jquery.com/jquery.js\"></script>");
		out.println("<script>");
		out.println("$(function(){");
		out.println("$('#keyword').keyup(function(){");
		out.println("let k=$(this).val();");
		out.println("console.log(k);");
		out.println("$('#user-table > tbody > tr').hide();");
		out.println("let temp=$('#user-table > tbody > tr > td:nth-child(5n+2):contains(\"'+k+'\")');");
		out.println("$(temp).parent().show();");
		out.println("})");
		out.println("})");
		out.println("</script>");
		
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>맛집 목록</h1>");

		out.println("<table border=1 bordercolor=black width=1024>");
		out.println("<tr>");
		out.println("<td>");
		out.println("<input type=text size=30 id=keyword>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		
		out.println("<table border=1 bordercolor=black width=1024 id=user-table>");
		
		out.println("<thead>"); //한번만 실행
		out.println("<tr>");
		out.println("<th></th>");
		out.println("<th>맛집명</th>");
		out.println("<th>주소</th>");
		out.println("<th>전화</th>");
		out.println("<th>음식종류</th>");
		out.println("</tr>");
		out.println("</thead>");
		
		out.println("<tbody>"); // vue, react => table 출력이 안됨
		for(FoodVO vo:list) {
			out.println("<tr>");
			out.println("<td><img src="+vo.getPoster()+" width=30 height=30></td>");
			out.println("<td>"+vo.getName()+"</td>");
			out.println("<td>"+vo.getAddress()+"</td>");
			out.println("<td>"+vo.getTel()+"</td>");
			out.println("<td>"+vo.getType()+"</td>");
			out.println("</tr>");
		}
		out.println("</tbody>");
		
		out.println("</table>");
		
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
