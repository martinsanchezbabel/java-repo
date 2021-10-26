<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Listado de Videojuegos</h1>

	<h2>${lista}</h2>
	
	<h3>Busqueda por id:</h3>
	<form action="BusquedaServlet">
		Id: <input type="number" name="id">
		<input type="submit" value="Pulsame">
	</form>
</body>
</html>