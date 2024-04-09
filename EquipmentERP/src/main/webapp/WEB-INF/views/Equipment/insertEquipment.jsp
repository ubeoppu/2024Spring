<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Insert Equipment Page</h1>
<form action ="/Equipment/insertEquipment" method="post" name="frm">
코드 : <input type="text" name ="EquipmentCode">
장비 명 : <input type="text" name ="EquipmentName">
관리자 명 :<input type="text" name ="MechanicName">

<input type="submit" value="삽입">

</form>
</body>
</html>