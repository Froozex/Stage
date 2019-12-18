<pre><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrazione</title>
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
<center><h2>Registrazione </h2></center>
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
	 <td><input type="text" name="role" /></td>
	 </tr>
 	<tr>
 	<td><%=(request.getAttribute("errMessage") == null) ? ""
	 : request.getAttribute("errMessage")%></td>
 	</tr>
 	<tr>
 	<td></td>
 	<td><input type="submit" value="Registrati"></input><input
 	type="reset" value="Reset"></input></td>
 </tr>
</table>
</form>
 
</body>
</html>