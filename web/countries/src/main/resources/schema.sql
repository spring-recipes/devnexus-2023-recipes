CREATE TABLE IF NOT EXISTS Country (
   id INT AUTO_INCREMENT,
   name varchar(250) NOT NULL,
   emoji varchar(100),
   currency varchar(100),
   code varchar(100),
   capital varchar(100),
   PRIMARY KEY (id)
);