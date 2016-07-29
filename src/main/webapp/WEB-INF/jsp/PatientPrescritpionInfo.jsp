<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
	<head>
		<title>Patient Prescription Info</title>
	</head>
	<style>
		#headerDiv {
			background-color: #006699;
			height: 75px;
		}

		#bodyDiv {
			width: 100%;
			height: 100%;
		}

		#title {
			color: white;
			display: inline-block;
			height:50px;
		}

		#welcomeMessage {
			color: white;
			float: right;
			margin-top: 20px;
			margin-right: 5px;
			font-size: 25px;
		}

		#titleText {
			font-size: 35px;
		}

		.no-padding {
			padding: 0px;
		}

		.full-height {
			height: 100%;
		}

		#left-pane-div {
			padding-top: 100px;
			padding-left: 50px;
			background-color: grey;
		}

		#selectElement {
			width: 200px;
			top: 30px;
		}
		
		table {
			border-collapse: collapse;
		}
		table, th, td {
		   border: 1px solid black;
		   text-align: center;
		}
	</style>
	<body>
		<div id="headerDiv">
			<span id="title">
				<p id="titleText">Patient Prescription Information</p>
			</span>
			<span id="welcomeMessage">
				<p>Welcome, ${username} | Logout</p>
			</span>
		</div>

		<div id="bodyDiv">
			<div class="row">
			    <div class="col-sm-3 no-padding full-height" id="left-pane-div">
			    	<div>
	                  <select id="selectElement">
							<c:forEach items="${currentDrugs}" var="drug"> 
  								<option value="${drug.name}" prescriptionID="${drug.prescriptionID}">${drug.name}</option>
							</c:forEach>
	                    </select> <br>
	                    <button id="addButton">Add</button>
	                    <button id="removeButton">Remove</button>
	                </div>
	                <br> <br>
	                <div>
	                    <form method="POST" action="upload" enctype="multipart/form-data">
	                        <p>Upload Prescription Image:</p>
	                        <input type="file" name="file" id="file" />  </br>
	                        <input type="submit" value="Upload" name="upload" id="upload"/>
	                    </form>
	                </div>
                </div>
			  	<div class="col-sm-9 no-padding">
			    	<div class="container">
					  	<ul class="nav nav-tabs">
						    <li class="active"><a data-toggle="tab" href="#drugInfoDiv">Drug Information</a></li>
						    <li><a data-toggle="tab" href="#drugInteractionDiv">Drug Interactions</a></li>
					  	</ul>

					  	<div class="tab-content">
						    <div id="drugInfoDiv" class="tab-pane fade in active">
						      	<h3>Drug Information</h3>
						      	<p>Select a drug to get information about it</p>
						    </div>
						    <div id="drugInteractionDiv" class="tab-pane fade">
						      	<h3>Drug Interaction</h3>
						      	<p>Select a drug to get information about its interactions with the other drugs</p>
						    </div>
					  	</div>
					</div>
			  	</div>
			</div>
		</div>
		
		<div id="dialog-form" title="Add new medicine">
		  <p class="validateTips">All form fields are required.</p>
		 
		  <form id="AddDrugForm">
		    <fieldset>
		      <label for="drugName">Drug Name</label><br />
		      <input type="text" name="drugName" id="drugName" value="" class="text ui-widget-content ui-corner-all" required><br />
		      <label for="startDate">Prescription Start Date</label>
		      <input type="date" name="startDate" id="startDate" placeholder="MM-DD-YYYY" class="text ui-widget-content ui-corner-all" required>
		      <label for="endDate">Prescription End Date</label>
		      <input type="date" name="endDate" id="endDate" placeholder="MM-DD-YYYY" class="text ui-widget-content ui-corner-all" required>
		 
		      <!-- Allow form submission with keyboard without duplicating the dialog button -->
		      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
		    </fieldset>
		  </form>
		</div>
		
		<script>
			jQuery.ajaxSettings.traditional = true;
			$(document).ready(new function() {
				$("#selectElement").attr("size",$("#selectElement").children().length);
				
				$('#selectElement').on('change', function() {
					selectedDrug = this.value
					$.ajax({
						url: "drug/patientEducation",
						type: 'POST',
						data: {
							drugName: this.value
						}, 
						success: function(result) {
							var html = "<h3>"+capitalizeFirstLetter(selectedDrug)+"</h3><br />"
							html += "<b>"+result.data[0].descriptionHeader+"</b><br />"+ result.data[0].description + "<br /><br />"
							html += "<b>"+result.data[0].contraindicationsHeader+"</b><br />"+ result.data[0].contraindications + "<br /><br />"
							html += "<b>"+result.data[0].administrationHeader+"</b><br />"+ result.data[0].administration + "<br /><br />"
							html += "<b>"+result.data[0].missedDoseHeader+"</b><br />"+ result.data[0].missedDose + "<br /><br />"
							html += "<b>"+result.data[0].interactionsHeader+"</b><br />"+ result.data[0].interactions + "<br /><br />"
							html += "<b>"+result.data[0].monitoringHeader+"</b><br />"+ result.data[0].monitoring + "<br /><br />"
							html += "<b>"+result.data[0].sideEffectsHeader+"</b><br />"+ result.data[0].sideEffects + "<br /><br />"
							html += "<b>"+result.data[0].storageHeader+"</b><br />"+ result.data[0].storage + "<br /><br />"
							
							$('#drugInfoDiv').html(html)
						}
					});
					
					$.ajax({
						url: "drug/interactions",
						type: 'POST',
						data: {
							primary: this.value
						}, 
						success: function(result) {
							var html = "<h3>Drug Interaction</h3><br /><table><tr><th>Drug Name</th><th>Severity</th><th>Notes</th></tr>"
							for(var i = 0; i < result.data.length; i++) {
								if(result.data[i].interactionSetADrugList[0] == selectedDrug) {
									html += "<tr><td>"+result.data[i].interactionSetBDrugList[0]+"</td><td>"+result.data[i].severity+"</td><td>"+result.data[i].consumerNotes+"</td></tr>"
								} else if(result.data[i].interactionSetBDrugList[0] == selectedDrug) {
									html += "<tr><td>"+result.data[i].interactionSetADrugList[0]+"</td><td>"+result.data[i].severity+"</td><td>"+result.data[i].consumerNotes+"</td></tr>"
								}
							}
							html += "</table>"
							$('#drugInteractionDiv').html(html)
						}
					});
				});
				
				$('#removeButton').click(function() {
					var remove = confirm("Are you sure you want to remove this drug?")
					if(remove == true) {
						$.ajax({
							url: "prescription/remove",
							type: 'POST',
							data: {
								prescriptionID: $('#selectElement option:selected').attr('prescriptionId'),
							}, 
							success: function(result) {
								$("#selectElement option:selected").remove();
								$("#selectElement").attr('size', parseInt($("#selectElement").attr("size"))-1);
							}
						});	
					}			
				});
				
				$('#dialog-form').dialog({
					autoOpen: false,
                    modal: true,
                    buttons: { 
                    	"Cancel": function() {
                    		$('#AddDrugForm')[0].reset();
                        	$(this).dialog("close")
                    	},
                        "Add Drug": function() {
							$.ajax({
								url: "prescription/add",
								type: 'POST',
								data: {
									drugName: $('#drugName').val(),
									startDate: $('#startDate').val(),
									endDate: $('#endDate').val()
								}, 
								success: function(result) {
									/*
									$("#selectElement").append("<option value='"+$('#drugName').val()+"'>"+$('#drugName').val()+"</option>");
									$("#selectElement").attr('size', parseInt($("#selectElement").attr("size"))+1);
									$("#selectElement").attr('prescriptionId', result);
									*/
									
									$('#AddDrugForm')[0].reset();
									
									$("#selectElement").children().remove();
									for(var i=0;i<result.length;i++){
										$("#selectElement").append("<option value='"+result[i].name+"'prescriptionId='"+result[i].prescriptionID+"'>"+result[i].name+"</option>");
									}
									$("#selectElement").attr('size', result.length);

									$(this).dialog("close");									
								}
							});
                     	}
                   }
                });
				
				$('#addButton').click(function() {
					$('#dialog-form').dialog('open')
				});
				
				function capitalizeFirstLetter(string) {
	    			return string.charAt(0).toUpperCase() + string.slice(1);
				}
  			});
		</script>
	</body>
</html>