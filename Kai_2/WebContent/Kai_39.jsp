<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:catch>
<%
String num=request.getParameter("n");
int n=Integer.parseInt(num);
out.print(n);
%><br>
</c:catch>

<hr>

</body>
</html>