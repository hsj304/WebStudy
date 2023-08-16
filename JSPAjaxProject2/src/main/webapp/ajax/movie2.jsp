<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top: 200px;
}
.row{
	margin: 0px auto;
	width: 100%;
}
</style> 
</head>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"> </script>
<script type="text/javascript">
$(function(){
	$('input[type=button]').click(function () {
		//alert($(this).attr("data-no"))
		let no=$(this).attr("data-no")
		$.ajax({
			type:'post',
			url:'json.jsp',
			data:{"no":no},
			success:function(result)
			{
				let json=result.trim();
				let data="";
				for(let i=0; i<json.length;i++)
				{
					data+='<div class="col-md-2">'
    				+'<div class="thumbnail">'
    				+'<img src="http://www.kobis.or.kr'+json[i].thumbUrl+'" style="width:100%" class="images">'
    				+'<div class="caption">'
    				+'<p>'+json[i].movieNm+'</p>'
    				+'</div>'
    				+'</div>'
    				+'</div>';				
				}
				$('#print').html(data)
			}
		})
	})
})
</script>
<body>
	<div class="container">
		<div class="row">
			<input type=button value="일별 박스오피스" class="btn btn-sm btn-danger" data-no="1">
			<input type=button value="실시간 예매율" class="btn btn-sm btn-primary" data-no="2">
			<input type=button value="좌석 점유율" class="btn btn-sm btn-success" data-no="3">
		</div>
		<div style="height: 20px;"></div>
		<div class="row" id="print">
		
		</div>
	</div>
</body>
</html>