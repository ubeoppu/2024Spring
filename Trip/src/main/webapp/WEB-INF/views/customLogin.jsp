<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>login</h1>
   <form action="/login" method="post">
      <%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
      <div class="error">
         ${error}
      </div>
      <div>
         ${logout}      
      </div>
      <div class="container">
         <label for="member_email"><b>Email</b></label> 
         <input type="text" placeholder="Enter Email" name="username"><br>
         <label for="pwd"><b>Password</b></label> 
         <input type="password" placeholder="Enter Password" name="password"><br> <label>
         <input type="checkbox" checked="checked" name="remember">
            Remember me
         </label>
         <br><button type="submit">Login</button>

      </div>

      <div class="container" style="background-color: #f1f1f1">
         <button type="button" class="cancelbtn">Cancel</button><br>
         <span class="pwd">Forgot <a href="#">Email?</a>/<a href="#">password?</a></span>
      </div>
   </form>
   <p>아직 아이디가 없으신가요?<button id="goJoin">회원가입하러 가기</button></p>
   
   
</body>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
   <script>
      $(document).ready(function(){
         
         $("#goJoin").on("click",function(e){
            self.location = '/member/join';
         })
         
         
         
      })   
   
   </script>
</html>