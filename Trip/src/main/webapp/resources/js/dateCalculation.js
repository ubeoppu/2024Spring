$(document).ready(function(){

    var totalMinute = 0;
    var totalHour = 0;
      var list = [];
      var daysDiff = 0;
      var sleepName = [];
      var totalDays = 0;
      
   $(".checkBtn").on("click",function(e){
      
      var content_id = $(this).siblings().find(".contentNameBtn").text();
      var contentType = $(this).siblings(".contentType").data("content-type");
      var addr2 = $(this).siblings(".contentAdd").data("content-addr2");
      var playTime = $(".contentTime").val();
      console.log("content_id값" + content_id)
      
      console.log('플레이 타임의 값' + playTime)
      
       if(playTime === null || playTime === "" || playTime === undefined){
           playTime = "02:00";
       } 
      console.log('playTime if문 거친 후' + playTime)
      list.push({
         content_id : content_id,
         contentType : contentType,
         addr2 : addr2,
         playTime : playTime
      })
       $(".chooseContent").find("input[name='content_id_c']").val(content_id);
      $(".chooseContent").find("input[name='contentName']").val(contentType);
      $(".chooseContent").find("input[name='contentTypes']").val(addr2);
      $(".chooseContent").find("input[name='contentTime']").val(playTime) 
      
      updateHtml();
      RunTimeSet();
      RunTimeCalculate();
      $(".contentTime").on("change", function() {
          RunTimeCalculate();
          RunTimeSet();
          RunTimeCalculate();
         });
      
   })
   var totalRunTimes = [];
   function RunTimeSet(){
       totalRunTimes=[];
       $(".contentTime").each(function() {
           
             totalRunTimes.push($(this).val());
             
             for(var i = 0; i < totalRunTimes.length; i++){
                 console.log('전체 런타임'	+totalRunTimes[i])
             }
             
         });
       
       
   }
   
  function RunTimeCalculate() {
 var runTime = document.getElementsByClassName('contentTime');
 var totalMinutes = 0;
 var totalTime = 0;
 for (var i = 0; i < runTime.length; i++) {
     var timeValue = runTime[i].value;
     console.log("runTime " + i + "번째 value: " + timeValue);
     totalMinutes += convertToMinutes(timeValue);
 }
 
 totalTime = convertToHoursMinutes(totalMinutes);
 console.log("총합 시간: " + totalTime.hours + "시간 " + totalTime.minutes + "분");

 if (totalTime.hours > totalHour) {
     alert("여행 총 시간보다 장소의 총 시간이 클 수 없습니다");
 } else {
     var str = "<p id='runCount'>" + runTime.length + "</p>&nbsp;&nbsp;" + totalTime.hours + "시간 " + totalTime.minutes + "분 / " + totalHour + "시간 " + totalMinute + "분";
     document.getElementById("totalRunTime").innerHTML = str;
 }
}

// Helper functions
function convertToMinutes(time) {
 var parts = time.split(':');
 var hours = parseInt(parts[0]);
 var minutes = parseInt(parts[1]);
 return (hours * 60) + minutes;
}

function convertToHoursMinutes(totalMinutes) {
 var hours = Math.floor(totalMinutes / 60);
 var minutes = totalMinutes % 60;
 return { hours: hours, minutes: minutes };
}

   

   function updateHtml() {
         var str = "";
             str += "<div class='list-group list-group-flush border-bottom scrollarea' >";
         for (var i = 0; i < list.length; i++) {
             str += "<div class='contentItem'>";
             str += "<input name='c_number' class='cNum' value='" + (i + 1) + "'>";
             str += "<input name='contentName' class='contentTitle'"  + "value='" + list[i].content_id + "'>";
             str += "<input name='contentTypes' class='contentT'" + "value='" + list[i].contentType + "'>";
             str += "<input name='address' class='contentAddr'"  + "value='" + list[i].addr2 + "'>";
             console.log('playTime값 2번 체크' + list[i].playTime)
             if(totalRunTimes[i] === "" || totalRunTimes[i] === null || totalRunTimes[i] === undefined){
                 console.log('트루문 찍힘')
             str += "<input type='text' name='playTime' pattern=''\d{2}:\d{2}' placeholder='HH:MM' value='02:00' title='올바른 형식으로 입력하세요 (HH:MM)' class='contentTime'>";
             }else{
                 console.log('false문 찍힘')
             str += "<input type='text' name='playTime' pattern=''\d{2}:\d{2}' placeholder='HH:MM' value='"+ totalRunTimes[i] +"' title='올바른 형식으로 입력하세요 (HH:MM)' class='contentTime'>";}
             str += "<button class='deleteBtn' data-index='" + i + "'>삭제</button>";
             str += "<hr>";
             str += "</div>";	
         }
             str += "</div>";
         $(".chooseContent").html(str);
         console.log('list길이값' + list.length)
     }
   
   $(document).on("click", ".dropBtn", function(){
       console.log("작동은 하니?")
     list.splice(0, list.length);
       updateHtml();
       
       
   });

     $(document).on("click", ".deleteBtn", function() {
         var index = $(this).data("index");
         list.splice(index, 1);
         totalRunTimes.splice(index, 1);
         updateHtml();
         RunTimeCalculate();
         
     });
   
   var modal = $(".modal");
   
      $(".contentNameBtn").on("click",function(){
         
         var content_id = $(this).siblings().find(".contentNameBtn").text();
         var contentType = $(this).siblings(".contentType").data("content-type");
         var addr2 = $(this).siblings(".contentAdd").data("content-addr2");
         
         console.log(content_id);
         console.log(contentType);
         console.log(addr2);
         
         var modalContentId = modal.find("input[name='contentName']");
         var modalContentType = modal.find("input[name='contentType']");
         var modalContentAdd = modal.find("input[name='contentAdd']");
         
         modalContentId.val(content_id);
         modalContentType.val(contentType);
         modalContentAdd.val(addr2);
         
         console.log(modalContentId.val());
         console.log(modalContentType.val());
         console.log(modalContentAdd.val());
         
         $(".modal").show();
      })
      
      $(".close").on("click",function(){
         $(".modal").hide();
      })
      
        function handleClick(event) {
         event.preventDefault();
         console.log("앵커 태그 클릭됨");
         
         var checkEvent = '숙소';
         

     }
      
          var dayElement = document.getElementById("day");
          var placeElement = document.getElementById("place");
          var placeElement2 = document.getElementById("place2");
          var sleepElement = document.getElementById("sleep");
          var sleepElement2 = document.getElementById("sleep2");
          var step1 = document.querySelector(".step1");
          var step2 = document.querySelector(".step2");
          var step3 = document.querySelector(".step3");
          
      $(".step1").on("click", function(){
          dayElement.style.display ="block";
          placeElement.style.display = "none";
          placeElement2.style.display = "none"; 
          sleepElement.style.display = "none";
          sleepElement2.style.display = "none";
          step1.style.color = "rgb(80 212 229)";
          step3.style.color ="#D5D5D5";
          step2.style.color ="#D5D5D5";
      })
      
      
      $(".step2").on("click", function(){
     dayElement.style.display ="none";
     placeElement.style.display = "block";
     placeElement2.style.display = "block"; 
     sleepElement.style.display = "none";
     sleepElement2.style.display = "none";
     step2.style.color ="rgb(80 212 229)";
     step1.style.color ="#D5D5D5";
     step3.style.color ="#D5D5D5";
      });
      
      $(".step3").on("click", function(){
          dayElement.style.display ="none";
          placeElement.style.display = "none";
          placeElement2.style.display = "none"; 
          sleepElement.style.display = "block";
          sleepElement2.style.display = "block";
               step3.style.color ="rgb(80 212 229)";
     step2.style.color ="#D5D5D5";
     step1.style.color ="#D5D5D5";
          updateSleep()
      })
      var datesBetween;
      $("#selectDay").on("click", function(){
          var appComponent = ReactDOM.render(React.createElement(APP, null), document.querySelector('#app'));
             var selectionStart = appComponent.state.selectionStart;
             var selectionEnd = appComponent.state.selectionEnd;
             console.log("끝" + selectionEnd)
             console.log("시작" + selectionStart)
             var milliseconds = selectionStart;
             var startDate = new Date(milliseconds);
             console.log(startDate);
             
             var milliseconds = selectionEnd;
             var endDate = new Date(milliseconds);
             console.log("포맷 전"+ endDate);
             
             var startDateFormatted = formatDate(startDate);
             var endDateFormatted = formatDate(endDate);
             
             datesBetween = getDatesWithDay(startDate, endDate);
             console.log(datesBetween);
             
             var dateStr ="";
             for(var i = 0; i < datesBetween.length; i++){
                 dateStr += "<input type ='text' name ='date_day' value='" + datesBetween[i].date + "' readonly='readonly'>";
             }
             $(".date2").html(dateStr);
             
             console.log("date확인" + datesBetween)
             
             var dateStr2 = "";
             for(var i = 0; i < datesBetween.length; i++){
                 dateStr2 += "<input type='text' name='date_week' value='" + datesBetween[i].dayOfWeek + "' readonly='readonly'>";
             }
             $(".date3").html(dateStr2);
             
             var dateStr3 = "";
             for(var i = 0; i < datesBetween.length; i++){
                 dateStr3 += "<input type = 'time' name='startTime' value='10:00' class='timeInputStart"+ i + "'>";
             }
             $(".date4").html(dateStr3)
             
                 var dateStr4 = "";
                 for(var i = 0; i < datesBetween.length; i++){
                     dateStr4 += "<input type='time' name='endTime' value='22:00' class='timeInputEnd" + i + "'>";
                 }
             $(".date5").html(dateStr4);
             
             var startMillis = startDate.getTime();
             var endMillis = endDate.getTime();

             var timeDiff = Math.abs(endMillis - startMillis);
             
             //숙소 개수 정할 때
              daysDiff = Math.ceil(timeDiff / (1000 * 3600 * 24)); 
             //총 일 수
            totalDays = daysDiff + 1;
             
             console.log('사이 날짜 값'+ daysDiff)
             
             console.log('총 일 수 ' + totalDays)
             timeCalculate(datesBetween)
              for (var i = 0; i < datesBetween.length; i++) {
             (function(index) {
                 var selector = ".timeInputStart" + index;
                 var selector2 = ".timeInputEnd" + index;
                 $(selector).on("change", function() {
                     timeCalculate()
                 });
                 
                 $(selector2).on("change", function(){
                     timeCalculate()
                 });
                 
             })(i);
         }
             
             $("#daysdiff").text("총 숙박 날" + daysDiff + "일");
             
             $(".dateRange").text(startDateFormatted + " ~ " + endDateFormatted);
             console.log('이쪽까지 동작을 안하나요')
             $('#modal-toggle').prop('checked', false);
      })
      
     function timeCalculate() {
          totalHour = 0;
          totalMinute = 0;

 for (var i = 0; i < datesBetween.length; i++) {
     var startTime = $(".timeInputStart" + i).val();
     var endTime = $(".timeInputEnd" + i).val();
     console.log('테스트 시작' + startTime)
     console.log('테스트 끝' + endTime)
     
     var startParts = startTime.split(':');
     var endParts = endTime.split(':');
     var startHour = parseInt(startParts[0]);
     var startMinute = parseInt(startParts[1]);
     var endHour = parseInt(endParts[0]);
     var endMinute = parseInt(endParts[1]);

     
     // 시간 차이 계산
     var diffHour = endHour - startHour;
     var diffMinute = endMinute - startMinute;

     console.log('시간 차' + diffHour)
     console.log('diffMinute값' +diffMinute )
     
     
     // 음수 방지를 위한 보정
     if (diffMinute < 0) {
         diffHour--; // 시간을 1 시간 감소
         diffMinute += 60; // 음수를 방지하기 위해 분에 60을 더함
     }

     totalHour += diffHour;
     totalMinute += diffMinute;
 }

 console.log("총합 시간: " + totalHour);
 console.log("총합 분: " + totalMinute);

 // 분이 60 이상인 경우 시간으로 환산
 totalHour += Math.floor(totalMinute / 60);
 totalMinute %= 60;

 console.log("총합 시간 (조정): " + totalHour);
 console.log("총합 분 (조정): " + totalMinute);
 
 $(".totalTime").val("총" + totalHour + "시간" + totalMinute + "분");  
 
 
 
}
      $(".checkInBtn").on("click",function(){
          
          var content_id = $(this).siblings().find(".contentNameBtn").text();
          
          console.log('content_id 숙소 값' + content_id)
          sleepName.push({
             content_id : content_id || undefined
          })
          for(var i = 0; i < sleepName.length; i++){
          console.log('sleepName배열' + sleepName[i].content_id)
          }
          updateSleep()
          
      })
      
      
     function updateSleep(){
          console.log('updateSleep')
          var str = "";
          console.log("확인 1번 값" + daysDiff)
          console.log("확인 2번 값" + datesBetween[0].date)
          for(var i = 0; i < daysDiff; i++){
              var q = i + 1;
              console.log('되겠죠'+ q)
              console.log("안찍혀 이게?")
              str += "<div class='sleepItem'>";
              str += "<span id='sleepDayCount'>"+ q + "</span> <input type='text'class='dateRan' value='" + datesBetween[i].date + "("+ datesBetween[i].dayOfWeek +")~" + datesBetween[q].date + "("+ datesBetween[q].dayOfWeek +")'>";
              if(sleepName[i] === undefined || sleepName[i].content_id === undefined){
                  console.log('true문 통과')
                  str += "<input type ='text' class='sleepVal' value='숙소를 추가해주세요.'>"	 
              }else{
              str += "<input type ='text' class='sleepValC' name='sleepName' value='"+ sleepName[i].content_id +"'>"
         }
              str += "</div>";
          }$(".chooseSleep").html(str);
      }
     
      $(".deleteBtn2").on("click",function(){
          console.log('숙소 삭제')
         sleepName = [];
         updateSleep();
          
      })
          
          
      
      function formatDate(date) {
 var year = date.getFullYear();
 var month = ("0" + (date.getMonth() + 1)).slice(-2);
 var day = ("0" + date.getDate()).slice(-2);
 var dayOfWeek = ["일", "월", "화", "수", "목", "금", "토"][date.getDay()];
 return year + "-" + month + "-" + day + "(" + dayOfWeek + ")";
}
      
      function getDatesWithDay(startDate, endDate) {
          const daysOfWeek = ['일', '월', '화', '수', '목', '금', '토'];
          const dates = [];
          let currentDate = new Date(startDate);

          while (currentDate <= new Date(endDate)) {
              const isoString = currentDate.toISOString();
              const monthDayStr = isoString.slice(5, 7) + "/" + isoString.slice(8, 10); // 월과 일만 추출하여 /로 구분
              const dayOfWeek = daysOfWeek[currentDate.getDay()];
              dates.push({ date: monthDayStr, dayOfWeek: dayOfWeek });
              currentDate.setDate(currentDate.getDate() + 1);
          }

          return dates;
      }
      
      $(".objsubmit").on("click", function(){
      
          console.log('작동')
          let placesForm = $("#places"); 
          
          console.log(totalDays);
          var sleepDay = totalDays - 1;
            var contentItems = document.querySelectorAll('.contentItem');
            // 선택된 장소 요소의 개수
            var contentCount = contentItems.length;
            
            var sleepItems = document.querySelectorAll('.sleepItem');
            
            // 선택된 숙박 요소의 개수
            var sleepCount = sleepItems.length;
            
            console.log('자는 날' + sleepDay)
            console.log('숙박 업소 개수' + sleepCount)
            console.log('개수' + contentCount);
          if(contentCount < totalDays){
          alert('여행 장소는 하루에 최소 1개 이상 선택해야합니다.')
          }else if(sleepCount < sleepDay){
          alert('숙박 할 곳을 지정해주세요.')
          }else{
          
         placesForm.submit();
}
})

$(".timeSetBtn").on("click", function(){
    var dayElement = document.getElementById("day");
    var placeElement = document.getElementById("place");
    var placeElement2 = document.getElementById("place2");
    var sleepElement = document.getElementById("sleep");
    var sleepElement2 = document.getElementById("sleep2");

    dayElement.style.display ="none";
    placeElement.style.display = "block";
    placeElement2.style.display = "block"; 
    sleepElement.style.display = "none";
    sleepElement2.style.display = "none";
    
})

})