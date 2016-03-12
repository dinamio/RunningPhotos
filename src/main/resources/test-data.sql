INSERT INTO role (name) VALUES ('Photographer')
INSERT INTO role (name) VALUES ('Runner')
INSERT INTO role (name) VALUES ('Operator')
INSERT INTO role (name) VALUES ('Admin')
INSERT INTO Runner (name,surname,sex) values ('Michael','Dobrynin','MALE')
INSERT INTO user (login,mail,name,surname,city,birthdate,role_id) VALUES ('antoni94','antoxa@ukr.net','Anton','Ivanchenko','Kiev','1995-10-10',2)
INSERT INTO user (login,mail,name,surname,city,birthdate,role_id) VALUES ('olya01','olyA@mail.ru','Olya','Pilipenko','Kharkiv','1991-02-01',2)
INSERT INTO Race (city,race_date,race_name) values ('Kharkiv','2015-01-01','Fun run')
INSERT INTO Race (city,race_date,race_name) values ('Kiev','2016-05-05','New Year run')
INSERT INTO Distance (name,length) values ('marathon',42)
INSERT INTO Distance (name,length) values ('half marathon',21)
INSERT INTO RacePhoto (Path, Author_id, Race_id) values ('race://photo/path',1,1)
INSERT INTO Runners_on_photo (Runner_id, Photo_id) values (1,1)




