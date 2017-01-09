<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.buchung.Buchung"%>
<%@page import="model.Ticket"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Buchung ansehen</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/bansehen.css">
		<script src="vendor/jquery/jquery.js"></script>
		<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
						Menu <i class="fa fa-bars"></i>
					</button>
					<a class="navbar-brand page-scroll" href="/Skywings">
						<i class="fa fa-plane"></i> <span style="font-weight:bold">SKYWINGS</span> Prototyp II
					</a>
				</div>
		</nav>
		<% Buchung buchung = (Buchung)request.getAttribute("buchung"); %>
		<div class="container">
		<% if (buchung == null) { %>
			<form class="search-booking" method="POST" >
				<h2 class="booking-heading">Please enter your Bookingnumber</h2><br>
				<label for="inputBookingbnr" class="sr-only">Bookingnumber</label>
				<input type="text" name ="bnr" id="inputBookingbnr" class="form-control" placeholder="z.B. AB123#2016-12-12@12:35_001" name="j_bnumber" required >
				<button class="btn btn-lg btn-primary btn-block" type="submit">Ansehen</button>
			</form>
			
			<!-- this is just a test -->
		<% } else { %> 
			<div id="info-output">
				Buchungsnummer: <%= buchung.getBuchungid() %><br>
				E-mail:         <%= buchung.getEmail() %><br>
				Telefonnummer:  <%= buchung.getTelefonnummer() %><br>
				
				<% for(int i =0;i<buchung.getPassagier().size();i++){
					String name = buchung.getPassagier().get(i).getVorname()+" "+buchung.getPassagier().get(i).getNachname();  
					String gebdat = ""+buchung.getPassagier().get(i).getGeburtsdatum(); 
					String passnr = buchung.getPassagier().get(i).getPassnummer();
					String nation = buchung.getPassagier().get(i).getNationalitaet();
					String adresse = buchung.getPassagier().get(i).getStrasse()+" "+buchung.getPassagier().get(i).getPostleitzahl(); %>
				Name: <%= name %><br>
				Geburtsdatum: <%= gebdat %><br>
				Passnummer: <%= passnr %><br>
				Nation: <%= nation %><br>
				Adresse: <%= adresse %><br>
				<% } %>
							
			</div>
		<% } %>
			
		</div>
	</body>
</html>