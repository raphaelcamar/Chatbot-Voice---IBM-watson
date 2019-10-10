<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<link rel="shortcut icon" href="img/favicon.ico">
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab&display=swap" rel="stylesheet">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="style/portugues.css">
    <title>Português</title>
</head>
<body>
<c:choose>
	<c:when test="${logado != null }"> 
     <header>
        <p>Português</p>
        <p><a href="index.jsp">Fiap EAD</a></p>
        <p><a href="logout">Sair</a></p>
    </header>
        <p class="list">Lista de conteúdos</p>
    <div class="container">
        <div class="conteudo"><p>Cap 1 - Comunicação Empresarial</p>
        <a href="#">Leia</a>
</div>
    <div class="conteudo"><p>Cap 2 - Técnicas de Leitura e Interpretação de Textos</p>
        <a href="#">Leia</a>
            </div>
    <div class="conteudo"><p>Cap 3 - A coesão textual e a construção do sentido</p>
        <a href="#">Leia</a>
</div>
    <div class="conteudo"><p>Cap 4 - Coerência - A unidade do texto</p>
        <a href="#">Leia</a>
</div>
    <div class="conteudo"><p>Cap 5 - Storytelling</p>
        <a href="#">Leia</a>
</div>
    <div class="conteudo"><p>Cap 6 - Conceito de Startup</p>
        <a href="conteudo.jsp">Leia</a>
</div>
    <div class="conteudo"><p>Cap 7 - Modelo de Negócios - Canvas </p>
        <a href="#">Leia</a>
</div>
    <div class="conteudo"><p>Cap 8 - O moderno texto empresarial</p>
        <a href="#">Leia</a>
</div>
    <div class="conteudo"><p>Cap 9 - Características do moderno texto empresarial</p>
        <a href="#">Leia</a>
</div>
    <div class="conteudo"><p>Cap 10 - Erros empresariais comuns</p>
        <a href="#">Leia</a>
</div>
    <div class="conteudo"><p>Cap 11 - Técnicas de Apresentação</p>
        <a href="#">Leia</a>
</div>
    <div class="conteudo"><p>Cap 12 - Pitch</p>
        <a href="#">Leia</a>
</div> 
    <div class="conteudo"><p>Cap 13 - Gramática normativa aplicada à leitura e produção textual</p>
        <a href="#">Leia</a>
</div>
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