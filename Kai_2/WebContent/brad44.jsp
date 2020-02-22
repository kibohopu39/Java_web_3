<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<sql:setDataSource 
driver="com.mysql.cj.jdbc.Driver"
url="jdbc:mysql://localhost:3306/opendata?serverTimezone=Asia/Taipei"
user="root"
password="root"
></sql:setDataSource>


<!-- 看 API，結果放在 var 裡 -->
<<sql:query var="rs1">SELECT*FROM local_snacks</sql:query>


<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="100%">
		<tr>
			<th>Names</th>
			<th>Address</th>
			<th>Tel</th>
			<th>Latng</th>
		</tr>

	</table>
</body>
</html>