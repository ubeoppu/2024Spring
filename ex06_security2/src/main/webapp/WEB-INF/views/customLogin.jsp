<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>customLogin Page</h1>
	<h2>${error }</h2>
	<h2>${logout }</h2>
	<form action="/login" method="post">
		<div>
			<input type="text" name="username" value="admin">
		</div>
		<div>
			<input type="text" name="password" value="1234">
		</div>
		
		<div>
		<input type="checkbox" name="remember-me">ReMember Me
		</div>
		
		<div>
			<input type="submit">
		</div>
		
		
		<!-- <security:csrf disabled="true"/>없을 시 post 요청 일 경우 반드시 기입* -->
		<%-- <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"> --%>



	</form>
</body>
</html>