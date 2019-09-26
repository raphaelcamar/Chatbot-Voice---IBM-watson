<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recuperar senha</title>
</head>
<body>
    <p>Digite a resposta colocada no seu cadastro</p>
    <form action="recuperarSenha" method="post">
        <input type="text" name="filme" placeholder="Digite sua resposta de segurança">
        <input type="email" name="email" placeholder="digite seu email">
        <button>Verificar</button>
    </form>
</body>
</html>