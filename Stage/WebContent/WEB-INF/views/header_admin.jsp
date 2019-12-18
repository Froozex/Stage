<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>       
    .navbar {

        height: 60px;
        line-height: 60px;
        
    }
    .navbar-brand {
        padding: 0 20px;
        height: 40px;
        line-height: 60px;
    }

</style>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="home">Forensics Data Manager</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="#">Impostazioni Fascicoli</a></li>
      <li><a href="userslist">Gestione Utenti</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <li><a href="#"><span class="glyphicon glyphicon-bell"></span> Notifiche</a></li>
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
        <span class="glyphicon glyphicon-user"></span>Account</a>
        <ul class="dropdown-menu">
          <li><b>Ruolo: <%=request.getAttribute("role") %></b></li>
          <li><b>Username: <%=request.getAttribute("userName") %></b></li>
        </ul>
      </li>
      <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
    </ul>
  </div>
</nav>