<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>초기화면</title>
  <script type="text/javascript">
	function frm_login() {
		var frmPrac = document.frm;
		frmPrac.method = "post";
		frmPrac.action = "login.jsp"; 
		frmPrac.command.value = "login";
		frmPrac.submit();
	}
</script>
</head> 
<body>
   <form name="frm" method="post" action="join.jsp">  
	   <input type ="submit" value="회원가입하기"><br>
	   <input type = "button" value = "로그인하기" onclick = "frm_login()">
	   <input name = "command" type = "hidden" value = "join">
   </form>
</head>
	
</body>
</html>