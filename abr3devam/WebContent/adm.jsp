<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style/adm.css">
<meta charset="ISO-8859-1">
<title>Página do administrador</title>
</head>
<body>		
	<h1>log de acessos aos conteúdos</h1>
		<div class="container">
				<p class="titulo-tabela">Disciplinas</p>
			<table>
				<tr>
					<td class="title-table">Matéria</td>
					<td class="title-table">Quantidade de acessos</td>
				</tr>
				<tr>
		<c:forEach var="materia" items="${ListaMateria }">	
		<tr>
					<td>${materia.nome}</td>
					<td>${materia.contador_de_acesso}</td>
					</tr>
		</c:forEach>
				</tr>
			</table>
		</div>
		<div class="container">
	<p class="titulo-tabela"><strong>Português</strong></p>
<table>
	<tr>
		
		<td class="title-table">Capítulo</td>
		<td class="title-table">Descrição do capítulo</td>
		<td class="title-table">quantidade de acessos</td>
	</tr>
	<c:forEach var="disciplina" items="${ListaDisciplina }">
		<c:if test="${disciplina.nomeDisciplina eq 'PORTUGUES' }">
		<tr>
			<td>${disciplina.capitulo}</td>
			<td>${disciplina.descricao}</td>
			<td>${disciplina.contador_acesso}</td>
		</tr>
		</c:if>
	</c:forEach>	
</table>
</div>
<div class="container">
<p class="titulo-tabela"><strong>Matemática</strong></p>
<table>
		<tr>
			
			<td class="title-table">Capítulo</td>
			<td class="title-table">Descrição do capítulo</td>
			<td class="title-table">quantidade de acessos</td>
		</tr>
		<c:forEach var="disciplina" items="${ListaDisciplina }">
			<c:if test="${disciplina.nomeDisciplina eq 'MATEMATICA' }">
			<tr>
				<td>${disciplina.capitulo}</td>
				<td>${disciplina.descricao}</td>
				<td>${disciplina.contador_acesso}</td>
			</tr>
			</c:if>
		</c:forEach>	
	</table>
</div>
<div class="container">
	<p class="titulo-tabela"><strong>Algoritmo</strong></p>
	<table>
			<tr>
				<td class="title-table">Capítulo</td>
				<td class="title-table">Descrição do capítulo</td>
				<td class="title-table">quantidade de acessos</td>
			</tr>
			<c:forEach var="disciplina" items="${ListaDisciplina }">
				<c:if test="${disciplina.nomeDisciplina eq 'ALGORITMO' }">
				<tr>
					<td>${disciplina.capitulo}</td>
					<td>${disciplina.descricao}</td>
					<td>${disciplina.contador_acesso}</td>
				</tr>
				</c:if>
			</c:forEach>	
		</table>
	</div>
</body>
</html>
		
					
					
