<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>문의사항 리스트</h1>
<c:forEach var="help" items="${list}">
<input type="hidden" name="help_id" value="${help.help_id }"> 아이디명 : ${help.member_email }  문의 제목 : ${help.title }<br>
</c:forEach>
</body>
</html>