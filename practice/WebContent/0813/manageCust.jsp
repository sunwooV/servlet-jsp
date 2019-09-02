<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="m" class="practice0813.CustBean" scope="page"/>
<jsp:setProperty name="m" property="*"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 관리 창</title>
</head>
<body>
	<form name="manageForm" method="get">
<%
	String searchId = request.getParameter("searchId");
	String command = request.getParameter("command");
	if(command!=null && command.equals("edit")){
		
%>
		<h1 style="text-align:center">고객 수정 창</h1>
		고객 번호 <input type="text" name="id" value=<jsp:getProperty  name="m" property="id" />><br>
		고객 이름 <input type="text" name="name" value=<jsp:getProperty  name="m" property="name" />><br>
		고객 주소 <input type="text" name="address" value=<jsp:getProperty  name="m" property="address" />><br>
		고객 주 <input type="text" name="state" value=<jsp:getProperty  name="m" property="state" />><br>
		고객 우편번호 <input type="text" name="zip" value=<jsp:getProperty  name="m" property="zip" />><br>
		고객 국가 <input type="text" name="country" value=<jsp:getProperty  name="m" property="country" />><br>
		고객 담당자 <input type="text" name="contact" value=<jsp:getProperty  name="m" property="contact" />><br>
		고객 메일주소 <input type="text" name="email" value=<jsp:getProperty  name="m" property="email" />><br><br>
		<input type="submit" value="수정" onClick="javascript_:document.manageForm.action='/practice/0813/lookCust.jsp';">
		<input type="hidden" name="editId" value=<jsp:getProperty  name="m" property="editId" />>
		<input type="hidden" name="searchId" value=<%=searchId %>>
		<input type="hidden" name="command" value="edit">
<%
	} else {
%>
		<h1 style="text-align:center">고객 추가 창</h1>
		고객 번호 <input type="text" name="id"><br>
		고객 이름 <input type="text" name="name"><br>
		고객 주소 <input type="text" name="address"><br>
		고객 주 <input type="text" name="state"><br>
		고객 우편번호 <input type="text" name="zip"><br>
		고객 국가 <input type="text" name="country"><br>
		고객 담당자 <input type="text" name="contact"><br>
		고객 메일주소 <input type="text" name="email"><br><br>
		<input type="submit" value="고객 추가" onClick="javascript_:document.manageForm.action='/practice/0813/lookCust.jsp';">
		<input type="hidden" name="searchId" value=<%=searchId %>>
		<input type="hidden" name="command" value="add">
	
<%
	}
%>

</body>
</html>