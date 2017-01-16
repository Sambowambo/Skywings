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
		<link rel="stylesheet" type="text/css" href="vendor/font-awesome/css/font-awesome.min.css">
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
		<% Buchung buchung = (Buchung)request.getAttribute("buchung");%>
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
			
			<table class="table">
			<thead>
				<tr>
				<th>Buchungsnummer </th>
				<th>E-mail </th>
				<th>Telefonnummer </th>
				<th></th>
				</tr>
			</thead>
			
			<%
			boolean bbr = (boolean)request.getAttribute("bbr");
			if(bbr==false)
			{%>
			this is something
			<% } else {%>
			<tbody>
				<tr>
				<td><%= buchung.getBuchungid() %> </td>
				<td><div id="writemail"><%= buchung.getEmail() %></div></td>
				<td><div id="writetel"><%= buchung.getTelefonnummer() %></div></td>
				<td>
					<button class="btn btn-default" id="b_bearbeiten" name="b_bearbeiten"><i class="fa fa-pencil" aria-hidden="true"></i></button>
				</td>
				<td>
					<button class="btn btn-default" style="display:none" id="b_bearbeiten_2" name="b_bearbeiten_2"><i class="fa fa-times" aria-hidden="true"></i></button>
				</td>
				</tr>
			</tbody>
			<% } %>
			 
			<script>
				$('#b_bearbeiten').click( function(){
					var $oldmail = $('#writemail');
					var $mailinput = $('<input\>').val($oldmail.text());
					$mailinput.attr("name", "mailinput");
					$oldmail.replaceWith($mailinput);
					
					var $oldmail = $('#writetel');
					var $mailinput = $('<input\>').val($oldmail.text());
					$oldmail.replaceWith($mailinput);
					
					$('#b_bearbeiten').attr("class", "btn btn-success");
					$('#b_bearbeiten_2').attr("class", "btn btn-danger");
					
					$('#b_bearbeiten').html("<i class=\"fa fa-check\" aria-hidden=\"true\"></i>");
					$('#b_bearbeiten_2').attr("style","");					
				});
				
				$('#b_bearbeiten_2').click(function(){
					var $mail = $('#writemail').val();
					$('#writemail').replaceWith($('<div />').text($mail));
				});
			</script>
			
			
				
				<table class="table">
			<thead>
				<tr>
				<th>Name </th>
				<th>Geburtsdatum </th>
				<th>Passnummer </th>
				<th>Nation</th>
				<th>Adresse</th>
				</tr>
			</thead>
			<tbody>
				
			
			
				<% for(int i =0;i<buchung.getPassagier().size();i++){
					String name = buchung.getPassagier().get(i).getVorname()+" "+buchung.getPassagier().get(i).getNachname();  
					String gebdat = ""+buchung.getPassagier().get(i).getGeburtsdatum(); 
					String passnr = buchung.getPassagier().get(i).getPassnummer();
					String nation = buchung.getPassagier().get(i).getNationalitaet();
					String adresse = buchung.getPassagier().get(i).getStrasse()+" "+buchung.getPassagier().get(i).getPostleitzahl(); 
					String passagier_btn = "";
					passagier_btn = "Passagier" + (i+1);%>
				<tr>
				<td><div id="writename"><%= name %></div> </td>
				<td><div id="writegebdat"><%= gebdat %></div> </td>
				<td><div id="writepassnr"> <%= passnr %></div> </td>
				<td><div id="writenation"><%= nation %></div> </td>
				<td><div id="writeadresse"><%= adresse %></div> </td>
				<td><button id=<%= passagier_btn %> class="btn btn-default"><i class="fa fa-pencil" aria-hidden="true"></i></button></td>
				</tr>
				<% } %>
				</tbody>
				<%for(int j=0;j<buchung.getPassagier().size();j++){ %>
				<script>
				$('#Passagier<%=j+1%>').click( function(){
					var $oldmail = $('#writename');
					var $mailinput = $('<input\>').val($oldmail.text());
					//$mailinput.attr("name", "mailinput");
					$oldmail.replaceWith($mailinput);
					
					var $oldmail = $('#writegebdat');
					var $mailinput = $('<input\>').val($oldmail.text());
					//$mailinput.attr("name", "mailinput");
					$oldmail.replaceWith($mailinput);
					
					var $oldmail = $('#writepassnr');
					var $mailinput = $('<input\>').val($oldmail.text());
					//$mailinput.attr("name", "mailinput");
					$oldmail.replaceWith($mailinput);
					
					var $oldmail = $('#writenation');
					var $mailinput = $('<input\>').val($oldmail.text());
					//$mailinput.attr("name", "mailinput");
					$oldmail.replaceWith($mailinput);
					
					var $oldmail = $('#writeadresse');
					var $mailinput = $('<input\>').val($oldmail.text());
					//$mailinput.attr("name", "mailinput");
					$oldmail.replaceWith($mailinput);
					
					
				});
			</script>
			<%} %>
							
			</div>
		<% } %>
		</table>
		</div>
	</body>
</html>