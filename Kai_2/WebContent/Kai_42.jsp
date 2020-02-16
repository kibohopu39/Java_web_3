<%@page import="Kai_mysql.BCrypt"%>
<%@page import="java.util.Properties"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:catch var="errMesg"></c:catch>

<%
	String passwd= BCrypt.hashpw("123456", BCrypt.gensalt());	


	Class.forName("com.mysql.cj.jdbc.Driver");
	Properties prop = new Properties();
	prop.put("user", "root");
	prop.put("password","root");
	prop.put("serverTimezone","Asia/Taipei");
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/brad",prop);
	
	String sql="INSERT INTO cust (account,passwd) VALUES(?,?)";
	PreparedStatement pstmt=conn.prepareStatement(sql);
	pstmt.setString(1, "aaa");
	pstmt.setString(2, passwd);
	pstmt.executeUpdate();
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${errMesg!=null }">${errMesg }</c:if>

</body>
</html>