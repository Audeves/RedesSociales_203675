CREATE SCHEMA redes_sociales;

USE redes_sociales;

CREATE TABLE plataforma (
id INT,
nombre VARCHAR(30),
url VARCHAR(50),
fecha_inicio DATE,
PRIMARY KEY (id)
);

CREATE TABLE usuario (
id INT,
nombre VARCHAR(30),
correo VARCHAR(50),
sexo VARCHAR(1),
fecha_nacimiento DATE,
edad INT,
PRIMARY KEY (id)
);

CREATE TABLE registro (
id_plataforma INT,
id_usuario INT,
fecha_registro DATE,
pseudonimo VARCHAR(25),
PRIMARY KEY (id_plataforma, id_usuario),
FOREIGN KEY (id_plataforma) REFERENCES plataforma(id) ON DELETE CASCADE,
FOREIGN KEY (id_usuario) REFERENCES usuario(id) ON DELETE CASCADE
);