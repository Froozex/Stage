<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
     <title>FDM</title>
  </head>
  <body>
  
  <%
  response.setHeader("Cache-Control", "no-cache");
  response.setHeader("Cache-Control", "no-store");
  response.setHeader("Pragma", "no-cache");
  response.setDateHeader("Expire", 0);
  
  %>
 
     <jsp:include page="header.jsp"></jsp:include>
     <jsp:include page="menu.jsp"></jsp:include>
    
      <h3>Benvenuto<b> <%=request.getAttribute("userName") %>!</b></h3>
      
      Gestisci qui i tuoi fascicoli forensi! <br><br>


<!-- Do not use table to format fields. As a good practice use CSS -->
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
  
  <jsp:include page="footer.jsp"></jsp:include>
  </body>

  
</html>