<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<html>
<head>
 <title>Fascicolo Manager</title>
</head>
<body>
 <center>
  <h1>Fascicolo Manager</h1>
        <h2>
         <a href="newfascicolo">Aggiungi Un Nuovo Fascicolo</a>
         &nbsp;&nbsp;&nbsp;
         <a href="fascicoli">Lista Fascicoli</a>
         
        </h2>
 </center>
    <div align="center">
  <c:if test="${fasc != null}">
   <form action="updatefascicolo" method="post">
        </c:if>
        <c:if test="${fasc == null}">
   <form action="insertfascicolo" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
             <h2>
              <c:if test="${fasc != null}">
               Modifica Fascicolo
              </c:if>
              <c:if test="${fasc == null}">
               Aggiungi Nuovo Fascicolo
              </c:if>
             </h2>
            </caption>
          <c:if test="${fasc != null}">
           <input type="hidden" name="id" value="<c:out value='${fasc.id}' />" />
          </c:if>            
            <tr>
                <th>Nomina: </th>
                <td>
                 <input type="text" name="nomina" size="10"
                   value="<c:out value='${fasc.nomina}' />"
                  />
                </td>
            </tr>
            <tr>
                <th>Procura: </th>
                <td>
                 <input type="text" name="procura" size="45"
                   value="<c:out value='${fasc.procura}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Pubblico Ministero: </th>
                <td>
                 <input type="text" name="pm" size="45"
                   value="<c:out value='${fasc.pm}' />"
                 />
                </td>
                <tr>
                <th>Polizia Giudiziaria: </th>
                <td>
                 <input type="text" name="pg" size="45"
                   value="<c:out value='${fasc.pg}' />"
                 />
                </td>
                <tr>
                <th>Indagato: </th>
                <td>
                 <input type="text" name="indagato" size="45"
                   value="<c:out value='${fasc.indagato}' />"
                 />
                </td>
                <tr>
                <th>Reato: </th>
                <td>
                 <input type="text" name="reato" size="45"
                   value="<c:out value='${fasc.reato}' />"
                 />
                </td>
                <tr>
                <th>Consulente: </th>
                <td>
                 <input type="text" name="consulente" size="45"
                   value="<c:out value='${fasc.consulente}' />"
                 />
                </td>
                <tr>
                <th>Ausiliario: </th>
                <td>
                 <input type="text" name="ausiliario" size="45"
                   value="<c:out value='${fasc.ausiliario}' />"
                 />
                </td>
                <tr>
                <th>Data Affidamento Incarico: </th>
                <td>
                 <input type="date" name="d_incarico"
                   value="<c:out value='${fasc.d_incarico}' />"
                 />
                </td>
                <tr>
                <th>Data Inizio Operazioni: </th>
                <td>
                 <input type="date" name="d_inizio"
                   value="<c:out value='${fasc.d_inizio}' />"
                 />
                </td>
                <tr>
                <th>Giorni Concessi: </th>
                <td>
                 <input type="number" name="giorni" size="3"
                   value="<c:out value='${fasc.giorni}' />"
                 />
                </td>
                <tr>
                <th>Scadenza: </th>
                <td>
                 <input type="date" name="scadenza"
                   value="<c:out value='${fasc.scadenza}' />"
                 />
                </td>
                <tr>
                <th>Proroga: </th>
                <td>
                 <input type="text" name="proroga" size="10"
                   value="<c:out value='${fasc.proroga}' />"
                 />
                </td>
                <tr>
                <th>Richiesta a Gestori: </th>
                <td>
                 <input type="text" name="richiesta" size="45"
                   value="<c:out value='${fasc.richiesta}' />"
                 />
                </td>
                <tr>
                <th>Relazione: </th>
                <td>
                 <input type="file" name="relazione"
                   value="<c:out value='${fasc.relazione}' />"
                 />
                </td>
                <tr>
                <th>Richiesta Spese: </th>
                <td>
                 <input type="text" name="costo" size="45"
                   value="<c:out value='${fasc.costo}' />"
                 />
                </td>
                <tr>
                <th>Pagamento avvenuto: </th>
                <td>
                 <input type="text" name="costo" size="2"
                   value="<c:out value='${fasc.costo}' />"
                 />
                </td>
            <tr>
             <td colspan="2" align="center">
              <input type="submit" value="Salva" />
             </td>
            </tr>
        </table>
        </form>
    </div> 
</body>
</html>