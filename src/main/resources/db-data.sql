INSERT INTO role (name) VALUES ('Photographer')
INSERT INTO role (name) VALUES ('Runner')
INSERT INTO role (name) VALUES ('Operator')
INSERT INTO role (name) VALUES ('Admin')
Insert into user (login,password,role_id) values('admin','admin',4)
Insert into user (login,password,role_id) values('operator','operator',3)
Insert into user (login,password,role_id) values('photographer','photographer',1)
INSERT INTO user (login,mail,name,surname,city,birthdate,role_id) VALUES ('antoni94','antoxa@ukr.net','Anton','Ivanchenko','Kiev','1995-10-10',2)
INSERT INTO user (login,mail,name,surname,city,birthdate,role_id) VALUES ('dandy','olyA@mail.ru','Olya','Pilipenko','Kharkiv','1991-02-01',2)
INSERT INTO user (login,mail,name,surname,city,birthdate,role_id,password) VALUES ('pathOf','olyA@mail.ru','Olya','Pilipenko','Kharkiv','1991-02-01',2,'ilai1111')
INSERT INTO Race (city,race_date,race_name,photo) values ('Харьков','2015-01-01','Любительский Забег','img_14.jpeg')
INSERT INTO Race (city,race_date,race_name,photo) values ('Киев','2016-05-05','Новогодний Марафон','img_145.jpeg')
INSERT INTO Race (city,race_date,race_name,photo) values ('Запорожье','2016-02-07','Веселые старты','img_1.jpeg')
INSERT INTO Race (city,race_date,race_name,photo) values ('Винница','2016-06-09','Грустный фининш','img_12.jpeg')
Insert into user (login,password,role_id) values('runner','runner',2)
INSERT INTO user (login,mail,name,surname,city,birthdate,role_id,password) VALUES ('login','olyA@mail.ru','Olya','Pilipenko','Kharkiv','1991-02-01',2,'password')


