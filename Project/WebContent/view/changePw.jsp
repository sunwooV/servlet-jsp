<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
<title>암호변경</title>
</head>
<body>
<form action="change.do" method="post">
<p>
	현재비밀번호:<br/><input type="password" name="password" value="${param.password}">
	<c:if test="${errors.password}">현재비밀번호를 입력하세요.</c:if>
</p>
<p>
	변경할 비밀번호:<br/><input type="password" name="newPwd">
	<c:if test="${errors.newPwd}">바꿀암호를 입력하세요.</c:if>
	<c:if test="${errors.Match}">현재비밀번호와 일치합니다.</c:if>
</p>
<c:if test="${errors.check}">현재비밀번호가 맞지 않습니다.</c:if><br>
<input type="submit" value="암호변경">
</form>
</body>
</html>