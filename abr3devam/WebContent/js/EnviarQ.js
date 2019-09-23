window.onload = function(){
    callbot("")
}
function scrollDiv(div){
    for (var i = 0; i < div.offsetHeight; i++) {
       div.scrollTop++;
    }
}
function criarDiv(texto, tipo){
    var div = document.createElement("div")
    div.classList.add("chat")  // apenas para estilização do balão de fala
    div.classList.add(tipo)
    div.textContent = texto
    return div
}
function criarMensagem(mensagem, tipo){
   var chat = docuemnt.querySelector("#chat")
    var div = createDiv(mensagem, tipo)
    chat.appendChild(div)
    scrollDiv(chat)
}

var enviarQ = document.querySelector("#enviarQ")
enviarQ.addEventListener("click", function(event){
event.preventDefault()
var question = document.querySelector("#pergunta")
criarMensagem(question.nodeValue, "me")
callbot(question, value)
quesrion.value = ""
})
function callBot(msg){
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "assistant", true)
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
    xhr.addEventListener("load", function(){
        if(xhr.status == 200){
            //Youu win
        }else{
            //you lose
            console.log(xhr.status);
            console.log(xhr.responseText)
        }
    })
    var data = "question=" + msg;
    xhr.send(data)
}