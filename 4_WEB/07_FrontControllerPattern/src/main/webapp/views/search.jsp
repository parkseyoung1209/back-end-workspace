<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/front" method="get">
		<input type="hidden" name="command" value="search">
		<label for=id>ID : <input type="text" name="id"></label>
		<input type="submit" value="정보확인">
	</form>
</body>
</html>