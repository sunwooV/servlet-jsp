<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경 창</title>
</head>
<body>
	<form name="frmchange" method="post" action="../management">
		현재암호: <input type="password" name="pwd"><br>
		새암호: <input type="password" name="newPwd"><br>
		<input type="submit" value="암호변경">
		<input type="reset" value="초기화">
		<input type="hidden" name="command" value="change">
	</form>
</body>
</html>