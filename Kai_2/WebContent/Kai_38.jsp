<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- JSTL -->
<%
	//taglib, JSTL
	//tomcat taglib download
	//跟el語法不一樣但功能一樣的標籤
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//request.setAttribute("x", "123");
	%>
	<c:set var="x" value="123" scope= "page"/>
	x=${x }
	<br>
	<%
		//pageContext.setAttribute("y", "456");
	%>
	<c:set var="y" value="456" scope="request"/>
	x=${requestScope.y }<br>
	
	<c:out value="hello" /><br>
	<c:out value="${'hello' }" /><br>
	<c:out value="${z }" default="heyhey" /><br>
	${z!=null?z:"no value" }<br>
	
	<c:set var="var1" />12345<br>
	<c:out value="${var1 }" default="heyhey" /><br>
	
	
	
</body>
</html>