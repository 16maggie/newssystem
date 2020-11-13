<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		//BOM
		var xhr = new XMLHttpRequest();	
		if(xhr == null){
			xhr = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xhr.open("POST","JSAjaxServlet",true);
		//如果使用get方式提交，提交的参数直接写在地址栏后面，在send()中填入null即可
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send("username=张三&age=19&sex=男");
		alert("1")
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				alert(xhr.responseText)
			}
		}
	</script>
</body>
</html>