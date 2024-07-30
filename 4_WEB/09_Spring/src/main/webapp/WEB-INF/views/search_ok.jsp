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
		<p>id: ${member.id }</p>
		<p>비밀번호:  ${member.password}</p>
		<p>이름:  ${member.name}</p>
		<a href="/">메인 페이지로 돌아가기</a>
</body>
</html>