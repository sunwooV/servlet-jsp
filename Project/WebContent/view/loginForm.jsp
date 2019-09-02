<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
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
<form action="/Project/addlogin.do" method="post">
<div class = "a">
<div class = "b">
<h1> 로그인창</h1>
<p>
	아이디:<br/><input type="text" name="id" value="${param.id}">
	<c:if test="${errors.id}">ID를 입력하세요.</c:if>
	
</p>
<p>
	비밀번호:<br/><input type="password" name="password">
	<c:if test="${errors.password}">비밀번호를 입력하세요.</c:if>
	
</p>
<c:if test="${errors.checklog}">아이디랑 비밀번호가 일치하지 않습니다</c:if><br>
<input type="submit" value="로그인">
<input type="button" onclick = "location.href = '/Project/answer.do'" value=" 비밀번호 찾기 "><br><br>
</div></div>
</form>
</body>
</html>