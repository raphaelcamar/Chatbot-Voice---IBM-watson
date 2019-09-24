<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="style/cadastro.css">
    <title>Fiap-ON Cadastro</title>
</head>
<body>

    <div class="img">
        <img src="img/on.jpg" alt="" width="60%" height="40%">
    </div>
   <c:forEach var="erro" items="${erro }">
   <p>${erro }</p>
   
   </c:forEach>
    <div class="form">
        <form action="cadastrar" method="POST" name="formulario">
            <input type="text" name="nome"  class="input" placeholder="Digite seu nome" />
            <input type="text" name="sobrenome"  class="input" placeholder="Digite seu segundo nome" />
            <input type="email" name="email"  class="input" placeholder="Digite seu Email" />
            <input type="text" name="rm"  class="input" placeholder="Digite seu RM" />
            <input type="password" name="senha" class="input" placeholder="Digite sua senha"/>
            <p class="question">Qual � seu filme favorito?</p>
            <input type="text" name="rSeguranca"  class="input" placeholder="Resposta da Pergunta" />
            <button class="botao">Login</button>
        </form>
    </div>
    <!-- <script src="script/login.js"></script> -->
    
</body>
</html>