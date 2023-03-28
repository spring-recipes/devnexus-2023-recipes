-- noinspection SqlNoDataSourceInspectionForFile

-- noinspection SqlDialectInspectionForFile

DROP TABLE IF EXISTS coffee;

CREATE TABLE coffee(
    id SERIAL NOT NULL PRIMARY KEY,
    name varchar(255) NOT NULL,
    size varchar(15) NOT NULL
);

-- INSERT INTO coffee(name,size) VALUES('Caffè Americano','GRANDE');
-- INSERT INTO coffee(name,size) VALUES('Caffè Latte','VENTI');
-- INSERT INTO coffee(name,size) VALUES('Caffè Caramel Macchiato','TALL');