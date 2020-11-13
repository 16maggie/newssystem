<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" enctype="application/x-www-form-urlencoded">
		<input type="text" >
		<input type="file" >
	</form>
	
	<script type="text/javascript">
		//创建XMLHttpRequest对象（BOM）
		var xhr = new XMLHttpRequest();
		//兼容老版本IE(IE5/IE6)
		if(xhr == null){
			xhr = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xhr.open("POST","JSAjaxServlet",true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		//GET请求中，参数直接携带在地址后面，此处填null即可
		xhr.send("username=张三&age=18&sex=男");
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200 ){
				alert(xhr.responseText)
			}
		}
	</script>
</body>
</html>