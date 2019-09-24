var botao = document.querySelector(".botao");
var inNome = document.querySelector(".input2");
var inSenha = document.querySelector(".input3");

inNome.addEventListener("input" , function(ev) {
    
	if ( this.value.length === 5 ) {
		this.classList.add('valid');
    } else if ( this.value.length < 6 ) {
    	this.classList.remove('valid');
    } else if ( that.value.length > 6 ) {
    	var myInput = document.querySelector(".input2");
    	
    	this.value = this.value.slice(0,6);
    }
});

inSenha.addEventListener("input" , function(ev) {
    
	if ( this.value.length === 6 ) {
		this.classList.add('valid');
    } else {
    	this.classList.remove('valid');
    }
});
