CREATE TABLE User (
id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(100) NOT NULL,
last_name VARCHAR(100) NOT NULL,
email VARCHAR(50),
username VARCHAR(100),
password VARCHAR(100),
date_created TIMESTAMP,
date_updated TIMESTAMP,
current_city  VARCHAR(100),
profession VARCHAR(100),
gender VARCHAR(1),
company_name VARCHAR(50),
UNIQUE (username)
)ENGINE=InnoDB;

insert into test.User (first_name,last_name,email,username,password,date_created,date_updated,current_city,profession,gender,company_name) values
( "Allyn","Smith","allyn@gmail.com","allyn","password",NOW(),NOW(),"Los angeles","Software Engineer","M","MGO");

insert into test.User (first_name,last_name,email,username,password,date_created,date_updated,current_city,profession,gender,company_name) values
( "John","Smith","john@gmail.com","john","password",NOW(),NOW(),"NewYork","Software Engineer","M","Hulu");


insert into test.User (first_name,last_name,email,username,password,date_created,date_updated,current_city,profession,gender,company_name) values
( "Keanu","Smith","keanu@gmail.com","keanu","password",NOW(),NOW(),"CulverCity","Software Engineer","M","NBC Studios");


insert into test.User (first_name,last_name,email,username,password,date_created,date_updated,current_city,profession,gender,company_name) values
( "David","Tinsley","david@gmail.com","david","password",NOW(),NOW(),"Westwood","Software Engineer","M","Netflix");
