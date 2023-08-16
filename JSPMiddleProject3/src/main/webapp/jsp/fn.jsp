<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String msg="홍길동입니다";
%>
<c:set var="msg" value="<%=msg %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Java</h1>
	<%=msg.length() %><br>
	<%=msg.substring(0,3) %><br>
	<h1>JSTL</h1>
	${fn:length(msg) }<br>
	${fn:substring(msg,0,3) }<br>
	${fn:replace(msg,'홍','박') }<br>
</body>
</html>