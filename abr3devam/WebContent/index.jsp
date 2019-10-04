<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	href="https://fonts.googleapis.com/css?family=Merriweather+Sans&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:900&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Roboto+Condensed&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="style/index.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Fiap EAD</title>
</head>
<body>
	<c:choose>
		<c:when test="${logado != null }">
		<a href="conteudo.jsp">chatbot</a>
			<header>
				<p id="nome">
					Olá
					<%=session.getAttribute("nomeAluno")%>!
				</p>
				<p class="opcao">
					<a href="https://www2.fiap.com.br/"> Portal do aluno</a>
				</p>
				<p class="opcao">
					<a href="logout">Sair</a>
				</p>
			</header>
			<h1>Nivelamento</h1>
			<div class="card-deck">
				<div class="card">
					<img src="img/algoritmo.jpg" class="card-img-top " alt="...">
					<div class="card-body">
						<h5 class="card-title">Algoritimo</h5>
						<p class="card-text">EAD focado em ajudar oferecer apoio à
							matéria de algoritmo</p>
						<p class="botao">
							<a href="#">Conteudo</a>
						</p>
					</div>
				</div>
				<div class="card">
					<img src="img/portugues.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Portugues</h5>
						<p class="card-text">EAD focado em passar conhecimentos de
							negócio</p>
						<p class="botao">
							<a href="#">Conteudo</a>
						</p>
					</div>
				</div>
				<div class="card">
					<img src="img/mat.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Matematica</h5>
						<p class="card-text">EAD focado em fortalecer alguns conceitos
							matemáticos</p>
						<p class="botao">
							<a href="#">Conteudo</a>
						</p>
					</div>
				</div>
			</div>
		</c:when>

		<c:otherwise>
			<div class="n-logado">
				<p>Você não possui cadastro!</p>
			</div>
			<div class="opcao-deslogado">
				<a href="cadastrar.jsp">Cadastre-se</a>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>