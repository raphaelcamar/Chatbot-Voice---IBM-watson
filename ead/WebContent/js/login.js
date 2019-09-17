var botao = document.querySelector(".botao");
var inNome = document.querySelector(".input2");
var inSenha = document.querySelector(".input3");
botao.disabled = true;
var cont;
var cont2;

inNome.addEventListener("input" , function(){
        inNome.classList.add('nomeL');
        cont = 1;
            inSenha.addEventListener("input" , function(){
                inSenha.classList.add('nomeL');
                    cont2 = 1;
                    if(cont == 1 && cont2 == 1){
                        botao.classList.add('botao2');
                        botao.classList.remove('botao');
                        botao.disabled = false;
                 }else{
                        
          }
    });
});





