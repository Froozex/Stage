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
  <script>
  function sum(){
	  dateFormat(d_inizio)=dateFormat(scadenza).add(giorni);}
  </script>
        <h2>
        <a href="home">Home Page</a>
        &nbsp;&nbsp;&nbsp;
         <a href="newfascicolo">Aggiungi nuovo fascicolo</a>
         &nbsp;&nbsp;&nbsp;
         
         
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
                <th>Data Inizio Operazioni</th>
                <th>Giorni Concessi</th>
                <th>Scadenza</th>
                <th>Proroga</th>
                <th>Richiesta Gestori</th>
                <th>Relazione</th>
                <th>Richiesta Spese</th>
                <th>Pagamento Avvenuto</th>
                <th></th>
            </tr>
            <c:forEach var="fasc" items="${listFasc}">
                <tr>
                    <td>
                     <a href="editfascicolo?nomina=<c:out value='${fasc.nomina}' />">Modifica</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="deletefascicolo?nomina=<c:out value='${fasc.nomina}' />">Elimina</a>                     
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
                    <td><c:out value="${fasc.richiesta}" /></td>
                    <td><c:out value="${fasc.relazione}" /></td>
                    <td><c:out value="${fasc.costo}" /></td>
                    <td><c:out value="${fasc.pagamento}" /></td>
                    <td><a href="reperti?nomina=<c:out value='${fasc.nomina}' />">Visualizza reperti</a></td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>