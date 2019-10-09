drop table CHATBOT_RESPOSTA_SEG;
drop table CHATBOT_ALUNO;
drop sequence RESP_SEG_SEQ;
drop sequence ID_ALUNO_SEQ;
drop sequence ID_ALUNO_RESP_SEQ;

create table CHATBOT_ALUNO(
ID_ALUNO integer primary key,
NOME varchar2(255),
SOBRENOME varchar2(255),
SENHA varchar2(255),
RM varchar2(255) unique,
EMAIL varchar2(255) unique);

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
RESPOSTA_SEGURANCA varchar2(255),
ID_ALUNO integer references CHATBOT_ALUNO(ID_ALUNO));