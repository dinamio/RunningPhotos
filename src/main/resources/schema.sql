
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

CREATE TABLE Runner (
id int primary key auto_increment,
Name varchar(20),
Surname varchar(30),
Sex VARCHAR (20),
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
runner_id int,
foreign key (Role_id) references Role(id),
foreign key (runner_id) references Runner(id)
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

create table Runners_on_photo(
Runner_id int,
foreign key (Runner_id) references Runner(id),
Photo_id int,
foreign key (Photo_id) references RacePhoto(id) on delete CASCADE
);

create table Distance (
id int primary key auto_increment,
Name varchar(30),
Length DECIMAL(5,2)
);

create table Result (
id int primary key auto_increment,
Finish_time varchar(10),
Number varchar(30),
Distance_id int,
foreign key (Distance_id) references Distance(id),
Runner_id int,
foreign key (Runner_id) references Runner(id),
Race_id int ,
foreign key (Race_id) references Race(id)
);

create table NumberOnPhoto(
id int primary key auto_increment,
Number varchar(30),
RacePhoto_id int,
foreign key (RacePhoto_id) references RacePhoto(id)
);

