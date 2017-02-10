CREATE DATABASE agenda;

use agenda;

CREATE TABLE usuarios
(nombre VARCHAR(25) PRIMARY KEY,
password VARCHAR(25));

INSERT INTO usuarios VALUES ('jorge', 'passw');

CREATE TABLE contactos
(id_persona INT(99) PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(25),
apellidos VARCHAR(40),
dni CHAR(9),
telefono CHAR(9),
fecha CHAR(10),
nombre_usuario VARCHAR(25),
CONSTRAINT fk_usuario FOREIGN KEY (nombre_usuario)
  REFERENCES usuarios(nombre));
 
INSERT INTO contactos(nombre, apellidos, dni, telefono, fecha, nombre_usuario) VALUES ('Jose', 'Gomez', '00000000A', '910000000', '10/09/1990', 'jorge');
INSERT INTO contactos(nombre, apellidos, dni, telefono, fecha, nombre_usuario) VALUES ('Lara', 'Bueno', '00000000B', '910000001', '01/04/1968',  'jorge');
INSERT INTO contactos( nombre, apellidos, dni, telefono, fecha, nombre_usuario) VALUES ('Paco', 'Ruiz', '00000000C', '910000002', '23/02/1999', 'jorge');

