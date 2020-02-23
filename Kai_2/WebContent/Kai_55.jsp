<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// cookie ==> client
	// session ==> server ==> 
	if (session.getAttribute("account") == null){
		response.sendRedirect("brad53.jsp");
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Brad Big Company</h1>
Welcome, ${account }
<hr>
<a href="logout.jsp">Logout</a>
</body>
</html>