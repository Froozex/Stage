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
  <body>
  
  
 
     <jsp:include page="header.jsp"></jsp:include>
    
      <h3>Benvenuto<b> <%=request.getAttribute("userName") %>!</b></h3>
      
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