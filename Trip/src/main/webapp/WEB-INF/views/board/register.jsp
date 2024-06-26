<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!-- DataTables CSS -->
<link href="/resources/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">
<!-- DataTables Responsive CSS -->
<link href="/resources/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="/resources/dist/css/sb-admin-2.css" rel="stylesheet">
<!-- Custom Fonts -->
<link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="../resources/css/list.css">
</head>
<%@include file="../includes/header1.jsp"%>
<body>
<div  class="page-title">
 <h3>HEADER</h3>
</div>

   <div class="container" style="margin-top: 150px;font-size: 20px">
      <h1>여행 후기 게시판</h1>
      <p>
         <strong>Trip.go?</strong>를 통하여 여행플랜을 계획한 여행지의 후기
      </p>
      <div class="panel-body" style="margin-top: 30px">
         <form role="form" action="/board/register" method="post">
            <div class="form-group">
               <label><strong>작성자</strong></label> 
               <input class="form-control" name="member_email" value='<sec:authentication property="principal.username"/>' readonly="readonly">
               
               <label><strong>제목</strong></label> 
               <input class="form-control" name="title"> 
               
               <label><strong>내용</strong></label>
               <textarea rows="3" class="form-control" name="content" style="resize: none; width:1300px; height: 600px;"></textarea>
               
               <button id="uploadBtn" class="btn btn-primary" style="margin-top: 20px">등록</button>
               <button type="reset" class="btn btn-warning" style="margin-top: 20px; float: right">초기화</button>
            </div>
         </form>
      </div>
   </div>
   
<%@include file="../includes/footer.jsp"%>
</body>
</html>