<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="e04" %>
<!-- 標籤裡用functions -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="var1" value="hello world"></c:set>
	<c:if test='${fn:contains(var1,"hello world") }'>
	</c:if>
	<e04:柬埔寨>ss</e04:柬埔寨>
</body>
</html>