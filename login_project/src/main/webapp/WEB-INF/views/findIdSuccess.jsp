<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./jsp_header.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
</head>
<body>
<br><br>
	<div align="center" class = "body">
		<h2>아이디 찾기</h2>
		<br>
		${findUser.name}님의 아이디는${findUser.id} 입니다.
		<br><br><br>
	<a href="login">[로그인]</a>
	</div>
</body>
</html>