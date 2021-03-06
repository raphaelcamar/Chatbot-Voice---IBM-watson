<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<link rel="shortcut icon" href="img/favicon.ico">
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
   
   <h1>Cadastro</h1>
   <section class="container">
   <div class="form">
        <form action="cadastrar" method="POST" name="formulario">
            <label>Nome:
            <input type="text" name="nome"  class="input" placeholder="nome" required />
        </label>
        <label>Sobrenome:
            <input type="text" name="sobrenome"  class="input" placeholder="segundo nome" required />
        </label>
        <label>E-mail:
            <input type="email" name="email"  class="input" placeholder="Email" required />
        </label>
        <label>RM:
            <input type="text" name="rm"  class="input" placeholder="RM" required/>
        </label>
        <label>Senha:
            <input type="password" name="senha" class="input" placeholder="senha"required/>
        </label>
            <label> <p class="question">Qual é o seu filme favorito?</p>
            <input type="text" name="rSeguranca"  class="input" placeholder="Resposta da Pergunta" required/>
        </label>
         <c:forEach var="erro" items="${erro }">
   <p class="invalid-fill">${erro }</p>
   		</c:forEach> 
            <button class="botao">Cadastre-se</button>
        </form>
    </div>
</section>
     <script src="script/login.js"></script> 
    <script src="js/cadastro.html"></script>
</body>
</html>