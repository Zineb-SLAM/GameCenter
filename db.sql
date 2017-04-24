DROP TABLE PRODUCTS;
DROP TABLE CONSOLTYPES;
DROP TABLE PUBLISHERS;
DROP TABLE CUSTOMERS;

CREATE TABLE CUSTOMERS (id int NOT NULL AUTO_INCREMENT, 
                        lastname varchar(30) UNIQUE NOT NULL, 
                        firstname varchar(30) NOT NULL , 
                        gender varchar(1) NOT NULL, 
                        username varchar(30) NOT NULL UNIQUE,               
                        email varchar(100) NOT NULL UNIQUE, 
                        password varchar(15) NOT NULL,
                        status boolean,
                        PRIMARY KEY (id));
                        

INSERT INTO CUSTOMERS (lastname, firstname, gender, username, email, password, status)
	VALUES ("michelle","obama","f","firstlady","first.lady@gov.org","youwish", 1),
			("barack","obama","m","president","barack.obama@gov.org","youwish", 1);




CREATE TABLE ADDRESSES        ( id int NOT NULL  AUTO_INCREMENT,
							  address varchar(50) NOT NULL,
							  zipcode varchar(5) NOT NULL,
							  city varchar(25) NOT NULL,
							  country varchar(15) NOT NULL,
							  type ENUM('shipping', 'billing', 'both') NOT NULL,
							  customer int NOT NULL,
							  status boolean,						
							  PRIMARY KEY (id),
							  FOREIGN KEY (customer) REFERENCES CUSTOMERS(id));


INSERT INTO ADDRESSES (address, zipcode, city, country, type, customer, status)
	VALUES ("white house","20001","washington dc","USA","both",1, 1),
			("white house","20001","washington dc","USA","billing", 2, 1),
			("green house","20001","washington dc","USA","shipping", 2, 1);


CREATE TABLE PAYMENTS( id int NOT NULL,
					  type ENUM('visa', 'mastercard', 'american_express', 'discover') NOT NULL,
					  cardnumber varchar(16),
					  code varchar(3),
					  customer int NOT NULL,
					  status boolean,
					  PRIMARY KEY (id),
			   		  FOREIGN KEY (customer) REFERENCES CUSTOMERS(id));




CREATE TABLE CONSOLTYPES (id int NOT NULL AUTO_INCREMENT, 
						name varchar(50) NOT NULL, 
						PRIMARY KEY (id));
INSERT INTO CONSOLTYPES (name)
	VALUES ("wii"), ("wiiu"), ("xbox"), ("psp"), ("playstation"), ("game cube");



CREATE TABLE PUBLISHERS (id int NOT NULL AUTO_INCREMENT, 
				name varchar(50) NOT NULL, 
				PRIMARY KEY (id));

INSERT INTO PUBLISHERS (name)
	VALUES ("ubisoft"), ("nintendo"), ("activisation blizzard"), ("electronic arts");


CREATE TABLE PRODUCTS ( id 			int NOT NULL AUTO_INCREMENT, 
                        name 		varchar(30) NOT NULL, 
                        maingenre 	varchar(35) NOT NULL,
                        publisherid int  NULL,
                        agemin 		int NOT NULL,
                        consoleid 	int NOT NULL,
                        releasedate date,
                        price float(4, 2), 
                        quantity int NOT NULL, 
                        description varchar(1000) NOT NULL ,            
                        PRIMARY KEY (id),
                        FOREIGN KEY (consoleid) REFERENCES CONSOLTYPES(id),
                        FOREIGN KEY (publisherid) REFERENCES PUBLISHERS(id));

 
