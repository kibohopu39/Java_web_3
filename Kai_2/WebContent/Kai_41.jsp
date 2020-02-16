<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="Kai_mysql.Kai_36_api"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<%
	String[] names = { "永強", "劉英", "皮長山" };
	pageContext.setAttribute("names", names);
	/*
	for (String name : names) {
	
	}
	*/
%>
<!-- 用標籤寫程式 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
tr { <c:choose> 
	<c:when test="${status.index%2==0}">pink</c:when> 
	<c:otherwise>yellow</c:otherwise> 
	</c:choose>
}
</style>
<body>
	<table border="1" width="100%">
		<tr>
			<th>Index</th>
			<th>Names</th>
			<th>Count</th>
		</tr>
		<!-- 這裡告訴我們可以把後端的參數傳到網頁的文件上，且是利用標籤的形式，不過要先載 taglib -->
		<c:forEach items="${names }" var="name" varStatus="status">
			<tr>
				<td>${status.index +1}</td>
				<td>${name }</td>
				<td>${status.count}</td>
				<td>${status.first}</td>
				<td>${status.last}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>