$(document).on('click','#2', function(){
					
					var $idedit2 = '2';
					
					var $oldname2 = $('#writename'+$idedit2);
					var $nameinput2 = $('<input\>').val($oldname2.text());
					var $pastname2 = $('<input\>').val($oldname2.text());
					$nameinput2.attr("name", "nameinput2");
					$nameinput2.attr("id","nameinput2")
					$oldname2.replaceWith($nameinput2);
					
					
					var $oldnachname2 = $('#writenachname'+$idedit2);
					var $nachnameinput2 = $('<input\>').val($oldnachname2.text());
					var $pastnachname2 = $('<input\>').val($oldnachname2.text());
					$nachnameinput2.attr("name", "nachnameinput2");
					$nachnameinput2.attr("id","nachnameinput2")
					$oldnachname2.replaceWith($nachnameinput2);
					
					var $olddat2 = $('#writegebdat'+$idedit2);
					var $datinput2 = $('<input\>').val($olddat2.text());
					var $pastdat2 = $('<input\>').val($olddat2.text());
					$datinput2.attr("name", "datinput2");
					$datinput2.attr("id","datinput2")
					$olddat2.replaceWith($datinput2);
					
					var $oldpass2 = $('#writepassnr'+$idedit2);
					var $passinput2 = $('<input\>').val($oldpass2.text());
					var $pastpass2 = $('<input\>').val($oldpass2.text());
					$passinput2.attr("name", "passinput2");
					$passinput2.attr("id","passinput2")
					$oldpass2.replaceWith($passinput2);
					
					var $oldnation2 = $('#writenation'+$idedit2);
					var $nationinput2 = $('<input\>').val($oldnation2.text());
					var $pastnation2 = $('<input\>').val($oldnation2.text());
					$nationinput2.attr("name", "nationinput2");
					$nationinput2.attr("id","nationinput2")
					$oldnation2.replaceWith($nationinput2);
					
					var $oldadress2 = $('#writeadresse'+$idedit2);
					var $adressinput2 = $('<input\>').val($oldadress2.text());
					var $pastadress2 = $('<input\>').val($oldadress2.text());
					$adressinput2.attr("name", "adressinput2");
					$adressinput2.attr("id","adressinput2")
					$oldadress2.replaceWith($adressinput2);
					
					var $oldplz2 = $('#writeplz'+$idedit2);
					var $plzinput2 = $('<input\>').val($oldplz2.text());
					var $pastplz2 = $('<input\>').val($oldplz2.text());
					$plzinput2.attr("name", "plzinput2");
					$plzinput2.attr("id","plzinput2")
					$oldplz2.replaceWith($plzinput2);
					
					var $edit_btn2 = $('#'+$idedit2);
					
					$save_btn2 = $('<button\>').html("<i class=\"fa fa-check\" aria-hidden=\"true\"></i>");
					$save_btn2.attr("id", "b_save"+$idedit2);
					$save_btn2.attr("name", "b_save"+$idedit2);
					$save_btn2.attr("class", "btn btn-success");
					
					$('#'+$idedit2).replaceWith($save_btn2);
					
					$('#c'+$idedit2).attr("class", "btn btn-danger");
					$('#c'+$idedit2).attr("style","");
					$('#save_me2').attr("method","POST");
					$('#save_me2').attr("action","passagierespeichern");
					
					$('#b_save2').click(function() {
						
						var checkname = $pastname2.prop("value");
						var currentname = $nameinput2.prop("value");
						
						var checknachname = $pastnachname2.prop("value");
						var currentnachname = $nachnameinput2.prop("value");
						
						var checkdat = $pastdat2.prop("value");
						var currentdat = $datinput2.prop("value");
						
						var checkpass = $pastpass2.prop("value");
						var currentpass = $passinput2.prop("value");
						
						var checknation = $pastnation2.prop("value");
						var currentnation = $nationinput2.prop("value");
						
						var checkadress = $pastadress2.prop("value");
						var currentadress = $adressinput2.prop("value");
						
						var checkplz = $pastplz2.prop("value");
						var currentplz = $plzinput2.prop("value");
						
						if(checkname!=currentname||checknachname!=currentnachname||
								checkplz!=currentplz||checkpass!=currentpass
								||checknation!=currentnation||checkadress!=currentadress)
						{
							
							
							document.getElementById("hiddenName2").value=currentname;
							document.getElementById("hiddenNachname2").value=currentnachname;
							document.getElementById("hiddenPlz2").value=currentplz;
							document.getElementById("hiddenPassnr2").value=currentpass;
							document.getElementById("hiddenNation2").value=currentnation;
							document.getElementById("hiddenAdress2").value=currentadress;
						
							alert("Daten gespeichert!");
						
							
						}
						
						return;
						
			
						
					});
					
					$('#c'+$idedit2).click(function() {

						
						$('#nameinput2').replaceWith($oldname2);
						$('#nachnameinput2').replaceWith($oldnachname2);
						$('#datinput2').replaceWith($olddat2);
						$('#passinput2').replaceWith($oldpass2);
						$('#nationinput2').replaceWith($oldnation2);
						$('#adressinput2').replaceWith($oldadress2);
						$('#plzinput2').replaceWith($oldplz2);
						
						
						$('#b_save'+$idedit2).replaceWith($edit_btn2);
						$('#c'+$idedit2).attr("style","display:none;");
						
						
					});
					
					
					
					
					
				});

