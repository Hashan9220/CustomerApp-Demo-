DROP DATABASE IF EXISTS customerApp;
CREATE DATABASE IF NOT EXISTS customerApp;
USE customerApp;

CREATE TABLE customer(
cutomer_id VARCHAR(10)PRIMARY KEY,
name VARCHAR(30)NOT NULL,
contact VARCHAR(20)NOT NULL,
email VARCHAR(30)NOT NULL,
address VARCHAR(60)NOT NULL
);