<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="style/recuperarSenha.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet">
    <title>Document</title>
</head>
<body>
    <div class="container">
                <p>Digite a resposta colocada no seu cadastro</p>
                <form action="#" method="post">
                    <input type="text" name="filme" placeholder="Digite sua resposta de segurança">
                    <input type="email" name="email" placeholder="digite seu email">
                    <button class="check">Verificar</button>
                </form>
            </div>
    <c:choose>
    	<c:when test="${valor != null }">
    		<p>Cadastrado com sucesso! <a href="login.jsp">Voltar para login</a>
    	</c:when>
    </c:choose>
    <c:forEach var="erro" items="${erro }">
   <p>${erro }</p>
   
   </c:forEach>
</body>
</html>