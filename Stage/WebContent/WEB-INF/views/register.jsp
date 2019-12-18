<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrazione</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
body,h1 {font-family: "Montserrat", sans-serif}
</style>

<script> 
function validate()
{ 
 var fullname = document.form.fullname.value;
 var email = document.form.email.value;
 var username = document.form.username.value; 
 var password = document.form.password.value;
 var conpassword= document.form.conpassword.value;
 var role= document.form.role.value;
 
 if (fullname==null || fullname=="" || !fullname.contains(" "))
 { 
 alert("Inserisci un Nome e Cognome");
 return false; 
 }
 else if (email==null || email=="" || !email.contains("@"))
 { 
 alert("Inserisci un indirizzo Email corretto!"); 
 return false; 
 }
 else if (username==null || username=="")
 { 
 alert("Inserisci un Username."); 
 return false; 
 }
 else if(password.length<6)
 { 
 alert("La password deve essere lunga almeno 6 caratteri"); 
 return false; 
 } 
 else if (password!=conpassword)
 { 
 alert("La Password scelta e quella di conferma sono diverse!"); 
 return false; 
 } 
 else if (role==null || role=="" || !role.contains("Admin") || !role.contains("User"))
 {
 alert("Il Ruolo deve essere Admin o User")
 }	 
 } 
</script> 
</head>
<body>
<div class="w3-content" style="text-align:center"><h1>Registrazione</h1>

<form name="form" action="register" method="post" onsubmit="return validate()">
	<table align="center">
  	<tr>
  	<td>Nome e Cognome</td>
	 <td><input type="text" name="fullname" /></td>
	 </tr>
	 <tr>
	 <td>Email</td>
	 <td><input type="text" name="email" /></td>
	 </tr>
	 <tr>
	 <td>Username</td>
	 <td><input type="text" name="username" /></td>
	 </tr>
	 <tr>
	 <td>Password</td>
	 <td><input type="password" name="password" /></td>
 	</tr>
 	<tr>
 	<td>Conferma Password</td>
 	<td><input type="password" name="conpassword" /></td>
 	</tr>
 	<tr>
	 <td>Ruolo</td>
	 <td><c:set var="rol" value="ruolo"/>
			<input type="radio" name="role" 
       		value="Admin" <c:if test="${ruolo.contains('Admin')}">checked</c:if>>Admin
			<input type="radio" name="role"  
 		     value="User" <c:if test="${ruolo.contains('User')}">checked</c:if>>User </td>
 	</tr>
 	<tr>
 	<td><%=(request.getAttribute("errMessage") == null) ? ""
	 : request.getAttribute("errMessage")%></td>
 	</tr>
 	<tr>
 	<td></td>
 	<td><input type="submit" value="Registrati" class="w3-bar-item w3-button w3-text-dark-grey w3-hover-black"></input><input
 	type="reset" value="Reset" class="w3-bar-item w3-button w3-text-dark-grey w3-hover-black"></input></td>
 </tr>
</table>
</form>
</div>
 
</body>
</html>