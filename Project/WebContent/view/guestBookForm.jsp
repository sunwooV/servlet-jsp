<%@ page language="java" contentType="text/html; charset=UTF-8"
import="java.util.*"
import="guestbook.dao.*"
import="guestbook.model.*"
import="guestbook.service.*"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
   	request.setCharacterEncoding("utf-8");
	List list = (List)request.getAttribute("list");
	
	int totalPage = (int)request.getAttribute("totalPage");
%>
<c:set var="list" value="<%=list %>" />
<!DOCTYPE html>
<html>
<head>

	<script type="text/javascript">
		function frm_check(){
		var frmcheck = document.frmcheck;
		var name = frmcheck.name.value;
		var password = frmcheck.password.value;
		var message = frmcheck.message.value;

			
			if(name.length = 0 || name == "")
			{
				alert("이름을 입력하세요.");
			
			}else if(password.length = 0 || password == "")
			{
				alert("암호를 입력하세요.");
			
			}else if(message.length = 0 || message == "")
			{
				alert("메세지을 입력하세요.");
			
			}
			else
			{
				frmcheck.method ="post";
				frmcheck.action ="write.do";
				frmcheck.submit();
			}
		}
		
	</script>

<meta charset="UTF-8">
<title>방명록</title>
</head>
<body>
	<form name="frmcheck">
	<div style="float:right;">
		<a href="/Project/index.jsp">[홈으로]</a>
	</div>
	<br><br>

		<table WIDTH="500" BORDER="1" CellPadding="0" CellSpacing="0">
			<TR>
				<TD WIDTH="40%" ALIGN="center">이름</TD>
				<TD width="80%" ALIGN="center"><INPUT TYPE="text" SIZE="15"
					MAXLENGTH="10" NAME="name"></TD>
					
			</TR>
			<TR>
				<TD WIDTH="40%" ALIGN="center">암호</TD>
				<TD WIDTH="60%" ALIGN="center"><INPUT TYPE="password" SIZE="15"
					MAXLENGTH="10" NAME="password"></TD>
					
			</TR>
			<TR>
				<TD WIDTH="40%" ALIGN="center">메시지</TD>
				<TD WIDTH="60%" ALIGN="center"><TEXTAREA NAME="message" ROWS=3
						COLS=30></TEXTAREA></TD>
						
			</TR>
			<TR>
				<TD WIDTH="100%" ALIGN="center" COLSPAN="2"><INPUT
					TYPE="submit" VALUE="메시지 남기기" onclick="frm_check()"></TD>
			</TR>
			</table>
			<hr> 

<br>
<table border="1"> 
<c:forEach var="message" items="${list}">
<tr>
<td>
메시지 번호: ${message.id}  <br /> 
손님 이름:${message.name} <br /> 
메시지: ${message.message} <br /> 
<a href="del.do?messageId=${message.id} &messagepassword=${message.password}">[삭제하기]</a> 

</td>
</tr> 
</c:forEach>
			
</table>

<c:forEach var="pageNum" begin="1" end="<%= totalPage %>">
<a href="list.do?pageNum=${ pageNum }">[${ pageNum }]</a>
</c:forEach>

</form>
</body>
</html>