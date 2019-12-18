<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
 <title>Lista fascicoli</title>
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

<body class="w3-content">

<div class="w3-content" style="text-align:center">
  <h1>Fascicoli</h1>
  <script>
  function myFunction() {
	  var input, filter, table, tr, td, i;
	  input = document.getElementById("myInput");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("myTable");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[1];
	    if (td) {
	      txtValue = td.textContent || td.innerText;
	      if (txtValue.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }
	  }
	}
  function sum(){
	  var d_inizio = document.form.d_inizio.value; 
	  var giorni = document.form.giorni.value; 
	  var scadenza = document.form.scadenza.value; 
	  scadenza = scadenza.add(Calendar.DAY_OF_MONTH, giorni);

	  return scadenza }
  </script>
        <h2>
        <a href="home">Home Page</a>
        &nbsp;&nbsp;&nbsp;
         <a href="fascicoli">Tutti i fascicoli</a><br>
        
         <a href="newfascicolo">Aggiungi nuovo fascicolo</a><br>
         Lista Fascicoli
        </h2>
          <h4>
         <input class="w3-input w3-border w3-padding" type="text" placeholder="Cerca per nomina..." id="myInput" onkeyup="myFunction()">
        </h4>
 </div>
 
    <div align="center" style="overflow-x:auto;" >
        <table border="1" class="w3-content" cellpadding="5" class="w3-table-all" class="w3-table-all w3-margin-top" id="myTable" >
            
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
                    <td><a href="download"> <c:out value='${fasc.nomina}'/>.docx </a></td>
                    <td><c:out value="${fasc.costo}"  /></td>
                    <td><c:out value="${fasc.pagamento}" /> </td>
                    <td><a href="reperti?nomina=<c:out value='${fasc.nomina}'/>">Visualizza reperti</a></td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>