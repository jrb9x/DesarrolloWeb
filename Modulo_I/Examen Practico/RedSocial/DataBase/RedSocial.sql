CREATE DATABASE REDSOCIAL;
USE REDSOCIAL;

CREATE TABLE usuarios
(nombre VARCHAR(25) PRIMARY KEY,
password VARCHAR(20),
imagen VARCHAR(45),
estado TEXT);
 
 CREATE TABLE seguidos
 (usuario VARCHAR(25),
 usuario_seguido VARCHAR(25),
 CONSTRAINT pk_seguidos PRIMARY KEY(usuario, usuario_seguido),
 
 CONSTRAINT FK_idusuario FOREIGN KEY (usuario)
	REFERENCES usuarios (nombre)
	ON UPDATE CASCADE
	ON DELETE RESTRICT,
	
CONSTRAINT FK_idusuarioSeguido FOREIGN KEY (usuario_seguido)
	REFERENCES usuarios (nombre)
	ON UPDATE CASCADE
	ON DELETE CASCADE);
	
INSERT INTO usuarios VALUES("Paco", "passw", "", "");
INSERT INTO usuarios VALUES("Pepe", "passw", "", "");
INSERT INTO usuarios VALUES("Maria", "passw", "", "");
INSERT INTO usuarios VALUES("Laura", "passw", "", "");
INSERT INTO usuarios VALUES("Jose", "passw", "", "");

INSERT INTO seguidos VALUES("Paco", "Pepe");
INSERT INTO seguidos VALUES("Paco", "Maria");
INSERT INTO seguidos VALUES("Paco", "Laura");
INSERT INTO seguidos VALUES("Paco", "Jose");