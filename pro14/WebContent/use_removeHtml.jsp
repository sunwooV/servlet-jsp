<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>removeHtml</title>
</head>
<body>
<c:set var="dateEL" value="<%=new Date() %>"/>
<tf:removeHtml trim="true">
	<font size="10">현재<style>시간</style>은 ${dateEL }</font>
</tf:removeHtml>
<br>
<tf:removeHtml length="15" trail="..." trim="true">
	<u>현재 시간</u>은 <b>${dateEL }</b>입니다.
</tf:removeHtml>
<br>
<tf:removeHtml length="15">
	<jsp:body><u>현재 시간</u>은 <b>${dateEL }</b>입니다.</jsp:body>
</tf:removeHtml>
</body>
</html>