INSERT INTO PRODUCTS (name, maingenre, publisherid, agemin, consoleid, releasedate, price, quantity, description)
VALUES  ("Assassin's Creed", "action", 1, 18, 3, '2015-12-27', 55.99, 12, "Assassin's Creed is an action-adventure video game in which the player primarily assumes the role of Altaïr, as experienced by protagonist Desmond Miles. The primary goal of the game is to carry out a series of assassinations  ordered by Al Mualim, the leader of the Assassins."),
		("Assassin's Creed", "action", 1, 18, 4, '2015-12-27', 55.99, 10, "Assassin's Creed is an action-adventure video game in which the player primarily assumes the role of Altaïr, as experienced by protagonist Desmond Miles. The primary goal of the game is to carry out a series of assassinations ordered by Al Mualim, the leader of the Assassins."),
		("Assassin's Creed", "action", 1, 18, 5, '2015-12-27', 55.99,  9, "Assassin's Creed is an action-adventure video game in which the player primarily assumes the role of Altaïr, as experienced by protagonist Desmond Miles. The primary goal of the game is to carry out a series of assassinations ordered by Al Mualim, the leader of the Assassins."),
		
		("Super Mario Race", "race", 2, 5, 1, '2012-02-17', 35.20, 5, "you get to choose between 8 racers (2 must be unlocked) at the beginning of the game. We have: Mario, Wario, Bowser, Donkey Kong, Princess, and of course Yoshi. There are 6 different courses to race on but they are mostly the same as the game is 2D flash"),
		("Super Mario Race", "race", 2, 5, 2, '2012-02-17', 35.20, 15, "you get to choose between 8 racers (2 must be unlocked) at the beginning of the game. We have: Mario, Wario, Bowser, Donkey Kong, Princess, and of course Yoshi. There are 6 different courses to race on but they are mostly the same as the game is 2D flash"),
		("Super Mario Race", "race", 2, 5, 3, '2015-04-02', 35.20, 5, "you get to choose between 8 racers (2 must be unlocked) at the beginning of the game. We have: Mario, Wario, Bowser, Donkey Kong, Princess, and of course Yoshi. There are 6 different courses to race on but they are mostly the same as the game is 2D flash"),
		("Super Mario Race", "race", 2, 5, 4, '2015-04-02', 35.20, 5, "you get to choose between 8 racers (2 must be unlocked) at the beginning of the game. We have: Mario, Wario, Bowser, Donkey Kong, Princess, and of course Yoshi. There are 6 different courses to race on but they are mostly the same as the game is 2D flash"),
		("Super Mario Race", "race", 2, 5, 5, '2012-12-17', 35.20, 35, "you get to choose between 8 racers (2 must be unlocked) at the beginning of the game. We have: Mario, Wario, Bowser, Donkey Kong, Princess, and of course Yoshi. There are 6 different courses to race on but they are mostly the same as the game is 2D flash"),
		("Super Mario Race", "race", 2, 5, 6, '2009-09.09', 35.20, 5, "you get to choose between 8 racers (2 must be unlocked) at the beginning of the game. We have: Mario, Wario, Bowser, Donkey Kong, Princess, and of course Yoshi. There are 6 different courses to race on but they are mostly the same as the game is 2D flash"),
		
		("Just Dance", "dancing", 1, 3, 1, '2009-12-17', 25, 1, "Rhythm, Dance. ... Just Dance is a dance video game developed by Ubisoft Milan and Ubisoft Paris and published by Ubisoft."),
		("Just Dance", "dancing", 1, 3, 1, '2012-10-09', 45, 2, "Rhythm, Dance. ... Just Dance is a dance video game developed by Ubisoft Milan and Ubisoft Paris and published by Ubisoft."),
		("Just Dance", "dancing", 1, 3, 3, '2012-10-09', 45, 6, "Rhythm, Dance. ... Just Dance is a dance video game developed by Ubisoft Milan and Ubisoft Paris and published by Ubisoft."),
		("Just Dance 2 ", "dancing", 1, 3, 1, '2017-12-07', 60, 2, "Rhythm, Dance. ... Just Dance is a dance video game developed by Ubisoft Milan and Ubisoft Paris and published by Ubisoft.");







)