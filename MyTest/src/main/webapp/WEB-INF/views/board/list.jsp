<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>board List..</h1>
<c:forEach var= "list" items ="${list}" >
작성자명: ${list.name }
제목 : ${list.title }
내용 : ${list.content }<br>
</c:forEach>
</body>
</html>