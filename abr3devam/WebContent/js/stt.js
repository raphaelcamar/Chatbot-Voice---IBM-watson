URL = window.URL || window.webkitURL;
var gumStream;
var rec;
var input;
var AudioContext = window.AudioContext || window.webkitAudioContext; // Classe
var audioContext; 
var btnRecord = document.querySelector("#recordButton");
var btnOpenChat = document.querySelector('.icon-chat');
var wrapperChat = document.querySelector('.chatbot');
var btnCloseChat = document.querySelector('.chatbot-close');

btnOpenChat.addEventListener('click', function() {
	wrapperChat.classList.add('is--active');
});

btnCloseChat.addEventListener('click', function() {
	wrapperChat.classList.remove('is--active');
});

function createAudioElement(blob, classe) {
	var url = URL.createObjectURL(blob);
	var audio = document.createElement("audio");
	var div = document.createElement("div");
	
	audio.controls = true;
	audio.src = url;
	
	div.classList.add(classe);
	div.appendChild(audio);
	var chat = document.querySelector(".chat-container");
	chat.appendChild(div);
	scrollDivDown(chat);
}

function scrollDivDown(div) {
	for (var i = 0; i < div.offsetHeight; i++) {
		div.scrollTop++;
	}
}

btnRecord.addEventListener("click", function(event) {
	event.preventDefault();
	
	if ( !event.currentTarget.classList.contains('is--recording') ) {
		constraints = {
				audio : true,
				video : false
		}
		
		navigator.mediaDevices.getUserMedia(constraints).then(function(stream) {
			audioContext = new AudioContext;
			gumStream = stream;
			input = audioContext.createMediaStreamSource(stream);
			rec = new Recorder(input, {
				numChannels : 1
			});
			rec.record();
		}).catch(function(err){
			console.log(err);
		});
		event.currentTarget.classList.add('is--recording');
	} else {
		event.currentTarget.classList.remove('is--recording');
		
		rec.stop();
		gumStream.getAudioTracks()[0].stop();
		rec.exportWAV(generateBlob);
	}
});

function generateBlob(blob) {
	createAudioElement(blob, 'pergunta');
	sendBlobToText(blob);
}

function sendBlobToText(blob) { 												
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "stt", true);
	xhr.setRequestHeader("Content-type", "audio/wav");
	

	xhr.addEventListener("load", function() {
		 if(xhr.status == 200) {
			 var resposta = JSON.parse(xhr.responseText);
			console.log(resposta)
		 	resposta[0].alternatives.forEach(function(transcript) {
				callBot(transcript.transcript)
			 });
			 
		 } else {
		 	console.log(xhr.status);
		 	console.log(xhr.responseText);
		 }
	});
	xhr.send(blob);
}
function sendMessageToVoice(msg) {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "tts", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
	
	xhr.addEventListener("load", function() {
		if(xhr.status == 200) {
			// Codigo de sucesso
			var blob = new Blob([xhr.response], {type : "audio/wav"});
			createAudioElement(blob, 'resposta');
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

function callBot(msg) {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "v1", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=utf-8");
	xhr.addEventListener("load", function() {
		if(xhr.status == 200) {
			var respostas = JSON.parse(xhr.responseText);
			respostas.forEach(function(resposta) {
				console.log(resposta);
				sendMessageToVoice(resposta)
			});
		}else{
			console.log(xhr.status);
			console.log(xhr.responseText);
		}
	});
	var data = "question=" + msg;
	xhr.send(data);
	console.log(data)
}
