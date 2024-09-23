<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
    crossorigin="anonymous" />
</head>
<body>
	<div class="container">
		<div class="header">
			<table class="table">
			<thead>
				<tr>
					<th>${content.no}) 제목 : ${content.title}</th>
					<th>등록시간 : ${content.date}</th>
				</tr>
			</thead>
			</table>
			<c:if test="${not empty content.url}">
			<img src="${pageContext.request.contextPath}/upload/${content.url}">
			</c:if>
			<textarea rows="10" name="content" class="form-control" readonly>${content.content}</textarea>
		</div>
		<!-- img 태그 사용! 
			수정시 file이 있다면 기존 파일은 삭제 하고 새로 추가된 파일로 업로드하고 db 수정
			삭제시 업로드한 파일도 삭제 (파일 삭제 : file 객체의 delete() 메서드 사용)
		-->
			<button type="submit" class="btn btn-outline-warning" id="update">수정</button>
			
	</div>
</body>
</html>