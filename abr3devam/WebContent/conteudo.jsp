<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>

		<link rel="shortcut icon" href="img/favicon.ico">
		<meta charset="utf-8">
		<title>Conceito Startup</title>
		<link rel="stylesheet" href="style/portPdf.css">
</head>
<c:choose>
	<c:when test="${logado != null }">
<body>
	<div class="iframe">
		<iframe src="startup.pdf" width="100%" height="100%"> </iframe>
	</div>

	<div class="icon-chat">
		<img src="img/Beta.png" width="120px" class="beta">
	</div>

	<div class="chatbot">
		<span class="chatbot-close">X</span>
		<div class="chat-container"></div>

		<div class="controls">
			<button id="recordButton">
				<span class="record"> <svg xmlns="http://www.w3.org/2000/svg"
						xmlns:sketch="http://www.bohemiancoding.com/sketch/ns"
						xmlns:xlink="http://www.w3.org/1999/xlink" height="16px"
						version="1.1" viewBox="0 0 16 16" width="16px">
						<title /><defs />
						<g fill="none" fill-rule="evenodd" id="Icons with numbers"
							stroke="none" stroke-width="1">
						<g fill="#000000" id="Group"
							transform="translate(-720.000000, -48.000000)">
						<path
							d="M733,54 L733,57 C733,59 731,61 729,61 L729,63 L732,63 L732,64 L725,64 L725,63 L728,63 L728,61 C726,61 724,59 724,57 L724,54 L725,54 L725,57 C725,58.5 726.5,60 728,60 L729,60 C730.5,60 732,58.5 732,57 L732,54 Z M728.004882,48 L728.995118,48 C730.1061,48 731,48.8918564 731,49.992017 L731,57.007983 C731,58.0998238 730.102384,59 728.995118,59 L728.004882,59 C726.8939,59 726,58.1081436 726,57.007983 L726,49.992017 C726,48.9001762 726.897616,48 728.004882,48 Z M728.004882,48"
							id="Shape" /></g></g></svg>
				</span> <span class="stop"> <svg xmlns="http://www.w3.org/2000/svg"
						xmlns:xlink="http://www.w3.org/1999/xlink"
						enable-background="new 0 0 512 512" height="24px" id="Layer_1"
						version="1.1" viewBox="0 0 512 512" width="24px"
						xml:space="preserve">
						<path
							d="M256,512C114.625,512,0,397.375,0,256C0,114.609,114.625,0,256,0s256,114.609,256,256C512,397.375,397.375,512,256,512z   M256,64C149.969,64,64,149.969,64,256s85.969,192,192,192c106.03,0,192-85.969,192-192S362.031,64,256,64z M192,192h128v128H192  V192z" /></svg>
				</span>
			</button>
		</div>
	</div>
	<script type="text/javascript" src="js/recorder.js"></script>
	<script type="text/javascript" src="js/assistant.js"></script>
	<script type="text/javascript" src="js/tts.js"></script>
	<script type="text/javascript" src="js/stt.js"></script>
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