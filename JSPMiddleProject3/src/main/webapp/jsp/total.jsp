<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%--
	response.sendRedirect(url)
		-> <c:redirect url="url">
	request.setAttribute("a", 값)
		=> <c:set var="a" value="값">
	out.println()
		=> <c:out value="">
		=> 자바스크립트에서 자바데이터를 받아서 출력
			jquery => $()
					  ${}
	fmt : 변환(날짜변환, 숫자변환 : DecimalFormat)
			  ------  ------        |
			  SimpleDateFormat	 <fmt:formatNumber value="" pattern="999,999">
			       |
			     <fmt:formatDate value="" pattern="yyyy-MM-dd">
	fn : String메소드 처리
		${fn:length(문자열)}
		${fn:substring(문자열,start,end)}
	------------------------------------
	sql : DAO
	xml : OXM
		=> 자바 자체에서 처리(사용빈도가 거의 없다)
 --%>
 <%--import --%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%-- format --%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%--function: fn --%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 <%--
 	prefix => 사용자 결정이 가능
 	prefix="c"
 	<c:~>
 	prefix="core"
 	<core:~>
  --%>
  <%
  	//데이터 설정 => 오라클
  	List<String> names=new ArrayList<String>();
  	names.add("홍길동");
  	names.add("심청이");
  	names.add("이순신");
  	names.add("박문수");
  	names.add("강감찬");
  	//EL은 사용할 수 없다(EL ${} => request, session에 저장을 해야 사용이 가능)
  	request.setAttribute("names", names);
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>자바를 이용한 for문</h1>
<h3>이름 목록</h3>
<ul>
	<%
		for(String name:names){
	%>
			<li><%=name %></li>
	<%		
		}
	%>
</ul>

<h3>JSTL출력</h3>
<ul>
	<c:forEach var="name" items="${names }">
		<li>${name }</li>
	</c:forEach>
</ul>

<h3>자바(StringTokenizer)</h3>
<ul>
<%
	String color="red,blue,green,yellow,black";
	StringTokenizer st = new StringTokenizer(color,",");
	while(st.hasMoreTokens()){
%>
		<li><%=st.nextToken() %></li>	
<%
	}
%>
</ul>
<h3>JSTL(forTokens)</h3>
<ul>
	<c:forTokens var="color" items="red,blue,green,yellow,black" delims=",">
		<li>${color }</li>
	</c:forTokens>
</ul>
	
</body>
</html>