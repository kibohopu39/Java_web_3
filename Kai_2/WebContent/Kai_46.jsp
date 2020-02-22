<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!-- 詢問是account是不是空的，是才能新增 -->
	<!-- 連上資料庫後，把得到的資料用SQL語法新增到資料庫裡 -->
<c:if test="${!empty param.account}">
	<sql:setDataSource 
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/opendata?serverTimezone=Asia/Taipei"
		user="root" password="root"/>
	

	<sql:update var="count">
		INSERT INTO kai_45(realNames,Account,passwd) values(?,?,?)
		<sql:param>${param.realname }</sql:param>
		<sql:param>${param.account }</sql:param>
		<sql:param>${param.passwd }</sql:param>
	</sql:update>
	<c:redirect url="Kai_45.jsp"></c:redirect>
</c:if>
	<!-- 返回Kai_45.jsp那一頁 -->



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 頁面出現的表單給使用者填 -->
	<form action="Kai_46.jsp">
		Account:<input type="text" name="account" /><br>
		Password:<input type="password" name="passwd" /><br>
		RealNames:<input type="text" name="realname" /><br>
		<input type="submit" value="Add">
	</form>

</body>
</html>