<%-- 실습 코드 java 코드 없애기 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*"
    import="practice0814.*"
    pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean  id="vo"  class="practice0814.MemberVO"  scope="request"/> 
<c:set var="command" value="${param.command }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form name="frm" method="post" action="/practice/memberservlet" encType="UTF-8">
	ID :<input type="text" name="id" value="${param.id}" /><br>
	비밀번호 :<input type="text" name="pwd" value="${param.pwd}" /><br>
	이름 :<input type="text" name="name" value="${param.name}" /><br>
	이메일:<input type="text" name="email" value="${param.email}" /><br>
	
	<c:if test="${command == 'modSearch' }">
		<input type="submit" name='submit' value="수정">
		<input type='hidden' name='command' value='modUpdate'   /> 
	</c:if>
	<c:if test="${command == 'addSearch' }">
		<input type="submit" name='submit' value="추가"> 
		<input type='hidden' name='command' value='addUpdate'   />
	</c:if>
	</form>
</body>
</html>