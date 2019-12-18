<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
 <title>Lista reperti</title>
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

 <style>
 body,h1 {font-family: "Montserrat", sans-serif}
 
thead, tbody tr {
      display:table;
      width: 2000px;
      table-layout:fixed;
  }
  thead {
      width: calc( 2000px - 2em )
  } 

tr:nth-child(even){background-color: #f2f2f2}
</style>
</head>

<% //In case, if Admin/User session is not set, redirect to Login page
if(request.getSession(false).getAttribute("Admin")== null || request.getSession(false).getAttribute("User")== null)
{
%>
<jsp:forward page="/WEB-INF/views/login.jsp"></jsp:forward>
<%} %>

<body class="w3-content">
<div class="w3-content" style="text-align:center">
  <h1>Reperti</h1>
  <h3>Reperto della Nomina<b> <c:out value='<%=request.getAttribute("nomina")%>'/>!</b></h3>
        <h2>
        <a href="fascicoli">Torna ai Fascicoli</a>
        &nbsp;&nbsp;&nbsp;
         <a href="newreperto">Aggiungi Nuovo Reperto</a>
         &nbsp;&nbsp;&nbsp;
         
        </h2>
        <h1>Lista Reperti</h1>
 </div>
    <div align="center" style="overflow-x:auto;">
        <table border="1" cellpadding="5" class="w3-table-all" class="w3-table-all w3-margin-top" id="myTable">
            
            <tr>
                <th></th>
                <th>Nomina</th>
                <th>Numero Reperto</th>
                <th>Sequestrato a:</th>
                <th>Tipo di Supporto</th>
                <th>Seriale</th>
                <th>Note</th>
                <th>Operazioni</th>
            </tr>
            <c:forEach var="rep" items="${listRep}">
                <tr>
                    <td>
                     <a href="editreperto?nreperto=<c:out value='${rep.nreperto}'/> ">Modifica</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="deletereperto?nreperto=<c:out value='${rep.nreperto}'/>">Elimina</a>                     
                    </td>
                    <td><c:out value="${rep.nomina}" /></td>
                    <td><c:out value="${rep.nreperto}" /></td>
                    <td><c:out value="${rep.sequestrato}" /></td>
                    <td><c:out value="${rep.supporto}" /></td>
                    <td><c:out value="${rep.seriale}" /></td>
                    <td><c:out value="${rep.note}" /></td>
                    <td><c:out value="${rep.operazioni}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>