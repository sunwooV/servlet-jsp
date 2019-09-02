<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" scope="request" class="chap08.member.MemberInfo" />
<%
	member.setId("madvirus");
	member.setName("홍길동");
%>
<<jsp:forward page="useObject.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>