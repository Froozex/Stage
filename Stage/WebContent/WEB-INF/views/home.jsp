<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  
<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
     <title>FDM</title>
  </head>
  
  <c:choose>
  <c:when test="${not empty Admin}">
    <%@ include file="header_admin.jsp" %>
  </c:when>
  <c:when test="${not empty User}">
    <%@ include file="header_user.jsp" %>
  </c:when>
  <c:otherwise>
    <jsp:forward page="/WEB-INF/views/login.jsp"></jsp:forward>
  </c:otherwise>
</c:choose>
  
  
  
  
  
  
  
  
  <body>
  
  
 
     
    
      <h3>Benvenuto<b> <%=request.getAttribute("role") %> <%=request.getAttribute("userName") %>!</b></h3>
      
      Gestisci qui i tuoi fascicoli forensi! <br><br>


<table align="center">
 <tr>
 <td></td>
 
 <form name="form" action="fascicoli" method="post" ">
 <input type="submit" value="Gestione fascicoli"></input></form>
 
 </tr>
  <tr>
 <td></td>
 <td></td>
 </tr>
 
     
   </table>

  </body>

  
</html>