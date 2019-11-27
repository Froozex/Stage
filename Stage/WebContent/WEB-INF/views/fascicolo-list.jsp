<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
 <title>Lista fascicoli</title>
</head>
<body>
 <center>
  <h1>Fascicoli</h1>
        <h2>
         <a href="new">Aggiungi nuovo fascicolo</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">Tutti i fascicoli</a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista Fascicoli</h2></caption>
            <tr>
                <th></th>
                <th>Nomina</th>
                <th>Procura</th>
                <th>Pubblico Ministero</th>
                <th>Polizia Giudiziaria</th>
                <th>Indagato</th>
                <th>Reato</th>
                <th>Consulente</th>
                <th>Ausiliario</th>
                <th>Data Affidamento Incarico</th>
                <th>Data Inizio</th>
                <th>Giorni</th>
                <th>Scadenza</th>
                <th>Proroga</th>
                <th>Richiesta Gestori</th>
                <th>Relazione</th>
                <th>Richiesta Spese</th>
                <th>Pagamento</th>
                <th></th>
            </tr>
            <c:forEach var="fasc" items="${listFasc}">
                <tr>
                    <td>
                     <a href="edit?nomina=<c:out value='${fasc.nomina}' />">Modifica</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?nomina=<c:out value='${fasc.nomina}' />">Elimina</a>                     
                    </td>
                    <td><c:out value="${fasc.nomina}" /></td>
                    <td><c:out value="${fasc.procura}" /></td>
                    <td><c:out value="${fasc.pm}" /></td>
                    <td><c:out value="${fasc.pg}" /></td>
                    <td><c:out value="${fasc.indagato}" /></td>
                    <td><c:out value="${fasc.reato}" /></td>
                    <td><c:out value="${fasc.consulente}" /></td>
                    <td><c:out value="${fasc.ausiliario}" /></td>
                    <td><c:out value="${fasc.d_incarico}" /></td>
                    <td><c:out value="${fasc.d_inizio}" /></td>
                    <td><c:out value="${fasc.giorni}" /></td>
                    <td><c:out value="${fasc.scadenza}" /></td>
                    <td><c:out value="${fasc.proroga}" /></td>
                    <td><c:out value="${fascirichiesta}" /></td>
                    <td><c:out value="${fasc.relazione}" /></td>
                    <td><c:out value="${fasc.costo}" /></td>
                    <td><c:out value="${fasc.pagamento}" /></td>
                    <td><a href="edit?id=<c:out value='${fasc.id}' />">Visualizza reperti</a></td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>