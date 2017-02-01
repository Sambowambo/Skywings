<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
    <%@page import="controller.StatistikController"%>
   <%
   Double avgPreis = (Double) request.getAttribute("avgPreis");
   
   int gesamtFlug=0;
   if (request.getAttribute("gesamtFlug") != null)
	   gesamtFlug = (Integer) request.getAttribute("gesamtFlug");
   
   int gesamtBuch=0;
   if (request.getAttribute("gesamtBuch") != null)
	   gesamtBuch = (int) request.getAttribute("gesamtBuch");
   
   Double durchPreis=null;
   if (request.getAttribute("durchPreis") != null)
	   durchPreis = (Double) request.getAttribute("durchPreis");
   
   int gesamPass=0;
   if (request.getAttribute("gesamPass") != null)
	   gesamPass = (int) request.getAttribute("gesamPass");
   
   int minPass=0;
   if (request.getAttribute("minPass") != null)
	   minPass = (int) request.getAttribute("minPass");
   
   int maxPass=0;
   if (request.getAttribute("maxPass") != null)
	   maxPass = (int) request.getAttribute("maxPass");
   
   Double avgPass=null;
   if (request.getAttribute("avgPass") != null)
	   avgPass = (Double) request.getAttribute("avgPass");
   
   Double minPreis=null;
   if (request.getAttribute("minPreis") != null)
	   minPreis = (Double) request.getAttribute("minPreis");
   
   Double maxPreis=null;
   if (request.getAttribute("maxPreis") != null)
	   maxPreis = (Double) request.getAttribute("maxPreis");
   
   Double gesamtPreis=null;
   if (request.getAttribute("gesamtPreis") != null)
	   gesamtPreis = (Double) request.getAttribute("gesamtPreis");
   
   String zeit=null;
   if (request.getAttribute("zeit") != null)
	   zeit= (String) request.getAttribute("zeit");
   
   
String date1 = (String) request.getAttribute("date1");
String date2 = (String) request.getAttribute("date2");
%>

<!DOCTYPE html>
<html lang="en">


  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/statistik.css">
    <link rel="stylesheet" type="text/css" href="vendor/font-awesome/css/font-awesome.min.css">
    <script type="text/javascript" src="vendor/jquery/jquery.js"></script>
    <script type="text/javascript" src="vendor/bootstrap/js/bootstrap.js"></script>
    <title>Statistik</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work 
    		 if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="jumbotron">
		<h1>Allgemeine Statistik</h1>
		<p class="lead" style="margin-top:15px;">Wählen Sie bitte nur eine Option aus, und geben das erste/zweite Datum ein, wenn 
		es nötig ist </p>
	</div>
	
<div class="container">
<div class="well well-lg">


<!--   checked="checked" -->
	<form action="StatistikServlet" method="post">
    <div align="center" style="background:#fafafa; color:#222; padding:10px;">
   <table class="checkbox-table">
   <tbody>
   	<tr>
   		<td>
    		<input type="checkbox" name="checkboxG4" id="checkboxG4" class="css-checkbox" value="g4" />
    		<label for="checkboxG4" class="css-label">Gesamtanzahl der Flügen (ohne Daten)&nbsp;&nbsp;&nbsp;&nbsp;</label>
    	</td>
    	<td>
    		<input type="checkbox" name="checkboxG5" id="checkboxG5" class="css-checkbox" value="g5"/>
    		<label for="checkboxG5" class="css-label">Gesamtanzahl der Buchungen (ohne Daten)&nbsp;&nbsp;&nbsp;&nbsp;</label>
    	</td>
    </tr>
    <tr>
    	<td>
    		<input type="checkbox" name="checkboxG6" id="checkboxG6" class="css-checkbox" value="g6"/>
    		<label for="checkboxG6" class="css-label">Durchschinttlicher Geldumlauf  (ohne Daten)&nbsp;&nbsp;&nbsp;&nbsp;</label>
    	</td>
    	<td>
    		<input type="checkbox" name="checkboxG7" id="checkboxG7" class="css-checkbox" value="g7" />
    		<label for="checkboxG7" class="css-label">Gesamtanzahl der Passagieren  (ohne Daten)&nbsp;&nbsp;&nbsp;&nbsp;</label>
    	</td>
    </tr>
    <tr>
    	<td>
    		<input type="checkbox" name="checkboxG8" id="checkboxG8" class="css-checkbox" value="g8"/>
    		<label for="checkboxG8" class="css-label">Minimale Anzahl der Passagieren&nbsp;&nbsp;&nbsp;&nbsp;</label>
    	</td>
    	<td>
    		<input type="checkbox" name="checkboxG9" id="checkboxG9" class="css-checkbox" value="g9" />
    		<label for="checkboxG9" class="css-label">Maximale Anzahl der Passagieren&nbsp;&nbsp;&nbsp;&nbsp;</label>
    	</td>
    </tr>
    <tr>
    	<td>
     		<input type="checkbox" name="checkboxG10" id="checkboxG10" class="css-checkbox" value="g10" />
    		<label for="checkboxG10" class="css-label">Durchschnittliche Anzahl der Passagieren&nbsp;&nbsp;&nbsp;&nbsp;</label>
    	</td>
  		<td>
    		<input type="checkbox" name="checkboxG11" id="checkboxG11" class="css-checkbox" value="g11"/>
    		<label for="checkboxG11" class="css-label">Minimaler Geldumlauf&nbsp;&nbsp;&nbsp;&nbsp;</label>
    	</td>
    </tr>
    <tr>
    	<td>
     		<input type="checkbox" name="checkboxG12" id="checkboxG12" class="css-checkbox" value="g12" />
    	<label for="checkboxG12" class="css-label">Maximaler Geldumlauf&nbsp;&nbsp;&nbsp;&nbsp;</label><br>
	    </td>
		<td>
			<input type="checkbox" name="checkboxG13" id="checkboxG13" class="css-checkbox" value="g13" />
	    	<label for="checkboxG13" class="css-label">Durchschnnittlicher Geldumlauf&nbsp;&nbsp;&nbsp;&nbsp;</label></td>
	  	<td>
    </tr>
    
    <tr>
    	<td>
     		<input type="checkbox" name="checkboxG14" id="checkboxG14" class="css-checkbox" value="g14" />
    	<label for="checkboxG14" class="css-label">Geldumlauf  (ohne Daten)&nbsp;&nbsp;&nbsp;&nbsp;</label><br>
	    </td>
		<td>
			<input type="checkbox" name="checkboxG15" id="checkboxG15" class="css-checkbox" value="g15" />
	    	<label for="checkboxG15" class="css-label">Zeitintensität  (ohne Daten)&nbsp;&nbsp;&nbsp;&nbsp;</label></td>
	  	<td>
    </tr>
    
    </tbody>
   </table>
  </div>
