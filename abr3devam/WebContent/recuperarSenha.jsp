<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<link rel="shortcut icon" href="img/favicon.ico">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="style/recuperarSenha.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet">
    <title>Document</title>
</head>
<body>
    <div class="container">
                <p class="titulo">Digite a resposta colocada no seu cadastro</p>
                <form action="recuperarSenha" method="post">
                <label>Resposta de Segurança
                    <input type="text" name="filme" placeholder="Digite sua resposta de segurança">
                    </label>
                    <label>E-mail
                    <input type="email" name="email" placeholder="digite seu email">
                    </label>
                    <label>Nova senha
                    <input type="password" name="novaSenha" placeholder="Digite suanova senha"/>
                    </label>
                    <button class="check">Verificar</button>
                       <c:choose>
    	<c:when test="${valor != null }">
    		<p class="feedback">Senha mudada com sucesso! <a href="login.jsp">Voltar para login</a>
    	</c:when>
    </c:choose>
    <c:forEach var="erro" items="${erro }">
   <p class="erro">${erro }</p>
   </c:forEach>

                </form>
            </div>
 
</body>
</html>