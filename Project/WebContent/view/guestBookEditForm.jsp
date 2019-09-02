<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String messageId = request.getParameter("messageId");
	String messagepassword = request.getParameter("messagepassword");
	String content = request.getParameter("content");
	String messagename = request.getParameter("messagename"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function check() {
		var frmCheck = document.frm;
		var id = frmCheck.id.value;
		var messagename = frmCheck.messagename.value;
		var messagepassword = frmCheck.messagepassword.value;
		var content = frmCheck.content.value;
		if (messagename == null || messagename == "") {1
			alert("이름을 입력해주세요");
		} else if (messagepassword == null || messagepassword.length == 0) {
			alert("비밀번호를 입력해주세요");
		} else if (content == null || content.length == 0) {
			alert("메시지를 입력해주세요");
		}
		else{	
			frmCheck.method = "post";
			frmCheck.action = "/Project/guestBook/realEdit.do";
			frmCheck.submit();
		}

	}
</script>
<body>
	<form name="frm" method="post" action="/Project/guestBook/realEdit.do">	
		<div style="float: right;">
			<a href="/Project/index.jsp">[홈으로]</a>
		</div>
		<br> <br>

		<table WIDTH="500" BORDER="1" CellPadding="0" CellSpacing="0">
			<TR>
				<TD WIDTH="40%" ALIGN="center">이름</TD>
				<TD width="80%" ALIGN="center">
				<INPUT TYPE="text" SIZE="15" MAXLENGTH="10" NAME="name" value="<%=messagename %>"></TD>
			</TR>
			<TR>
				<TD WIDTH="40%" ALIGN="center">암호</TD>
				<TD WIDTH="60%" ALIGN="center">
				<INPUT TYPE="password" SIZE="15" MAXLENGTH="10" NAME="password"></TD>
			</TR>
			<TR>
				<TD WIDTH="40%" ALIGN="center">메시지</TD>
				<TD WIDTH="60%" ALIGN="center">
				<TEXTAREA NAME="message" ROWS=3	COLS=30><%=content%></TEXTAREA></TD>
			</TR>
			<TR>
				<TD WIDTH="100%" ALIGN="center" COLSPAN="2">
				<INPUT TYPE="button" VALUE="메시지 수정하기" onclick="check()"></TD>
				<input type="hidden" name="id" value="<%=messageId %>">
				<input type="hidden" name="messagename" value="name">
				<input type="hidden" name="messagepassword" value="password">
				<input type="hidden" name="content" value="message">
			</TR>
			
		</table>
	</form>
</body>
</html>