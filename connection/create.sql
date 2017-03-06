DROP SCHEMA IF exists celular;
CREATE DATABASE  IF NOT EXISTS  celular ;
USE  celular ;


CREATE TABLE  cliente  (
   cpf varchar(11) NOT NULL,
   nomeCli varchar(100) NOT NULL,
   telefone char(11) NOT NULL,
   email varchar(50) NOT NULL,
   
  PRIMARY KEY (cpf)
 
);


--
-- Table structure for table  material 
--
CREATE TABLE material (
   codMat varchar(11) NOT NULL,
   descricao varchar(100) NOT NULL,
   
  PRIMARY KEY (codMat)
 
);


--
-- Table structure for table  smartphone 
--
CREATE TABLE smartphone (
   codCelular varchar(11) NOT NULL,
   numSerie varchar(11) NOT NULL,
   marca varchar(11) NOT NULL,
   modelo varchar(20) NOT NULL,
   cor varchar(11) NOT NULL,
   cpf varchar(11) NOT NULL,
   
  PRIMARY KEY (codCelular),
  FOREIGN KEY (cpf) REFERENCES cliente (cpf)
	  ON DELETE CASCADE
	  ON UPDATE CASCADE
  
);


--
-- Table structure for table  reparo 
--
CREATE TABLE reparo (
   codCelular varchar(11) NOT NULL,
   dataExecutada date NOT NULL,
   dataUltimoConserto date,
   
  PRIMARY KEY (dataExecutada),
  FOREIGN KEY (codCelular) REFERENCES  smartphone  (codCelular)
	  ON DELETE CASCADE
	  ON UPDATE CASCADE
  
);


--
-- Table structure for table  material_reparo 
--
CREATE TABLE material_reparo (
   codCelular varchar(11) NOT NULL,
   dataExecutada date NOT NULL,
   codMat varchar(11) NOT NULL,
   quantidade int NOT NULL,
  
  PRIMARY KEY(codCelular, dataExecutada,codMat),
  FOREIGN KEY (codMat) REFERENCES  material (codMat)
	  ON DELETE CASCADE
	  ON UPDATE CASCADE
  
);