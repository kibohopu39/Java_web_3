<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//隱含物件 request
	String method = request.getMethod();
	//隱含物件 out ==> respond.getWriter() ==> PrintWriter
	out.print(method + "<br>");
	//隱含物件 pageContext
	//這邊在測試 ServletRequest 是不是 HttpServletRequest，並闡述在 get...的方法命名邏輯下
	//該類別應該會有什麼屬性可以讓你直接取得屬性
	ServletRequest sr = pageContext.getRequest();
	out.println(sr instanceof HttpServletRequest);
	out.println((sr == request) + "<br>");
	//取得對於本機來說的遠端IP
	String remoteIP = request.getRemoteAddr();
	out.println(remoteIP + "<br>");
	//取得傳遞URL後面的參數 =>測試一下更改mathod成post看看並想想
	String qs = request.getQueryString();
	out.println(qs + "<br>");
	
	String[] likes = request.getParameterValues("like");
	
	String country = pageContext.getResponse().getLocale().getDisplayCountry();
	out.println(country);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br> Method = ${pageContext.request.method}
	<br> Your IP = ${pageContext.request.remoteAddr}
	<br> QueryString = ${pageContext.request.queryString}
	<br> Account: ${param.account}
	<br> Account: ${param.passwd}
	<br> Like1:${paramValues.like[0] }
	<br> Like2:${paramValues.like[1] }
	<br> Like3:${paramValues.like[2] }
	<br> Country: ${pageContext.response.locale.displayCountry}
</body>
</html>