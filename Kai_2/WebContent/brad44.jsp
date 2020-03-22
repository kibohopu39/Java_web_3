<%@page import="javax.servlet.jsp.jstl.sql.Result"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<sql:setDataSource driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/opendata?serverTimezone=Asia/Taipei"
	user="root" password="root"></sql:setDataSource>

<sql:query var="rs1">
SELECT * FROM local_snacks
</sql:query>

<c:set var="rpp" value="10" />


<%                        
	Result result =  (Result)pageContext.getAttribute("rs1");
	int rowCount = result.getRowCount();
	int rpp = Integer.parseInt((String)pageContext.getAttribute("rpp"));
	int pages = rowCount % rpp == 0 ? rowCount/rpp : rowCount/rpp+1;// int ==> Integer
	pageContext.setAttribute("pages", pages);
%>

<c:set var="page" value="${param.page == null ? 1 : param.page }" />
<c:set var="start" value="${(page - 1) * rpp }" />
<c:set var="prev" value="${page == 1? 1 : page-1 }" />
<c:set var="next" value="${page == pages? page : page + 1 }" />

<!-- 看 API，結果放在 var 裡 -->
<sql:query var="result">SELECT*FROM local_snacks limit ${start}, ${rpp}</sql:query>




<!-- 撰寫上下一頁的參數 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="?page=${prev }">上一頁</a> |
	<a href="?page=${next }">下一頁</a> 總筆數:${result.rowCount}
	<hr>
	<table border="1" width="100%">
		<tr>
			<th>Names</th>
			<th>Address</th>
			<th>Tel</th>
			<th>Latng</th>
			<th>id</th>
			<th>pic</th>
		</tr>


		<c:forEach items="${result.rows }" var="row">
			<tr>
				<td>${row.cname }</td>
				<td>${row.address }</td>
				<td>${row.tel }</td>
				<td>${row.latng }</td>
				<td>${row.id }</td>
				<td><img src="${row.picurl }" width="128px" height="96px"></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>