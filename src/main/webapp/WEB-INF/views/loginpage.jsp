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
		<H1>DO LOGIN!!</H1>

		<div>
			<span>
				<h2>ID</h2> <input type="text" id="username">
			</span> <span>
				<h2>PASSWORD</h2> <input type="password" id="password">
			</span>
		</div>
		<div style="display: flex; justify-content: center;">
			<button id="loginBtn" style="width: 100px; height: 50px">LOGIN</button>
		</div>
		<div style="display: flex; justify-content: center;">
			<button id="signupBtn" style="width: 100px; height: 50px">SIGN UP</button>
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
	
	axios({
		url: "http://localhost:8081/security/login",
		method: 'POST',
		data: JSON.stringify(loginObj),
		headers: {
		      'Content-Type': 'application/json',
		    },
	})
	.then(res=> {
		console.log(res.data)
		location.href = 'login-success'
	})
	.catch(res => alert("Fail Login........"))
}, false)

document.querySelector("#signupBtn").addEventListener("click",() => {
	location.href = "signup"
}, false)

document.querySelector("#loginCheckBtn").addEventListener("click",() => {
	axios({
		url: "http://localhost:8081/security/login-check",
		method: 'POST',
		headers: {
		      'Content-Type': 'application/json',
		    },
	})
	.then(res => console.log(res.data))
}, false)

	session = document.cookie
	console.log(session)
 
</script>
</html>