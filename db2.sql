USE SR03;
CREATE TABLE CUSTOMERS (id int NOT NULL AUTO_INCREMENT, 
                        lastname varchar(30) NOT NULL, 
                        firstname varchar(30) NOT NULL , 
                        gender varchar(1) NOT NULL, 
                        username varchar(30) NOT NULL UNIQUE,               
                        email varchar(100) NOT NULL UNIQUE, 
                        password varchar(50) NOT NULL,
                        status boolean,
                        PRIMARY KEY (id));
                       

INSERT INTO CUSTOMERS (lastname,firstname,gender,username,password,email,status) VALUES ("Amelia","Kiona","m","Chaney C. Bauer","PBG42UUS7QG","et.magnis@ridiculusmus.net",1),("Priscilla","Nadine","f","Jena R. Snider","CEY39DOK1BL","ut.aliquam@dui.ca",1),("Axel","Fatima","m","Victoria X. Miles","LZQ59TEO5JD","Cras@Classaptenttaciti.org",1),("Ruby","Idola","f","Riley J. Hurst","FOI39LMI5NJ","tempor.bibendum.Donec@id.org",1),("Keely","Edward","m","May Y. Henry","OMF65PWE8CN","luctus.Curabitur.egestas@magnaCrasconvallis.net",1),("Magee","Ria","m","Ivan A. Garcia","BJV44KNC0BD","erat.vitae.risus@semperduilectus.com",1),("Alyssa","Clayton","f","Taylor D. Montgomery","ARB70GJF3OD","Nulla.interdum.Curabitur@euneque.co.uk",1),("Calista","Honorato","m","Jermaine Z. Lynch","BKV41FNP5FI","Integer.vitae.nibh@orci.net",1),("Libby","Benedict","f","Teagan M. Delaney","PGF12IMP4VV","neque@sitamet.ca",1),("Urielle","Elmo","m","Mallory H. Newman","PNV41MZU9CL","non.enim.Mauris@Pellentesquehabitantmorbi.net",1);
INSERT INTO CUSTOMERS (lastname,firstname,gender,username,password,email,status) VALUES ("Genevieve","Tucker","f","Micah I. Vaughn","QKO27HAL7AM","fringilla.porttitor@Sedmolestie.org",1),("Dexter","Emily","m","Hamish Q. Levine","NQY98DXJ9SC","dapibus.ligula@auguemalesuada.ca",1),("Derek","Kasimir","m","Karly Y. Witt","CWI50AZP9CI","sit.amet.dapibus@Donectempuslorem.com",1),("Delilah","Gwendolyn","f","Eagan L. Fry","RDC46KPM8ZN","Vestibulum.accumsan@estcongue.net",1),("Harding","Tatyana","f","Hayfa X. Hahn","OGQ20CFH4LT","sit.amet@nibh.net",1),("Vaughan","Slade","f","Medge Y. Page","GPO66EDM3YV","parturient.montes@nonvestibulum.net",1),("MacKensie","Skyler","m","Kaden D. Dudley","IOI40XIW5HC","adipiscing.Mauris@nequeNullamut.com",1),("Castor","Zena","m","Carol J. Harper","TUA21RVJ3RD","sit.amet.faucibus@habitant.org",1),("Carla","Carolyn","f","Karen I. Salinas","MXW11IZD8LH","vel@primisin.com",1),("Nyssa","Mollie","f","Tanya Q. Mckay","SYA31TDS0QR","iaculis.odio.Nam@tellus.ca",1);
INSERT INTO CUSTOMERS (lastname,firstname,gender,username,password,email,status) VALUES ("Irene","Xantha","m","Venus Q. Nelson","RGC77JAO8OY","venenatis.lacus.Etiam@arcuNunc.edu",1),("Christen","Brenna","m","Fritz O. Holt","DBQ32GPY0TG","sed.facilisis@duiFusce.edu",1),("Kellie","Jonas","m","Joseph A. Raymond","MDM56SVY0EB","pede.et.risus@egetipsum.edu",1),("Beatrice","India","f","Quyn J. Stuart","GDB43HUN6OE","cursus@lobortis.net",1),("Jolene","Daryl","f","Seth C. Wiggins","REM98BRZ0PG","magna.nec.quam@ametloremsemper.org",1),("Thaddeus","Fuller","m","Sandra M. Meadows","AUQ34AQU5ST","augue.ac.ipsum@dolor.edu",1),("Isabella","Bree","f","Lysandra C. Ryan","CJT68DLJ3IV","a.scelerisque@euelit.org",1),("Sydney","Tara","f","Quinlan R. Tran","IYO24NWL5SE","dolor.Donec.fringilla@rhoncusNullamvelit.edu",1),("Xaviera","Zephania","m","Ora Q. Lowery","MLL14JMQ5UP","neque.vitae@necurnasuscipit.ca",1),("Arden","Reuben","m","Clark N. Riggs","ECD76NRW2OW","orci.luctus@sagittisDuisgravida.ca",1);
INSERT INTO CUSTOMERS (lastname,firstname,gender,username,password,email,status) VALUES ("Jamal","Alice","m","Illana W. Ashley","MYY27DZR6HE","faucibus.id@eueleifendnec.co.uk",1),("May","Hyacinth","m","Bert N. Morton","JYC16TJS0AH","mauris.Integer@faucibusleoin.co.uk",1),("Micah","Ali","m","Audra L. Travis","SON63TBR1BG","egestas.Aliquam.nec@dignissimmagnaa.org",1),("Macey","Bryar","f","Halla P. Conrad","VJP83DRQ3MY","Fusce@imperdieteratnonummy.co.uk",1),("Yvette","Deirdre","m","Rhona K. Robbins","BZG15BCH2YN","porttitor.eros@viverra.net",1),("Howard","Chelsea","m","Jordan I. Rose","QAF97GBC1YD","Nunc@antebibendum.com",1),("Omar","Chester","f","Haley W. Pickett","OXP07QFA5ST","et@adipiscingelitAliquam.org",1),("Eve","Aaron","m","Susan I. Kline","OGB97APA3XV","dictum.sapien@posuerecubilia.ca",1),("Julie","Madaline","f","Olga M. Bass","JVS83OJX7XY","placerat.Cras.dictum@lorem.edu",1),("Alfreda","Avram","m","Tiger P. Dean","ANG62GVJ6ZU","viverra@ac.net",1);
INSERT INTO CUSTOMERS (lastname,firstname,gender,username,password,email,status) VALUES ("Brianna","Jocelyn","m","Kaitlin A. Beach","RZN20ZDF4YE","nec.ante.Maecenas@sodales.edu",1),("Isadora","Velma","m","MacKenzie O. Lee","EDF58FIG7GU","nunc.Quisque.ornare@loremacrisus.ca",1),("Rahim","Maile","m","Adria O. Willis","GUE05GYB1QP","arcu@dui.net",1),("Madaline","Joelle","m","Tallulah T. Mcdowell","LFC09TSZ8JC","dolor.dolor@accumsan.ca",1),("Quon","Michael","m","Benedict X. Copeland","EPQ77CPB5TR","tempor.diam@Phasellus.edu",1),("Elizabeth","Cameron","m","Ashely M. Hurley","ZAX87UAT5KL","neque.tellus.imperdiet@ultricesaauctor.ca",1),("Zachery","Genevieve","m","Jeremy L. Carroll","GYA06OUG1QD","Ut@et.com",1),("Cameran","Hilel","f","Savannah U. Simpson","UPM07WLY8HW","primis.in@Quisquepurussapien.com",1),("Mona","Kendall","m","Rae G. Raymond","DJL08GYQ5KZ","tortor.nibh.sit@ridiculusmusAenean.org",1),("Kieran","Brennan","f","Anne S. Willis","KLZ49GTY7VJ","dolor@antedictum.net",1);
INSERT INTO CUSTOMERS (lastname,firstname,gender,username,password,email,status) VALUES ("Rachel","Gretchen","m","Brady R. Baldwin","GLE64FIT6GW","lacus@sedsemegestas.ca",1),("Alexis","Samuel","f","Hillary R. Pope","IPW89UPD0DN","sed.sapien.Nunc@vel.org",1),("Blake","Naomi","m","Brenda G. Rich","UOC51UHP6YR","in.magna.Phasellus@Suspendissetristique.edu",1),("Heather","Steel","f","Kimberley Y. Baird","YNK62RBC5EL","pede.blandit@euismodac.net",1),("Kirestin","Brenden","m","Merritt W. Nielsen","ITC60KOG9IW","fermentum@Duis.com",1),("Kylee","Guy","m","Mason V. Wolf","HFL25NMY4EY","dictum.placerat@lacusUt.com",1),("Nero","Gary","m","Quon L. Olsen","IMX42JOR4RB","feugiat.tellus@mollisnon.co.uk",1),("Calvin","Odette","f","Gisela Z. Baxter","ZDC86KUX4YN","Cras@Nulla.net",1),("Graiden","Octavia","f","Chantale W. Kirk","QTW76YFS1RI","magna@InfaucibusMorbi.edu",1),("Rinah","Lucas","m","Hope W. Shepherd","WFM32IDB2OR","Lorem.ipsum.dolor@interdumligulaeu.net",1);
INSERT INTO CUSTOMERS (lastname,firstname,gender,username,password,email,status) VALUES ("Grady","Angela","m","Tarik V. Conrad","XXN87UTM8ZG","elit.pharetra.ut@necleo.ca",1),("Quinn","Melissa","m","Robin G. Howe","ICW13GRY9PF","montes@imperdieteratnonummy.edu",1),("Dexter","Dennis","f","Kylan A. Castaneda","MIR44KVQ1PG","facilisis.magna@arcuSed.org",1),("Xandra","Ariana","m","Shaine K. Moreno","YYT42VBW7BD","sollicitudin.commodo@suscipit.co.uk",1),("Brody","McKenzie","m","Elton D. Blanchard","TUD11UNF1PA","velit.eget@faucibusutnulla.co.uk",1),("Kennedy","Susan","f","Megan F. Holden","XRZ40XIX2PS","Maecenas@pedenec.ca",1),("Doris","Irene","f","Sydney A. Solomon","EUP82CUP3EO","et.rutrum@mauris.ca",1),("Dieter","Cameron","f","Shad Y. Bush","HMO60PUE3UL","sociis.natoque@mollisneccursus.org",1),("Zoe","Blossom","f","Maris R. Nguyen","VCY15GPU2TC","felis.purus.ac@Curabiturvel.edu",1),("Quail","Stacy","f","Clio L. Patton","IJO71GJR1UX","pharetra.Nam@mauriseuelit.com",1);
INSERT INTO CUSTOMERS (lastname,firstname,gender,username,password,email,status) VALUES ("Hamish","Kennedy","m","Tashya A. Wynn","MMS18KFE1UP","scelerisque@placerat.ca",1),("Laith","Bo","m","Ivory I. Wilson","JHU63DWX7IS","in@aliquet.net",1),("Gareth","Portia","f","Griffith K. Barrett","MFS71MDE4ED","urna.Nunc.quis@neceuismod.com",1),("Rebecca","Alfonso","f","Ursa R. Wilkinson","BQY38NRX2AM","mi.lacinia.mattis@mauriselitdictum.net",1),("Molly","Amy","f","Holly G. Benton","WXK49FUA7MG","et@musProin.org",1),("Nathaniel","Adele","m","Ian H. Sparks","TWA64LEX9HH","adipiscing.fringilla.porttitor@ullamcorperDuisat.org",1),("Risa","Idona","f","Melodie I. Hensley","SZI13BJS2GF","consequat@sit.co.uk",1),("Honorato","Alec","f","Ariana M. Guy","TZZ01UMU2CW","varius.Nam.porttitor@eratvelpede.ca",1),("Amber","Kuame","f","Lani S. Foreman","MTV17IIM4LG","Nullam.lobortis@tristiquepellentesquetellus.ca",1),("Neve","Laith","m","Palmer T. Swanson","KQB66DAL5KG","malesuada@facilisisfacilisis.com",1);
INSERT INTO CUSTOMERS (lastname,firstname,gender,username,password,email,status) VALUES ("Alvin","Hoyt","f","Hayfa M. Clarke","KUQ79BLO5KF","ornare.lectus.ante@iaculis.edu",1),("Anika","Ila","m","Lionel F. Bailey","KBL97HEG7AT","ante@consequat.com",1),("Tad","Coby","f","Josiah G. Glenn","ZGP72XYX2OS","ac.mattis@enim.org",1),("Oliver","Randall","m","Tashya Q. Holcomb","QVI96MPD3PT","ac.mattis@in.net",1),("Jennifer","Sydney","f","Linda Y. Knight","WKN52HGF6HH","iaculis.lacus.pede@erosProin.org",1),("Dieter","Maryam","m","Leilani P. Vang","TNR30JQD8XJ","elit.sed@tortorNunccommodo.edu",1),("Marah","Astra","m","Lamar N. Love","OQT22SUP3BV","Nunc@Proin.ca",1),("Kyla","Tobias","m","Shafira S. Joseph","EKB39VHD4XF","quis@Praesenteu.net",1),("Lyle","Karly","f","Karly Z. Erickson","LWL45IUB7YU","cursus.vestibulum@Donectempor.org",1),("Garrison","Hayley","m","Tanek A. Beasley","WCC45OGP5JX","et@arcu.edu",1);
INSERT INTO CUSTOMERS (lastname,firstname,gender,username,password,email,status) VALUES ("Fatima","Rogan","m","Tucker P. Camacho","SAS98NRY9AL","adipiscing.non.luctus@est.net",1),("Scott","Jeremy","m","Moana S. Lucas","NOA33XBU7HY","volutpat.nunc@maurisIntegersem.org",1),("Kaden","Alana","f","Astra T. Poole","PJE70SYG0SZ","non@cubilia.net",1),("Wilma","Inez","m","Jennifer A. Ellison","JKL25TJL5SO","tempor@dignissimMaecenas.com",1),("Audra","Wade","m","Meghan U. Waters","XIK17JFX4ID","Donec.vitae@habitant.ca",1),("Reagan","Lesley","f","Martina K. Jordan","XVP11WPM8BQ","non.vestibulum@porttitorerosnec.org",1),("Brandon","Samantha","f","Jasper M. Gross","IKJ91PMM4YE","elit.sed.consequat@nisia.ca",1),("Kareem","Beck","m","Maggie G. Hendricks","RYN09OQN3RY","Cras.convallis@pharetraQuisque.com",1),("Grady","Ria","f","Paki L. Lowery","EWV68NDV9ID","pellentesque.tellus@estMauriseu.com",1),("Jorden","Natalie","f","Gil J. Pittman","GWC73XPR2OC","ac@dictum.net",1);





