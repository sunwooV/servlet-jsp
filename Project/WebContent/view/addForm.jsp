<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
	import="article.dao.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 추가창</title>
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
	<form name="frmCheck">
		<table style="text-align: center; border: 2px solid #dddddd">
			<tr>
				<th colspan="2" style="background-color: #eeeeee; text-align: center;">게시판 글쓰기 양식</th>
			</tr>
			<tbody>
				<tr>
					<td><input type="text" class="form-control" placeholder="글 제목" name="title" maxlength="500"/></td>
				</tr>
				<tr>
					<td><textarea class="form-control" placeholder="글 내용" name="content" maxlength="3048" style="height: 350px;"></textarea></td>
				</tr>
			</tbody>
		</table>	
		<input type="submit" value="새 글 등록" onclick="frm_check()"/>
	</form>

</body>
</html>