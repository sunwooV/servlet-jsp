<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인 완료</title>
</head>
<body>

${sessionScope.loginReq.name }님, 안녕하세요!
<a href="logout.do">[로그아웃하기]</a>
<a href="passwordchange.do">[암호변경하기]</a><br>
<a href="guestBook/list.do">-방명록-</a><br>
<a href="article/list.do">-게시판-</a>

<br/>
</body>
</html>