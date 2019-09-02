<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 검색 창</title>
   <script type="text/javascript">
      function frm_add() {
         var frmAdd = document.custForm;
         frmAdd.method = "get";
         frmAdd.action = "../customer";
         frmAdd.command.value = "add";
         frmAdd.submit();
      }
   </script>
</head>
<body>
   <form name="custForm" method="get" action="../customer">
      <h1 style="text-align:center">고객 조회 창</h1><br>
      
      <h3 style="text-align:center">고객 번호 <input type="text" name="searchId">
      <input type="submit" value="조회하기">
      <input type="submit" value="고객추가" onClick="frm_add()">
      <input type="hidden" name="command" value="search">
      </h3>
   </form>
</body>
</html>