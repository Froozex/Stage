<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
 <title>Fascicolo Manager</title>
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
 <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 
 <style>
body,h1 {font-family: "Montserrat", sans-serif}
</style>


 <script> 
function validate()
{ 
 var nomina = document.form.nomina.value; 
 var procura = document.form.procura.value;
 var pubblico_ministero = document.form.pubblico_ministero.value; 
 var indagato = document.form.indagato.value;
 var reato = document.form.reato.value
 var consulente = document.form.consulente.value;
 
 if (nomina==null || nomina=="")
 { 
 alert("Inserire la nomina!"); 
 return false; 
 }
 else if(procura==null || procura=="")
 { 
 alert("Inserire la procura!"); 
 return false; 
 } 
 if (pubblico_ministero==null || pubblico_ministero=="")
 { 
 alert("Inserire il Pubblico Ministero!"); 
 return false; 
 }
 if (indagato==null || indagato=="")
 { 
 alert("Inserire il nome e cognome dell'indagato!"); 
 return false; 
 }
 if (reato==null || reato=="")
 { 
 alert("Inserire il reato dell'indagato!"); 
 return false; 
 }
 if (consulente==null || consulente=="")
 { 
 alert("Inserire il nome del consulente!"); 
 return false; 
 }
}
</script> 
</head>


<% //In case, if Admin/User session is not set, redirect to Login page
if(request.getSession(false).getAttribute("Admin")== null || request.getSession(false).getAttribute("User")== null)
{
%>
<jsp:forward page="/WEB-INF/views/login.jsp"></jsp:forward>
<%} %>


<body>
<div class="w3-content" style="text-align:center">
  <h1>Fascicolo Manager</h1>
        <h2>
        <a href="home">Home Page</a>
        &nbsp;&nbsp;&nbsp; <a href="fascicoli">Lista Fascicoli</a>
        </h2>

        
  
  <div>
      <h2>
         <c:if test="${fasc != null}">
               Modifica Fascicolo
              </c:if>
              </h2>
              <h2>
              <c:if test="${fasc == null}">
               Nuovo Fascicolo
              </c:if>
             </h2>
            </div>
            <c:choose>
  <c:when test="${fasc != null}">
  <form action="updatefascicolo" method="post" onsubmit="return validate()" enctype="multipart/form-data">
        </c:when>
        <c:otherwise>
   <form action="insertfascicolo" method="post" onsubmit="return validate()" enctype="multipart/form-data">
        </c:otherwise>
        </c:choose>
        <div align="center" >
        <table class="w3-content" border="1" cellpadding="5"  >
            
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
                 <c:choose>
                 <c:when test= "<c:out value='${fasc.relazione}' />== null">
                 <input type="file" name="relazione" id= "Inserisci il file della relazione">
                 <input type="button" name="doc" id= "...Oppure creane uno nuovo.">
                  </c:when>  
                   <c:otherwise>  
                   <a href="download"><c:out value='${fasc.nomina}'/>.docx </a>
                   
                   <input type="file" name="relazione" value= "Inserisci un altro file della relazione" >
                  </c:otherwise>
				</c:choose>
                </td>
                <tr>
                <th>Richiesta Spese: </th>
                <td>
                <c:set var="cost" value='${fasc.costo}'/>
					<input type="radio" name="costo" 
            		value="SI" <c:if test="${cost.contains('SI')}">checked</c:if>>SI
					<input type="radio" name="costo" 
           		    value="NO" <c:if test="${cost.contains('NO')}">checked</c:if>>NO
                </td>
                <tr>
                <th>Pagamento avvenuto: </th>
                <td>
                <c:set var="payment" value='${fasc.pagamento}'/>
					<input type="radio" name="pagamento" 
            		value="SI" <c:if test="${payment.contains('SI')}">checked</c:if>>SI
					<input type="radio" name="pagamento" 
           		    value="NO" <c:if test="${payment.contains('NO')}">checked</c:if>>NO
                </td>
            <tr>
             <td colspan="2" align="center">
              <input type="submit" class="w3-button w3-dark-grey" value="Salva" />
             </td>
           </tr>
        </table>
    </div> 
    
    </div>
    </form>
    </form>
</body>
</html>