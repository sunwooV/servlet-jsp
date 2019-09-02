<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, practice0813.*"
    pageEncoding="UTF-8"%>
<%
   request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="m" class="practice0813.CustBean" scope="page"/>
<jsp:setProperty name="m" property="*"/>
<%
   String command=request.getParameter("command");
   CustDAO custDAO = new CustDAO();

   if(command!=null && command.equals("edit")){
      
      custDAO.editCust(m);
   } else if(command!=null && command.equals("add")){
      
      custDAO.addCust(m);
   }
   List custList = custDAO.listCusts(m);
   
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객 조회 창</title>
</head>
<body>
   <h1 style="text-align:center">고객 조회</h1>
   <table align="center">
      <tr align="center" bgcolor="lightpink">
         <td>고객 번호</td>
         <td>고객 이름</td>
         <td>고객 주소</td>
         <td>고객 주</td>
         <td>고객 우편번호</td>
         <td>고객 국가</td>
         <td>고객 담당자</td>
         <td>고객 메일주소</td>
         <td>수정</td>
      </tr>
<%
   if(custList.size()==0){
%>
      <tr>
         <td colspan="9">
            <p align="center"><b><span style="font-size:11pt;">
            등록된 고객이 없습니다.</span></b></p>
         </td>
      </tr>
<%
   } else { //고객이 있을 때
      for(int i=0;i<custList.size();i++){
         CustBean bean = (CustBean)custList.get(i);
%>
      <tr>
         <td>
            <%= bean.getId() %>
         </td>
         <td>
            <%= bean.getName() %>
         </td>
         <td>
            <%= bean.getAddress() %>
         </td>
         <td>
            <%= bean.getState() %>
         </td>
         <td>
            <%= bean.getZip() %>
         </td>
         <td>
            <%= bean.getCountry() %>
         </td>
         <td>
            <%= bean.getContact() %>
         </td>
         <td>
            <%= bean.getEmail() %>
         </td>
         <td>
            <a href='/practice/customer?command=edit&id=<%=bean.getId()%>&name=<%=bean.getName()%>&address=<%=bean.getAddress()%>&state=<%=bean.getState()%>&zip=<%=bean.getZip()%>&country=<%=bean.getCountry()%>&contact=<%=bean.getContact()%>&email=<%=bean.getEmail()%>&editId=<%=bean.getId()%>&searchId=<%=m.getSearchId()%>'>수정</a>
         </td>

<%
      }
   }
%>
      </tr>
      
   </table>
   <a href='/practice/0813/searchCust.jsp'>새로운 고객 검색하기</a>
</body>
</html>