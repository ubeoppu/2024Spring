<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="jsp_header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
	<div class="login-page">
		<div class="form">
			<form:form class="login-form" modelAttribute="user" method="post"
				action="login">
				<p align="left">
					<span class="fieldError"><form:errors path="id" /></span>
				</p>
				<form:input path='id' type="text" placeholder="username" />

				<p align="left">
					<span class="fieldError"><form:errors path="pass" /></span>
				</p>
				<form:input path='pass' type="password" placeholder="password" />

				<button type="submit">login</button>

				<p class="message">
				<ul id="ullog">
					<li id="lilogb"><a href="join">회원가입</a></li>
					<li id="lilog"><a href="findId">아이디 찾기</a> 
					<a href="findPass" class="pwd">비밀번호 찾기</a></li>
				</ul></p>
			</form:form>
		</div>
	</div>
</body>
</html>