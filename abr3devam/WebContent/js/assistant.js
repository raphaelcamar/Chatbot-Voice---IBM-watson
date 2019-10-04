

function scrollDivDown(div) {
	for (var i = 0; i < div.offsetHeight; i++) {
		div.scrollTop++;
	}
}

function createMessage(message, type) {
	var chat = document.querySelector(".chat-container");
	var div = createDiv(message, type);
	chat.appendChild(div);
	scrollDivDown(chat);
}

function createDiv(text, type) {
	var div = document.createElement("div");
	div.classList.add("chat");
	div.classList.add(type);
	div.textContent = text;
	return div;
}

//var btnSendQuestion = document.querySelector("#sendQuestion");
//btnSendQuestion.addEventListener("click", function(event) {
//	event.preventDefault();
//	var question = document.querySelector("#question");
//	createMessage(question.value, "me");
//	callBot(question.value);
//	question.value = "";
//});

function callBot(msg) {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "v1", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
	xhr.addEventListener("load", function() {
		if(xhr.status == 200) {
			// Codigo de sucesso
			var respostas = JSON.parse(xhr.responseText);
			respostas.forEach(function(resposta) {
				console.log(resposta);
				sendMessageToVoice(resposta)
			});
		}else{
			// Codigo de deu ruim!
			console.log(xhr.status);
			console.log(xhr.responseText);
		}
	});
	var data = "question=" + msg;
	xhr.send(data);
	console.log(data)
}

function sendMessageToVoice(msg) {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "tts", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
	xhr.addEventListener("load", function() {
		if(xhr.status == 200) {
			// Codigo de sucesso
			var blob = new Blob([xhr.response], {type : "audio/wav"});
			createAudioElement(blob);
			
		}else{
			// Codigo de deu ruim!
			console.log(xhr.status);
			console.log(xhr.responseText);
		}
	});
	xhr.responseType = 'blob';
	var data = "question=" + msg;
	xhr.send(data);
}

function createAudioElement(blob) {
	var url = URL.createObjectURL(blob);
	var audio = document.createElement("audio");
	var div = document.createElement("div");
	
	audio.controls = true;
	audio.src = url;
	
	div.appendChild(audio);
	var chat = document.querySelector(".chat-container");
	chat.appendChild(div);
	scrollDivDown(chat);
}













