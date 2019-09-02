<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>가입</title>
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
<form action="addjoin.do" method="post">
<div class="a"><div class="b">
<h1> 회원 가입창</h1>

<p>
	아이디:<br/><input type="text" name="id" value="${param.id}">
	<c:if test="${errors.id}">ID를 입력하세요.</c:if>
	<c:if test="${errors.duplicateId}">이미 사용중인 아이디입니다.</c:if>
</p>
<p>
	이름:<br/><input type="text" name="name" value="${param.name}">
	<c:if test="${errors.name}">이름을 입력하세요.</c:if>
</p>
<p>
	암호:<br/><input type="password" name="password">
	<c:if test="${errors.password}">암호를 입력하세요.</c:if>
</p>
<p>
	확인:<br/><input type="password" name="confirmPassword">
	<c:if test="${errors.confirmPassword}">확인을 입력하세요.</c:if>
	<c:if test="${errors.notMatch}">암호와 확인이 일치하지 않습니다.</c:if>
</p>
<p>
	가장 좋아하는 동물은?<br/><input type="text" name="answer">
	<c:if test="${errors.answer}">가장 좋아하는 동물을 입력하세요.</c:if>
</p>
<input type="submit" value="가입">
</div></div>
</form>
</body>
</html>