<br><br>


		<center>
			<label for="username" id ="lable1" >Date 1: </label> 
			<input type="text" class="form-control" id="date1" name="date1" placeholder="yyyy-MM-dd"  >
			<br>
			<label for="username" id ="lable1" >Date 2: </label> 
			<input type="text" class="form-control" id="date2" name="date2" placeholder="z.B.: 2017-12-12" >
			<br>
		<button type="submit" class="btn btn-warning">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Go&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
		<input type="button"  class="btn btn-warning" value='&nbsp;&nbsp;&nbsp;&nbsp;Reset&nbsp;
		&nbsp;&nbsp;&nbsp;' onclick="location='/Skywings/statistik'" />
		</center>
	</form>
	<br>
	<div align="center" style="background:#fafafa; color:#222; padding:10px;">


	</script>

	<div id="g13">
		<% if( avgPreis != null){ %>
			<strong>Durchschnittlicher Geldumlauf : <%= avgPreis%></strong>
			&nbsp;
			<%= date1%>&nbsp;&nbsp;&nbsp;<%= date2 %>
		<%}%>
	</div>

<div id="g4">
		<% if( gesamtFlug != 0 && gesamtFlug!=-1){ %>
			<strong>Gesamtanzahl der Flügen : <%= gesamtFlug%></strong>
		<%}%>
		<% if( gesamtFlug==-1){ %>
			<strong>Gesamtanzahl der Flügen : 0</strong>
		<%}%>
	</div>
	
	<div id="g5">
		<% if( gesamtBuch != 0 && gesamtBuch!=-1){ %>
			<strong>Gesamtanzahl der Buchungen : <%= gesamtBuch%></strong>
		<%}%>
		
		<% if( gesamtBuch==-1){ %>
			<strong>Gesamtanzahl der Buchungen : 0</strong>
		<%}%>
	</div>
	
	<div id="g6">
		<% if( durchPreis != null){ %>
			<strong>Durchschinttlicher Geldumlauf : <%= durchPreis%></strong>
		<%}%>
	</div>
	
	<div id="g7">
		<% if( gesamPass != 0 && gesamPass!=-1){ %>
			<strong>Gesamtanzahl der Passagieren : <%= gesamPass%></strong>
		<%}%>
		
		<% if(gesamPass == -1){ %>
			<strong>Gesamtanzahl der Passagieren : 0</strong>
		<%}%>
	</div>
	
	<div id="g8">
		<% if( minPass != 0 && minPass!=-1){ %>
			<strong>Minimale Anzahl der Passagieren : <%= minPass%></strong>
			&nbsp;
			<%= date1%>&nbsp;&nbsp;&nbsp;<%= date2 %>
		<%}%>
		
		<% if( minPass == -1){ %>
			<strong>Minimale Anzahl der Passagieren : 0</strong>
		<%}%>
		
	</div>
	
	<div id="g9">
		<% if( maxPass != 0 && maxPass!=-1){ %>
			<strong>Maximale Anzahl der Passagieren : <%= maxPass%></strong>
			&nbsp;
			<%= date1%>&nbsp;&nbsp;&nbsp;<%= date2 %>
		<%}%>
		
		<% if( maxPass == -1){ %>
			<strong>Maximale Anzahl der Passagieren : 0</strong>
		<%}%>
	</div>
	
	<div id="g10">
		<% if( avgPass != null){ %>
			<strong>Durchschnittliche Anzahl der Passagieren : <%= avgPass%></strong>
			&nbsp;
			<%= date1%>&nbsp;&nbsp;&nbsp;<%= date2 %>
		<%}%>
	</div>
	
	<div id="g11">
		<% if( minPreis != null){ %>
			<strong>Minimaler Geldumlauf : <%= minPreis%></strong> 
			&nbsp;
			<%= date1%>&nbsp;&nbsp;&nbsp;<%= date2 %>
			<%}%>
	</div>
	
	<div id="g12">
		<% if( maxPreis != null){ %>
			<strong>Maximaler Geldumlauf : <%= maxPreis%></strong>
			&nbsp;
			<%= date1%>&nbsp;&nbsp;&nbsp;<%= date2 %>
		<%}%>
	</div>
	
	<div id="g14">
		<% if( gesamtPreis != null){ %>
			<strong>Geldumlauf : <%= gesamtPreis%></strong>
		<%}%>
	</div>
	
	<div id="g15">
		<% if( zeit != null){ %>
			<strong>Zeitintensität : <%= zeit%></strong>
		<%}%>
	</div>

</div>

	</div></div>


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
  </body>
</html>