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
<body>
<form action="/Project/guestBook/check.do" method="post">
메시지를 수정하시려면 암호를 입력하세요:<br />
암호: <input type="password" name="password" /> <br />
  <input type="submit" value="메시지 수정하기" >
  <input type="hidden" name="messagepassword" value="<%=msgPwd %>" >
  <input type="hidden" name="messageId" value="<%=msgId %>" >
  <input type="hidden" name="messagename" value="<%=name %>" >
  <input type="hidden" name="content" value="<%=content %>" >
 </form>
</body>
</html>