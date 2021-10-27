<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale= 1.0">
    <link href="style.css" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,300;1,400;1,500;1,600;1,700;1,800&display=swap" rel="stylesheet">
    <title>Exercise 1 Option 2</title>
    
    <style>
    	body {
		    background-color: #ff7d7d;
		    font-family: Open Sans;
		    margin: 0;
		}
		
		h1, h2 {
		    display: block;
		    position: relative;
		    transform: translate(110px, 60px);
		    font-weight: 400;
		}
		
		h2 {
			color: red;
			margin-left: 150px;
		}
		
		.container {
		    display: block;
		    position: relative;
		    transform: translate(100px, 200px);
		    height: 550px;
		    width: 500px;
		    background-color:  #f2f2f2;
		    color: #7b7b7b;
		}
		
		.input {
		    display: block;
		    position: relative;
		    transform: translate(80px, 40px);
		    width: 300px;
		    border: 1px solid #dbdbdb;
		    margin-top: 50px;
		    padding: 25px;
		    font-size: 20px;
		    color: #c4c4c4;
		}
		
		button {
		    display: block;
		    position: relative;
		    transform: translate(180px, 80px);
		    height: 50px;
		    width: 150px;
		    background-color: #75fffe;
		    color: #FFFFFF;
		    font-family: Open Sans;
		    font-weight: 400;
		    font-size: 20px;
		    text-transform: uppercase;
		    border: none;
		}
		
		.login {
		    text-decoration: none;
		}
		
		.checkbox {
		    position: relative;
		    transform: translate(85px, 120px);
		    color: #c4c4c4;
		}
		
		#rememberMe {
		    height: 30px;
		    width: 30px;
		}
		
		@media screen and (min-width: 768px) {
		
		body {
		    background-color: #ff7d7d;
		    font-family: Open Sans;
		    margin: 0;
		}
		
		h1 {
		    display: block;
		    position: relative;
		    transform: translate(300px, 60px);
		    font-weight: 400;
		}
		
		.container {
		    display: block;
		    position: relative;
		    transform: translate(480px, 200px);
		    height: 550px;
		    width: 900px;
		    background-color:  #f2f2f2;
		    color: #7b7b7b;
		}
		
		.input {
		    display: block;
		    position: relative;
		    transform: translate(160px, 40px);
		    width: 500px;
		    border: 1px solid #dbdbdb;
		    margin-top: 50px;
		    padding: 25px;
		    font-size: 20px;
		    color: #c4c4c4;
		}
		
		button {
		    display: block;
		    position: relative;
		    transform: translate(350px, 80px);
		    height: 50px;
		    width: 150px;
		    background-color: #75fffe;
		    color: #FFFFFF;
		    font-family: Open Sans;
		    font-weight: 400;
		    font-size: 20px;
		    text-transform: uppercase;
		    border: none;
		}
		
		.checkbox {
		    position: relative;
		    transform: translate(160px, 120px);
		    color: #c4c4c4;
		}
		
		#rememberMe {
		    height: 30px;
		    width: 30px;
		}
		
		}
    </style>
</head>

<body>
    <section class="container">
    <h1>Have an account? Sign in</h1>
    <h2>${empty error ? "" : error}</h2>
	    <form action="LoginController" method="get">
	        <input class="input" placeholder="Username" name="username">
	        <input type="password" class="input" placeholder="Password" name="password">
	        <button type="submit" class="login">Login</button>
	    </form>
    </section>
</body>
</html>