<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="jsp_header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css">
<script>
	function Delete(){
		if(confirm("탈퇴하시겠습니까>")){
			editForm.action = 'delete';
			editForm.submit();
		}
	}
</script>
</head>
<body>
		<div align="center" class="body">
		<h2>회원정보 수정</h2>
		<form:form modelAttribute="user" method="post" action="edit" name="editForm">
			<table border="1" width='600' cellpadding='0' cellspacing='0'>
				<tr height="40px">
					<td bgcolor='cccccc' width='100' align='center'>아이디</td>
					<td><form:input type="text" path="id" readonly="true" /></td>
				</tr>
				<tr height="40px">
					<td bgcolor='cccccc' width='100' align='center'>패스워드</td>
					<td><form:input type="password" path="pass" /></td>
				</tr>
				<tr height="40px">
					<td bgcolor='cccccc' width='100' align='center'>이름</td>
					<td><form:input type="text" path="name" /></td>
				</tr>
				<tr height="40px">
					<td bgcolor='cccccc' width='100' align='center'>우편번호</td>
					<td><form:input type="text" path="zip" /></td>
				</tr>
				<tr height="40px">
					<td bgcolor='cccccc' width='100' align='center'>주소</td>
					<td><form:input type="text" path="addr1" /></td>
				</tr>
				<tr height="40px">
					<td bgcolor='cccccc' width='100' align='center'>상세주소</td>
					<td><form:input type="text" path="addr2" /></td>
				</tr>
				<tr height="40px">
					<td bgcolor='cccccc' width='100' align='center'>전화번호</td>
					<td><form:input type="text" path="phone" /></td>
				</tr>
				<tr height="40px">
					<td bgcolor='cccccc' width='100' align='center'>이메일</td>
					<td><form:input type="text" path="email" /></td>
				</tr>
			</table>
			<br>
			<p>
				<input type="submit" value="수 정"> 
				<input type="button"value="탈 퇴" OnClick="Delete()"> 
				<input type="reset"value="취 소">
				</TD>
				</TR>
			</p>
		</form:form>
	</div>

</body>
</html>