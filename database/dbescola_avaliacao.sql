DROP DATABASE IF EXISTS dbescola;

CREATE DATABASE dbescola;

USE dbescola;

CREATE TABLE IF NOT EXISTS escolas (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    endereco VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS alunos (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    idade INT(2),
    endereco VARCHAR(50),
    escola_id INT(10) NOT NULL,
    FOREIGN KEY(escola_id) REFERENCES escolas(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS cursos (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    id_escola INT(11) NOT NULL,
    FOREIGN KEY(id_escola) REFERENCES escolas(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS  alunos_cursos(
    id_curso INT(11),
    id_aluno INT(11),
    nota FLOAT(2) DEFAULT 0,
    cadastrado TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id_aluno, id_curso),
    CONSTRAINT fk_alunoscursos_curso FOREIGN KEY (id_curso) REFERENCES cursos (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_alunoscursos_alunos FOREIGN KEY (id_aluno) REFERENCES alunos (id) ON DELETE CASCADE ON UPDATE CASCADE
);
