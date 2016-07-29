<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<spring:url value="/resources" var="resources"/>   
<html>
<head>
<meta charset="UTF-8">
<title>Flat Login Form 3.0</title>


<!--  link rel="stylesheet" href="css/reset.css"-->

<link rel='stylesheet prefetch'
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

<link rel="stylesheet" href="${resources}/css/login.css">
</head>
<body>
	<div class="pen-title">
		<h1>Patient Login Page</h1>
	</div>
	<!-- Form Module-->
	<div class="module form-module">
		<div class="toggle">
			<i class="fa fa-times fa-pencil"></i>
			<div class="tooltip">Create An Account</div>
		</div>
		<div class="form">
			<h2>Login to your account</h2>
			<form name="loginForm" method="POST" action="home">
				<input type="text" name="username" placeholder="Username"/> 
				<input type="password" name="password" placeholder="Password"/>
				<button>Login</button>
			</form>
			<div>
			${message}
			</div>
		</div>	
	</div>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src='http://codepen.io/andytran/pen/vLmRVp.js'></script>

	<script src="js/index.js"></script>




</body>
</html>
