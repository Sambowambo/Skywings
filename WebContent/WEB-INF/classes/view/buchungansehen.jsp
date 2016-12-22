<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Buchung ansehen</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/login.css">
		<script src="vendor/jquery/jquery.js"></script>
		<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
		<div class="container">
			<form class="search-booking" method="POST" >
				<h2 class="booking-heading">Please enter your Ticketnumber</h2><br>
				<label for="inputTicketnr" class="sr-only">Ticketnumber</label>
				<input type="text" id="inputTicketnr" class="form-control" placeholder="Ticketnummer" name="j_tnumber" required autofocus>
				
				<button class="btn btn-lg btn-primary btn-block" type="submit">Ansehen</button>
			</form>
		</div>
	</body>
</html>