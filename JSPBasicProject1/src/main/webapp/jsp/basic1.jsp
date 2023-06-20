<%--
	주석
	JSP
	---------------------------
	 ***웹 프로그램 : C/S => cloud(CI/CD)
	1. 구성요소
		Client : 브라우저
		Server : WebServer / WAS
							Web Application Server
							=> Tomcat / Regin ...
				 client => ===== WAS =====
				 		   Web Server => WebContainer
				 		   ----------    ------------ JSP / Servlet을 HTML로 변환
				 		   1. client의 요청을 받는다
				 		   ***client는 항상 파일명 요청
				 		   2. Web Server
				 		   	자체 처리(HTML, CSS, JSON)
				 		   	Web Container로 전송
				 		   	JSP / Servlet
				 		   	========================
				 ** WAS는 어떤 것을 사용했는지?
				 	--- TOMCAT
				 	형상관리 : GIT	
				 		   
	2. 웹동작
				요청(request)
		client --------------   ---------------WAS-----------------
			   					1. request / response 객체 생성
			   --------------      -------  ---------
			   	응답(response)					|브라우저 정보(IP/PORT)
			   						 |사용자가 보낸 모든 정보
			   						  ?뒤에 있는 데이터
			   						  사용자의 브라우저 정보
			   						  (사용자 IP / 사용자 PORT)
			   					2. 서블릿 분석 => get방식 => doGet
			   									post방식 => doPost
			   					----------------------------------
			   						서블릿을 찾아서 HTML을 만들어서 브라우저 전송
			   						
			 JSP 동작
			 개발자(소스코딩) => 찾은JSP => 서블릿 변환 => 컴파일 => 실행
			 												  |
			 												메모리에 HTML
			 												메모리에 있는 HTML을 브라우저가 읽어가게 만든다
	3. Servlet VS JSP
		Servlet
		JSP
		---------------> 웹 서비스 기능(사용자 요청=>HTML로 변환해서 화면 출력)
		=>Servlet은 자바파일 => 수정시마다 컴파일을 해야 한다
		 1. 변경시마다 컴파일
		 2. HTML이 자바안에서 코딩 => 문자열
		 3. CSS를 구사하기 어렵다.. 개발자(HTML,JS,CSS,Java,Oracle...)
		=>단점을 보완 : JSP(HTML을 쉽게 다루게 만든다)
		=>장점
			서블릿보다 쉽고 작성하기 빠르다
			HTML과 Java가 분리가 되어 있다
			------------ 분업해서 사용이 가능
			=> 컴파일하지 않고 바로 확인이 가능하다
	4. JSP 주로 사용하는 위치
	   ---- VIEW만 사용(Java를 별도로 만들기 때문에) : 출력만 담당
	   ---- JSP가 점차적으로 사라지고 있다
	   		Spring : 서버 역할
	   		화면 출력 => HTML에서 직접 작업
	   				   ---------------HTML에 제어문 기능(타임리프)
	   				   ---------------Vue,React
	   	19page
	   	------
	   		요청 : URL을 이용해서 서버에 접근 => 요청
	   			  ---- 파일명?요청하는 데이터
	   		응답 : Servlet/JSP에서 받아서 처리후 => HTML로 변환
	   	------
	   	 정적페이지 : HTML(파일을 따로 제작)
	   	 동적페이지 : JSP / Servlet (한개의 파일안에서 데이터만 변경)
	   	 ------- 정적 쿼리 / 동적 쿼리
	5. JSP 문법
		***=지시자
		=스크립트릿
		***=내장 객체
		***=액션 태그
		***=빈즈
		***=JSTL
		***=EL
		***=MVC
		=========***는 Spring에서도 사용(JSP:브라우저 연결)
		
		26page
		 => JSP
		 	동적 페이지를 생성하기 위한 자바의 사용기술(자바)
		 	컴포넌트(클래스) 기반에서 개발 가능
		 => Servlet(28page)
		 	JSP와 연결해서 처리
		 	JSP : 정적페이지 : 코딩하기 편리(자바/HTML) 구분
		 					=> 소스 코딩이 노출(라이브러리 제작은 어려움)
		 	Servlet : 동적페이지 => 보안
		 	
		 	MVC
		 	Model : 자바
		 	View : 화면 출력(JSP)
		 	Controller : 서블릿(Spring)
		 	
		 	
		 	JSP 동작(72page)
		 	
		 	1. 사용자 요청
		 		브라우저 주소창만 이용이 가능
		 		http://localhost:8080/프로젝트명/폴더/.XXX.jsp
		 		=>      서버에 접근\
		 		
		 	2. 맨마지막 파일 
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