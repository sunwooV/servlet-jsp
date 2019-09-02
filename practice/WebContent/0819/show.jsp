<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)session.getAttribute("name");
	String id = (String)session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공 창</title>
	<script type="text/javascript">
		function frm_logout(){
			alert("로그아웃 되셨습니다.");
			var frmLogout = document.frm;
			frmLogout.method = "get";
			frmLogout.action = "../management";
			frmLogout.submit();
		}

	</script>
</head>
<body>
	<form name="frm" method="post" action="change.jsp">
		<h2>안녕하세요. <%=name %>님 !!!</h2>
		<input type="button" value="로그아웃하기" onclick="frm_logout()">
		<input type="submit" value="암호변경하기">
	</form>
</body>
</html>