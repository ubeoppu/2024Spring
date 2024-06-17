<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
   <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Sidebars · Bootstrap v5.1</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/sidebars/">

    

    <!-- Bootstrap core CSS -->
    <link href="../resources/css/modal.css" rel="stylesheet">
    <link href="../resources/css/modal2.css" rel="stylesheet">
    <link href="../resources/css/calendar.css" rel="stylesheet">
<link href="../resources/css/bootstrap.min.css" rel="stylesheet">
<link href="../resources/css/place.css" rel="stylesheet">

  </head>
  <body>

<main>
  <h1 class="visually-hidden">Sidebars examples</h1>

  <div class="d-flex flex-column flex-shrink-0 bg-light" style="width: 6.5rem;">
    <a href="/main" class="d-block p-3 link-dark text-decoration-none" title="Icon-only" data-bs-toggle="tooltip" data-bs-placement="right">
      <svg class="bi" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
      <span class="visually-hidden">Main</span>
      <img src="/resources/images/logo.png" id="sideIcon">
    </a>
    <ul class="nav nav-pills nav-flush flex-column mb-auto text-center">
      <li class="nav-item">
      <a href="#link1" class="step1">STEP1<br>날짜 확인</a>
       <!--  <a href="#" class="nav-link active py-3 border-bottom" aria-current="page" title="Home" data-bs-toggle="tooltip" data-bs-placement="right">
          <svg class="bi" width="24" height="24" role="img" aria-label="Home"><use xlink:href="#home"/></svg>
        </a> 메뉴바 1번째 칸~-->
      </li>
      <li class="nav-item">
      <a href="#link2" class="step2">STEP2<br>장소 선택</a>
        <!-- <a href="#" class="nav-link py-3 border-bottom" title="Dashboard" data-bs-toggle="tooltip" data-bs-placement="right">
          <svg class="bi" width="24" height="24" role="img" aria-label="Dashboard"><use xlink:href="#speedometer2"/></svg>
        </a> 메뉴바 2번째 칸-->
      </li>
      <li class="nav-item">
      <a href="#link3" class="step3">STEP3<br>숙소 설정</a>
        <!-- <a href="#" class="nav-link py-3 border-bottom" title="Orders" data-bs-toggle="tooltip" data-bs-placement="right">
          <svg class="bi" width="24" height="24" role="img" aria-label="Orders"><use xlink:href="#table"/></svg>
        </a> 메뉴바 3번째 칸-->
      </li>
      <li>
      <button class = "objsubmit">일정생성</button>
      </li>
    </ul>
  </div>
<!-- modal -->

<!-- modalEnd -->
<form id ="places" action="/plan/library" method="get">
<!-- 날짜 선택 --><!-- 날짜 선택 --><!-- 날짜 선택 --><!-- 날짜 선택 --><!-- 날짜 선택 --><!-- 날짜 선택 -->
<div id ="day">

<div class="d-flex flex-column align-items-stretch flex-shrink-0 bg-white" style="width: 380px;">
<h2 style="font-weight:bold;">${areaname }</h2>
<h5 class="dateRange" style="font-weight:bold;"></h5>

<div class="timeSetter">
<h6>여행시간 상세설정</h6>
<label class="selectDayBtn" for="modal-toggle">
<input type="text" class="totalTime" value="여행 총시간" readonly="readonly" style="border: none; width:300px;"><br> 
일정 수정하기</label> <br>
<table class="dateAll">
    <thead>
        <tr>
                <th class="dateColumn">일자</th>
                <th class="dayColumn">요일</th>
                <th class="startTimeColumn">시작시간</th>
                <th class="endTimeColumn">종료시간</th>
            
        </tr>
    </thead>
    <tbody>
        <tr>
            <td class="date2"><!-- 요일 데이터를 여기에 추가 --></td>
            <td class="date3"><!-- 시작시간 데이터를 여기에 추가 --></td>
            <td class="date4"><!-- 종료시간 데이터를 여기에 추가 --></td>
            <td class="date5">
        </tr>
    </tbody>
</table>
<button type="button" class="timeSetBtn">시간 설정 완료</button>
</div>
</div>
<div class="modal-container">
  <input id="modal-toggle" type="checkbox">
  
  <label class="modal-backdrop" for="modal-toggle"></label>
  <div class="modal-content">
    <label class="modal-close" for="modal-toggle">&#x2715;</label>
    <h2>여행 기간을 선택해주세요</h2><hr />
    <!-- 달력 추가 -->
<div id="app"></div>
<!-- 달력 끝 -->
  </div>          
</div>  
</div>


<!-- 날짜 선택End --><!-- 날짜 선택End --><!-- 날짜 선택End --><!-- 날짜 선택End --><!-- 날짜 선택End -->
<!-- 장소 선택 --><!-- 장소 선택 --><!-- 장소 선택 --><!-- 장소 선택 --><!-- 장소 선택 --><!-- 장소 선택 -->
<div id ="place">
  <div class="d-flex flex-column align-items-stretch flex-shrink-0 bg-white" style="width: 380px;">
      <h2 style="font-weight:bold;">${areaname }</h2>
