var botao = document.querySelector(".botao");
var inNome = document.querySelector(".input2");
var inSenha = document.querySelector(".input3");
var check;
botao.disabled = true;

inNome.addEventListener("input" , function(ev) {
    
	if (this.value.length === 5 ) {
		this.classList.add('valid');
    } else if ( this.value.length < 6 ) {
    	this.classList.remove('valid');
    } check = this.classList.contains('valid') ? true : false;
});

inSenha.addEventListener("input" , function(ev) {
    
	if ( this.value.length >= 6 & this.value.length <=20 && check) {
		this.classList.add('valid');
		botao.classList.add('botao2')
		botao.disabled = false;
    } else {
		this.classList.remove('valid');
		botao.classList.remove('botao2')
		botao.disabled = true;
    }
});