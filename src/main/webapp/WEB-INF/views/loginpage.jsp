<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div
		style="width: 350px; height: 500px; border: outset; display: flex; justify-content: space-evenly; align-content: center; flex-wrap: wrap; flex-direction: column;">
		<H1>DO LOGIN!!</H1>

		<div>
			<span>
				<h2>USERNAME</h2> <input type="text" id="username">
			</span> <span>
				<h2>PASSWORD</h2> <input type="password" id="password">
			</span>
		</div>
		<div style="display: flex; justify-content: center;">
			<button id="loginBtn" style="width: 100px; height: 50px">LOGIN</button>
		</div>
		<div style="display: flex; justify-content: center;">
			<button id="loginCheckBtn" style="width: 100px; height: 50px">LOGIN
				CHECK</button>
		</div>
	</div>
</body>
<script>
document.querySelector("#loginBtn").addEventListener("click",() => {
	const username = document.querySelector("#username").value
	const password = document.querySelector("#password").value
	
	const loginObj = {username:username, password:password}
	
	fetch("http://localhost:8081/security/login", {
		method: 'POST',
		body: JSON.stringify(loginObj),
		headers: {
		      'Content-Type': 'application/json',
		    },
	})
	.then(response => {
		console.log(response)
	})
}, false)
document.querySelector("#loginCheckBtn").addEventListener("click",() => {
	fetch("http://localhost:8081/security/login-check", {
		method: 'POST',
		headers: {
		      'Content-Type': 'application/json',
		    },
	})
	.then(response => {
		console.log(response)
	})
}, false)
</script>
</html>