$(document).on('click','#3', function(){
	
	var $idedit3 = '3';
	
	var $oldname3 = $('#writename'+$idedit3);
	var $nameinput3 = $('<input\>').val($oldname3.text());
	var $pastname3 = $('<input\>').val($oldname3.text());
	$nameinput3.attr("name", "nameinput3");
	$nameinput3.attr("id","nameinput3")
	$oldname3.replaceWith($nameinput3);
	
	
	var $oldnachname3 = $('#writenachname'+$idedit3);
	var $nachnameinput3 = $('<input\>').val($oldnachname3.text());
	var $pastnachname3 = $('<input\>').val($oldnachname3.text());
	$nachnameinput3.attr("name", "nachnameinput3");
	$nachnameinput3.attr("id","nachnameinput3")
	$oldnachname3.replaceWith($nachnameinput3);
	
	var $olddat3 = $('#writegebdat'+$idedit3);
	var $datinput3 = $('<input\>').val($olddat3.text());
	var $pastdat3 = $('<input\>').val($olddat3.text());
	$datinput3.attr("name", "datinput3");
	$datinput3.attr("id","datinput3")
	$olddat3.replaceWith($datinput3);
	
	var $oldpass3 = $('#writepassnr'+$idedit3);
	var $passinput3 = $('<input\>').val($oldpass3.text());
	var $pastpass3 = $('<input\>').val($oldpass3.text());
	$passinput3.attr("name", "passinput3");
	$passinput3.attr("id","passinput3")
	$oldpass3.replaceWith($passinput3);
	
	var $oldnation3 = $('#writenation'+$idedit3);
	var $nationinput3 = $('<input\>').val($oldnation3.text());
	var $pastnation3 = $('<input\>').val($oldnation3.text());
	$nationinput3.attr("name", "nationinput3");
	$nationinput3.attr("id","nationinput3")
	$oldnation3.replaceWith($nationinput3);
	
	var $oldadress3 = $('#writeadresse'+$idedit3);
	var $adressinput3 = $('<input\>').val($oldadress3.text());
	var $pastadress3 = $('<input\>').val($oldadress3.text());
	$adressinput3.attr("name", "adressinput3");
	$adressinput3.attr("id","adressinput3")
	$oldadress3.replaceWith($adressinput3);
	
	var $oldplz3 = $('#writeplz'+$idedit3);
	var $plzinput3 = $('<input\>').val($oldplz3.text());
	var $pastplz3 = $('<input\>').val($oldplz3.text());
	$plzinput3.attr("name", "plzinput3");
	$plzinput3.attr("id","plzinput3")
	$oldplz3.replaceWith($plzinput3);
	
	var $edit_btn3 = $('#'+$idedit3);
	
	$save_btn3 = $('<button\>').html("<i class=\"fa fa-check\" aria-hidden=\"true\"></i>");
	$save_btn3.attr("id", "b_save"+$idedit3);
	$save_btn3.attr("name", "b_save"+$idedit3);
	$save_btn3.attr("class", "btn btn-success");
	
	$('#'+$idedit3).replaceWith($save_btn3);
	
	$('#c'+$idedit3).attr("class", "btn btn-danger");
	$('#c'+$idedit3).attr("style","");
	$('#save_me3').attr("method","POST");
	$('#save_me3').attr("action","passagierespeichern");
	
	$('#b_save3').click(function() {
		
		var checkname = $pastname3.prop("value");
		var currentname = $nameinput3.prop("value");
		
		var checknachname = $pastnachname3.prop("value");
		var currentnachname = $nachnameinput3.prop("value");
		
		var checkdat = $pastdat3.prop("value");
		var currentdat = $datinput3.prop("value");
		
		var checkpass = $pastpass3.prop("value");
		var currentpass = $passinput3.prop("value");
		
		var checknation = $pastnation3.prop("value");
		var currentnation = $nationinput3.prop("value");
		
		var checkadress = $pastadress3.prop("value");
		var currentadress = $adressinput3.prop("value");
		
		var checkplz = $pastplz3.prop("value");
		var currentplz = $plzinput3.prop("value");
		
		if(checkname!=currentname||checknachname!=currentnachname||
				checkplz!=currentplz||checkpass!=currentpass
				||checknation!=currentnation||checkadress!=currentadress)
		{
			
			
			document.getElementById("hiddenName3").value=currentname;
			document.getElementById("hiddenNachname3").value=currentnachname;
			document.getElementById("hiddenPlz3").value=currentplz;
			document.getElementById("hiddenPassnr3").value=currentpass;
			document.getElementById("hiddenNation3").value=currentnation;
			document.getElementById("hiddenAdress3").value=currentadress;
			
		
			alert("Daten gespeichert!");
		
			
		}
		
		return;
		

		
	});
	
	
	
	$('#c'+$idedit3).click(function() {

		
		$('#nameinput3').replaceWith($oldname3);
		$('#nachnameinput3').replaceWith($oldnachname3);
		$('#datinput3').replaceWith($olddat3);
		$('#passinput3').replaceWith($oldpass3);
		$('#nationinput3').replaceWith($oldnation3);
		$('#adressinput3').replaceWith($oldadress3);
		$('#plzinput3').replaceWith($oldplz3);
		
		
		$('#b_save'+$idedit3).replaceWith($edit_btn3);
		$('#c'+$idedit3).attr("style","display:none;");
		
		
	});
	
	
	
});

