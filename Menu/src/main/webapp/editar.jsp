<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Restaurante</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
	<h1>Editar prato</h1>
	<form name="frmNovo" action="update">
		Codigo: <input type="number" name="Codigo" value="<%out.print(request.getAttribute("codigo"));%>"><br>
		Nome: <input type="text" name="Nome" value="<%out.print(request.getAttribute("Nome"));%>"><br>
		Ingredientes: <input type="text" name="Ingredientes" value="<%out.print(request.getAttribute("Ingredientes"));%>"><br>
		Tipo: <select name="Tipo" value="<%out.print(request.getAttribute("Tipo"));%>">
			<option value="entrada">Entrada</option>
			<option value="principal">Principal</option>
			<option value="sobremesa">Sobremesa</option>
		</select><br> 
		<input type="submit" value="Salvar" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>