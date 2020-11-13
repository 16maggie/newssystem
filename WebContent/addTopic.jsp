<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<input type="text" name="tname">
		<input type="button" value="添加主题" onclick="addTopic()">
	</form>
	<script type="text/javascript">
	function addTopic(){
		//创建XMLHttpRequest对象（BOM）
		var xhr = new XMLHttpRequest();
		//兼容老版本IE(IE5/IE6)
		if(xhr == null){
			xhr = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xhr.open("POST","AddTopicServlet",true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		//GET请求中，参数直接携带在地址后面，此处填null即可
		xhr.send("tname="+document.getElementsByName("tname")[0].value);
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200 ){
				alert(xhr.responseText)
			}
		}
	}
	</script>
</body>
</html>