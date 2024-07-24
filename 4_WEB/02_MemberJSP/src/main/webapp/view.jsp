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
	<h2>회원 조회</h2>
	<form action="search">
		검색할 회원 아이디를 입력해주세요<br>
		<input type = "text" name ="id">
		<input type = "submit" value="조회">
	</form>
<%-- ViewServlet : 전체 회원 보기 관련 비즈니스 로직 구현 --%>

	<h1>전체 리스트</h1>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<% ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
			if(list!=null) {
			for(Member m : list) {
			%>
				<tr>
					<td><%=m.getId() %></td>
					<td><%=m.getPassword() %></td>
					<td><%=m.getName() %></td>
				</tr>
		<% 	}}%>
		</tr>
		<%-- 리스트로 가지고 오시고 for문 활용! --%>
	</table>
</body>
</html>