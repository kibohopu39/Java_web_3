<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<sql:setDataSource driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/opendata?serverTimezone=Asia/Taipei"
	user="root" password="root"></sql:setDataSource>
<!-- 交易機制 -->
<c:catch>
	<sql:transaction>
		<sql:update>
			INSERT INTO kai_45(account,realname) values(?,?)
			<sql:param>Eric</sql:param>
			<sql:param>Eric Wang</sql:param>
		</sql:update>
		<sql:query var="lastid">
			SELECTE last_insert_id() as newid
		</sql:query>
		<sql:update>
			UPDATE kai_45 SET passwd=? WHERE id=?
			<sql:param>${lastid.rows[0].newid }</sql:param>
			<sql:param>1</sql:param>
		</sql:update>
	</sql:transaction>



</c:catch>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>