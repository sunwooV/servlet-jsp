<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="contextPath" value="<%= request.getContextPath()%>"/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 조회</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script> <!-- 제이쿼리를 사용하기 위해 반드시 설정 -->
<script type="text/javascript">
	$(function(){
		$("#search").click(function(){
			var _id = $("#cust_id").val();
			if(_id == ''){
				alert("고객번호를 입력하세요.");
				return;
			}
			$.ajax({
				type: "post",
				async: false,
				url: "http://localhost:8090/practice /cus",
				dataType: "text",
				data: { id: _id},
				url: "${contextPath}/cus",
				success: function(data, textStatus){
					var jsonInfo = JSON.parse(data);
					
					var customerInfo = "고객 정보<br>========================<br>";
					
					for(var i in jsonInfo.customers){
						customerInfo += "<table border=1>";
						customerInfo += "<tr>";
						customerInfo += "<td bgcolor=lightpink>고객번호</td>";
						customerInfo += "<td>" + jsonInfo.customers[i].id + "</td>";
						customerInfo += "</tr>";
						
						customerInfo += "<tr>";
						customerInfo += "<td bgcolor=lightpink>고객이름</td>";
						customerInfo += "<td>" + jsonInfo.customers[i].name + "</td>";
						customerInfo += "</tr>";
						
						customerInfo += "<tr>";
						customerInfo += "<td bgcolor=lightpink>고객주소</td>";
						customerInfo += "<td>" + jsonInfo.customers[i].address + "</td>";
						customerInfo += "</tr>";
						
						customerInfo += "<tr>";
						customerInfo += "<td bgcolor=lightpink>고객주</td>";
						customerInfo += ("<td><select>" 
								+ "<option selected>" + jsonInfo.customers[i].state + "</option>"
								+ "</select></td>");
						customerInfo += "</tr>";
						
						customerInfo += "<tr>";
						customerInfo += "<td bgcolor=lightpink>고객우편번호</td>";
						customerInfo += "<td>" + jsonInfo.customers[i].zip + "</td>";
						customerInfo += "</tr>";
						
						customerInfo += ("<tr>");
						customerInfo += ("<td bgcolor=lightpink>고객국가</td>");
						customerInfo += ("<td><select>" 
								+ "<option selected>" + jsonInfo.customers[i].country + "</option>"
								+ "</select></td>");
						customerInfo += ("</tr>");
						
						customerInfo += ("<tr>");
						customerInfo += ("<td bgcolor=lightpink>고객담당자</td>");
						customerInfo += ("<td>" + jsonInfo.customers[i].contact + "</td>");
						customerInfo += ("</tr>");
						
						customerInfo += ("<tr>");
						customerInfo += ("<td bgcolor=lightpink>고객메일주소</td>");
						customerInfo += ("<td>" + jsonInfo.customers[i].email + "</td>");
						customerInfo += ("</tr></table>");
					}
					$('#search').prop("disabled", true);
					$("#output").html(customerInfo);
					
				},
				error: function(data, textStatus){
					alert("고객이 존재하지 않습니다.");
				},
				complete : function (data, textstatus){
				}
			});
		});
	});
</script>
</head>
<body>
	<h1>고객 조회</h1><br><br>
	고객 번호 <input type="text" id="cust_id">
	<input type="button" id="search" value="조회"><br><br>
	<div id="output"></div>
</body>
</html>