<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
<title>암호변경</title>
</head>
<style>
.a{
	border:3px solid #D8D8D8;
	text-align:center;
	width:500px;
	height:800px;
	padding:5px;
	background-color:white;
	margin-left:auto;
	margin-right:auto;
	margin-top:auto;
	vertical-align:middle;
}
.b{
	padding:30px;
}
input{
	border: 1px solid #A4A4A4;
    background-color: #D8D8D8;
    color: black;
    padding: 5px;
    border-top-left-radius: 5px;
    border-top-right-radius: 5px;
    border-bottom-left-radius: 5px;
	border-bottom-right-radius: 5px;
}
input:hover{
	background-color:#6E6E6E;
	color:white;
}
</style>
<body>
<form action="change.do" method="post">
<div class="a"><div class="b">
<h1>암호 변경</h1>
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
</div></div>
</form>
</body>
</html>