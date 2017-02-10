CREATE DATABASE profesorexamen;

USE profesorexamen;

CREATE TABLE usuarios(
	nombre VARCHAR(30)PRIMARY KEY,
	password VARCHAR(30),
	estado VARCHAR(250),
	imagen VARCHAR(250)
);

CREATE TABLE seguir(
	seguidor VARCHAR(30),
	usuario VARCHAR(30),
	CONSTRAINT pk_seguir PRIMARY KEY(usuario,seguidor),
	
	CONSTRAINT fk_id_seguidor FOREIGN KEY(seguidor)
	REFERENCES usuarios(nombre)
	ON DELETE CASCADE
	ON UPDATE CASCADE,
	
	CONSTRAINT fk_id_usuario FOREIGN KEY(usuario)
	REFERENCES usuarios(nombre)
	ON DELETE CASCADE
	ON UPDATE CASCADE	
);

INSERT INTO usuarios VALUES("Paco", "pass", "Hola que ase paco", "./Perfiles/imagenPaco.png");
INSERT INTO usuarios VALUES("Pepe", "pass", "Hola que ase pepe", "./Perfiles/imagenPaco.png");
INSERT INTO usuarios VALUES("Juan", "pass", "Hola que ase juan", "./Perfiles/imagenPaco.png");
INSERT INTO usuarios VALUES("Maria", "pass", "Hola que ase maria", "./Perfiles/imagenPaco.png");
INSERT INTO usuarios VALUES("Carolina", "pass", "Hola que ase carol", "./Perfiles/imagenPaco.png");

INSERT INTO seguir VALUES("Paco","Pepe");
INSERT INTO seguir VALUES("Paco","Juan");
INSERT INTO seguir VALUES("Paco","Maria");
INSERT INTO seguir VALUES("Paco","Carolina");