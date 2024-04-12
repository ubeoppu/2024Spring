<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>listpage..</h1>
<c:forEach var="board" items="${list }">
게시글 번호 : ${board.bno }
작성자 명 : ${board.name }
게시글 제목 : ${board.title }
내용 : ${board.content }
올린 날짜 : <fmt:formatDate value="${board.regDate }" pattern="yyyy-MM-dd"/>   
<br>
</c:forEach>
</body>
</html>