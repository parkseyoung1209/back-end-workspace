<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>1) 기존 방식</h2>
	<%=request.getParameter("id") %>
	<p>test</p>
	<% String[] hobbyList = request.getParameterValues("hobby");
	for(String hobby : hobbyList) { %>
		<p>-<%=hobby %></p>
	<%}%>
	
	<h2>2) EL </h2>
	${param.id}<br>
	- ${paramValues.hobby[0]}<br>
	- ${paramValues.hobby[1]}<br>
</body>
</html>