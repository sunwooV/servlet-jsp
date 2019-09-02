<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>가입 완료</title>
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
<h1>${param.name}님, 회원 가입에 성공했습니다.</h1>
<p>
<a href="login.do">[로그인하기]</a></p>
</div>
<br/>
</body>
</html>