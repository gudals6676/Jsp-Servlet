<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="a" value="11"></c:set>  <%-- 선언 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${a%2==0}">      <%-- if문 --%>
 ${a}는 짝수입니다<br>
</c:if>
<c:if test="${a%2!=0}">
 ${a}는 홀수입니다<br>
</c:if>
<c:choose>                      <%-- 스위치케이스문 --%>
	<c:when test="${a%2==0 }">
	 ${a}는 짝수입니다<br>
	</c:when>
	<c:when test="${a%2!=0 }">
	 ${a}는 홀수입니다<br>
	</c:when>
	<c:when test="">
		<c:otherwise>
			일치하는 when이 없을때 실행
		</c:otherwise>
	</c:when>
</c:choose>
</body>
</html>