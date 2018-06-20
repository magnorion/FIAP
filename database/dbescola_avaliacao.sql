USE dbescola;

CREATE DATABASE dbescola;

CREATE TABLE IF NOT EXISTS alunos (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    idade INT(2),
    endereco VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS escolas (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    endereco VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS cursos (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50),
    id_escola INT(11) NOT NULL,
    FOREIGN KEY(id_escola) REFERENCES escolas(id)
);

CREATE TABLE IF NOT EXISTS  alunos_cursos(
	id_escola INT(11) NOT NULL,
    id_curso INT(11) NOT NULL,
    id_aluno INT(11) NOT NULL,
    nota FLOAT(3) NOT NULL,
    FOREIGN KEY(id_escola) REFERENCES escolas(id),
    FOREIGN KEY(id_curso) REFERENCES cursos(id),
    FOREIGN KEY(id_aluno) REFERENCES alunos(id)
);
