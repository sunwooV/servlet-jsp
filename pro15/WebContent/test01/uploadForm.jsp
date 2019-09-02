<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="contextPath" value="<%= request.getContextPath()%>"/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
<form action="${contextPath }/upload.do" <%-- 서블릿에 요청해 파일을 업로드 --%>
			 method="post" enctype="multipart/form-data"> <%-- 파일 업로드 시 반드시 encType을 multipart/form-data로 설정해야 한다. --%>
	파일1 : <input type="file" name="file1" ><br>
	파일2 : <input type="file" name="file2" ><br>
	매개변수1 : <input type="text" name="param1" ><br>
	매개변수2 : <input type="text" name="param2" ><br>
	매개변수3 : <input type="text" name="param3" ><br>
	<input type="submit" value="업로드">
</form>
</body>
</html>