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
		<div class="container" >
		<% if (buchung == null) { %>
			<form class="search-booking" method="POST" >
				<h2 class="booking-heading">Please enter your Bookingnumber</h2><br>
				<label for="inputBookingbnr" class="sr-only">Bookingnumber</label>
				<input type="text" name ="bnr" id="inputBookingbnr" class="form-control" placeholder="z.B. AB123#2016-12-12@12:35_001" name="j_bnumber" required >
				<button class="btn btn-lg btn-primary btn-block" type="submit">Ansehen</button>
			</form>
			
			<!-- this is just a test -->
		<% } else { %> 
			<div id="info-output" >
			
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
				<form id="save_this"  >
					<input type="hidden" id="hiddenMail" name="HiddenMail" value="<%=buchung.getEmail()%>"/>
					<input type="hidden" id="hiddenTel" name="HiddenTel" value="<%=buchung.getTelefonnummer()%>"/>
					<input type="hidden" id="hiddenBookingnr" name="HiddenBookingnr" value="<%=buchung.getBuchungid()%>"/>
					<button class="btn btn-default" id="b_bearbeiten" name="b_bearbeiten" ><i class="fa fa-pencil" aria-hidden="true"></i></button>
				</form>
				</td>
				<td>
					<button class="btn btn-default" style="display:none" id="b_cancel" name="b_bearbeiten_2"><i class="fa fa-times" aria-hidden="true"></i></button>
				</td> 
				</tr>
			</tbody>
			<% } %>
			
			<script>
			
				

					$(document).on('click','#b_bearbeiten', function(){
						
						var $oldmail = $('#writemail');
						var $buffer_mail = $oldmail;
						var $mailinput = $('<input\>').val($oldmail.text());
						var $pastmail = $('<input\>').val($oldmail.text());
						$mailinput.attr("name", "mailinput");
						$mailinput.attr("id", "mailinput");
						$oldmail.replaceWith($mailinput);
						
						var $oldtel = $('#writetel');
						var $buffer_tel = $oldtel;
						var $telinput = $('<input\>').val($oldtel.text());
						var $pasttel = $('<input\>').val($oldtel.text());
						$telinput.attr("name", "telinput");
						$telinput.attr("id", "telinput");
						$oldtel.replaceWith($telinput);
						
						
						var $edit_btn = $('#b_bearbeiten');
						
						
						
						$save_btn = $('<button\>').html("<i class=\"fa fa-check\" aria-hidden=\"true\"></i>");
						$save_btn.attr("id", "b_save");
						$save_btn.attr("name", "b_save");
						$save_btn.attr("class", "btn btn-success");
						
						$('#b_bearbeiten').replaceWith($save_btn);
						$('#save_this').attr("method","POST");
						$('#save_this').attr("action","buchungspeichern");
						
						$('#b_cancel').attr("class", "btn btn-danger");
						$('#b_cancel').attr("style","");
						
						$('#b_save').click(function() {
							
							var checkmail = $pastmail.prop("value");
							var currentmail = $mailinput.prop("value");
							
							var checktel = $pasttel.prop("value");
							var currenttel = $telinput.prop("value");
							
							if(checkmail!=currentmail||checktel!=currenttel)
							{
								
								
								document.getElementById("hiddenMail").value=currentmail;
								document.getElementById("hiddenTel").value=currenttel;
								alert("Daten gespeichert!");
							//location.reload();
								
							}
							
							return;
							
							
							
							
							
						});
						
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
				<th>Vorname </th>
				<th>Nachname</th> 
				<th>Geburtsdatum </th>
				<th>Passnummer </th>
				<th>Nation</th>
				<th>Strasse</th>
				<th>PLZ</th>
				</tr>
			</thead>
			<tbody>
				
			
			
				<% for(int i =0;i<buchung.getPassagier().size();i++){
					String name = buchung.getPassagier().get(i).getVorname();  
					String nachname = buchung.getPassagier().get(i).getNachname();
					String gebdat = ""+buchung.getPassagier().get(i).getGeburtsdatum(); 
					String passnr = buchung.getPassagier().get(i).getPassnummer();
					String nation = buchung.getPassagier().get(i).getNationalitaet();
					String adresse = buchung.getPassagier().get(i).getStrasse(); 
					String plz = " "+buchung.getPassagier().get(i).getPostleitzahl();
					
					String passagier_btn = "";
					passagier_btn = ""+(i+1);
					String passagier_cncl ="";
					passagier_cncl="c"+(i+1);
							
					%>
				<tr>
				<td><div id="writename<%=i+1%>"><%= name %></div> </td>
				<td><div id="writenachname<%=i+1%>"><%= nachname %></div> </td>
				<td><div id="writegebdat<%=i+1%>"><%= gebdat %></div> </td>
				<td><div id="writepassnr<%=i+1%>"> <%= passnr %></div> </td>
				<td><div id="writenation<%=i+1%>"><%= nation %></div> </td>
				<td><div id="writeadresse<%=i+1%>"><%= adresse %></div> </td>
				<td><div id="writeplz<%=i+1%>"><%= plz %></div> </td>
				<td>
				<form id="save_me<%=i+1%>">
					<input type="hidden" id="hiddenName<%=i+1 %>" name="HiddenName<%=i+1 %>" value="<%=buchung.getPassagier().get(i).getVorname()%>"/>
					<input type="hidden" id="hiddenNameid" name="HiddenNameId" value="HiddenName<%=i+1%>"/>
					<input type="hidden" id="hiddenNachname<%=i+1 %>" name="HiddenNachname<%=i+1 %>" value="<%=buchung.getPassagier().get(i).getNachname()%>"/>
					<input type="hidden" id="hiddenNachnameid" name="HiddenNachnameId" value="HiddenNachname<%=i+1%>"/>
					
					<input type="hidden" id="hiddenPassnr<%=i+1 %>" name="HiddenPassnr<%=i+1 %>" value="<%=buchung.getPassagier().get(i).getPassnummer()%>"/>
					<input type="hidden" id="hiddenPassnrid" name="HiddenPassnrId" value="HiddenPassnr<%=i+1%>"/>
					<input type="hidden" id="hiddenNation<%=i+1 %>" name="HiddenNation<%=i+1 %>" value="<%=buchung.getPassagier().get(i).getNationalitaet()%>"/>
					<input type="hidden" id="hiddenNationid" name="HiddenNationId" value="HiddenNation<%=i+1%>"/>
					<input type="hidden" id="hiddenAdress<%=i+1 %>" name="HiddenAdress<%=i+1 %>" value="<%=buchung.getPassagier().get(i).getStrasse()%>"/>
					<input type="hidden" id="hiddenAdressid" name="HiddenAdressId" value="HiddenAdress<%=i+1%>"/>
					<input type="hidden" id="hiddenPlz<%=i+1 %>" name="HiddenPlz<%=i+1 %>" value="<%=buchung.getPassagier().get(i).getPostleitzahl()%>"/>
					<input type="hidden" id="hiddenPlzid" name="HiddenPlzId" value="HiddenPlz<%=i+1%>"/>
					
					
					<input type="hidden" id="hiddenBookingnr" name="HiddenBookingnr" value="<%=buchung.getBuchungid()%>"/>
					<button id=<%= passagier_btn %> class="btn btn-default"><i class="fa fa-pencil" aria-hidden="true"></i></button>
				</form>
				</td>
				<td>
					<button class="btn btn-default" style="display:none" id=<%=passagier_cncl %> name="b_bearbeiten_2"><i class="fa fa-times" aria-hidden="true"></i></button>
				</td> 
				</tr>
				 
				<% } %>
				</tbody>
				
				
				
				<script>
				$(document).on('click','#1', function(){
					
					var $idedit = this.id;
					
					var $oldname = $('#writename'+$idedit);
					var $nameinput = $('<input\>').val($oldname.text());
					var $pastname = $('<input\>').val($oldname.text());
					$nameinput.attr("name", "nameinput");
					$nameinput.attr("id","nameinput")
					$oldname.replaceWith($nameinput);
					
					var $oldnachname = $('#writenachname'+$idedit);
					var $nachnameinput = $('<input\>').val($oldnachname.text());
					var $pastnachname = $('<input\>').val($oldnachname.text());
					$nachnameinput.attr("name", "nachnameinput");
					$nachnameinput.attr("id","nachnameinput")
					$oldnachname.replaceWith($nachnameinput);
					
					var $olddat = $('#writegebdat'+$idedit);
					var $datinput = $('<input\>').val($olddat.text());
					var $pastdat = $('<input\>').val($olddat.text());
					$datinput.attr("name", "datinput");
					$datinput.attr("id","datinput")
					$olddat.replaceWith($datinput);
					
					var $oldpass = $('#writepassnr'+$idedit);
					var $passinput = $('<input\>').val($oldpass.text());
					var $pastpass = $('<input\>').val($oldpass.text());
					$passinput.attr("name", "passinput");
					$passinput.attr("id","passinput")
					$oldpass.replaceWith($passinput);
					
					var $oldnation = $('#writenation'+$idedit);
					var $nationinput = $('<input\>').val($oldnation.text());
					var $pastnation = $('<input\>').val($oldnation.text());
					$nationinput.attr("name", "nationinput");
					$nationinput.attr("id","nationinput")
					$oldnation.replaceWith($nationinput);
					
					var $oldadress = $('#writeadresse'+$idedit);
					var $adressinput = $('<input\>').val($oldadress.text());
					var $pastadress = $('<input\>').val($oldadress.text());
					$adressinput.attr("name", "adressinput");
					$adressinput.attr("id","adressinput")
					$oldadress.replaceWith($adressinput);
					
					var $oldplz = $('#writeplz'+$idedit);
					var $plzinput = $('<input\>').val($oldplz.text());
					var $pastplz = $('<input\>').val($oldplz.text());
					$plzinput.attr("name", "plzinput");
					$plzinput.attr("id","plzinput")
					$oldplz.replaceWith($plzinput);
					
					var $edit_btn = $('#'+$idedit);
					
					$save_btn = $('<button\>').html("<i class=\"fa fa-check\" aria-hidden=\"true\"></i>");
					$save_btn.attr("id", "b_save"+$idedit);
					$save_btn.attr("name", "b_save"+$idedit);
					$save_btn.attr("class", "btn btn-success");
					
					$('#'+$idedit).replaceWith($save_btn);
					
					$('#c'+$idedit).attr("class", "btn btn-danger");
					$('#c'+$idedit).attr("style","");
					
					
					$('#b_save1').click(function() {
						
						
						$('#save_me1').attr("method","POST");
						$('#save_me1').attr("action","passagierespeichern");
						
						var checkname = $pastname.prop("value");
						var currentname = $nameinput.prop("value");
						
						var checknachname = $pastnachname.prop("value");
						var currentnachname = $nachnameinput.prop("value");
						
						var checkdat = $pastdat.prop("value");
						var currentdat = $datinput.prop("value");
						
						var checkpass = $pastpass.prop("value");
						var currentpass = $passinput.prop("value");
						
						var checknation = $pastnation.prop("value");
						var currentnation = $nationinput.prop("value");
						
						var checkadress = $pastadress.prop("value");
						var currentadress = $adressinput.prop("value");
						
						var checkplz = $pastplz.prop("value");
						var currentplz = $plzinput.prop("value");
						
						if(checkname!=currentname||checknachname!=currentnachname||
								checkplz!=currentplz||checkpass!=currentpass
								||checknation!=currentnation||checkadress!=currentadress)
						{
							
							
							document.getElementById("hiddenName1").value=currentname;
							document.getElementById("hiddenNachname1").value=currentnachname;
							document.getElementById("hiddenPlz1").value=currentplz;
							document.getElementById("hiddenPassnr1").value=currentpass;
							document.getElementById("hiddenNation1").value=currentnation;
							document.getElementById("hiddenAdress1").value=currentadress;
						
							alert("Daten gespeichert!");
						
							
						}
						
						return;
						
						
						
						
						
					});
					
					$('#c'+$idedit).click(function() {

						
						$('#nameinput').replaceWith($oldname);
						$('#nachnameinput').replaceWith($oldnachname);
						$('#datinput').replaceWith($olddat);
						$('#passinput').replaceWith($oldpass);
						$('#nationinput').replaceWith($oldnation);
						$('#adressinput').replaceWith($oldadress);
						$('#plzinput').replaceWith($oldplz);
						
						
						$('#b_save'+$idedit).replaceWith($edit_btn);
						$('#c'+$idedit).attr("style","display:none;");
						
						
					});
					
					
					
				});
			</script>
			<script type="text/javascript" src="js/bansehen_id_2.js"></script>
			<%} %>
							
			</div>
		
		</table>
		</div>
	</body>
</html>