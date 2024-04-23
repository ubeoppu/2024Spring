<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./jsp_header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
</head>
<body>
	<div align="center" class="form">
		<p>관리자 페이지</p>

		<hr size='1'>
		<form:form modelAttribute="user" name="adminPage" method="post"
			align="center">
			<TABLE border='2' width='800' cellSpacing=0 cellPadding=5>
				<thead>
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>전화번호</th>
						<th>주소</th>
						<th>수정</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="result" items="${userList}" varStatus="status">
						<tr>
							<td>${result.no}</td>
							<td>${result.name}</td>
							<td>${result.phone}</td>
							<td>${result.addr1}${result.addr2}</td>
							<td><button class="edit-button" data-userid="${result.id}">수정</button></td>
						</tr>
					</c:forEach>
				</tbody>
				<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
				<script>
					$(document).ready(function() {
						$(".edit-button").click(function() {
							var userId = $(this).data("userid");
							window.location.href = "edit?userId=" + userId;
						});
					});
				</script>
			</TABLE>
		</form:form>
	</div>
</body>
</html>
