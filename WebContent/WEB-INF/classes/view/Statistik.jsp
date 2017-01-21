<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
    <%@page import="controller.StatistikController"%>
   <%
Double meinpassaggier = (Double) request.getAttribute("minPassagier");
%>

<!DOCTYPE html>
<html lang="en">


  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Statistik</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>

<div class="container">
<div class="well well-lg">
<h2>Allgemeine Statistik Übersicht: </h2>

<% StatistikController psm = new StatistikController();%> 
<%=psm.Zeitintensitaet() %>

		<form action="StatistikServlet" method="post">
			<label for="username">Date 1: </label> 
			<input type="text" class="form-control" id="date1" name="date1" >
			<br>
			<label for="username">Date 2: </label> 
			<input type="text" class="form-control" id="date2" name="date2" >
		<button type="submit" class="btn btn-default">go</button>
	</form>
		<% if( meinpassaggier != null){ %>
	max. Pass : <%= meinpassaggier%>

<%}%>

		
	</div></div>


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
  </body>
</html>