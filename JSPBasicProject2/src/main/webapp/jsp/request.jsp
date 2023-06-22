<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%--
	JSP
		1. 동작 순서
			1)client 요청 (주소창을 이용해서 서버에 연결)
			  http://localhost:8080 /JSPBasicProject2/jsp/request.jsp
			  ---------------------  --------------------------------
			       		|서버관련						|클라이언트 요청 관련
			       		----------------------------------------------URL
			       									|URI
			       									
		public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
		{
			final javax.servlet.jsp.PageContext pageContext;
		    javax.servlet.http.HttpSession session = null;
		    final javax.servlet.ServletContext application;
		    final javax.servlet.ServletConfig config;
		    javax.servlet.jsp.JspWriter out = null;
		    final java.lang.Object page = this;
		    javax.servlet.jsp.JspWriter _jspx_out = null;
		    javax.servlet.jsp.PageContext _jspx_page_context = null;
		    
		    소스 코딩 영역
		}
		
		3) 추가 정보
		setAttribute() : request 데이터 추가 전송
		getAttribute() : 전송된 데이터 읽기
		
		
 --%> 				
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
	.container{
		margin-top:50px;
	}
	.row{
		margin:0px auto;
		width:800px;
	}
	h1{
		text-align:center;
	}
</style>

</head>
<body>
	<div class=container>
		<h1>개인 정보</h1>
		<div class=row>
			<form action="request_ok.jsp" method=post>
				<table class=table>
					<tr>
						<th class=text-center width=20%>이름</th>
						<td width=80%>
							<input type=text name=name size=15 class="input-sm">
						</td>
					</tr>
					
					<tr>
						<th class=text-center width=20%>성별</th>
						<td width=80%>
							<%-- 라디오 버튼은 반드시 그룹(name 통일) --%>
							<input type=radio name=sex value=남자 checked>남자
							<input type=radio name=sex value=여자>여자
						</td>
					</tr>
					
					<tr>
						<th class=text-center width=20%>전화번호</th>
						<td width=80%>
						<%--
							getParameter("tel")
						 --%>
							<select name="tel" class="input-sm">
								<option>010</option>
							</select>
							<input type=text name=tel2 size=15 class=input-sm>
						</td>
					</tr>
					
					<tr>
						<th class=text-center width=20%>소개</th>
						<td width=80%>
							<textarea rows="8" cols="50" name="content"></textarea>
						</td>
					</tr>
					
					<tr>
						<th class=text-center width=20%>취미</th>
						<td width=80%>
							<input type=checkbox name=hobby value=운동>운동
							<input type=checkbox name=hobby value=등산>등산
							<input type=checkbox name=hobby value=낚시>낚시
							<input type=checkbox name=hobby value=게임>게임
							<input type=checkbox name=hobby value=공부>공부
							<input type=checkbox name=hobby value=자전거>자전거
							<input type=checkbox name=hobby value=여행>여행
							<input type=checkbox name=hobby value=컴퓨터>컴퓨터
						</td>
					</tr>
					
					<tr>
						<td colspan=2 class=text-center>
							<button class="btn btn-sm btn-danger">전송</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>