<h5 class="dateRange" style="font-weight:bold;"></h5>
<span class="fs-5 fw-semibold">장소 선택</span>
                  <input type="hidden" id="lat" name="lat" value="${area.lat}">
            <input type="hidden" id="lng" name="lng"  value="${area.lng}">
      <div id="map"></div>
      <div id="infowindow-content">
         <img src="" width="16" height="16" id="plage-icon">
         <span id="place-name" class="title"></span><br>
         <span id="place-address"></span>
      </div>
      <div class="list-group list-group-flush border-bottom scrollarea" >
      <c:forEach var="content" items="${list}">
         <div class="d-flex w-100 align-items-center justify-content-between">
         <hr>
         <b><button class="contentNameBtn" style="width:100px;" data-content-id="${content.content_id}">${content.content_id}</button></b>
         <input class="contentType" type="text" data-content-type="${content.contentType}" value="${content.contentType}" readonly="readonly">
        <br><input id="addr2" class="contentAdd" type="text" data-content-addr2="${content.addr2}" value="${content.addr2}" readonly="readonly">
         <button type="button" id="checkBtn" class="checkBtn" >+</button>
         <hr>
      </div>
      </c:forEach>
      </div>
  </div>
  
  <div id="place2" class="flex-shrink-0 p-3 bg-white" style="width: 350px;">
    <a href="/" class="d-flex align-items-center pb-3 mb-3 link-dark text-decoration-none border-bottom">
      <svg class="bi me-2" 
      width="30" height="24" style="margin-top:15px;"><use xlink:href="#bootstrap"/></svg>
      <span id="totalRunTime"></span>
    </a>
         <div class="chooseContent" style="border:1px;">
         </div>
  </div>
  </div>
 
 
  <!-- 장소 선택End --><!-- 장소 선택End --><!-- 장소 선택End --><!-- 장소 선택End --><!-- 장소 선택End --><!-- 장소 선택End -->
  
  <!-- 숙소 선택 --><!-- 숙소 선택 --><!-- 숙소 선택 --><!-- 숙소 선택 --><!-- 숙소 선택 --><!-- 숙소 선택 -->
  <div id="sleep">
    <div class="d-flex flex-column align-items-stretch flex-shrink-0 bg-white" style="width: 380px;">
    <h2 style="font-weight:bold;">${areaname }</h2>
<h5 class="dateRange" style="font-weight:bold;"></h5>
      <span class="fs-5 fw-semibold">숙소 선택</span>
      

      <div id="map"></div>
      <div id="infowindow-content">
         <img src="" width="16" height="16" id="plage-icon">
         <span id="place-name" class="title"></span><br>
         <span id="place-address"></span>
      </div>
      <div class="list-group list-group-flush border-bottom scrollarea" >
      <c:forEach var="content" items="${sleep}">
         <div class="d-flex w-100 align-items-center justify-content-between">
         <hr>
         <c:if test="${content.contentType == '숙소'}">
         <b><button class="contentNameBtn" style="width:100px;" data-content-id="${content.content_id}">${content.content_id}</button></b>
         <input class="contentType" type="text" data-content-type="${content.contentType}" value="${content.contentType}" readonly="readonly">
        <br><input id="addr2" class="contentAdd" type="text" data-content-addr2="${content.addr2}" value="${content.addr2}" readonly="readonly">
         <button type="button" class="checkInBtn" class="checkInBtn" >+</button>
         <hr>
         </c:if>
      </div>
      </c:forEach>
      </div>
  </div>
  <div id="sleep2" class="flex-shrink-0 p-3 bg-white" style="width: 350px;">
    <a href="/" class="d-flex align-items-center pb-3 mb-3 link-dark text-decoration-none border-bottom">
      <svg class="bi me-2" width="30" height="24" style="margin-top:15px;"><use xlink:href="#bootstrap"/></svg>
      <span class="fs-5 fw-semibold" style="margin-top:5px; padding-top:10px;">숙소 선택 </span>
      <span class="fs-5 fw-semibold" id="daysdiff" style="margin-top:5px; padding-top:10px;"></span>
    </a>
         <div class="chooseSleep" style="border:1px;">
         </div>
  </div>
  </div>
 
  <!-- 숙소 선택End --><!-- 숙소 선택End --><!-- 숙소 선택End --><!-- 숙소 선택End --><!-- 숙소 선택End --><!-- 숙소 선택End -->
  </form>
  <!-- The Modal -->
  <div class="modal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title"><input name="contentName" value="contentName" readonly="readonly" style="border:none;"></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
        <input name="contentType" value="contentType" readonly="readonly" style="border:none;"><br>
        <input name="contentAdd" value="contentAdd" readonly="readonly" style="border:none;">
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
        </div>
        
      </div>
    </div>
  </div>
<div>
<div id="googleMap" style="position:absolute; display:inline-block; width: 80%;height:100%;"></div>
</div>
</main>

   <script>
  window.addEventListener('DOMContentLoaded', function() {
	    var modalToggle = document.getElementById('modal-toggle');
	    modalToggle.checked = true; // 모달 창 체크 박스를 선택하여 모달이 열리도록 설정
	  });
  </script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD-nI2V_bsNjQF5ZQ4mlq8o8sr1oZ6bLi0&libraries=places&callback=myMap"></script>
<script src="https://unpkg.com/react@17/umd/react.development.js"></script>
<script src="https://unpkg.com/react-dom@17/umd/react-dom.development.js"></script>
    <script src="../resources/js/bootstrap.bundle.min.js"></script>
      <script src="../resources/js/sidebars.js"></script>
<script src="../resources/js/calendar.js"></script>
<script src="../resources/js/googleMap.js"></script>
<script src="../resources/js/dateCalculation.js"></script>
  </body>
  
  


  


</html>