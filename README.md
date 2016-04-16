# HIBERNATE : RESOLVING N+1 PROBLEM
Solutions to the Hibernate N+1 Select's problem

This project is to learn and test solution's

**Problem (simple explained)**

Let’s assume that you’re writing an application that’d track the shops that sell sport brands.
So you have a collection of objects representing different brands,
and each brand has a collection of objects representing the shops where you can buy this brands.
And every webshop can have multiple addresses for example decathlon.be, decathlon.nl

To put it simple, there’s exists a many-to-many relationship between Brand:Webshop and a one-to-many between Webshop
and address.

For example if you want to print out all information of all the brand's native Hibernate will do a query to get all the
brands and after catching the results it will do one query for every brand to find the shops. You can see this by running the
TestProblem class.


Explanation of the test classes
-------------------------------
The _TestProblem_ class contains the example of the n+1 problem.
The result is that there are n+1 query's executed:
1 time:
`SELECT b
 FROM Brand b`
n time:
`SELECT webshops0_.brandId AS brandId2_6_0_,
        webshops0_.webShopId AS webShopI1_6_0_,
        webshop1_.id AS id1_5_1_,
        webshop1_.name AS name2_5_1_
 FROM WebshopBrand webshops0_
 INNER JOIN WebShop webshop1_ ON webshops0_.webShopId=webshop1_.id
 WHERE webshops0_.brandId=?`

The _SolutionNamedEntityGraph_ class contains the solution by using the NamedEntityGraph.
the result is one query:
`SELECT brand0_.id AS id1_1_0_,
        webshop2_.id AS id1_5_1_,
        brand0_.name AS name2_1_0_,
        webshop2_.name AS name2_5_1_,
        webshops1_.brandId AS brandId2_6_0__,
        webshops1_.webShopId AS webShopI1_6_0__
 FROM Brand brand0_
 LEFT OUTER JOIN WebshopBrand webshops1_ ON brand0_.id=webshops1_.brandId
 LEFT OUTER JOIN WebShop webshop2_ ON webshops1_.webShopId=webshop2_.id`

The _SolutionEntityGraph_ class contains the solution for the n+1 selection problem by adding programmatically
define Entity Graphs.
the result is one query:
`SELECT DISTINCT brand0_.id AS id1_1_0_,
                 webshop2_.id AS id1_5_1_,
                 address3_.id AS id1_0_2_,
                 brand0_.name AS name2_1_0_,
                 webshop2_.name AS name2_5_1_,
                 webshops1_.brandId AS brandId2_6_0__,
                 webshops1_.webShopId AS webShopI1_6_0__,
                 address3_.url AS url2_0_2_,
                 address3_.WEBSHOPID AS WEBSHOPI3_0_2_,
                 address3_.WEBSHOPID AS WEBSHOPI3_0_1__,
                 address3_.id AS id1_0_1__
 FROM Brand brand0_
 LEFT OUTER JOIN WebshopBrand webshops1_ ON brand0_.id=webshops1_.brandId
 LEFT OUTER JOIN WebShop webshop2_ ON webshops1_.webShopId=webshop2_.id
 LEFT OUTER JOIN Address address3_ ON webshop2_.id=address3_.WEBSHOPID`

The _SolutionFetchMode_ contains the solution for the n+1 selection problem by adding @Fetch(FetchMode.SUBSELECT)
the result is that there are two query's executed:
1 time:
`SELECT b
 FROM Brand b`
1 time:
`SELECT products0_.categoryId AS category2_4_1_,
       products0_.productId AS productI1_4_1_,
       product1_.id AS id1_3_0_,
       product1_.name AS name2_3_0_
FROM ProductCategory products0_
INNER JOIN Product product1_ ON products0_.productId=product1_.id
WHERE products0_.categoryId IN
    (SELECT category0_.id
     FROM Category category0_)`

The _SolutionSpecificFetchInQuery_ contains the solution for the n+1 selection problem by join and fetch in the hql query
`SELECT brand0_.id           AS id1_1_0_,
       webshop2_.id         AS id1_5_1_,
       brand0_.NAME         AS name2_1_0_,
       webshop2_.NAME       AS name2_5_1_,
       webshops1_.brandid   AS brandId2_6_0__,
       webshops1_.webshopid AS webShopI1_6_0__
FROM   brand brand0_
       INNER JOIN webshopbrand webshops1_
               ON brand0_.id = webshops1_.brandid
       INNER JOIN webshop webshop2_
               ON webshops1_.webshopid = webshop2_.id `



Some notes:
-----------
**Show hibernate statistics**
Add `<property name="hibernate.generate_statistics" value="true"/> ` to the persistence unit and
add `log4j.logger.org.hibernate.stat=debug` to the log4j.properties

**Log all SQL DML statements**
`log4j.logger.org.hibernate.SQL=debug` //Log all SQL DML statements as they are executed

**Remarks, ideas or tips are welcome @ koen at corstjens.eu**
