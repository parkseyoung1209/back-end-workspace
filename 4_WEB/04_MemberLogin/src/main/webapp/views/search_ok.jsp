<%@page import="com.kh.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%Member member = (Member) request.getAttribute("member"); %>
		<%if(member!=null) {%>
		<p>id: <%=member.getId() %></p>
		<p>비밀번호: <%=member.getPassword() %></p>
		<p>이름: <%=member.getName() %></p>
		<% }%>
</body>
</html>