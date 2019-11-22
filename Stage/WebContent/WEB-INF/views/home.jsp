<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
     <title>Home Page</title>
  </head>
  <body>
  
  		<h2>Benvenuto <%=request.getAttribute("userName") %></h2>
  		
  		
      <h3>Forensics Data Manager</h3>
      
      Gestisci qui i tuoi fascicoli forensi! <br><br>
      <b>It includes the following functions:</b>
      <ul>
         <li>Login</li>
         <li>Storing user information in cookies</li>
         <li>Product List</li>
         <li>Create Product</li>
         <li>Edit Product</li>
         <li>Delete Product</li>
      </ul>
 
     <jsp:include page="footer.jsp"></jsp:include>
 
  </body>
</html>