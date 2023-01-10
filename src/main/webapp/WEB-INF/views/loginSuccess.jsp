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
		<H1>WELLCOME</H1>
			${memberInfo}
		<div>
		</div>
		<div style="display: flex; justify-content: center;">
			<form method="POST" action="log-out">
				<button id="logoutBtn" style="width: 100px; height: 50px">LOG OUT</button>
			</form>
		</div>
	</div>
</body>
<script>
</script>
</html>