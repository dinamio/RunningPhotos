
 CREATE TABLE Race (
id int primary key auto_increment,
City varchar(50),
Race_Date date,
Race_Name varchar(50),
photo VARCHAR(250));

create table Role(
id int primary key auto_increment,
name VARCHAR(30)
);

create table User(
id int primary key auto_increment,
Login varchar(50),
Mail varchar(50),
Password varchar(30),
Name varchar(30),
Surname varchar(30),
City varchar (20),
Birthdate date,
Role_id int,
foreign key (Role_id) references Role(id),
);

create table RacePhoto(
id int primary key auto_increment,
mark bit,
Path varchar(150),
Author_id int,
foreign key (Author_id) references User(id)
on delete SET NULL,
Race_id int,
foreign key (Race_id) references Race(id)
);

create table NumberOnPhoto(
id int primary key auto_increment,
Number varchar(30),
RacePhoto_id int,
foreign key (RacePhoto_id) references RacePhoto(id)
);

