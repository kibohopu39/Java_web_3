<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if (!session.isNew()){
		if (session.getAttribute("account") != null){
			response.sendRedirect("brad55.jsp");
		}else{
			response.sendRedirect("logout.jsp");
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="brad54.jsp">
	Account:<input type="text" name="account" /><br>
	Password:<input type="password" name="passwd" /><br>
	<input type="submit" value="Login" />
</form>

</body>
</html>