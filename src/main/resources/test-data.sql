INSERT INTO role (name) VALUES ('Photographer')
INSERT INTO role (name) VALUES ('Runner')
INSERT INTO user (login,mail,name,surname,city,birthdate,role_id) VALUES ('antoni94','antoxa@ukr.net','Anton','Ivanchenko','Kiev','1995-10-10',2)
INSERT INTO user (login,mail,name,surname,city,birthdate,role_id) VALUES ('olya01','olyA@mail.ru','Olya','Pilipenko','Kharkiv','1991-02-01',2)
INSERT INTO Race (city,race_date,race_name) values ('Kharkiv','2015-01-01','Fun run')
INSERT INTO Race (city,race_date,race_name) values ('Kiev','2016-05-05','New Year run')
INSERT INTO Runner (name,surname,sex,user_id) values ('Anton','Ivanchenko','MALE',1)
INSERT INTO Runner (name,surname,sex,user_id) values ('Michael','Dobrynin','MALE',2)
INSERT INTO Distance (name,length) values ('marathon',42)
INSERT INTO Distance (name,length) values ('half marathon',21)
