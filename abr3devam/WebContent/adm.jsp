<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="img/favicon.ico">
<link rel="stylesheet" href="style/adm.css">
<meta charset="utf-8">
<title>Página do administrador</title>
</head>
<body>
<c:choose>
		<c:when test="${logado != null}">
<header>
		<a href="index.jsp">Tela de usuário</a>
		<a href="#disciplinas">Disciplinas</a>
		<a href="#portugues">Português</a>
		<a href="#matematica">Matemática</a>
		<a href="#algoritmo">Algoritmo</a>
		<a href="#alunos">Cadastros</a>
		<a href="logout">Sair</a>
	</header>
	<h1>LOG DE ACESSOS</h1>
	
		<div class="container" id="disciplinas">
				<p class="titulo-tabela">Disciplinas</p>
			<table>
				<thead>
				<tr>
					<td class="title-table">Matéria</td>
					<td class="title-table">Quantidade de acessos</td>
				</tr>
			</thead>
			<tbody>
				<tr>
		<c:forEach var="materia" items="${ListaMateria }">	
		<tr>
					<td>${materia.nome}</td>
					<td>${materia.contador_de_acesso}</td>
					</tr>
		</c:forEach>
				</tr>
			</tbody>
			</table>
		</div>
		<div class="container" id="portugues">
	<p class="titulo-tabela"><strong>Português</strong></p>
<table>
		<thead>
	<tr>
		<td class="title-table">Capítulo</td>
		<td class="title-table">Descrição do capítulo</td>
		<td class="title-table">quantidade de acessos</td>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="disciplina" items="${ListaDisciplina }">
		<c:if test="${disciplina.nomeDisciplina eq 'PORTUGUES' }">
		<tr>
			<td>${disciplina.capitulo}</td>
			<td>${disciplina.descricao}</td>
			<td>${disciplina.contador_acesso}</td>
		</tr>
		</c:if>
	</c:forEach>
</tbody>	
</table>
</div>
<div class="container" id="matematica">
<p class="titulo-tabela"><strong>Matemática</strong></p>
<table>
	<thead>
		<tr>
			<td class="title-table">Capítulo</td>
			<td class="title-table">Descrição do capítulo</td>
			<td class="title-table">quantidade de acessos</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="disciplina" items="${ListaDisciplina }">
			<c:if test="${disciplina.nomeDisciplina eq 'MATEMATICA' }">
			<tr>
				<td>${disciplina.capitulo}</td>
				<td>${disciplina.descricao}</td>
				<td>${disciplina.contador_acesso}</td>
			</tr>
			</c:if>
		</c:forEach>
	</tbody>	
	</table>
</div>
<div class="container" id="algoritmo">
	<p class="titulo-tabela"><strong>Algoritmo</strong></p>
	<table>
		<thead>
			<tr>
				<td class="title-table">Capítulo</td>
				<td class="title-table">Descrição do capítulo</td>
				<td class="title-table">quantidade de acessos</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="disciplina" items="${ListaDisciplina }">
				<c:if test="${disciplina.nomeDisciplina eq 'ALGORITMO' }">
				<tr>
					<td>${disciplina.capitulo}</td>
					<td>${disciplina.descricao}</td>
					<td>${disciplina.contador_acesso}</td>
				</tr>
				</c:if>
			</c:forEach>
		</tbody>	
		</table>
	</div>
	<div class="container" id="alunos">
				<p class="titulo-tabela">Alunos cadastrados</p>
			<table>
				<thead>
				<tr>
					<td class="title-table">Nome do aluno</td>
					<td class="title-table">Sobrenome</td>
					<td class="title-table">RM</td>
					<td class="title-table">E-mail</td>
				</tr>
			</thead>
			<tbody>
				<tr>
		<c:forEach var="alunos" items="${ListaAluno }">	
		<tr>
					<td>${alunos.nome}</td>
					<td>${alunos.sobrenome}</td>
					<td>${alunos.rm}</td>
					<td>${alunos.email}</td>
					</tr>
		</c:forEach>
				</tr>
			</tbody>
			</table>
		</div>
		</c:when>
		<c:otherwise>
			<div class="n-logado">
				<p>Você não possui cadastro!</p>
			</div>
			<div class="opcao-deslogado">
				<a href="cadastro.jsp">Cadastre-se</a>
			</div>
		</c:otherwise>
		</c:choose>
</body>
</html>