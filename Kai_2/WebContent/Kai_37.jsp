<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Kai_mysql.Kai_36_api" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Kai_37.jsp">
		<input type="number" name="x" value="${param.x}" required min=0 />
		<select
			name="ap">
			<option value="1" ${(param.ap=="1")?"selected":"" }>+</option>
			<option value="2" ${(param.ap=="2")?"selected":"" }>-</option>
			<option value="3" ${(param.ap=="3")?"selected":"" }>*</option>
			<option value="4" ${(param.ap=="4")?"selected":"" }>/</option>
		</select>
		<input type="number" name="y" value="${param.y}" />
		<input type="submit" value="=" />
		${Kai_36_api.calc(param.x,param.y,param.ap) }
	</form>
</body>
</html>