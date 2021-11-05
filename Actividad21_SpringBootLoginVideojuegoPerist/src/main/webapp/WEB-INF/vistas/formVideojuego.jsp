<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
* {
	margin: 0;
	padding: 0;
	font-size: 14px;
	font-family: 'Montserrat', sans-serif;
}
body {
	background-color: #05141D;
}
#login-panel, #signup-panel {
	position: absolute;
	width: 400px;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	text-align: center;
	color: white;
}
#login-panel h3, #signup-panel h3 {
	font-size: 26px;
	margin-bottom: 15px;
}
form {
	margin: auto;
	display: flex;
	justify-content: space-around;
	flex-wrap: wrap;
}
input, button {
	width: 100%;
	height: 50px;
	margin: 3px;
	border-radius: 3px;
	border: 1px solid #aaa;
	text-align: center;
	background-color: white;
}
input:focus {
	border-color: #2980b9;
	box-shadow: 0 0 5px #2980b9;
}
.signup-button:focus {
	border-color: #06883B;
	box-shadow: none;
}
.signup-button, .login-button {
	cursor: pointer;
	border: none;
	background-color: #1297E0;
	color: white;
	width: 47%;
	margin-top: 5px;
	border-bottom: 2px solid #0267A0;
}
form .signup-button {
	background-color: #16A84B;
	border-bottom: 2px solid #06680B;
}
form .signup-button:active {
	background-color: #06883B;
	border-color: #04681B;
}
form .login-button:active {
	background-color: #1277B0;
	border-color: #024780;
}
#signup-panel .signup-button {
	width: 100%;
}
label {
	text-align: center;
	color: white;
	margin-top: 15px;
}
label a {
	color: #22A7F0;
	text-decoration: none;
}
h2 {
	color: red;
}
@media screen and (max-width: 832px) {
	#login-panel, #signup-panel {
		width: 245px;
	}
	label {
		width: 80%;
	}
}

.error {
	color: red;
}
</style>

</head>
<body>
    
    <div id="signup-panel">
		<h3>A�adir Videojuego</h3>
		<form:form action="doFormVideojuego" method="POST" modelAttribute="videojuego">
			<form:hidden path="id"/>
			
			<form:errors path="nombre" cssClass="error" />
			<form:input class="input" placeholder="Nombre" path="nombre"/>
			
			<form:errors path="author" cssClass="error" />
			<form:input class="input" placeholder="Author" path="author"/>
			
			<form:errors path="compania" cssClass="error" />
		    <form:input class="input" placeholder="Compania" path="compania"/>
		    
		    <form:errors path="nota" cssClass="error" />
		    <form:input class="input" placeholder="Nota" path="nota"/>
		    
			<button type="submit" class="signup-button">${empty videojuego.nombre ? 'Crear' : 'Modificar'}</button>
		</form:form>
	</div>
</body>
</html>