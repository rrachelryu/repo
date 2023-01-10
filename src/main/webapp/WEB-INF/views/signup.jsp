<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/1.2.2/axios.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div
		style="width: 350px; height: 500px; border: outset; display: flex; justify-content: space-evenly; align-content: center; flex-wrap: wrap; flex-direction: column;">
		<H1>SIGN UP!!</H1>

		<div>
			<span>
				<h2>ID</h2> <input type="text" id="username">
			</span> 
			<span>
				<h2>PASSWORD</h2> <input type="password" id="password">
			</span>
			<span>
				<h2>NICKNAME</h2> <input type="text" id="nickname">
			</span>
		</div>
		<div style="display: flex; justify-content: center;">
			<button id="signupBtn" style="width: 100px; height: 50px">OK</button>
		</div>
	</div>
</body>
<script>
document.querySelector("#signupBtn").addEventListener("click",() => {
	const username = document.querySelector("#username").value
	const password = document.querySelector("#password").value
	const nickname = document.querySelector("#nickname").value
	
	const signupObj = {
			securityDTO: {
				username: username, 
				password: password
			},
			memberDTO: {
				memNm: nickname,
				grade: 0
			}
	}
	
	axios({
		url: "http://localhost:8081/security/signup", 
		method: 'POST',
		data: JSON.stringify(signupObj),
		headers: {
		      'Content-Type': 'application/json',
		    },
	})
	.then(res => {
		location.href = "login-success"
	})
	.catch(error => {
		console.log(error.response.status)
		if(error.response.status === 500) {
			alert("Fail Signup.....")
		}
		console.log("error")
		})
}, false)
</script>
</html>