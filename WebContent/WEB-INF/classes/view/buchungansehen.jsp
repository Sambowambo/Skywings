<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<% String tnr = (String)request.getAttribute("tnr"); %>
		<div class="container">
		<% if (tnr == null) { %>
			<form class="search-booking" method="POST" >
				<h2 class="booking-heading">Please enter your Ticketnumber</h2><br>
				<label for="inputTicketnr" class="sr-only">Ticketnumber</label>
				<input type="text" name ="tnr" id="inputTicketnr" class="form-control" placeholder="z.B. AB123#2016-12-12@12:35_001002" name="j_tnumber" required >
				<button class="btn btn-lg btn-primary btn-block" type="submit">Ansehen</button>
			</form>
			
			<!-- this is just a test -->
		<% } else { %> 
			<div id="info-output">
				Ticketnummer: <%= tnr %>
			</div>
		<% } %>
			
		</div>
	</body>
</html>