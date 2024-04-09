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
<h1>EquipmentList Page</h1>
<form action ="/Equipment/deleteEquipment" method="post">
<c:forEach var="list" items="${list }">
<input type ="checkbox" name ="EquipmentCode" value="${list.equipmentCode }">
<input type ="text"  value="${list.equipmentCode }" style="border: none;">
<input type ="text"  value="${list.equipmentName }" style="border: none;">
<input type ="text"  value="${list.mechanicName }" style="border: none;">
<br>
</c:forEach>

<input type="submit" value="삭제">

</form>
</body>
</html>