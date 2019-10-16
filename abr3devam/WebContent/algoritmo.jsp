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
        <p>Algoritmo</p>
        <p><a href="index.jsp">Fiap EAD</a></p>
        <p><a href="logout">Sair</a></p>
    </header>
        <p class="list">Lista de conteúdos</p>
        
        <form action="conteudo" method="post">
    <div class="container">
        <div class="conteudo"><p>Cap 1 - Princípios da programação</p>
       <button name="submit" value="1">Leia</button>
</div>
    <div class="conteudo"><p>Cap 2 - Tomada de Decisão</p>
       <button name="submit" value="2">Leia</button>
            </div>
    <div class="conteudo"><p>Cap 3 - Estruturas de Repetição</p>
        <button name="submit" value="3">Leia</button>
</div>
    <div class="conteudo"><p>Cap 4 - Vetores e Matrizes</p>
       <button name="submit" value="4">Leia</button>
</div>
    <div class="conteudo"><p>Cap 5 - Análise Algorítima</p>
        <button name="submit" value="5">Leia</button>
</div>
    <div class="conteudo"><p>Cap 6 - Ordenação de Vetores</p>
      <button name="submit" value="6">Leia</button>
</div>
    <div class="conteudo"><p>Cap 7 - Busca</p>
         <button name="submit" value="7">Leia</button>
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
</body>
</html>