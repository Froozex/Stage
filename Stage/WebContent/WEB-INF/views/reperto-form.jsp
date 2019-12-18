<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
 <title>Reperto Manager</title>
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 
 <style>
body,h1 {font-family: "Montserrat", sans-serif}
</style>
</head>

<% //In case, if Admin/User session is not set, redirect to Login page
if(request.getSession(false).getAttribute("Admin")== null || request.getSession(false).getAttribute("User")== null)
{
%>
<jsp:forward page="/WEB-INF/views/login.jsp"></jsp:forward>
<%} %>


<body>
<div class="w3-content" style="text-align:center">
  <h1>Reperti</h1>
        <h2>
         <a href="home">Home Page</a>
         &nbsp;&nbsp;&nbsp;
         <a href="fascicoli">Torna ai Fascicoli</a>
         
        </h2>
<div align="center">
             <h2>
              <c:if test="${rep != null}">
               Modifica Reperto
              </c:if>
              <c:if test="${rep == null}">
               Aggiungi Nuovo Reperto
              </c:if>
             </h2>
            </div>
 
  <c:if test="${rep != null}">
   <form action="updatereperto" method="post">
        </c:if>
        <c:if test="${rep == null}">
   <form action="insertreperto" method="post">
        </c:if>
           <div align="center">
        <table class="w3-content" border="1" cellpadding="5">
            
          <c:if test="${rep != null}">
           <input type="hidden" name="id" value="<c:out value='${rep.id}' />" />
          </c:if>            
            
            <tr>
            	<th>Nomina: </th>
            	<td>
            	<c:if test="${rep != null}">
            	<input type="text" name= "nomina" size="10"
            	
            	value="<c:out value='${rep.nomina}' />"disabled 
            	/>
                </c:if>
                <c:if test="${rep == null}">
            	<input type="text" name= "nomina" size="10"
            	
            	value="<c:out value='${rep.nomina}' />" 
            	/>
                </c:if>
                </td>
                </tr>
                <tr>
                <th>Numero Reperto: </th>
                <td>
                 <input type="text" name="nreperto" size="10"
                   value="<c:out value='${rep.nreperto}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Sequestrato a: </th>
                <td>
                 <input type="text" name="sequestrato" size="10"
                   value="<c:out value='${rep.sequestrato}' />"/>
                </td>
                <tr>
                <th>Tipo di Supporto: </th>
                <td>
                 <input type="text" name="supporto" size="45"
                   value="<c:out value='${rep.supporto}' />"/>
                </td>
                <tr>
                <th>Seriale: </th>
                <td>
                 <input type="text" name="seriale" size="100"
                   value="<c:out value='${rep.seriale}' />"
                 />
                </td>
                <tr>
                <th>Note: </th>
                <td>
                 <input type="text" name="note" size="100"
                   value="<c:out value='${rep.note}' />"
                 />
                </td>
                <tr>
                <th>Operazioni: </th>
                <td>
                 <input type="text" name="operazioni" size="45"
                   value="<c:out value='${rep.operazioni}' />"/>
                </td>
             <td colspan="2" align="center">
              <input type="submit" class="w3-button w3-dark-grey" value="Salva" />
             </td>
            </tr>
        </table>
        </form>
        </form>
    </div> 
    </div>
</body>
</html>