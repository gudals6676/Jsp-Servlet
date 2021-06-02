<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% 
	String[] f = {"사과", "딸기", "바나나", "포도", "수박"};
	request.setAttribute("f", f);// Controller
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border = "1">
<%for(int i = 0; i < f.length; i++){ %>
     <tr>
     	<td><%=f[i] %></td>
     </tr>
     <%} %>
</table>
<table border = "1">
<c:forEach var="i" items="${f}" >  
<tr>
	<td>${i}</td>
</tr>
</c:forEach>
</table>
</body>
</html>