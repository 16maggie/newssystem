<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.hnjd.news.dao.NewsDao" %>
<%@ page import="com.hnjd.news.dao.NewsDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hnjd.news.entity.News" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示所有新闻</title>
<style type="text/css">
	td a:hover{
		cursor: pointer;
		text-decoration: underline;
	}
</style>
</head>
<body>
	欢迎 !  ${user.uname}<br>
	<c:forEach items="${topicList}" var="topic">
		<a class="topic" data-tid="${topic.tid}" href="javascript:void(0)">${topic.tname}</a>
	</c:forEach>
	
	<form action="${pageContext.request.contextPath}/deleteNewsServlet" method="post">
		<table>
			<tr>
				<th><input type="submit" value="删除所选"></th>
				<th>新闻标题</th>
				<th>新闻作者</th>
				<th>创建时间</th>
				<th>修改时间</th>
				<th>操作</th>
			</tr>
			<c:forEach var="news" items="${newsList}">
				<tr>
					<td><input type="checkbox" name="nids" value="${news.nid}"></td>
					<td>
						<a href="${pageContext.request.contextPath}/selectNewsServlet?nid=${news.nid}">${news.ntitle}</a>
					</td>
					<td>${news.nauthor}</td>
					<td>${news.ncreateDate}</td>
					<td>${news.nmodifyDate}</td>
					<td>	
						<a href="${pageContext.request.contextPath}/selectNewsServlet?nid=${news.nid}&option=edit">修改</a>
						<a href="${pageContext.request.contextPath}/deleteNewsServlet?nid=${news.nid}">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript">
		$(".topic").on('click',function(){
			var tid = $(this).data("tid")
			$.ajax({
				url:"SelectNewsByTidServlet",
				type:"GET",
				dataType:"json",
				data:{"tid":tid},
				success:function(data){
					debugger
				},
				error:function(){
					alert("内部错误！")
				}
			})
		})
	</script>
	
</body>
</html>