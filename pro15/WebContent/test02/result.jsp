<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="contextPath" value="<%= request.getContextPath()%>"/>  
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="file1" value="${param.param1 }"/> <%-- 다운로드할 파일 이름을 가져온다. --%>
<c:set var="file2" value="${param.param2 }"/>
<title>이미지 파일 출력하기</title>
</head>
<body>
	매개변수 1 : <c:out value="${file1 }"/><br>
	매개변수 2 : <c:out value="${file2 }"/><br>
	
	<c:if test="${not empty file1 }">
		<img src="${contextPath }/download.do?fileName=${file1 }" width=300 height=300/><br>
		<%-- 파일 이름으로 서블릿에서 이미지를 다운로드해 표시 --%>
	</c:if>
	<c:if test="${not empty file2 }">
		<img src="${contextPath }/download.do?fileName=${file2 }" width=300 height=300/><br>
		<%-- 파일 이름으로 서블릿에서 이미지를 다운로드해 표시 --%>
	</c:if>
	파일 내려받기 : <br>
	<a href="${contextPath }/download.do?fileName=${file2 }"> <%-- 이미지를 파일로 다운로드 --%>
	파일 내려받기 </a><br>
</body>
</html>