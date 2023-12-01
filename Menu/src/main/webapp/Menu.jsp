<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("pratos");
//for (int i = 0; i < lista.size(); i++){
//out.println(lista.get(i).getCodigo());
//out.println(lista.get(i).getNome());
//out.println(lista.get(i).getIngredientes());
//out.println(lista.get(i).getTipo());
//}
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Restaurante</title>
<link rel="stylesheet" href="styles.css">
</head>
<body>
	<header>
		<h1>Restaurante ABC</h1>
		<nav></nav>
	</header>

	<main>
		<h2>Opções de Pratos</h2>
		<table>
			<thead>
				<tr>
					<th>Codigo</th>
					<th>Nome</th>
					<th>Ingredientes</th>
					<th>Tipo</th>
					<th>Opções</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (int i = 0; i < lista.size(); i++) {
				%>
				<tr>
					<td><%=lista.get(i).getCodigo()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getIngredientes()%></td>
					<td><%=lista.get(i).getTipo()%></td>
					<td><a href="select?Codigo=<%=lista.get(i).getCodigo()%>">EDITAR|</a>
					<a href="javascript: confirmar(<%=lista.get(i).getCodigo() %>)">|EXCLUIR</a>
					</td>
				</tr>
				<%} %>
			</tbody>
		</table>
		<div>
			<a href="novo.html">INSERIR NOVO PRATO</a>
		</div>
	</main>
	<script src="scripts/confirmador.js"></script>
</body>
</html>

