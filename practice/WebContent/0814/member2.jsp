<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*"
    import="practice0814.*"
    pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<style>
h1, h3 {
text-align: center;
}
</style>
  <meta charset="UTF-8">
<title>회원 정보 출력창</title> 
</head>
<body>
<h1>회원 정보 출력</h1>
<%
   request.setCharacterEncoding( "utf-8" );

 //  List membersList = (List)request.getAttribute("membersList");
%>


 <table border='1' width='800' align='center'>
   <tr align='center' bgcolor='lightpink'> 
     <td>아이디</td>
     <td>비밀번호</td>
     <td>이름</td>
     <td >이메일</td>
     <td>수정</td>
	</tr>
	<c:forEach var="member" items="${membersList }">
	<tr align="center">
		<td>${member.id }</td>
		<td>${member.pwd }</td>
		<td>${member.name }</td>
		<td>${member.email }</td>
		<c:url var="url1" value="0814/modify.jsp">
			<c:param name="id" value="${member.id }"/>
			<c:param name="pwd" value="${member.pwd }"/>
			<c:param name="name" value="${member.name }"/>
			<c:param name="email" value="${member.email }"/>
			<c:param name="command" value="modSearch"/>
		</c:url>
		<td><a href='${url1 }'>수정</a></td>
	</tr>
	</c:forEach>
</table>
<h3>
	<c:url var="url2" value="0814/search.jsp"/>
	<a href='${url2 }'>고객 조회</a>
</h3>
</body>
</html>
