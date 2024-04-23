<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./jsp_header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
	<br>
	<br>

	
	<br>
	<span class="filedError" align="center">${errMsg}</span>
	<br>
	<form:form modelAttribute="user" Name="findIdForm" Method="post"
		Action="findId">
		<font size='3'><b>아이디 찾기</b></font>

		<table border='2' width='600' cellSpacing=0 cellPadding=5 align=center>

			<tr>
				<td bgcolor="cccccc" align="center"><font size='2'>이 름</font></td>
				<td bgcolor="cccccc"><form:input path="name" maxlength="20"
						class="name" size="10" /> <span class="fieldError"><form:errors
							path="name" /></span></td>
			</tr>

			<tr>
				<td bgcolor="cccccc" align="center"><font size='2'>E
						-MAIL</font></td>
				<td bgcolor="cccccc"><input type="text" maxlength="50"
					size="50" name="email" /> <span class="fieldError"><form:errors
							path="email" /></span></td>
			</tr>

		</table>
		<br>
		<table border='0' width='700' cellpadding='0' cellsapacing='0'>
			<tr>
				<td><hr size='1' noshade></td>
			</tr>
		</table>
		<table>
			<tr>
				<td colspan='2' align='center'><input type='submit' value="찾기"></td>
				<br>
				<td><input type='reset' value='취소'></td>
			</tr>
		</table>

	</form:form>

</body>
</html>