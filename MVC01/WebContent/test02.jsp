<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
 String[] name = {"체리1","체리2","체리3"};
 String[] story = {"널 용서하지 않겠따","헤으응...","가즈아ㅏㅏ"};
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="jumbotron text-center">
  <h1>코드캡쳐체리</h1>
  <p>Resize this responsive page to see the effect!</p> 
</div>
  
<div class="container">
  <div class="row">
   <% for(int i = 1; i <= 3; i++){ %>
    <div class="col-sm-4">
      <h3><%=name[i-1] %></h3>
      <p><img src = "img/체리<%=i%>.jpg" height = 350 width = 250></p>
      <p><%=story[i-1] %></p>
    </div>
    <% } %>  
    </div>
  </div>
</div>
</body>
</html>

