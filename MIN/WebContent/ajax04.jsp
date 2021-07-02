<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="#">
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
function loginFn() {
	var user_id=$("#user_id").val();
	var password=$("#password").val();
    $.ajax({
    	url : "ajaxlogin.do",
    	type : "post",
    	data : {"user_id" : user_id, "password" : password},
    	success : function(data) {
    		if(data=="NO"){
    			alert("회원인증 실패야ㅠㅠ");
    		}else{
    			location.href="ajax04.jsp"; //다시한번 메인화면으로 
    			alert(user_id+"님 환영해용!!!");
    		}
    		
    	},
    	error : function () {alert("error");}
					
    });
}
function logoutFn() {
	//세션 메모리를 삭제 해야함. 세션트래킹?
   $.ajax({
	   url : "ajaxlogout.do",
	   type : "get",
	   //data :
		success : function(){  			
			location.href="ajax04.jsp";
			alert("로그아웃 성공쓰!!")
		},
		error : function(){alert("error");}
   });
}
</script>
</head>
<body>
	<div class="container">
  <h4><strong>♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥매일쌤 사랑합니다♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥♥</strong></h4>
  <div class="panel panel-default">
    <div class="panel-heading">
    <c:if test="${sessionScope.userVO==null }"> <%-- request가아닌 session으로 getAttribute하기위해 sessionScope를 붙힘 --%>
    <form id="loginfrm" class="form-inline"  method="post">
      <div class="form-group">
      <label>ID:</label>
      <input type="text" class="form-control" id="user_id" name = "user_id">
      </div>
      <div class="form-group">
      <label>PWD:</label>
      <input type="password" class="form-control" id="password" name = "password">
      </div> 
      <button type="button" class="btn btn-primary" onclick="loginFn()">로그인</button>

    </form>
     </c:if>
      
      <c:if test="${sessionScope.userVO!=null }">
      ${sessionScope.userVO.user_name}님 방문을 환영합니다!!
      <input type="button" value="로그아웃" onclick="logoutFn()" class ="btn btn-sm btn-primary">
      </c:if>
      </div>
     
  </div>
</div>	
</body>
</html>