<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
	import="article.dao.*"
    pageEncoding="UTF-8"%>
   <%
  		request.setCharacterEncoding("utf-8");
   		String editId = request.getParameter("editId");
   		String pageNum = request.getParameter("pageNum");
   		String title = request.getParameter("title");
   		String content = request.getParameter("content");

   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정창</title>
</head>
	<script type="text/javascript">
		function frm_check(){
		var frmCheck = document.frmCheck;
		var title = frmCheck.title.value;

			
			if(title.length = 0 || title == "")
			{
				alert("제목을 입력하세요.");
			
			}
			else
			{
				frmCheck.method ="post";
				frmCheck.action ="add.do";
				frmCheck.submit();
			}
		}
		
	</script>
<body>
	<form name="frmCheck" action="realEdit.do" method="post">
		<table style="text-align: center; border: 2px solid #dddddd">
			<tr>
				<th colspan="2" style="background-color: #eeeeee; text-align: center;">게시판 글쓰기 양식</th>
			</tr>
			<tbody>
				<tr>
					<td><input type="text" class="form-control" placeholder="글 제목" name="title" value="<%=title %>" maxlength="500"/></td>
				</tr>
				<tr>
					<td><textarea class="form-control" placeholder="글 내용" name="content" maxlength="3048" style="height: 350px;"><%=content.replace("<br>", "\r\n") %></textarea></td>
				</tr>
			</tbody>
		</table>	
		<input type="submit" value="글 수정" />
		<input type="hidden" value= "<%=editId %>" name="editId">
		<input type="hidden" value= "<%=pageNum %>" name="pageNum">
	</form>

</body>
</html>