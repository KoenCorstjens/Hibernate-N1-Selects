package eu.corstjens.springboot.hibernaten1selects.problem;

import eu.corstjens.hibernate.n1selects.model.Brand;
import eu.corstjens.springboot.hibernaten1selects.problem.util.BrandUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by koencorstjens on 17/04/16.
 */
public class SolutionNamedEntityGraph {

    private EntityManagerFactory entityManagerFactory;

    @Before
    public void before() {
        entityManagerFactory = Persistence.createEntityManagerFactory("manager1");
    }

    @After
    public void afther() {
        entityManagerFactory.close();
    }


    // returns to many results
    @Test
    public void getBrands_Graph_BrandWebshop() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        EntityGraph<?> graph = entityManager.createEntityGraph("graph.BrandWebshop");


        List<Brand> brands = entityManager.createQuery("select distinct b from Brand b", Brand.class)
            .setHint("javax.persistence.loadgraph", graph)
            .getResultList();

        Assert.assertEquals(8, brands.size());

        BrandUtil.printBrandShopAddress(brands);

        entityManager.getTransaction().commit();
        entityManager.close();
    }


    // To fix the "returns to many results" add distinct to the query

    @Test
    public void getBrands_Graph_BrandWebshopAddressFixToManyResultsByAtDistinct() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        EntityGraph<?> graph = entityManager.createEntityGraph("graph.BrandWebshopAddress");


        List<Brand> brands = entityManager.createQuery("select distinct b from Brand b", Brand.class)
            .setHint("javax.persistence.loadgraph", graph)
            .getResultList();
        Assert.assertEquals(8, brands.size());
        BrandUtil.printBrandShopAddress(brands);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

}
