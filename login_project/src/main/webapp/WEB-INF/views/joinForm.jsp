<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
	<div ailgn="center" class="body">
		<h2>회원가입</h2>
		<form method ="post" action = "join">
		<table border="1" width='600' cellpadding='0' cellspacing='0'>
			<tr height="40px">
				<td bgcolor='cccccc' width='100' align='center'>아이디</td>
				<td> <input type="text" name="id"></td>
			</tr>
			<tr height="40px">
				<td bgcolor='cccccc' width='100' align='center'>패스워드</td>
				<td> <input type="text" name="pass"></td>
			</tr>
			<tr height="40px">
				<td bgcolor='cccccc' width='100' align='center'>이름</td>
				<td> <input type="text" name="name"></td>
			</tr>
			<tr height="40px">
				<td bgcolor='cccccc' width='100' align='center'>우편번호</td>
				<td> <input type="text" name="zip"></td>
			</tr>
			<tr height="40px">
				<td bgcolor='cccccc' width='100' align='center'>주소</td>
				<td> <input type="text" name="addr1"></td>
			</tr>
			<tr height="40px">
				<td bgcolor='cccccc' width='100' align='center'>상세주소</td>
				<td> <input type="text" name="addr2"></td>
			</tr>
			<tr height="40px">
				<td bgcolor='cccccc' width='100' align='center'>전화번호</td>
				<td> <input type="text" name="phone"></td>
			</tr>
			<tr height="40px">
				<td bgcolor='cccccc' width='100' align='center'>이메일</td>
				<td> <input type="text" name="email"></td>
			</tr>
		</table>
		<br>
		<p>
			<input type="submit" value="회원가입">
		</p>	
		</form>
	</div>

</body>
</html>