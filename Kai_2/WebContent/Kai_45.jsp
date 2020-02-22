<%@page import="javax.servlet.jsp.jstl.sql.Result"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<sql:setDataSource driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/opendata?serverTimezone=Asia/Taipei"
	user="root" password="root"></sql:setDataSource>

<!--  -->
<c:if test="${!empty param.delid }">
	<sql:update>
		DELETE FROM Kai_45 WHERE id = ?
		<sql:param>${param.delid }</sql:param>
	</sql:update>
</c:if>
<!-- SQL 查詢該表單，並存於 result 的物件 (var) -->
<sql:query var="result">
SELECT * FROM Kai_45
</sql:query>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 在資料庫增加一列 -->
<!-- 點擊後前往 Kai_46.jsp -->
	<a href="Kai_46.jsp">Add New one</a>
	<hr>
	<table border="1" width="100%">
		<tr>
			<th>realNames</th>
			<th>Account</th>
			<th>id</th>
			<th>Del</th>
			<th>Edit</th>
		</tr>
		<c:forEach items="${result.rows }" var="row">
			<tr>
				<td>${row.realNames }</td>
				<td>${row.Account }</td>
				<td>${row.id }</td>
				<script>
				function delconfirm(account){
					return confirm("DELETE"+account+"?");
				}
				</script>
				<td><a href='?delid=${row.id }'
					onclick="return=delconfirm('${row.account }')">Del</a></td>
				<td><a href='Kai_47.jsp?editid=${row.id }'><button>Edit</button></a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>