CREATE TABLE ADDRESSES        ( id int NOT NULL  AUTO_INCREMENT,
							  address varchar(50) NOT NULL,
							  zipcode varchar(10) NOT NULL,
							  city varchar(25) NOT NULL,
							  country varchar(15) NOT NULL,
							  type ENUM('shipping', 'billing', 'both') NOT NULL,
							  customer int NOT NULL,
							  status boolean,						
							  PRIMARY KEY (id),
							  FOREIGN KEY (customer) REFERENCES CUSTOMERS(id));

INSERT INTO ADDRESSES (address,zipcode,city,country,type,customer,status) VALUES ("236 At, Road","83153","Columbus","United States","shipping",35,1),("6748 Aliquam Av.","61246","Seattle","United States","shipping",66,1),("300-7704 Justo Rd.","79772","Wichita","United States","shipping",71,1),("P.O. Box 575, 688 Vitae, St.","75011","Philadelphia","United States","shipping",1,1),("P.O. Box 728, 3319 Vel Ave","54186","Shreveport","United States","shipping",67,1),("147-1797 Et Av.","72321","Harrisburg","United States","both",14,1),("9005 Rutrum Av.","38815","Las Vegas","United States","shipping",6,1),("P.O. Box 208, 453 Ac Av.","77086","Chandler","United States","billing",27,1),("6419 Urna, Avenue","98275","Des Moines","United States","billing",24,1),("488 Rutrum Avenue","15211","Kenosha","United States","shipping",9,1);
INSERT INTO ADDRESSES (address,zipcode,city,country,type,customer,status) VALUES ("P.O. Box 173, 2990 Laoreet Street","54080","Fayetteville","United States","shipping",2,1),("P.O. Box 525, 3360 Ornare, Road","87536","Jackson","United States","billing",87,1),("Ap #931-596 Fusce Road","58334","Springfield","United States","shipping",78,1),("Ap #632-5132 Vulputate St.","39002","Lafayette","United States","both",24,1),("767-9577 Senectus St.","10755","Paradise","United States","billing",54,1),("P.O. Box 686, 5171 Sed Avenue","44292","San Antonio","United States","shipping",16,1),("P.O. Box 671, 6694 Ligula. Rd.","23321","Lewiston","United States","shipping",80,1),("Ap #809-8182 Nunc. Road","60922","San Francisco","United States","billing",47,1),("Ap #600-763 Augue Av.","25498","Jackson","United States","billing",16,1),("P.O. Box 214, 4796 Tortor, Rd.","45073","Fairbanks","United States","shipping",1,1);
INSERT INTO ADDRESSES (address,zipcode,city,country,type,customer,status) VALUES ("2283 Tempor Street","34123","Gaithersburg","United States","billing",51,1),("7018 Ultricies Avenue","82468","Biloxi","United States","billing",47,1),("P.O. Box 578, 889 Faucibus Ave","60373","Reading","United States","shipping",10,1),("Ap #565-8600 Maecenas Rd.","71310","College","United States","both",26,1),("P.O. Box 527, 9242 Donec St.","55544","Sterling Heights","United States","both",89,1),("1831 Nascetur Av.","29976","Columbia","United States","both",24,1),("283-2118 Dis Road","55502","Tallahassee","United States","both",45,1),("773-8268 In, Road","72188","Sandy","United States","shipping",23,1),("Ap #347-7618 Turpis Avenue","52653","Des Moines","United States","both",1,1),("575-9023 Eu Rd.","77458","Hilo","United States","both",18,1);
INSERT INTO ADDRESSES (address,zipcode,city,country,type,customer,status) VALUES ("P.O. Box 265, 6420 Diam St.","13801","Chattanooga","United States","both",71,1),("995-2866 Ipsum St.","59223","Great Falls","United States","shipping",82,1),("Ap #954-3337 Non, Ave","99607","Nashville","United States","shipping",27,1),("5423 Diam. Rd.","42326","New Orleans","United States","both",76,1),("499-396 Dui St.","59748","Columbus","United States","both",14,1),("703-4711 Neque Road","53332","Phoenix","United States","both",15,1),("972 Mauris St.","37790","Memphis","United States","billing",62,1),("798-3020 Nec, Ave","68361","Gresham","United States","shipping",75,1),("P.O. Box 775, 9386 Sem. Street","43146","Lafayette","United States","shipping",73,1),("P.O. Box 266, 2617 Metus. St.","46206","Reading","United States","both",28,1);
INSERT INTO ADDRESSES (address,zipcode,city,country,type,customer,status) VALUES ("Ap #474-6060 Nec, Street","81690","Hilo","United States","shipping",75,1),("6653 Velit. St.","80235","Atlanta","United States","shipping",67,1),("967-6170 Ac Road","24091","Biloxi","United States","billing",17,1),("P.O. Box 386, 3976 Lacus. Street","42446","Chesapeake","United States","shipping",26,1),("491-1674 Odio. Rd.","89666","Kailua","United States","both",49,1),("P.O. Box 726, 5266 Orci Rd.","46055","Montpelier","United States","shipping",32,1),("8320 Pharetra, St.","11383","Lewiston","United States","both",49,1),("Ap #504-6159 Urna Street","42220","Fairbanks","United States","both",39,1),("5557 Duis Ave","86002","Fort Worth","United States","both",64,1),("801-7179 Nisl. Rd.","21475","Hattiesburg","United States","billing",8,1);
INSERT INTO ADDRESSES (address,zipcode,city,country,type,customer,status) VALUES ("P.O. Box 633, 5329 Auctor St.","69590","Denver","United States","both",25,1),("9583 Vel Av.","43551","Atlanta","United States","billing",50,1),("P.O. Box 959, 3599 Ipsum. St.","14170","Nampa","United States","both",43,1),("953-3876 Per St.","81901","Jefferson City","United States","billing",22,1),("655-4242 Tincidunt Av.","86530","Idaho Falls","United States","both",53,1),("271-6161 Imperdiet St.","58658","Lincoln","United States","billing",7,1),("4057 Elit Av.","60935","Montgomery","United States","both",27,1),("6645 Et Rd.","37548","Salem","United States","billing",79,1),("P.O. Box 803, 7532 Convallis, St.","50051","Spokane","United States","shipping",78,1),("360-5473 Dolor Av.","56579","North Las Vegas","United States","both",61,1);
INSERT INTO ADDRESSES (address,zipcode,city,country,type,customer,status) VALUES ("Ap #752-4709 Venenatis Rd.","94613","Augusta","United States","both",52,1),("972-1439 Erat Ave","64205","Springfield","United States","both",78,1),("3739 Sollicitudin Av.","45807","Tucson","United States","both",53,1),("329-6820 Volutpat Street","62055","Juneau","United States","billing",23,1),("6292 Aenean Ave","53320","Gresham","United States","billing",84,1),("5376 Interdum. Avenue","86181","Phoenix","United States","billing",13,1),("2932 Ac St.","66390","South Bend","United States","billing",55,1),("Ap #312-5291 Et Avenue","68832","Minneapolis","United States","billing",23,1),("P.O. Box 707, 3934 Quam Av.","76880","Louisville","United States","shipping",81,1),("Ap #128-3208 Mi. Rd.","32793","Kaneohe","United States","both",23,1);
INSERT INTO ADDRESSES (address,zipcode,city,country,type,customer,status) VALUES ("629 Vel, Road","63249","Green Bay","United States","shipping",15,1),("Ap #490-5877 Duis Street","47857","Harrisburg","United States","shipping",34,1),("876-9333 Aliquet Street","36256","Milwaukee","United States","both",54,1),("512-3470 Sem Avenue","72921","Spokane","United States","both",46,1),("Ap #774-7916 Commodo St.","21897","Fairbanks","United States","both",59,1),("687-6190 Sagittis St.","78655","Davenport","United States","billing",65,1),("P.O. Box 702, 8169 Nulla Av.","51902","South Burlington","United States","both",30,1),("P.O. Box 799, 5282 Sed Rd.","46858","Idaho Falls","United States","shipping",52,1),("868-7316 Donec Road","18919","Norman","United States","billing",56,1),("100-5364 Fusce Road","86172","Newark","United States","billing",75,1);
INSERT INTO ADDRESSES (address,zipcode,city,country,type,customer,status) VALUES ("P.O. Box 566, 6832 Elit Street","25140","Oklahoma City","United States","both",35,1),("3707 Donec Street","12115","Fort Wayne","United States","billing",69,1),("P.O. Box 803, 7793 Dis Road","36984","Lansing","United States","both",60,1),("P.O. Box 363, 8929 Turpis St.","58781","Salem","United States","shipping",70,1),("P.O. Box 717, 9171 Suspendisse Street","42146","Rockville","United States","billing",20,1),("2205 Sit Rd.","23218","Frederick","United States","shipping",42,1),("346-5970 Nunc. Rd.","34076","Topeka","United States","both",41,1),("574-9542 Aliquet Road","49839","Ketchikan","United States","both",54,1),("Ap #728-3632 Donec St.","95126","Duluth","United States","shipping",8,1),("687-3078 Nullam St.","69341","Pike Creek","United States","billing",49,1);
INSERT INTO ADDRESSES (address,zipcode,city,country,type,customer,status) VALUES ("P.O. Box 743, 9216 Sodales St.","85356","Birmingham","United States","shipping",56,1),("Ap #966-1025 Ultrices. St.","85618","Salem","United States","shipping",69,1),("P.O. Box 181, 1150 Etiam Ave","19819","Fort Wayne","United States","both",43,1),("4326 Odio St.","85849","Lafayette","United States","billing",27,1),("6515 Quisque Rd.","16870","Mesa","United States","both",27,1),("Ap #104-695 Sapien, Ave","87741","Portland","United States","shipping",21,1),("181-8308 Ut St.","45227","Wyoming","United States","both",50,1),("3984 Urna St.","32430","Pittsburgh","United States","billing",32,1),("9903 Nam Street","22665","Billings","United States","billing",74,1),("1387 Lorem. Avenue","35826","Lafayette","United States","both",15,1);


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

