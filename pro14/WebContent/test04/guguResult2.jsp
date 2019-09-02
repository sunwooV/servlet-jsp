<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 출력창</title>
</head>
<body>
	<c:set var="dan" value="${param.dan }"/>
	<table border="1" width="800" align="center">
		<tr align="center" bgcolor="lightpink">
			<td colspan="2">
				<c:out value="${dan }"/>단 출력 </td>
		</tr>
		<c:forEach var="i" begin="1" end="9" step="1">
			<c:if test="${i%2==0 }">
				<tr align="center" bgcolor="violet">
			</c:if>
			<c:if test="${i%2!=0 }">
				<tr align="center" bgcolor="white">
			</c:if>
			<td width="400">
				<c:out value="${dan }"/> * <c:out value="${i }"/>
			</td>
			<td width="400">
				<c:out value="${dan*i }"/>
			</td>
		</c:forEach>
	</table>
</body>
</html>