<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 창</title>
	<script type="text/javascript">
		function frm_check(){
			var frmcheck = document.frmCK;
			var id = frmcheck.id.value;
			var pwd = frmcheck.pwd.value;
			var pwd_ck = frmcheck.pwd_ck.value;
			if(id.length == 0 || id == ""){
				alert("ID 입력은 필수입니다.");
			} else if(pwd.length == 0 || pwd == ""){
				alert("암호 입력은 필수입니다.");
			} else if(pwd != pwd_ck){
				alert("암호가 일치하지 않습니다.");
			} else {
				alert("가입 완료되었습니다.")
				frmcheck.method = "post";
				frmcheck.action = "../management"; 
				frmcheck.submit();
			}
		}
	</script>
</head>
<body>
	<form name="frmCK">  
		ID: <input type="text" name="id"><br>
		이름: <input type="text" name="name"><br>
		암호: <input type="password" name="pwd"><br>
		확인: <input type="password" name="pwd_ck"><br><br>
		<input type="button" value="가입" onclick="frm_check()">
		<input type="reset" value="다시 입력">
		<input type="hidden" name="command" value="join">
	</form>
</body>
</html>