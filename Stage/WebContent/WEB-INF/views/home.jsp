<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
     <title>Home Page</title>
  </head>
  <body>
 
     <jsp:include page="header.jsp"></jsp:include>
     <jsp:include page="menu.jsp"></jsp:include>
    
      <h3>Benvenuto<b> <%=request.getAttribute("userName") %>!</b></h3>
      
      Gestisci qui i tuoi fascicoli forensi! <br><br>


<!-- Do not use table to format fields. As a good practice use CSS -->
<table align="center">
 <tr>
 <td></td>
 <td><form name="form" action="FascicoloServlet" method="post">
 <input type="submit" value="Gestione fascicoli."></input></form></td>
 </tr>
  <tr>
 <td></td>
 <td></td>
 </tr>
 
     
   </table>
  
  <jsp:include page="footer.jsp"></jsp:include>
  </body>

  
</html>