<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
	import="article.dao.*"
	import="article.model.*"
	import="article.service.*"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
   	request.setCharacterEncoding("utf-8");
	List list = (List)request.getAttribute("list");
	int totalPage = (int)request.getAttribute("totalPage");
	String pageNum = (String)request.getParameter("pageNum");
	if(pageNum==null){
		pageNum = "1";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style>
.a{
	border:1px solid #444444;
	width:100%;
	padding: 10px 0px;
}

h1{
	text-align:center;
	color:#444444;
}

</style>
</head>
<body>
	<form action="join.do" method="post">
	<div style="float:right;">
		<a href="/Project/index.jsp">[홈으로]</a>
		<a href="/Project/logout.do">[로그아웃하기]</a><br>
	</div>
	<br><br>
	<div class="a" style="bgcolor:powderblue;">
	
	<h1>게시판</h1>
	
	</div>
	
		<div>
		<table border="1" width= "100%">
		 <tr bgcolor="FFFF66">
		 	<td colspan="4"><a href="write.do">게시글쓰기</a></td>
		 </tr>
	 	<tr>
		 	<th bgcolor="#eeeeee" align="center">번호</th>
			<th bgcolor="#eeeeee" align="center">제목</th>
			<th bgcolor="#eeeeee" align="center">작성자</th>
			<th bgcolor="#eeeeee" align="center">조회수</th>
		</tr>

		 	<%
				System.out.println("totalPage : : : " + totalPage);
		 		for(int i = 0; i < list.size(); i++){
						Article a = (Article) list.get(i);
		 	%>
		 	
		 		<tr>
		 			<%--<td width= "100"><%=dan %></td> --%>
		 			<td width= "20"><%=a.getNo() %></td>
		 			<td width= "20"><a href="each.do?eachId=<%=a.getNo() %>&pageNum=<%=pageNum%>"><%=a.getTitle() %></a></td>
		 			<td width= "50"><%=a.getName() %></td>
		 			<td width= "50"><%=a.getCnt() %></td>
		 		</tr>
		 	<%
		 		}
		 			
		 		
		 	%>
		 	
		</table>
		<c:forEach var="pageNum" begin="1" end="<%=totalPage %>">
			<a href="list.do?pageNum=${pageNum }">[${pageNum }]</a>
		</c:forEach>
		</div>
	</form>
</body>
</html>