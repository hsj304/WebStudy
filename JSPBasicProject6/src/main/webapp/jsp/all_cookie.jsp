<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.FoodBean"%>
<%@page import="java.util.List"%>
<%@page import="com.sist.dao.FoodDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	Cookie[] cookies=request.getCookies();
	FoodDAO dao=FoodDAO.newInstance();
	List<FoodBean> cList=new ArrayList<FoodBean>();
	if(cookies!=null){
		for(int i=0;i<cookies.length;i++){
			if(cookies[i].getName().startsWith("food_")){
				
			}
		}
	}
%>

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
	width: 960px;
}
</style> 
</head>
<body>
	<div class=container>
		<div class=row>
		<%
			int i=0;
			if(cookies!=null && cList.size() >0){
		
				for(FoodBean vo:cList){
					if(i==8)
						break;
		%>
					
							<td>
							<img src="<%=vo.getPoster() %>" style="width:100px;height:100px; title="<%=vo.getName() %>>"<p>
							<a href="cookie_delete.jsp?fno=<%=vo.getFno() %>" class="btn btn-xs btn-danger">삭제</a>
							</td>
		<%
					i++;
				}
			} else {
		%>
			<h3>쿠키가 없습니다</h3>
		<%
			}
		%>
		</div>
	</div>
</body>
</html>
