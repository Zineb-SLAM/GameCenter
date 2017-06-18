DROP TABLE ORDER_LINES, ORDERS;
DROP TABLE ADDRESSES, PAYMENTS;
DROP TABLE CUSTOMERS, ADMIN;

CREATE TABLE CUSTOMERS (id int NOT NULL AUTO_INCREMENT, 
						username varchar(30) NOT NULL UNIQUE, 
                        lastname varchar(30)  NOT NULL, 
                        firstname varchar(30) NOT NULL , 
                        gender varchar(1) NOT NULL,                        
                        email varchar(100) NOT NULL UNIQUE, 
                        password varchar(255) NOT NULL,
                        status boolean,
                        PRIMARY KEY (id));
                       
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


CREATE TABLE PAYMENTS( id int NOT NULL AUTO_INCREMENT,
					  type ENUM('visa', 'mastercard', 'americanexpress', 'discover') NOT NULL,
					  pan varchar(16) NOT NULL,
					  cvv varchar(3) NOT NULL,
					  month  INT NOT NULL check (month between 1 and 12),
					  year INT NOT NULL check (year between 2017 and 2080),
					  customer int NOT NULL,
					  status boolean NOT NULL,
					  PRIMARY KEY (id),
					  CONSTRAINT  PAYMENTS_CONST UNIQUE(customer,type, pan),
			   		  FOREIGN KEY (customer) REFERENCES CUSTOMERS(id));


CREATE TABLE CONSOLTYPES (id int NOT NULL AUTO_INCREMENT, 
						name varchar(50) NOT NULL, 
						PRIMARY KEY (id));
						



CREATE TABLE PUBLISHERS (id int NOT NULL AUTO_INCREMENT, 
						name varchar(50) NOT NULL, 
						PRIMARY KEY (id)
);



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
                        FOREIGN KEY (publisherid) REFERENCES PUBLISHERS(id)
 );

CREATE TABLE ORDERS (
						id INT AUTO_INCREMENT,
						customerid INT NOT NULL,
						paid BOOLEAN NOT NULL,
						paymentid INT,
						PRIMARY KEY(id),
						FOREIGN KEY(customerid) REFERENCES CUSTOMERS(id),
						FOREIGN KEY(paymentid) REFERENCES PAYMENTS(id));
		
CREATE TABLE ORDER_LINES (
						id INT AUTO_INCREMENT,
						orderid INT NOT NULL,
						productid INT NOT NULL,
						quantity INT NOT NULL,
						PRIMARY KEY (id),
						FOREIGN KEY (productid) REFERENCES PRODUCTS(id),
						FOREIGN KEY (orderid) REFERENCES ORDERS(id)
);


CREATE TABLE ADMIN(
					id INT AUTO_INCREMENT,
					username varchar(30) NOT NULL UNIQUE, 
					email varchar(100) NOT NULL UNIQUE, 
                    lastname varchar(30)  NOT NULL, 
                    firstname varchar(30) NOT NULL,
                    password varchar(255) NOT NULL,
                    PRIMARY KEY (id) 

);

 
 INSERT INTO CONSOLTYPES (name)
	VALUES ("wii"), ("wiiu"), ("xbox"), ("psp"), ("playstation"), ("game cube");


INSERT INTO PUBLISHERS (name)
	VALUES ("ubisoft"), ("nintendo"), ("activisation blizzard"), ("electronic arts");


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
		
		
		
		

		INSERT INTO ORDERS (customerid, paid, paymentid) VALUES 
			(1, true, 1),
			(1, true, 1),
			(1, false, 1);
		
		INSERT INTO ORDER_LINES (orderid, productid, quantity) VALUES 
			(1,1,1),
			(1,2,2);

