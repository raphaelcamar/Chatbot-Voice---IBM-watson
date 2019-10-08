drop table CHATBOT_RESPOSTA_SEG;
drop table CHATBOT_ALUNO;
drop sequence RESP_SEG_SEQ;
drop sequence ID_ALUNO_SEQ;

create table CHATBOT_ALUNO(
ID_ALUNO integer primary key,
NOME varchar(255),
SOBRENOME varchar(255),
SENHA varchar(255),
RM varchar(255) unique,
EMAIL varchar (255) unique);

create sequence ID_ALUNO_SEQ
increment by 1
start with 1;

create sequence RESP_SEG_SEQ
increment by 1
start with 1;

create table CHATBOT_RESPOSTA_SEG(
ID_RESPOSTA_SEGURANCA integer primary key,
RESPOSTA_SEGURANCA varchar (255),
ID_ALUNO integer references CHATBOT_ALUNO(ID_ALUNO));