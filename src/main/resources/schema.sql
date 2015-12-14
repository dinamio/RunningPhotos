CREATE TABLE Role (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255));
create table User(
id int primary key auto_increment,
Login varchar(50),
Mail varchar(50),
Name varchar(20),
Surname varchar(30),
City varchar (20),
Birthdate date,
Role_id int,
foreign key (Role_id) references Role(id)
);