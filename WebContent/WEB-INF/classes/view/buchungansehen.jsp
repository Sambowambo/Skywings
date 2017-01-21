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
			
			<table class="table" >
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
					<button class="btn btn-default" id="b_bearbeiten" name="b_bearbeiten" ><i class="fa fa-pencil" aria-hidden="true"></i></button>
				</td>
				<td>
					<button class="btn btn-default" style="display:none" id="b_cancel" name="b_bearbeiten_2"><i class="fa fa-times" aria-hidden="true"></i></button>
				</td> 
				</tr>
			</tbody>
			<% } %>
			
			<script>
			
				

					$(document).on('click','button#b_bearbeiten', function(){
						var $oldmail = $('#writemail');
						var $buffer_mail = $oldmail;
						var $mailinput = $('<input\>').val($oldmail.text());
						$mailinput.attr("name", "mailinput");
						$mailinput.attr("id", "mailinput");
						$oldmail.replaceWith($mailinput);
						
						var $oldtel = $('#writetel');
						var $buffer_tel = $oldtel;
						var $telinput = $('<input\>').val($oldtel.text());
						$telinput.attr("name", "telinput");
						$telinput.attr("id", "telinput");
						$oldtel.replaceWith($telinput);
						
						
						var $edit_btn = $('#b_bearbeiten');
						
						$save_btn = $('<button\>').html("<i class=\"fa fa-check\" aria-hidden=\"true\"></i>");
						$save_btn.attr("id", "b_save");
						$save_btn.attr("name", "b_save");
						$save_btn.attr("class", "btn btn-success");
						
						$('#b_bearbeiten').replaceWith($save_btn);
						
						$('#b_cancel').attr("class", "btn btn-danger");
						$('#b_cancel').attr("style","");
						
						$('#b_cancel').click(function() {

							
							$('#mailinput').replaceWith($oldmail);
							$('#telinput').replaceWith($oldtel);
							
							$('#b_save').replaceWith($edit_btn);
							$('#b_cancel').attr("style","display:none;");
							
							
						});
						
					});
					
				
			</script>
			
			
				
				<table class="table" id="tablelist" >
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
					passagier_btn = ""+(i+1);
					String passagier_cncl ="";
					passagier_cncl="c"+(i+1);
							
					%>
				<tr>
				<td><div id="writename<%=i+1%>"><%= name %></div> </td>
				<td><div id="writegebdat<%=i+1%>"><%= gebdat %></div> </td>
				<td><div id="writepassnr<%=i+1%>"> <%= passnr %></div> </td>
				<td><div id="writenation<%=i+1%>"><%= nation %></div> </td>
				<td><div id="writeadresse<%=i+1%>"><%= adresse %></div> </td>
				<td>
					<button id=<%= passagier_btn %> class="btn btn-default"><i class="fa fa-pencil" aria-hidden="true"></i></button>
				</td>
				</tr>
				 <td>
					<button class="btn btn-default" style="display:none" id=<%=passagier_cncl %> name="b_bearbeiten_2"><i class="fa fa-times" aria-hidden="true"></i></button>
				</td> 
				<% } %>
				</tbody>
				
				<script type="text/javascript" src="js/bansehen_id_2.js"></script>
				<script>
				$(document).on('click','#1', function(){
					
					var $idedit = 1;
					
					var $oldname = $('#writename'+$idedit);
					var $nameinput = $('<input\>').val($oldname.text());
					//$mailinput.attr("name", "mailinput");
					$oldname.replaceWith($nameinput);
					
					var $olddat = $('#writegebdat'+$idedit);
					var $datinput = $('<input\>').val($olddat.text());
					//$mailinput.attr("name", "mailinput");
					$olddat.replaceWith($datinput);
					
					var $oldpass = $('#writepassnr'+$idedit);
					var $passinput = $('<input\>').val($oldpass.text());
					//$mailinput.attr("name", "mailinput");
					$oldpass.replaceWith($passinput);
					
					var $oldnation = $('#writenation'+$idedit);
					var $nationinput = $('<input\>').val($oldnation.text());
					//$mailinput.attr("name", "mailinput");
					$oldnation.replaceWith($nationinput);
					
					var $oldadress = $('#writeadresse'+$idedit);
					var $adressinput = $('<input\>').val($oldadress.text());
					//$mailinput.attr("name", "mailinput");
					$oldadress.replaceWith($adressinput);
					
					var $edit_btn = $('#'+$idedit);
					
					$save_btn = $('<button\>').html("<i class=\"fa fa-check\" aria-hidden=\"true\"></i>");
					$save_btn.attr("id", "b_save"+$idedit);
					$save_btn.attr("name", "b_save"+$idedit);
					$save_btn.attr("class", "btn btn-success");
					
					$('#'+$idedit).replaceWith($save_btn);
					
					$('#c'+$idedit).attr("class", "btn btn-danger");
					$('#c'+$idedit).attr("style","");
					
					$('#c'+$idedit).click(function() {

						
						$('#nameinput').replaceWith($oldname);
						$('#datinput').replaceWith($olddat);
						$('#passinput').replaceWith($oldpass);
						$('#nationinput').replaceWith($oldnation);
						$('#adressinput').replaceWith($oldadress);
						
						
						$('#b_save'+$idedit).replaceWith($edit_btn);
						$('#c'+$idedit).attr("style","display:none;");
						
						
					});
						
					
				});
			</script>
			<%} %>
							
			</div>
		
		</table>
		</div>
	</body>
</html>