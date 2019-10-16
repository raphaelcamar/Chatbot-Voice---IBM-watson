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
        <p>Matemática</p>
        <p><a href="index.jsp">Fiap EAD</a></p>
        <p><a href="logout">Sair</a></p>
    </header>
        <p class="list">Lista de conteúdos</p>
        
        <form action="conteudo" method="post">
    <div class="container">
        <div class="conteudo"><p>Cap 1 - Revisão de funções</p>
       <button name="submit" value="21">Leia</button>
</div>
    <div class="conteudo"><p>Cap 2 - Funções e suas aplicações exponenciais</p>
       <button name="submit" value="22">Leia</button>
            </div>
    <div class="conteudo"><p>Cap 3 - Limite e suas aplicações</p>
        <button name="submit" value="23">Leia</button>
</div>
    <div class="conteudo"><p>Cap 4 - Derivadas - Parte 1</p>
       <button name="submit" value="24">Leia</button>
</div>
    <div class="conteudo"><p>Cap 4 - Derivadas - Parte 2</p>
        <button name="submit" value="25">Leia</button>
</div>
    <div class="conteudo"><p>Cap 5 - Integrais</p>
      <button name="submit" value="26">Leia</button>
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