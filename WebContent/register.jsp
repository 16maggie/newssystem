<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="form">
		<input name="uname" placeholder="请输入用户名">
		<input name="upwd" placeholder="请输入密码">
		<input name="upwd2" placeholder="请确认密码">
		<input type="submit"  value="提交">
	</form>
	<h1 id="result"></h1>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript">
		$("#form").on("submit",function(){
			upwd = $("input[name='upwd']").val();
			upwd2 = $("input[name='upwd2']").val();
			if(!(upwd == upwd2)) {
				alert("两次密码输入不一致！") ;
				return;
			}
			$.ajax({
				"url":"UserRegisterServlet",
				"type":"post",
				"dataType":"json",
				"data": $("#form").serializeArray(),
				"success":function(data){
					alert(data.result);
					if(data.code == "000"){
						location.href = "login.jsp?uname="+$("input[name='uname']").val();
					}
					return false;
				}
			})
			return false; 
		})
	</script>
</body>
</html>