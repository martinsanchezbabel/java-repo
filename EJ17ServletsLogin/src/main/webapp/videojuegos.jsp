<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Table Component</title>
    
    <style>
    	* {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
      }

      body {
        font-family: 'Inter', sans-serif;
        color: #343a40;
        line-height: 1;
        display: flex;
        justify-content: center;
      }
      
      ul {
      	list-style-type: none;
      }

      table {
        width: 800px;
        border-right-color: #ffffff;
        margin-top: 100px;
        font-size: 18px;
        /* /* border: 1px solid #343a40; */
        border-collapse: collapse; 
      }
      
      th, td {
        /* border: 1px solid #343a40; */
        padding: 16px 24px;
        text-align: left;
      }

      th {
        background-color: #087f5b;
        color: #fff;
        width: 25%;
      }

      tbody tr:nth-child(odd){
        background-color: #f8f9fa;
      }

      
      tbody tr:nth-child(even){
        background-color: #e9ecef;
      }
      
      button {
		    display: block;
		    height: 50px;
		    width: 150px;
		    background-color: #5F4785;
		    color: #FFFFFF;
		    font-family: Open Sans;
		    font-weight: 400;
		    font-size: 20px;
		    text-transform: uppercase;
		    border-radius: 3px 3px;
		}
    </style>
  </head>
  <body>
  


  	<header>
	    <nav>
	    	<ul>
	    		<li><h1>Bienvenido ${username}</h1></li>
	    	</ul>
	    </nav>
	</header>

  
    <table>
    
      <thead>
      
        <tr>
          <th>ID</th>
          <th>Nombre</th>
          <th>Compañia</th>
          <th>Nota Media</th>
          <th></th>
        </tr>
      </thead>

      <tbody>
      
      <!-- Esta funcion esta en las librerias JSTL 
      	for(Videojuego videojuego : videojuegos){
      	
      	}
      -->
      <c:forEach items="${videojuegos}" var="videojuego">
        <tr>
          <td><c:out value="${videojuego.id}"></c:out></td>
          <td><c:out value="${videojuego.nombre}"></c:out></td>
          <td><c:out value="${videojuego.compania}"></c:out></td>
          <td><c:out value="${videojuego.nota}"></c:out></td>
          <td>
          	<a href = "<c:url value="VideojuegoDetalleController">
                				<c:param name="id" value="${videojuego.id}"/>
         				</c:url>"><button>Ver más</button>
         	</a>
          </td>
        </tr>
      </c:forEach> 
        
      </tbody>      
    </table>
  </body>
</html>