<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 창</title>
</head>
<body>
	<c:if test="${empty param.userID }"> <!-- ID가 null 이면 -->
		아이디를 입력하세요.<br>
		<a href="login.jsp">로그인 창</a>
	</c:if>
	<c.if test="${not empty param.userID }"> <!-- ID가 null이 아니면 -->
		<c:if test="${param.userID == 'admin'}"> <!-- ID가 admin이면 관리자 화면을 출력 -->
			<h1>관리자로 로그인 했습니다.</h1> 
			<form>
				<input type=button value="회원정보 삭제하기"/>
				<input type=button value="회원정보 수정하기"/>
			</form> 
		</c:if>
		<c:if test="${param.userID != 'admin' }"> <!-- ID가 admin이 아니면 로그인 메시지 출력 -->
			<h1>환영합니다.
			<c:out value="${param.userID }" />님!!!</h1>
		</c:if>
	</c.if>
</body>
</html>