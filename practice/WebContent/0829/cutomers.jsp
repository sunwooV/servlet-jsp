<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 조회</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- 제이쿼리를 사용하기 위해 반드시 설정 -->
<script type="text/javascript">
	function fn_process(_command) {
		
		var params = $("#frm").serialize(); //입력된 모든 Element를 문자열의 데이터에 serialize 한다.
		var _id = $("#cust_id").val();
		$("#command").val(_command);

		//조회 시 아이디 없을 때
		if (_command == 'search' && _id == '') {
			alert("고객번호를 입력하세요.");
			return;
		}

		//추가 시 값 초기화한 후 종료
		if (_command == 'add') {
			$('#id').prop("disabled", false);
			$('#frm')[0].reset();
			return;
		}

		//저장 시 id 값이 없으면 에러 창
		var id = $("#id").val();
		if (_command == 'save' && id == '') {
			alert("고객번호를 입력하세요.");
			return;
		}

		$.ajax({
			type : "post",
			async : false,
			url : "http://localhost:8090/practice/cus2",
			dataType : "text",
			data : params = "command=" + _command + "&_id=" + _id + "&id=" + id
					+ "&name=" + $("#name").val() + "&address="
					+ $("#address").val() + "&state=" + $("#state").val()
					+ "&zip=" + $("#zip").val() + "&country="
					+ $("#country").val() + "&contact=" + $("#contact").val()
					+ "&email=" + $("#email").val() + "&copyId="
					+ $("#copyId").val(),
			url : "${contextPath}/cus2",
			success : function(data, textStatus) {
	
				if (_command == 'search') {
					var jsonInfo = JSON.parse(data);
		            if(jsonInfo.error.error_yn == 'Y'){
		        	   alert(jsonInfo.error.error_text);
		        	   return;
		            }
					
					$('#id').prop("disabled", true); //고객번호는 변경 x
					
					$('#id').val(jsonInfo.customers[0].id);
					$('#copyId').val(jsonInfo.customers[0].id);
					$('#name').val(jsonInfo.customers[0].name);
					$('#address').val(jsonInfo.customers[0].address);
					
					$('#zip').val(jsonInfo.customers[0].zip);
					$('#country').val(jsonInfo.customers[0].country);
					$('#contact').val(jsonInfo.customers[0].contact);
					$('#email').val(jsonInfo.customers[0].email);
					
					//select box에 들어갈 value
					var stateList = "<select name='stateList'>"; 
					stateList += "<option value = '" + jsonInfo.customer[0].state +"' selected>"
					+ jsonInfo.customer[0].state + "</option>";
					for(var i in jsonInfo.stateList){
						stateList += ("<option value = '" + jsonInfo.stateList[i] +"'>"
								+ jsonInfo.stateList[i] + "</option>");
					}
					stateList += "</select>"
					
					$("#stateList").html(stateList);
					
				} else if(_command == 'save'){
					alert("저장되었습니다.");
				}
			},
			error : function(data, request, error) {
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			},
			complete : function(data, textstatus) {
			}
		});
	}
</script>
</head>
<body>
	<form name="frm" id="frm">
		<h1>고객 조회</h1>
		<br>
		<br> 고객 번호 <input type="text" id="cust_id"> 
		<input type="hidden" id="command" name="command"> 
		<input type="button" id="search" value="조회" onClick="fn_process('search')">
		<input type="button" id="add" value="추가" onClick="fn_process('add')">
		<input type="button" id="save" value="저장" onClick="fn_process('save')"><br><br><br>
		
		==================================<br><br>

		<table border=1>
			<tr>
				<td bgcolor=lightpink>고객번호</td>
				<td><input type="text" id="id"></td>
				<input type="hidden" name="copyId" id="copyId">
			</tr>

			<tr>
				<td bgcolor=lightpink>고객이름</td>
				<td><input type="text" id="name"></td>
			</tr>

			<tr>
				<td bgcolor=lightpink>고객주소</td>
				<td><input type="text" id="address"></td>
			</tr>

			<tr>
				<td bgcolor=lightpink>고객주</td>
				<td><div id="stateList"></div></td>
			</tr>

			<tr>
				<td bgcolor=lightpink>고객우편번호</td>
				<td><input type="text" id="zip"></td>
			</tr>

			<tr>
				<td bgcolor=lightpink>고객국가</td>
				<td><input type="text" id="country"></td>
			</tr>

			<tr>
				<td bgcolor=lightpink>고객담당자</td>
				<td><input type="text" id="contact"></td>
			</tr>

			<tr>
				<td bgcolor=lightpink>고객메일주소</td>
				<td><input type="text" id="email"></td>
			</tr>
		</table>

	</form>
</body>
</html>