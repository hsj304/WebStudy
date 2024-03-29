<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*,java.util.*"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.cotainer{
	margin-top: 50px;
}
.row{
	margin: 0px auto;
	width: 1200px;
}
</style>
</head>
<body>
	<div class=container>
		<h1>믿고 보는 맛집리스트</h1>
		<hr>
		<div class=row>
			<c:forEach var="vo" items="${list }" varStatus="s">
				<c:if test="${s.index>=0 && s.index<12 }">
					<div class="col-md-3">
					    <div class="thumbnail">
					      <a href="food_list.do?cno=${vo.cno }">
					        <img src="${vo.poster }" style="width:100%;">
					        <div class="caption">
					          <p>${vo.title }</p>
					        </div>
					      </a>
					    </div>
					</div>				
				</c:if>
			</c:forEach>
		</div>
		<h1>지역별 맛집리스트</h1>
		<hr>
		<div class=row>
			<c:forEach var="vo" items="${list }" varStatus="s">
				<c:if test="${s.index>=12 && s.index<18 }">
					<div class="col-md-3">
					    <div class="thumbnail">
					      <a href="food_list.do?cno=${vo.cno }">
					        <img src="${vo.poster }" style="width:100%;">
					        <div class="caption">
					          <p>${vo.title }</p>
					        </div>
					      </a>
					    </div>
					</div>	
				</c:if>
			</c:forEach>
		</div>
		<h1>인기 메뉴별 맛집리스트</h1>
		<hr>
		<div class=row>
			<c:forEach var="vo" items="${list }" varStatus="s">
				<c:if test="${s.index>=18 && s.index<30 }">
					<div class="col-md-3">
					    <div class="thumbnail">
					      <a href="food_list.do?cno=${vo.cno }">
					        <img src="${vo.poster }" style="width:100%;">
					        <div class="caption">
					          <p>${vo.title }</p>
					        </div>
					      </a>
					    </div>
					</div>	
				</c:if>
			</c:forEach>
		</div>
	</div>
</body>
</html>