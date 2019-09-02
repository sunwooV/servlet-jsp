<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
request.setCharacterEncoding("utf-8");
String msgId = request.getParameter("messageId");
String msgPwd = request.getParameter("messagepassword");
String name = request.getParameter("messagename");
String content = request.getParameter("content");
%>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
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
input{
	text-align:center;
}
</style>
<body>

<form action="/Project/guestBook/check.do" method="post">
<div class="a">
<h1>메시지를 수정하시려면 암호를 입력하세요:<br /></h1>
암호: <input type="password" name="password" /> <br />
  <input type="submit" value="메시지 수정하기" >
  <input type="hidden" name="messagepassword" value="<%=msgPwd %>" >
  <input type="hidden" name="messageId" value="<%=msgId %>" >
  <input type="hidden" name="messagename" value="<%=name %>" >
  <input type="hidden" name="content" value="<%=content %>" >
  </div>
 </form>
</body>
</html>