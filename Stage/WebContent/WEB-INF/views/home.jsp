<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
 <style>
body,h1 {font-family: "Montserrat", sans-serif}
</style>
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

  <body class="w3-content">
 
   
    
      <h3>Benvenuto<b> <%=request.getAttribute("role") %> <%=request.getAttribute("userName") %>!</b></h3>
      
      Gestisci qui i tuoi fascicoli forensi! <br><br>

<form name="form" action="fascicoli" method="post" >
 <input type="submit" value="Gestione fascicoli" class="w3-bar-item w3-button w3-text-dark-grey w3-hover-black"></input></form>
 <table align="center">
 <tr>
 <td></td>
 
 

 </tr>
  <tr>
 <td></td>
 <td></td>
 </tr>
 
     
   </table>
  </body>
  
</html>