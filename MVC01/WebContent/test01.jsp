<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! 
	//메서드(선언)
	public int hap(int a, int b){
	return a+b;
}
%>
<% //스크립틀릿(자바 코드를 치기 위함)
	int cnt = hap(10, 10); //call
	
%>
<%--주석이다잇! --%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=cnt %>
</body>
</html>