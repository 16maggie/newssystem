<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>根据条件查询新闻</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/SelectNewsByCondition" method="post">
		新闻标题：<input type="text" name="ntitle">
		新闻类型：<select name="ntid">
					<option value="1">国内</option>
				</select>
		新闻作者：<input type="text" name="nauthor">
		新闻创建时间：<input type="date" name="ncreateDate">
		<input type="submit" value="查询">
	</form>
	<table>
		<tr>
			<th>新闻标题</th>
			<th>新闻作者</th>
			<th>创建时间</th>
			<th>修改时间</th>
		</tr>
		<c:forEach var="news" items="${newsByCondition}">
			<tr>
				<td>${news.ntitle}</td>
				<td>${news.nauthor}</td>
				<td>${news.ncreateDate}</td>
				<td>${news.nmodifyDate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>