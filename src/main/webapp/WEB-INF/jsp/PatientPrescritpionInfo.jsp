<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>   
<html>
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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
			    	<select size="4" id="selectElement">
						<option value="cisplatin">cisplatin</option>
						<option value="ibuprofen">ibuprofen</option>
						<option value="aspirin">aspirin</option>
						<option value="methadone">methadone</option>
						<option value="venlafaxine">venlafaxine</option>
					</select>
					<br>
					<button>Add</button>
					<button>Remove</button>
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
		
		<script>
			jQuery.ajaxSettings.traditional = true;
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
						drugNames: ["cisplatin","methadone","venlafaxine", "aspirin","paracetamol","ibuprofen"],
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
			
			function capitalizeFirstLetter(string) {
    			return string.charAt(0).toUpperCase() + string.slice(1);
			}
		</script>
	</body>
</html>