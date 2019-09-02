<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 창</title>
</head>
<body>
	<form name="frmLogin" method="post" action="/practice/management" encType="UTF-8">
		ID: <input type="text" name="user_id"><br>
		비밀번호: <input type="password" name="user_pwd"><br>
		<input type="submit" value="로그인">
		<input type="reset" value="초기화">
		<input type="hidden" name="command" value="login">
	</form>
</body>
</html>