
<%@page import="org.eclipse.jdt.internal.compiler.lookup.MethodScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%
String method=request.getMethod();
if (method.equals("POST")){
	response.sendError(response.SC_INTERNAL_SERVER_ERROR);
}
%>
<c:if test="${!empty param.account}">
	<sql:setDataSource 
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/opendata?serverTimezone=Asia/Taipei"
		user="root" password="root"/>
	

	<sql:update var="count">
		INSERT INTO cust(realNames,Account,passwd) values(?,?,?)
		<sql:param>${param.realname }</sql:param>
		<sql:param>${param.account }</sql:param>
		<sql:param>${param.passwd }</sql:param>
	</sql:update>
</c:if>