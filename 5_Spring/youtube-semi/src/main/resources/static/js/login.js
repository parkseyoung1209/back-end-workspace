id.addEventListener("input", function(e) {
	const regExp = /^[a-zA-Z][a-zA-Z0-9]{9,13}$/;
	$.ajax({
		type : 'post',
		url : '/check',
		data: {
			id: e.target.value
		},
		success : function(data) {
			if(data) {
				idCheck.innerHTML = "";
			}else {
				if(regExp.test(e.target.value)) {
						idCheck.style.color = "green";
						idCheck.innerHTML = "";
					} else if(e.target.value === "") {
						idCheck.innerHTML = "";
					} else {
						idCheck.style.color = "red";
						idCheck.innerHTML = "첫글자는 영어로, 영어 또는 숫자로만 10~14글자로 입력하세요"
					}
			}
		}
	});
	
});

function validate() {
	const regExp = /^[a-zA-Z][a-zA-Z0-9]{9,13}$/;
	$.ajax({
			type : 'post',
			url : '/check',
			data: {
				id: id.value
			},
			success : function(data) {
				if(data) {
					id.focus();
					return true;
				}else {
					if(!regExp.test(id.value)) {
						id.focus();
						return true;
					} else if(idt.value === "") {
						id.focus();
						return true;
					}
				}
			}
		});
}