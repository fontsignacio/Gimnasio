CREATE DATABASE gimnasio;

USE gimnasio;

CREATE TABLE cliente(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(100) NOT NULL,
	actividad VARCHAR(100) NOT NULL,
	id_est INT DEFAULT NULL, 
	estado VARCHAR(100) DEFAULT NULL
	 
);

SELECT * FROM cliente;

insert INTO cliente VALUES (1,"Ignacio","Musculacion",NULL,NULL);


ALTER TABLE cliente
modify COLUMN Fecha Date NOT NULL DEFAULT GETDATE(); 

