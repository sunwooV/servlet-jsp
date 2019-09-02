<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
	import="article.dao.*"
	import="article.model.*"
	import="article.service.*"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
   	request.setCharacterEncoding("utf-8");
	List list = (List)request.getAttribute("eachList");
	String pageNum = (String)request.getParameter("pageNum");
	System.out.println("pageNUm ______" + pageNum);
	ArticleContent ac = (ArticleContent) list.get(0);
	String con = null;
	if(ac.getContent() == null){
		con = "";
	}
	else{
		con = ac.getContent();
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>각 게시물 상세조회</title>
</head>
<body>
	<table border="1" width="100%">
		<tr bgcolor="FFFF66">
			<td>번호</td>
			<td width="70%"><%=ac.getNo() %></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td width="70%"><%=ac.getName() %></td>
		</tr>
		<tr>
			<td>제목</td>
			<td width="70%"><%=ac.getTitle() %></td>
		</tr>
		<tr>
			<td>내용</td>
			<td width="70%"><textarea readonly="readonly" cols="40" rows="10"><%=con.replace("<br>","\r\n") %></textarea></td>
		</tr>
		<tr>
			<td colspan="2"><a href='list.do'>[목록]</a><a href='edit.do?pageNum=<%=pageNum%>&editId=<%=ac.getNo()%>&title=<%=ac.getTitle() %>&content=<%=con.replace("\r\n","<br>") %>'>[게시글수정]</a><a href='del.do?pageNum=<%=pageNum%>&delId=<%=ac.getNo()%>'>[게시글삭제]</a></td>
		</tr>
	</table>
</body>
</html>