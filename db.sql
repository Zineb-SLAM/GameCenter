CREATE TABLE CUSTOMERS (id int NOT NULL AUTO_INCREMENT, 
                        lastname varchar(30) UNIQUE NOT NULL, 
                        firstname varchar(30) NOT NULL , 
                        gender varchar(1) NOT NULL, 
                        username varchar(30) NOT NULL UNIQUE,               
                        email varchar(100) NOT NULL, 
                        password varchar(15) NOT NULL,
                        PRIMARY KEY (id));
                        

INSERT INTO CUSTOMERS (lastname, firstname, gender, username, email, password)
	VALUES ("michelle","obama","f","firstlady","first.lady@gov.org","youwish"),
			("barack","obama","m","president","barack.obama@gov.org","youwish");



CREATE TABLE CONSOLTYPES (id int NOT NULL AUTO_INCREMENT, 
						name varchar(50) NOT NULL, 
						PRIMARY KEY (id));
INSERT INTO CONSOLTYPES (name)
	VALUES ("wii"), ("wiiu"), ("xbox"), ("psp"), ("playstation"), ("game cube");



CREATE TABLE PUBLISHERS (id int NOT NULL AUTO_INCREMENT, name varchar(50) NOT NULL, PRIMARY KEY (id));

INSERT INTO PUBLISHERS (name)
	VALUES ("Ubisoft"), ("nintendo"), ("activisation blizzard"), ("electronic arts");


CREATE TABLE PRODUCTS ( id int NOT NULL AUTO_INCREMENT, 
                        name varchar(30) NOT NULL, 
                        maingenre varchar(35) NOT NULL,
                        publisherid int  NULL,
                        agemin int,
                        releasedate date,
                        price float, 
                        consoleid int NOT NULL, 
                        description varchar(1000) NOT NULL ,              
                        PRIMARY KEY (id),
                        FOREIGN KEY (consoleid) REFERENCES CONSOLTYPES(id),
                        FOREIGN KEY (publisherid) REFERENCES PUBLISHERS(id));

 
INSERT INTO PRODUCTS (name, maingenre, publisherid, agemin, releasedate, price, consoleid, description)
VALUES ("Assassin's Creed", "action", 1, 18, '2015-12-27', 55.99, 3, "Assassin's Creed is an action-adventure video game in which the player primarily assumes the role of Altaïr, as experienced by protagonist Desmond Miles. The primary goal of the game is to carry out a series of assassinations  ordered by Al Mualim, the leader of the Assassins."),
		("Assassin's Creed", "action", 1, 18,  '2015-12-27', 55.99, 4, "Assassin's Creed is an action-adventure video game in which the player primarily assumes the role of Altaïr, as experienced by protagonist Desmond Miles. The primary goal of the game is to carry out a series of assassinations ordered by Al Mualim, the leader of the Assassins."),
		("Assassin's Creed", "action", 1, 18,  '2015-12-27', 55.99, 5, "Assassin's Creed is an action-adventure video game in which the player primarily assumes the role of Altaïr, as experienced by protagonist Desmond Miles. The primary goal of the game is to carry out a series of assassinations ordered by Al Mualim, the leader of the Assassins."),
		("Super Mario Race", "race", 2, 5, '2012-02-17', 35.20, 1, "you get to choose between 8 racers (2 must be unlocked) at the beginning of the game. We have: Mario, Wario, Bowser, Donkey Kong, Princess, and of course Yoshi. There are 6 different courses to race on but they are mostly the same as the game is 2D flash"),
		("Super Mario Race", "race", 2, 5, '2012-02-17', 35.20, 2, "you get to choose between 8 racers (2 must be unlocked) at the beginning of the game. We have: Mario, Wario, Bowser, Donkey Kong, Princess, and of course Yoshi. There are 6 different courses to race on but they are mostly the same as the game is 2D flash"),
		("Super Mario Race", "race", 2, 5, '2015-04-02', 35.20, 3, "you get to choose between 8 racers (2 must be unlocked) at the beginning of the game. We have: Mario, Wario, Bowser, Donkey Kong, Princess, and of course Yoshi. There are 6 different courses to race on but they are mostly the same as the game is 2D flash"),
		("Super Mario Race", "race", 2, 5, '2015-04-02', 35.20, 4, "you get to choose between 8 racers (2 must be unlocked) at the beginning of the game. We have: Mario, Wario, Bowser, Donkey Kong, Princess, and of course Yoshi. There are 6 different courses to race on but they are mostly the same as the game is 2D flash"),
		("Super Mario Race", "race", 2, 5, '2012-12-17', 35.20, 5, "you get to choose between 8 racers (2 must be unlocked) at the beginning of the game. We have: Mario, Wario, Bowser, Donkey Kong, Princess, and of course Yoshi. There are 6 different courses to race on but they are mostly the same as the game is 2D flash"),
		("Super Mario Race", "race", 2, 5, '2009-09.09', 34.0, 6, "you get to choose between 8 racers (2 must be unlocked) at the beginning of the game. We have: Mario, Wario, Bowser, Donkey Kong, Princess, and of course Yoshi. There are 6 different courses to race on but they are mostly the same as the game is 2D flash"),
		("Just Dance", "dancing", 1, 3, '2009-12-17', 35, 1, "Rhythm, Dance. ... Just Dance is a dance video game developed by Ubisoft Milan and Ubisoft Paris and published by Ubisoft."),
		("Just Dance 2 ", "dancing", 1, 3, '2017-12-07', 45, 2, "Rhythm, Dance. ... Just Dance is a dance video game developed by Ubisoft Milan and Ubisoft Paris and published by Ubisoft."),
		("Just Dance", "dancing", 1, 3, '2012-10-09', 45, 2, "Rhythm, Dance. ... Just Dance is a dance video game developed by Ubisoft Milan and Ubisoft Paris and published by Ubisoft."),
		("Just Dance", "dancing", 1, 3, '2012-10-09', 45, 3, "Rhythm, Dance. ... Just Dance is a dance video game developed by Ubisoft Milan and Ubisoft Paris and published by Ubisoft.");