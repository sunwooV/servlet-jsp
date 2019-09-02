<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인 완료</title>
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
<h1>${sessionScope.loginReq.name }님, 안녕하세요!</h1>
<p>
<a href="logout.do">[로그아웃하기]</a>
<a href="passwordchange.do">[암호변경하기]</a><br>
<a href="guestBook/list.do">-방명록-</a><br>
<a href="article/list.do">-게시판-</a>
</p>
</div>
<br/>
</body>
</html>