<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>회원제 게시판 예제</title>
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
</head>
<body>
<div class="a">
	<div class="b">
	<h1>초기화면</h1><br><br>
	<input type="button" class="btn btn-primary" onclick = "location.href = 'guestBook/list.do'" value=" 방명록 "><br><br>
	<input type="button" class="btn btn-primary" onclick = "location.href = 'article/list.do'" value=" 게시판 "><br><br>
	<input type="button" class="btn btn-primary" onclick = "location.href = 'login.do'" value=" 로그인 "><br><br>
	<input type="button" class="btn btn-primary" onclick = "location.href = 'join.do'" value=" 회원가입 "><br><br>
	</div>
</div>

<br/>
</body>
</html>