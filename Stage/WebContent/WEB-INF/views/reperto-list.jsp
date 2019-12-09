<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
 <title>Lista reperti</title>
</head>
<body>
 <center>
  <h1>Reperti</h1>
        <h2>
        <a href="fascicoli">Lista Fascicoli</a>
        &nbsp;&nbsp;&nbsp;
         <a href="newreperto">Aggiungi Nuovo Reperto</a>
         &nbsp;&nbsp;&nbsp;
         <a href="reperti">Tutti i Reperti</a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista Reperti</h2></caption>
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
                     <a href="editrepertoicolo?nomina=<c:out value='${rep.nreperto}'/> ">Modifica</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="deletereperto?nomina=<c:out value='${rep.nreperto}'/>">Elimina</a>                     
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