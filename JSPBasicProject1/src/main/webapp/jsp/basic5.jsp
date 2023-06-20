<%--
	자바 / HTML 분리
	=> <%! %>
	=> <%  %>
	=> <%= %>
	----------자바 코딩 영역
	1. 145page
		지시자
		1) page : JSP파일의 정보
		   -------------------
		    1. info
		    	정보 => 작성자 / 수정일 ...
		    2. contentType
		    	변환 => 브라우저에 알려준다(실행 결과)
		    	text/html;charset=UTF-8 => HTML
		    	text/xml;charset=UTF-8 => XML
		    	text/plain;charset=UTF-8 => JSON
		    3. import
		    	자바 라이브러리 읽기
		    	=> 사용자 정의 읽기
		    	=> 자동 추가
		    		java.lang.*
		    		javax.servlet.*
		    	<%@ page 속성=값 ... %> => 속성마다 1번만 사용이 가능
		    	<%@ page import="java.util.*, java.io.* "%>
		    	
		    4. buffer
		    5. errorPage : 에러 발생시에 이동하는 파일 지정
		    6. isErrorPage : 종류별 에러 처리
		2) taglib
		3) include
		
		
		속성="" 속성="값"
		<%@ %> => 번역되는 태그가 아니라 선언하는 태그
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>