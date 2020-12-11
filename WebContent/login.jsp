<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${user == null && code == 111}">账号密码不正确！</c:if>
	<c:if test="${user == null && code == 222}">请先登录！</c:if>
	<form  id="loginForm" action="UserLoginServlet" method="post">
		<input placeholder="请输入用户名"  name="uname">
		<input placeholder="请输入密码" name="upwd">
		<input type="submit"> 
	</form>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript">
	
		$("#loginForm").on("submit",function(){
			if($("input[name='uname']").val().length>0 && $("input[name='upwd']").val().length>0){
				return true;
			}else{
				alert("用户名和密码不能为空！")
				return false;
			}
		
		})
	</script>
</body>
</html>