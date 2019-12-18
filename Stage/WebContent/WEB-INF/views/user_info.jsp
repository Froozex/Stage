<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
 <title>Gestione Utenti</title>
</head>


<body>
 <center>
 <h1>Utenti Piattaforma</h1>  
        <h2>
        <a href="home">Torna alla Home</a>
        &nbsp;&nbsp;&nbsp;
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Utenti Piattaforma</h2></caption>
            <tr>
                <th></th>
                <th>Nome e Cognome</th>
                <th>Email</th>
                <th>Username</th>
                <th>Ruolo</th>
            </tr>
            <c:forEach var="user" items="${listUsers}">
                <tr>
                    <td>
                     <a href="deleteuser?email=<c:out value='${user.email}'/> ">Elimina</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;                     
                    </td>
                    <td><c:out value="${user.fullName}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.userName}" /></td>
                    <td><c:out value="${user.role}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>