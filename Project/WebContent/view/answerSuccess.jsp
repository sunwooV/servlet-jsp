<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기성공</title>
</head>
<style>
.a{
	border:1px solid #D8D8D8;
	width:100%;
	padding: 10px 0px;
}

h1{
	text-align:center;
	color:#444444;
}
p{
	text-align:center;
}
</style>
<body>
<div class="a">
<h1>비밀번호는 ${sessionScope.answerReq.password}입니다!</h1><br>
<p>
<a href="login.do">[로그인하기]</a></p>
</div>
</body>
</html>