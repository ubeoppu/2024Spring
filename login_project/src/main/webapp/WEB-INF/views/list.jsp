<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./jsp_header.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
	<div align="center" class="form">
		<p>회원 목록</p>
		<%-- <tr>
			<td colspan="7">
				<form action="<%= %>/adUserSelect.do" name="frm" method="post" onsubmit="return searchCheck()">
				<select name="keyFieId" id="form-select" class="form-select form-select-sm" aria-label=".form-select-sm example">
					<option value="0">---선택---</option>
					<option value="userId">아이디</option>
					<option value="UserName">이름</option>
				</select>
				<input type="text" name="keyword" placeholder="회원정보를 입력해주세요" maxlength="50">
				<input name="submit" value="검색">
				<input name="reset" value="취소">				
				</form>
			</td>
		</tr> --%>
		<hr size='1'>
		<form:form modelAttribute="user" name="userList" method="post">
			<TABLE border='2' width='800' cellSpacing=0 cellPadding=5>
				<thead>
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>전화번호</th>
						<th>주소</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="result" items="${userList}" varStatus="status">
						<tr>
							<td>${result.no}</td>
							<td>${result.name}</td>
							<td>${result.phone}</td>
							<td>${result.addr1}${result.addr2}</td>
						</tr>
					</c:forEach>		
				</tbody>
			</TABLE>
		</form:form>
	</div>
</body>
</html>