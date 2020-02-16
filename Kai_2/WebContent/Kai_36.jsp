<%@page import="java_ee20200209.Member"%>
<%@page import="Kai_mysql.Kai_36_api"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String[] aaa = { "V1", "V2", "V3", "V4", "V5" };
	//35是獲取整個頁面的某個特定數值，這裡我們來看能不能從自己設置的邏輯裡讀取他??並呈現在網頁上?
	pageContext.setAttribute("username", aaa);
	String[] bbb = { "V1b", "V2b", "V3b", "V4b", "V5b" };
	request.setAttribute("username2", bbb);
	
	//案例2
	LinkedList<String> list = new LinkedList<>();
	list.add("AAA");
	list.add("BBB");
	list.add("CCC");
	request.setAttribute("listdata", list);
	
	//案例3
	HashMap<String,String> map = new HashMap<>();
	map.put("K1","V1");
	map.put("K2","V2");
	map.put("K3","V3");
	request.setAttribute("map", map);
	
	Member member=new Member();
	member.setAccount("aaa");
	member.setRealName("甘梅");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- ${} 裡面拿到的東西都是String-->
	username1: ${username[0] }
	<br> username2: ${username2[0] }
	<br> List:${listdata[param.i]}
	<br> Map1: ${map["K1"] }
	<br> Map2: ${map.K2}
	<br> Map3: ${map[param.key] }
	<!-- key 是從網頁 request 得來的參數 -->
	<br> Lottery1: <%=Kai_36_api.createLottery() %>
	<br> Lottery2: ${Kai_36_api.createLottery() }
	<br> random: ${Math.random() }
	<!-- x 是從網頁讀取的參數 -->
	<br> Hello: ${Kai_36_api.say(param.x) }
	<!-- ${} -->
	<br> Account: ${member.acount }
	<br> RealName: ${member.realname }
</body>
</html>