INSERT INTO PAYMENTS (type,pan,cvv,month,year,customer,status) VALUES ("mastercard","4508825387929440","840",4,2024,45,1),("mastercard","4508363536545503","951",6,2023,19,1),("visa","4917270417468587","533",9,2017,28,1),("mastercard","4917183375986286","589",2,2022,4,1),("visa","4913190502912956","997",8,2020,33,1),("mastercard","4175006490024229","958",3,2019,3,1),("mastercard","4844946940515253","309",7,2020,8,1),("mastercard","4844012963530826","218",7,2017,1,1),("mastercard","4508682885516249","473",3,2023,31,1),("mastercard","4026135921705964","818",8,2018,36,1);
INSERT INTO PAYMENTS (type,pan,cvv,month,year,customer,status) VALUES ("visa","4844749824625457","849",8,2023,8,1),("mastercard","4026557079932746","836",2,2019,48,1),("mastercard","4026081344537461","383",10,2017,5,1),("mastercard","4917799174692708","469",10,2023,18,1),("mastercard","4508847779928087","897",7,2023,39,1),("mastercard","4175007617357526","989",5,2018,23,1),("mastercard","4917614795643156","321",7,2018,1,1),("visa","4175004738321622","873",2,2019,42,1),("visa","4844944275986991","744",8,2017,48,1),("mastercard","4026959238734825","547",4,2022,48,1);
INSERT INTO PAYMENTS (type,pan,cvv,month,year,customer,status) VALUES ("visa","4913170790604408","528",5,2021,37,1),("mastercard","4026614528145717","396",9,2024,28,1),("mastercard","4913358697466803","783",8,2017,4,1),("visa","4175009963331253","554",10,2023,18,1),("visa","4844281132159938","499",2,2017,23,1),("mastercard","4844343201264245","146",4,2017,15,1),("visa","4026086945209113","254",2,2023,3,1),("visa","4917473508645234","258",9,2019,23,1),("visa","4175008256583265","692",5,2017,30,1),("mastercard","4508896428939144","722",7,2020,9,1);
INSERT INTO PAYMENTS (type,pan,cvv,month,year,customer,status) VALUES ("mastercard","4844136857082485","752",12,2017,29,1),("mastercard","4913056442673778","403",12,2022,20,1),("mastercard","4917275904513415","642",3,2020,33,1),("visa","4917063194083905","467",11,2017,41,1),("mastercard","4913592676985264","303",9,2022,35,1),("mastercard","4508744345618518","339",3,2019,47,1),("visa","4844297601426350","732",2,2022,24,1),("mastercard","4913220210667913","152",4,2024,38,1),("visa","4844481931218154","847",10,2021,13,1),("mastercard","4026426025627976","555",7,2021,8,1);
INSERT INTO PAYMENTS (type,pan,cvv,month,year,customer,status) VALUES ("mastercard","4508304307066923","785",2,2022,19,1),("mastercard","4844345073349301","319",12,2021,25,1),("mastercard","4844968223261397","728",11,2024,21,1),("mastercard","4913724722547216","274",8,2021,29,1),("visa","4917584026687613","351",1,2017,10,1),("mastercard","4175009114109236","352",7,2020,29,1),("visa","4508176986958483","149",5,2024,10,1),("mastercard","4913815158798479","862",7,2024,30,1),("mastercard","4026662791552705","785",12,2018,28,1),("visa","4508349848485074","999",11,2024,21,1);
INSERT INTO PAYMENTS (type,pan,cvv,month,year,customer,status) VALUES ("visa","4026446718213801","592",3,2019,8,1),("mastercard","4175004920087064","429",10,2022,19,1),("mastercard","4508055958390083","814",10,2017,32,1),("visa","4913953674270929","980",5,2018,23,1),("visa","4508129363348307","141",6,2017,14,1),("mastercard","4844575077665332","306",10,2022,37,1),("mastercard","4844445878681054","323",12,2020,28,1),("visa","4026905404495329","594",6,2022,12,1),("visa","4913212909742487","832",6,2020,9,1),("visa","4026930450812557","782",5,2023,11,1);
INSERT INTO PAYMENTS (type,pan,cvv,month,year,customer,status) VALUES ("mastercard","4175001890381261","628",12,2023,3,1),("mastercard","4844279389551740","341",10,2019,31,1),("visa","4917344147804393","330",7,2019,13,1),("mastercard","4844366719517929","471",8,2021,12,1),("mastercard","4026751945093185","767",2,2023,12,1),("visa","4844357085581201","436",11,2024,25,1),("visa","4175002931541723","177",9,2020,14,1),("visa","4508597810630610","189",11,2024,34,1),("visa","4844205016303957","959",11,2019,40,1),("mastercard","4844670654983933","652",3,2018,26,1);
INSERT INTO PAYMENTS (type,pan,cvv,month,year,customer,status) VALUES ("visa","4175001286446462","936",2,2021,44,1),("visa","4175003002841950","323",9,2024,10,1),("mastercard","4508631244519477","171",4,2021,26,1),("visa","4175000993917724","794",5,2022,24,1),("mastercard","4844836535490436","355",11,2021,41,1),("visa","4508982585145707","162",7,2018,32,1),("visa","4917883171681854","518",12,2021,19,1),("visa","4913413714369710","566",11,2021,42,1),("visa","4913900236133939","810",1,2018,19,1),("mastercard","4913062631971643","222",11,2023,20,1);
INSERT INTO PAYMENTS (type,pan,cvv,month,year,customer,status) VALUES ("mastercard","4508651928587699","558",1,2024,41,1),("mastercard","4026457444888303","196",12,2019,44,1),("mastercard","4508806045049953","432",12,2019,2,1),("mastercard","4917751484922325","753",11,2019,27,1),("mastercard","4175009498706540","122",10,2023,30,1),("visa","4917718630903202","557",8,2023,14,1),("mastercard","4844161683510673","585",1,2024,25,1),("mastercard","4917656607432187","682",2,2023,40,1),("mastercard","4175004177905935","367",8,2018,3,1),("mastercard","4844559561261832","869",2,2021,34,1);
INSERT INTO PAYMENTS (type,pan,cvv,month,year,customer,status) VALUES ("mastercard","4917731976009625","941",1,2018,47,1),("mastercard","4508306377520143","623",11,2024,43,1),("mastercard","4175003928224240","143",12,2022,39,1),("visa","4026898724805774","117",6,2017,20,1),("visa","4175005955247960","338",12,2022,32,1),("visa","4508110468686791","748",6,2017,1,1),("mastercard","4508955253308419","809",2,2024,14,1),("visa","4913223975865508","502",12,2017,29,1),("mastercard","4026698576333531","490",7,2018,3,1),("mastercard","4026038979476910","513",11,2019,34,1);




