<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*" import="guestbook.dao.*"
	import="guestbook.model.*" import="guestbook.service.*"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
	List list = (List) request.getAttribute("list");

	int totalPage = (int) request.getAttribute("totalPage");

%>
<c:set var="list" value="<%=list%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
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
p{
	text-align:center;
}
</style>
</head>
<script type="text/javascript">
	function check() {
		var frmCheck = document.frm;
		var id = frmCheck.id.value;
		var name = frmCheck.name.value;
		var password = frmCheck.password.value;
		var message = frmCheck.message.value;
		if (name == null || name == "") {1
			alert("이름을 입력해주세요");
		} else if (password == null || password.length == 0) {
			alert("비밀번호를 입력해주세요");
		} else if (message == null || message.length == 0) {
			alert("메시지를 입력해주세요");
		}
		else{	
			frmCheck.id.value = id;
			frmCheck.password.value = password;
			frmCheck.name.value = name;
			frmCheck.message.value = message;
			frmCheck.method = "post";
			frmCheck.action = "write.do";
			frmCheck.submit();
		}

	}
	function frm_del(messageId, messagepassword) {
		var frmCheck = document.frm;

		frmCheck.messageId.value = messageId;
		frmCheck.messagepassword.value = messagepassword;

		frmCheck.method = "post";
		frmCheck.action = "del.do";

		frmCheck.submit();

	}
	function frm_edit(messageId, messagepassword, messagename, content) {
		var frmCheck = document.frm;

		frmCheck.messageId.value = messageId;
		frmCheck.messagepassword.value = messagepassword;
		frmCheck.messagename.value = messagename;
		frmCheck.content.value = content;
		frmCheck.method = "post";
		frmCheck.action = "edit.do";

		frmCheck.submit();

	}
</script>
<body>
	<form name="frm">
		<div style="float: right;">
			<a href="/Project/index.jsp">[홈으로]</a>
		</div>
		<br> <br>
		<div class="a" style="bgcolor:powderblue;">
		<h1>방명록</h1>
		</div>
		<div>
		<br><br>
		<table WIDTH="500" BORDER="1" CellPadding="0" CellSpacing="0" align="center">
			<TR>
				<TD WIDTH="40%" ALIGN="center" bgcolor="skyblue">이름</TD>
				<TD width="80%" ALIGN="center">
				<INPUT TYPE="text" SIZE="15" MAXLENGTH="10" NAME="name"></TD>
			</TR>
			<TR>
				<TD WIDTH="40%" ALIGN="center" bgcolor="skyblue">암호</TD>
				<TD WIDTH="60%" ALIGN="center">
				<INPUT TYPE="password" SIZE="15" MAXLENGTH="10" NAME="password"></TD>
			</TR>
			<TR>
				<TD WIDTH="40%" ALIGN="center" bgcolor="skyblue">메시지</TD>
				<TD WIDTH="60%" ALIGN="center">
				<TEXTAREA NAME="message" ROWS=3	COLS=30></TEXTAREA></TD>
			</TR>
			<TR>
				<TD WIDTH="100%" ALIGN="center" COLSPAN="2">
				<INPUT TYPE="button" VALUE="메시지 남기기" onclick="check()"></TD>
			</TR>
		</table>
		<br>
		<hr>



		<br>
		<table border="1" WIDTH="500" BORDER="1" CellPadding="0" CellSpacing="0" align="center">
			<c:forEach var="message" items="${list}">
				<tr>
					<td>메시지 번호: ${message.id} <br /> 손님 이름:${message.name} <br />
						메시지: ${message.message} <br /> 
						<a href="javascript:frm_del('${message.id }', '${message.password }')">[삭제하기]</a>
						<%--<a href="javascript:frm_edit('${message.id }', '${message.password }','${message.name}','${message.message}')">[수정하기]</a>--%>
						<input type="hidden" value="${message.id }" name="messageId">
						<input type="hidden" value="${message.password }" name="messagepassword">
						<input type="hidden" value="${message.name }" name="messagename">
						<input type="hidden" value="${message.message }" name="content">
					</td>
				</tr>
			</c:forEach>

		</table>
		<p>
		<c:forEach var="pageNum" begin="1" end="<%=totalPage%>">
			<a href="list.do?pageNum=${ pageNum }">[${ pageNum }]</a>
		</c:forEach>
		<input type="hidden" value="${pageNum }" name="pageNum">
		</p>
		<br><hr>
		</div>
	</form>
</body>
</html>