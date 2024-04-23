<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./jsp_header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
	<div align="center" class="body">
		<h2>로그인화면</h2>
		<br> 환영합니다, ${loginUser.name}님! <br> <br>
		<br>
		<br> <a href="edit?userId=${loginUser.id}">[회원정보 수정]</a>
		<br>
		<br> <a href="list">[회원 목록]</a>
	</div>
</body>
</html>