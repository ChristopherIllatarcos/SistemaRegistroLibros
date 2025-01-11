CREATE DATABASE IF NOT EXISTS bd_registroLibros;
USE bd_registroLibros;

-- tabla para registrar los autores
CREATE TABLE tb_autores(
id_autor INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
apellido VARCHAR(100) NOT NULL,
nacionalidad VARCHAR(100)
);



-- tabla para registrar los generos 
CREATE TABLE tb_generos(
id_genero INT AUTO_INCREMENT PRIMARY KEY,
nombre_genero VARCHAR(100) NOT NULL UNIQUE
);


-- tabla para registrar editoriales
CREATE TABLE tb_editoriales(
id_editorial INT AUTO_INCREMENT PRIMARY KEY,
nombre_editorial VARCHAR(100) NOT NULL UNIQUE
);



-- tabla para registrar los libros
CREATE TABLE tb_libros(
id_libro INT AUTO_INCREMENT PRIMARY KEY,
titulo VARCHAR(200) NOT NULL,
id_autor INT NOT NULL,
id_genero INT NOT NULL, 
id_editorial INT NOT NULL,
fecha DATE, 
numero_paginas INT,
FOREIGN KEY (id_autor) REFERENCES tb_autores(id_autor),
FOREIGN KEY (id_genero) REFERENCES tb_generos(id_genero),
FOREIGN KEY (id_editorial) REFERENCES tb_editoriales(id_editorial)
);


