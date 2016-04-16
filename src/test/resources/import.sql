INSERT INTO BRAND (id, NAME) VALUES (0, 'Nike');
INSERT INTO BRAND (id, NAME) VALUES (1, 'Asics‎');
INSERT INTO BRAND (id, NAME) VALUES (2, 'Adidas‎');
INSERT INTO BRAND (id, NAME) VALUES (3, 'Puma');
INSERT INTO BRAND (id, NAME) VALUES (4, 'Reebok');
INSERT INTO BRAND (id, NAME) VALUES (5, 'Champion');
INSERT INTO BRAND (id, NAME) VALUES (6, 'Champs');
INSERT INTO BRAND (id, NAME) VALUES (7, 'Columbia');

INSERT INTO WEBSHOP (id, name) VALUES (0, 'United Brands');
INSERT INTO WEBSHOP (id, name) VALUES (1, 'Gi Sport');
INSERT INTO WEBSHOP (id, name) VALUES (2, 'Sports Direct');
INSERT INTO WEBSHOP (id, name) VALUES (3, 'Decathlon');
INSERT INTO WEBSHOP (id, name) VALUES (4, 'eurosportbelgium');
INSERT INTO WEBSHOP (id, name) VALUES (5, 'Zalando');

INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (0, 0);
INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (0, 1);
INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (0, 2);
INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (0, 3);
INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (0, 4);
INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (0, 5);

INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (1, 0);
INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (1, 1);
INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (1, 2);
INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (1, 3);
INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (1, 4);

INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (2, 0);
INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (2, 1);
INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (2, 2);
INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (2, 3);
INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (2, 4);

INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (3, 0);
INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (3, 1);
INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (3, 2);
INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (3, 3);
INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (3, 4);

INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (4, 0);
INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (4, 1);
INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (4, 2);
INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (4, 3);
INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (4, 4);


INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (5, 0);
INSERT INTO WEBSHOPBRAND (BRANDID, WEBSHOPID) VALUES (5, 1);


INSERT INTO ADDRESS (id, URL, WEBSHOPID) VALUES (0, 'www.unitedbrands.be', 0);
INSERT INTO ADDRESS (id, URL, WEBSHOPID) VALUES (1, 'www.unitedbrands.nl', 0);

INSERT INTO ADDRESS (id, URL, WEBSHOPID) VALUES (2, 'www.gisport.be', 1);

INSERT INTO ADDRESS (id, URL, WEBSHOPID) VALUES (3, 'www.decathlon.be', 3);
INSERT INTO ADDRESS (id, URL, WEBSHOPID) VALUES (4, 'www.decathlon.nl', 3);
INSERT INTO ADDRESS (id, URL, WEBSHOPID) VALUES (5, 'www.decathlon.fr', 3);
INSERT INTO ADDRESS (id, URL, WEBSHOPID) VALUES (6, 'www.decathlon.it', 3);

INSERT INTO ADDRESS (id, URL, WEBSHOPID) VALUES (7, 'www.eurosportbelgium.be', 4);


INSERT INTO PRODUCT (id,name) VALUES (0,'Nike Flyknit Racer');
INSERT INTO PRODUCT (id,name) VALUES (1,'Nike Air Max 2014 Flyknit M iD');
INSERT INTO PRODUCT (id,name) VALUES (2,'Nike Free RN Flyknit');
INSERT INTO PRODUCT (id,name) VALUES (3,'Nike Free RN');
INSERT INTO PRODUCT (id,name) VALUES (4,'Nike Free 5.0 iD');

INSERT INTO CATEGORY (id,name) VALUES (0,'Lifestyle');
INSERT INTO CATEGORY (id,name) VALUES (1,'Hardlopen');
INSERT INTO CATEGORY (id,name) VALUES (2,'Fitness en training');
INSERT INTO CATEGORY (id,name) VALUES (3,'Tennis');
INSERT INTO CATEGORY (id,name) VALUES (4,'Golf');
INSERT INTO CATEGORY (id,name) VALUES (5,'Voetbal');
INSERT INTO CATEGORY (id,name) VALUES (6,'Basketbal');
INSERT INTO CATEGORY (id,name) VALUES (7,'Dames');
INSERT INTO CATEGORY (id,name) VALUES (8,'Heren');

INSERT INTO PRODUCTCATEGORY(PRODUCTID, CATEGORYID) VALUES (1,1);
INSERT INTO PRODUCTCATEGORY(PRODUCTID, CATEGORYID) VALUES (2,1);
INSERT INTO PRODUCTCATEGORY(PRODUCTID, CATEGORYID) VALUES (3,1);
INSERT INTO PRODUCTCATEGORY(PRODUCTID, CATEGORYID) VALUES (4,1);
INSERT INTO PRODUCTCATEGORY(PRODUCTID, CATEGORYID) VALUES (4,7);
INSERT INTO PRODUCTCATEGORY(PRODUCTID, CATEGORYID) VALUES (0,8);
INSERT INTO PRODUCTCATEGORY(PRODUCTID, CATEGORYID) VALUES (1,8);


