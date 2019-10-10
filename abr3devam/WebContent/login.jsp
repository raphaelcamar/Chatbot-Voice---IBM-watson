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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="style/login.css">
    <title>Fiap-ON login</title>
</head>

<body>

    <div class="form">
	    
	    <div class="img">
	        <img src="img/on.jpg" alt="On">
	    </div>
	    <div class="form-bg"> 
		    <form action="logar" method="POST" name="formulario">
	            <input type="number" name="rm"  class="input input2" placeholder="&#xf007; RM" required />
	            <input type="password" name="senha" class="input input3" placeholder="&#xf023; Digite sua senha" required/>
	            <c:choose>
		<c:when test="${not empty erroLogin}">
		 <p class="invalid-user">Usuário ou senha inválidos!</p>
		</c:when>
		</c:choose>
	            <button class="botao">Login</button>
	        </form>
	        <p> Não possui uma conta?<a href="cadastro.jsp"> Cadastre-se</a></p>
	        <p>Esqueceu sua senha? <a href="recuperarSenha.jsp"> Clique aqui</a></p>
	    </div>
    </div>
    <script src="js/login.js"></script>
</body>
</body>
</html>