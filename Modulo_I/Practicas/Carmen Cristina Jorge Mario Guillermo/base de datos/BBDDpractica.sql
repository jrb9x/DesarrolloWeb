

CREATE DATABASE CCOO;
USE CCOO;


CREATE TABLE delegados
(idDelegado INT PRIMARY KEY AUTO_INCREMENT,
 usuario VARCHAR(25),
 password VARCHAR(16),
 nombre VARCHAR(25),
 apellidos VARCHAR(25));

CREATE TABLE solicitudDelegados
(idSolicitud INT PRIMARY KEY AUTO_INCREMENT,
 nombre VARCHAR(25),
 apellidos VARCHAR(50),
 telefono CHAR(9),
 email VARCHAR(254),
 razon TEXT);

CREATE TABLE noticias
(idNoticia INT PRIMARY KEY AUTO_INCREMENT,
 titulo VARCHAR(240),
 subtitulo TEXT,
 cuerpo TEXT,
 imagen VARCHAR(250),
 pieImagen varchar(150),
 imagenMiniatura VARCHAR(250),
 fechaCreacion DATE,
 fechaModificaion DATETIME);

CREATE TABLE eventos
(idEvento INT PRIMARY KEY AUTO_INCREMENT,
 tipo VARCHAR(20),
 fechaInicio DATE,
 hora VARCHAR(5),
 fechaFin DATE,
 duracion VARCHAR(5),
 lugar VARCHAR(100),
 descripcion TEXT,
 cupo INT,
 fechaModificacion DATETIME);

CREATE TABLE inscripciones
(idInscripcion INT PRIMARY KEY AUTO_INCREMENT,
 id_evento INT,
 nombre VARCHAR(25),
 apellido VARCHAR(50),
 email VARCHAR(254),
 telefono CHAR(9),
 CONSTRAINT FK_idEvento FOREIGN KEY(id_evento)
 REFERENCES eventos (idEvento)
 ON UPDATE CASCADE
 ON DELETE RESTRICT);

CREATE TABLE documentacion
(idDocumentacion INT PRIMARY KEY AUTO_INCREMENT,
 titulo VARCHAR(250),
 descripcion VARCHAR(254),
 fechaPublicacion DATE,
 archivo VARCHAR(250),
 privado BOOLEAN,
 ley BOOLEAN,
 fechaModificacion DATETIME);

CREATE TABLE album
(idAlbum INT PRIMARY KEY AUTO_INCREMENT,
 titulo VARCHAR(150),
 arrayMultimedia VARCHAR(254),
 imagenes BOOLEAN,
 fechaModificacion DATETIME);

CREATE TABLE multimedia
(idMultimedia INT PRIMARY KEY AUTO_INCREMENT,
 fuente VARCHAR(254),
 imagen BOOLEAN,
 titulo VARCHAR(150),
 id_album INT,
 fechaModificacion DATETIME,
 CONSTRAINT FK_idAlbum FOREIGN KEY (id_album)
 REFERENCES album (idAlbum)
 ON UPDATE CASCADE
 ON DELETE RESTRICT);
 