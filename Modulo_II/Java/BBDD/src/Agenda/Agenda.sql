CREATE DATABASE agenda;

CREATE TABLE personas
(nombre VARCHAR(25),
 apellidos VARCHAR(25),
 dni CHAR(9) PRIMARY KEY,
 telefono CHAR(9),
 dia CHAR(2),
 mes CHAR(2),
 anio CHAR(4));

