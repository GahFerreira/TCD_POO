create database biblioteca;
use biblioteca;

create table cliente(
id INT(10) AUTO_INCREMENT,
nome varchar(255),
cpf varchar(255),
endereco varchar(255),
sexo varchar(255),
telefone varchar(255),
primary key(id)
);

create table vendedor(
id INTEGER(10) AUTO_INCREMENT,
nome varchar(255),
cpf varchar(255),
sexo varchar(255),
telefone varchar(255),
usuario varchar(255) not null unique,
senha varchar(255),
primary key(id)
);

create table gerente(
id INTEGER AUTO_INCREMENT,
nome varchar(255),
cpf varchar(255),
sexo varchar(255),
telefone varchar(255),
usuario varchar(255) not null unique,
senha varchar(255),
primary key(id)
);

create table quadrinho(
id INTEGER AUTO_INCREMENT,
isbn varchar(255),
titulo varchar(255),
autor varchar(255),
editora varchar(255),
categoria varchar(255),
volume integer,
primary key(id)
);

create table venda(
id INTEGER AUTO_INCREMENT,
datacompra date,
valor double,
primary key(id)
);

create table emprestimo(
id integer auto_increment,
dtemprestimo date,
dtdevolucao date,
multa double,
status boolean,
primary key(id)
);

use biblioteca;
show tables;

select * from emprestimo;


ALTER TABLE venda MODIFY datacompra date;

desc venda;

INSERT INTO venda(valor) VALUES(286.2616);

select * from venda where valor=286.2616;
INSERT INTO venda(datacompra,valor) VALUES('20/12/16',286.2616);
select * from quadrinho;

create table usuario(
id INTEGER AUTO_INCREMENT,
nome varchar(255),
cpf varchar(255),
sexo varchar(255),
telefone varchar(255),
usuario varchar(255) not null unique,
senha varchar(255),
gerente boolean,
primary key(id)
);

show tables;

select * from emprestimo;
select * from usuario;
select * from Quadrinho;
select * from Venda;
select * from emprestimo;

