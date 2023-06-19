package com.sist.servlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/StudentInsert")
public class StudentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//화면 출력(폼)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
out.println("<html>");
		
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.println("<style>");
		out.println(".container{margin-top:50px}");
		out.println(".row{margin:0px auto;width:350px;}");
		out.println("h1{text-align:center}");
		out.println("</style>");
		
		out.println("</head>");
		
		
		out.println("<body>");
		
		out.println("<div class=container>");
		out.println("<h1>학생 등록</h1>");
		out.println("<div class=row>");
		
		out.println("<table class=table>");
		out.println("<tr>");
		out.println("<td width=35%>이름</td>");
		out.println("<td width=65%>");
		out.println("<input type=text name=name size=20 class=input-sm>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td width=35%>국어</td>");
		out.println("<td width=65%>");
		out.println("<input type=number name=kor size=20 class=input-sm max=100 min=0 step=5>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td width=35%>영어</td>");
		out.println("<td width=65%>");
		out.println("<input type=number name=eng size=20 class=input-sm max=100 min=0 step=5>");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<td width=35%>수학</td>");
		out.println("<td width=65%>");
		out.println("<input type=number name=math size=20 class=input-sm max=100 min=0 step=5>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	//doGet에서 입력된 데이터를 받아서 데이터 추가(기능)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
