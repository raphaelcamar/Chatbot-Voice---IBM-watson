
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<link rel="shortcut icon" href="img/favicon.ico">
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans|Roboto+Condensed&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="style/index.css">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Fiap EAD</title>
</head>
<body>
	<c:choose>
		<c:when test="${logado != null }">
			<header>
				<p class="opcao">
					<a href="https://www2.fiap.com.br/"> Portal do aluno</a>
				</p>
				<p id="nome">
					Olá
					<%=session.getAttribute("nomeAluno")%>!
				</p>
				<p class="opcao">
					<a href="logout">Sair</a>
				</p>

			</header>
			<form action="disciplina" method="post">
			<div class="container">
				<div class="algoritmo">
					<img src="img/algoritmo.jpg">
					<h5 class="name">Algoritimo</h5>
					<p class="desc">EAD focado em oferecer apoio à matéria de
						algoritmos</p>
					<button name="valorConteudo" value="1">Conteúdo</button>
					
				</div>
				<div class="portugues">
					<img src="img/portugues.jpg">
					<h5 class="name">Português</h5>
					<p class="desc">EAD focado em passar conhecimentos na área de
						negócios</p>
					<button name="valorConteudo" value="2">Conteúdo</button>
				</div>
				<div class="matematica">
					<img src="img/mat.jpg" class="card-img-top">
					<h5 class="name">Matemática</h5>
					<p class="desc">EAD focado em fortalecer alguns conceitos
						matemáticos</p>
					<button name="valorConteudo" value="3">Conteúdo</button>
				</div>
			</div>
		</form>
			
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
	<script src="script/EnviarQ.js"></script>
			<script src="script/index.js"></script>
</body>
</html>