$(document).on('click','#2', function(){
					
					var $idedit2 = 2;
					
					var $oldname2 = $('#writename'+$idedit2);
					var $nameinput2 = $('<input\>').val($oldname2.text());
					//$mailinput.attr("name", "mailinput");
					$oldname2.replaceWith($nameinput2);
					
					var $olddat2 = $('#writegebdat'+$idedit2);
					var $datinput2 = $('<input\>').val($olddat2.text());
					//$mailinput.attr("name", "mailinput");
					$olddat2.replaceWith($datinput2);
					
					var $oldpass2 = $('#writepassnr'+$idedit2);
					var $passinput2 = $('<input\>').val($oldpass2.text());
					//$mailinput.attr("name", "mailinput");
					$oldpass2.replaceWith($passinput2);
					
					var $oldnation2 = $('#writenation'+$idedit2);
					var $nationinput2 = $('<input\>').val($oldnation2.text());
					//$mailinput.attr("name", "mailinput");
					$oldnation2.replaceWith($nationinput2);
					
					var $oldadress2 = $('#writeadresse'+$idedit2);
					var $adressinput2 = $('<input\>').val($oldadress2.text());
					//$mailinput.attr("name", "mailinput");
					$oldadress2.replaceWith($adressinput2);
					
					var $edit_btn2 = $('#'+$idedit2);
					
					$save_btn2 = $('<button\>').html("<i class=\"fa fa-check\" aria-hidden=\"true\"></i>");
					$save_btn2.attr("id", "b_save"+$idedit2);
					$save_btn2.attr("name", "b_save"+$idedit2);
					$save_btn2.attr("class", "btn btn-success");
					
					$('#'+$idedit2).replaceWith($save_btn2);
					
					$('#c'+$idedit2).attr("class", "btn btn-danger");
					$('#c'+$idedit2).attr("style","");
					
					$('#c'+$idedit2).click(function() {

						
						$('#nameinput2').replaceWith($oldname2);
						$('#datinput2').replaceWith($olddat2);
						$('#passinput2').replaceWith($oldpass2);
						$('#nationinput2').replaceWith($oldnation2);
						$('#adressinput2').replaceWith($oldadress2);
						
						
						$('#b_save'+$idedit2).replaceWith($edit_btn2);
						$('#c'+$idedit2).attr("style","display:none;");
						
						
					});
						
					
				});
			