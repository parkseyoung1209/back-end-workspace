<%@page import="com.kh.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	<tr>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>이름</th>
	</tr>
	<c:forEach items="${allList}" var="m" varStatus="status">
		<tr>
			<%-- index : 0부터, count : 1부터 시작 --%>
			<td>${status.count}</td>
			<td>${m.id}</td>
			<td>${m.password}</td>
			<td>${m.name}</td>
		</tr>
		</c:forEach>
	</table>
	<a href="/">돌아가기</a>
</body>
</html>