<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
   <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans&display=swap" rel="stylesheet">
      <link href="https://fonts.googleapis.com/css?family=Nunito:900&display=swap" rel="stylesheet">
      <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed&display=swap" rel="stylesheet">
      <link rel="stylesheet" type="text/css" href="style/index.css">
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
      <meta http-equiv="X-UA-Compatible" content="ie=edge">
      <title>Fiap EAD</title>
   </head>
   <body>
      <header>
         <p id="nome">Ol� <%= session.getAttribute("nomeAluno") %>!</p>
              <p class="opcao"><a href="https://www2.fiap.com.br/"> Portal do aluno</a>   </p>
              <p class="opcao"><a href="">Sair</a></p>
      </header>
      <h1>Nivelamento</h1>
      <div class="card-deck">
         <div class="card">
            <img src="img/algoritmo.jpg" class="card-img-top " alt="...">
            <div class="card-body">
               <h5 class="card-title">Algoritimo   </h5>
               <p class="card-text">EAD focado em ajudar oferecer apoio � mat�ria de algoritmo</p>
               <p class="botao"><a href="#">Conteudo</a></p>
            </div>
         </div>
         <div class="card">
            <img src="img/portugues.jpg" class="card-img-top" alt="...">
            <div class="card-body">
               <h5 class="card-title">Portugues</h5>
               <p class="card-text">EAD focado em passar conhecimentos de neg�cio</p>
               <p class="botao"><a href="#">Conteudo</a></p>
            </div>
         </div>
         <div class="card">
            <img src="img/mat.jpg"class="card-img-top" alt="...">
            <div class="card-body">
               <h5 class="card-title">Matematica</h5>
               <p class="card-text">EAD focado em fortalecer alguns conceitos matem�ticos</p>
               <p class="botao"><a href="#">Conteudo</a></p>
            </div>
         </div>
      </div>
      <section class="chatbot">
         <div class="chat"></div>
         <input type="text" name="pergunta" id="pergunta" class="pergunta" placeholder="Tire sua d�vidas aqui!">
         <div class="control">
            <button id="enviarQ">Enviar</button>
            <button id="enviarVoz">Enviar voz</button>
            <button id="gravar">Gravar voz</button>
            <button id="pausar" disabled>Pausar voz</button>
            <button id="parar" disabled>Parar de gravar</button>
         </div>
         </section>
      <script src="script/EnviarQ.js"></script>
   </body>
</html>