$(document).on('click','#4', function(){
	
	var $idedit4 = '4';
	
	var $oldname4 = $('#writename'+$idedit4);
	var $nameinput4 = $('<input\>').val($oldname4.text());
	var $pastname4 = $('<input\>').val($oldname4.text());
	$nameinput4.attr("name", "nameinput4");
	$nameinput4.attr("id","nameinput4")
	$oldname4.replaceWith($nameinput4);
	
	
	var $oldnachname4 = $('#writenachname'+$idedit4);
	var $nachnameinput4 = $('<input\>').val($oldnachname4.text());
	var $pastnachname4 = $('<input\>').val($oldnachname4.text());
	$nachnameinput4.attr("name", "nachnameinput4");
	$nachnameinput4.attr("id","nachnameinput4")
	$oldnachname4.replaceWith($nachnameinput4);
	
	var $olddat4 = $('#writegebdat'+$idedit4);
	var $datinput4 = $('<input\>').val($olddat4.text());
	var $pastdat4 = $('<input\>').val($olddat4.text());
	$datinput4.attr("name", "datinput4");
	$datinput4.attr("id","datinput4")
	$olddat4.replaceWith($datinput4);
	
	var $oldpass4 = $('#writepassnr'+$idedit4);
	var $passinput4 = $('<input\>').val($oldpass4.text());
	var $pastpass4 = $('<input\>').val($oldpass4.text());
	$passinput4.attr("name", "passinput4");
	$passinput4.attr("id","passinput4")
	$oldpass4.replaceWith($passinput4);
	
	var $oldnation4 = $('#writenation'+$idedit4);
	var $nationinput4 = $('<input\>').val($oldnation4.text());
	var $pastnation4 = $('<input\>').val($oldnation4.text());
	$nationinput4.attr("name", "nationinput4");
	$nationinput4.attr("id","nationinput4")
	$oldnation4.replaceWith($nationinput4);
	
	var $oldadress4 = $('#writeadresse'+$idedit4);
	var $adressinput4 = $('<input\>').val($oldadress4.text());
	var $pastadress4 = $('<input\>').val($oldadress4.text());
	$adressinput4.attr("name", "adressinput4");
	$adressinput4.attr("id","adressinput4")
	$oldadress4.replaceWith($adressinput4);
	
	var $oldplz4 = $('#writeplz'+$idedit4);
	var $plzinput4 = $('<input\>').val($oldplz4.text());
	var $pastplz4 = $('<input\>').val($oldplz4.text());
	$plzinput4.attr("name", "plzinput4");
	$plzinput4.attr("id","plzinput4")
	$oldplz4.replaceWith($plzinput4);
	
	var $edit_btn4 = $('#'+$idedit4);
	
	$save_btn4 = $('<button\>').html("<i class=\"fa fa-check\" aria-hidden=\"true\"></i>");
	$save_btn4.attr("id", "b_save"+$idedit4);
	$save_btn4.attr("name", "b_save"+$idedit4);
	$save_btn4.attr("class", "btn btn-success");
	
	$('#'+$idedit4).replaceWith($save_btn4);
	
	$('#c'+$idedit4).attr("class", "btn btn-danger");
	$('#c'+$idedit4).attr("style","");
	$('#save_me4').attr("method","POST");
	$('#save_me4').attr("action","passagierespeichern");
	
	$('#b_save4').click(function() {
		
		var checkname = $pastname4.prop("value");
		var currentname = $nameinput4.prop("value");
		
		var checknachname = $pastnachname4.prop("value");
		var currentnachname = $nachnameinput4.prop("value");
		
		var checkdat = $pastdat4.prop("value");
		var currentdat = $datinput4.prop("value");
		
		var checkpass = $pastpass4.prop("value");
		var currentpass = $passinput4.prop("value");
		
		var checknation = $pastnation4.prop("value");
		var currentnation = $nationinput4.prop("value");
		
		var checkadress = $pastadress4.prop("value");
		var currentadress = $adressinput4.prop("value");
		
		var checkplz = $pastplz4.prop("value");
		var currentplz = $plzinput4.prop("value");
		
		if(checkname!=currentname||checknachname!=currentnachname||
				checkplz!=currentplz||checkpass!=currentpass
				||checknation!=currentnation||checkadress!=currentadress)
		{
			
			
			document.getElementById("hiddenName4").value=currentname;
			document.getElementById("hiddenNachname4").value=currentnachname;
			document.getElementById("hiddenPlz4").value=currentplz;
			document.getElementById("hiddenPassnr4").value=currentpass;
			document.getElementById("hiddenNation4").value=currentnation;
			document.getElementById("hiddenAdress4").value=currentadress;
			
		
			alert("Daten gespeichert!");
		
			
		}
		
		return;
		

		
	});
	
	
	$('#c'+$idedit4).click(function() {

		
		$('#nameinput4').replaceWith($oldname4);
		$('#nachnameinput4').replaceWith($oldnachname4),
		$('#datinput4').replaceWith($olddat4);
		$('#passinput4').replaceWith($oldpass4);
		$('#nationinput4').replaceWith($oldnation4);
		$('#adressinput4').replaceWith($oldadress4);
		$('#plzinput4').replaceWith($oldplz4);
		
		
		$('#b_save'+$idedit4).replaceWith($edit_btn4);
		$('#c'+$idedit4).attr("style","display:none;");
		
		
	});
	
	
	
});