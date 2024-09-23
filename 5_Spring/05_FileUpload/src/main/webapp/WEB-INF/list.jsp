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
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="header">
		<h1>List Page</h1>
		<a href="/write" class="btn btn-outline-warning">게시글 등록</a>
		</div>
		
		<table class="table">
			<thead>
				<tr>
					<th>#번호</th>
					<th>제목</th>
					<th>작성시간</th>
				</tr>
			</thead>
			<tbody>
				<!-- 리스트 가져다가 뿌리기! -->
					<c:forEach items="${list}" var="board">
					<tr>
						<th class="no">${board.no}</th>
						<th id="${board.no}"><a href="/contentInfo" class="title">${board.title}</a></th>
						<th>${board.date}</th>
						</tr>
					</c:forEach>

			</tbody>
		</table>
	</div>
	<script>
		$(".title").click((e) => {
			const id = $(e.target).parent().attr('id');
			$.ajax({
				type : 'post',
				url : '/contentInfo',
				data : {number : id},
				success : function() {
					console.log("!");
				}
			});
		});
	</script>
</body>
</html>