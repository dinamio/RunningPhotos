 CREATE TABLE Race (
id int primary key auto_increment,
City varchar(50),
Race_Date date,
Race_Name varchar(50));

create table Role(
id int primary key auto_increment,
name varchar(30)
);

create table User(
id int primary key auto_increment,
Login varchar(50),
Mail varchar(50),
Name varchar(30),
Surname varchar(30),
City varchar (20),
Birthdate date,
Role_id int,
foreign key (Role_id) references Role(id)
);

create table RacePhoto(
id int primary key auto_increment,
Path varchar(150),
Author_id int,
foreign key (Author_id) references User(id),
Race_id int,
foreign key (Race_id) references Race(id)
);

CREATE TABLE Runner (
id int primary key auto_increment,
Name varchar(20),
Surname varchar(30),
User_id int,
foreign key (User_id)
references User(id)
on delete SET NULL
);

create table Runners_on_photo(
Runner_id int,
foreign key (Runner_id) references Runner(id),
Photo_id int,
foreign key (Photo_id) references RacePhoto(id)
);

create table Result (
Finish_time varchar(10),
Number varchar(30),
Place int,
Distance int,
Runner_id int,
foreign key (Runner_id) references Runner(id),
Race_id int ,
foreign key (Race_id) references Race(id)
);

 

