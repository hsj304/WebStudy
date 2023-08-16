<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	EL 지원하는 내장객체(581page)
	***1) requestScope => request.setAttribute()
	***2) sessionScope => session.setAttribute()
	3) param		   => request.getParameter()
	4) paramValues	   => requset.getParameterValues()
 --%>
 <%
 	String name="홍길동";
 	request.setAttribute("name", "홍길동");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이름:${name },${requestScope.name} <%--requestScope. 생략 --%>
	<%=request.getAttribute("name") %>
</body>
</html>