CREATE TABLE CONSOLTYPES (id int NOT NULL AUTO_INCREMENT, 
						name varchar(50) NOT NULL, 
						PRIMARY KEY (id));
INSERT INTO CONSOLTYPES (name)
	VALUES ("wii"), ("wiiu"), ("xbox"), ("psp"), ("playstation"), ("SELECT id FROM PUBLISHERS WHERE name= ?");



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
                        CONSTRAINT  PRODUCTS_CONST UNIQUE(name,consoleid, releasedate),
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



		CREATE TABLE ORDERS (
			id INT AUTO_INCREMENT,
			customerid INT NOT NULL,
			paid BOOLEAN NOT NULL,
			paymentid INT,
			PRIMARY KEY(id),
			FOREIGN KEY(customerid) REFERENCES CUSTOMERS(id),
			FOREIGN KEY(paymentid) REFERENCES PAYMENTS(id)
		);
		
		CREATE TABLE ORDER_LINES (
			id INT AUTO_INCREMENT,
			orderid INT NOT NULL,
			productid INT NOT NULL,
			quantity INT NOT NULL,
			PRIMARY KEY (id),
			FOREIGN KEY (productid) REFERENCES PRODUCTS(id),
			FOREIGN KEY (orderid) REFERENCES ORDERS(id)
		);

		INSERT INTO ORDERS (customerid, paid, paymentid) VALUES 
			(1, true, 1),
			(1, true, 1),
			(1, false, 1);
		
		INSERT INTO ORDER_LINES (orderid, productid, quantity) VALUES 
			(1,1,1),
			(1,2,2);





)