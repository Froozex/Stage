<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<html>
<head>
 <title>Reperto Manager</title>
</head>
<body>
 <center>
  <h1>Reperti</h1>
        <h2>
         <a href="fascicoli">Torna ai Fascicoli</a>
         &nbsp;&nbsp;&nbsp;
         
         
         
        </h2>
 </center>
    <div align="center">
  <c:if test="${rep != null}">
   <form action="updatereperto" method="post">
        </c:if>
        <c:if test="${rep == null}">
   <form action="insertreperto" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
             <h2>
              <c:if test="${rep != null}">
               Modifica Reperto
              </c:if>
              <c:if test="${rep == null}">
               Aggiungi Nuovo Reperto
              </c:if>
             </h2>
            </caption>
          <c:if test="${rep != null}">
           <input type="hidden" name="id" value="<c:out value='${rep.id}' />" />
          </c:if>            
            
            <tr>
                <th>Nomina : </th>
                <td>
                 <input type="text" name="nomina" size="10"
                   value="<c:out value='${rep.nomina}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Numero Reperto : </th>
                <td>
                 <input type="text" name="nreperto" size="10"
                   value="<c:out value='${rep.nreperto}' />"
                 />
                </td>
            </tr>
            <tr>
                <th>Sequestrato a : </th>
                <td>
                 <input type="text" name="sequestrato" size="45"
                   value="<c:out value='${rep.sequestrato}' />"
                 />
                </td>
                <tr>
                <th>Tipo di Supporto : </th>
                <td>
                 <input type="text" name="supporto" size="45"
                   value="<c:out value='${rep.supporto}' />"
                 />
                </td>
                <tr>
                <th>Seriale : </th>
                <td>
                 <input type="text" name="seriale" size="100"
                   value="<c:out value='${rep.seriale}' />"
                 />
                </td>
                <tr>
                <th>Note : </th>
                <td>
                 <input type="text" name="note" size="100"
                   value="<c:out value='${rep.note}' />"
                 />
                </td>
                <tr>
                <th>Operazioni : </th>
                <td>
                 <input type="text" name="operazioni" size="45"
                   value="<c:out value='${rep.operazioni}' />"
                 />
                </td>
             <td colspan="2" align="center">
              <input type="submit" value="Salva" />
             </td>
            </tr>
        </table>
        </form>
    </div> 
</body>
</html>