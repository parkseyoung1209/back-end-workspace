<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</head>
<body>
	<form id="frm">
	Id : <input type="text" id="id" name="id"><br>
	pwd : <input type="text" id="password" name="password"><br>
	name : <input type="text" id="name" name="name"><br>
	
	<input type="button" value="가입" id="btn">
	</form>
	
	<div id="result"></div>
	
	<script>
		$("#btn").click(() => {
			const id = $("#id").val();
			const password = $("#password").val();
			const name = $("#name").val();
			const user = {id, password, name};
			$.ajax({
				type : "post",
				url : "/serial",
				data : $("#frm").serialize(),
				success : function(result) {
					$("#result").html("id : "+id+"<br>"+"pwd: "+password+"<br>"+"name : "+name);
				},
				error: function() {
					alert("회원가입 실패!");
				}
			})
		});
		
	
	</script>
</body>
</html>