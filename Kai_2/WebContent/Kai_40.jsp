<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="Kai_mysql.Kai_36_api" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 用標籤寫程式 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>神來</h1>
	<hr>

	<!-- el 可以做判斷 -->
	<c:if test='${param.n=="100" }' var="result">hello,World</c:if>

	<c:set var="score">${Kai_36_api.randomScore() }</c:set>
	Score: ${score }
	<br>

	<!-- 選擇分支，注意型別 -->
	<c:choose>
		<c:when test="${score >=90 }">A</c:when>
		<c:when test="${score >=80 }">B</c:when>
		<c:when test="${score >=70 }">C</c:when>
		<c:when test="${score >=60 }">D</c:when>
		<c:otherwise>E</c:otherwise>
	</c:choose>

</body>
</html>