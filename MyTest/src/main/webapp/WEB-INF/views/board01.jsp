<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>board01</h1>

<form action ="/board/board01insert" method="post">
이름:<input type="text" name="name"><br>
제목:<input type="text" name="title"><br>
내용:<input type="text" name="content">
<input type="submit" value="전송">
</form>
</body>
</html>