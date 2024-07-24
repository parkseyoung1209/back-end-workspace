<%@page import="com.kh.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%ArrayList<Member>list = (ArrayList<Member>) request.getAttribute("allList");
	 if(list!=null) {%>
	<%for(Member m : list) {%>
		<p><%=m %></p>
	<% }%>
	<% }%>
</body>
</html>