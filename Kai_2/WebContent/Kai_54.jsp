<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if (session.isNew() ||
			request.getParameter("account") == null ||
			request.getParameter("passwd") == null){
		// 
		response.sendRedirect("brad53.jsp");
		return;
	}
	String account = request.getParameter("account"); 
	String passwd = request.getParameter("passwd");
	if (account.equals("brad") && passwd.equals("123")){
		// Login Suceess
		session.setAttribute("account", account);
		response.sendRedirect("brad55.jsp");
	}else{
		// Login failure
		response.sendRedirect("brad53.jsp");
	}
%>