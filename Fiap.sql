drop table CHATBOT_RESPOSTA_SEG;
drop table CHATBOT_ALUNO;
drop table RESPOSTA_SEGURANCA;


create table CHATBOT_ALUNO(
ID_ALUNO integer primary key,
NOME varchar(30),
SOBRENOME varchar(40),
SENHA varchar(6),
RM varchar(5) unique,
EMAIL varchar (30) unique);

create sequence ID_ALUNO_SEQ
increment by 1
start with 1;

create sequence RESP_SEG_SEQ
increment by 1
start with 1;

create sequence ID_ALUNO_RESP_SEQ
increment by 1
start with 1;

create table CHATBOT_RESPOSTA_SEG(
ID_RESPOSTA_SEGURANCA integer primary key,
RESPOSTA_SEGURANCA varchar (50),
ID_ALUNO integer references CHATBOT_ALUNO(ID_ALUNO));