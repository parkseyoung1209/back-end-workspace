<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/front" method="post">
	<h1>로그인</h1>
	<input type="hidden" name="command" value="login">
	<p><label for="id">ID : <input type="text" name = "id"></label></p>
	<p><label for="pwd">비밀번호 : <input type="password" name = "pwd"></label></p>
	<input type="submit" value="로그인">
	</form>
</body>
</html>