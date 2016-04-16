package eu.corstjens.springboot.hibernaten1selects.problem;


import eu.corstjens.springboot.hibernaten1selects.model.Address;
import eu.corstjens.springboot.hibernaten1selects.model.Brand;
import eu.corstjens.springboot.hibernaten1selects.model.WebShop;
import eu.corstjens.springboot.hibernaten1selects.problem.util.BrandUtil;
import org.hibernate.FetchMode;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by koencorstjens on 17/04/16.
 */
public class SolutionEntityGraph {

    private EntityManagerFactory entityManagerFactory;

    @Before
    public void before() {
        entityManagerFactory = Persistence.createEntityManagerFactory("manager1");
    }

    @After
    public void afther() {
        entityManagerFactory.close();
    }


    @Test
    public void getBrandsByHQL() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        EntityGraph<?> graph = entityManager.createEntityGraph(Brand.class);
        Subgraph<WebShop> webShopSubgraph = graph.addSubgraph("webShops");
        webShopSubgraph.addSubgraph("address");

        List<Brand> brands = entityManager.createQuery("select distinct b from Brand b", Brand.class)
                .setHint("javax.persistence.loadgraph", graph)
                .getResultList();

        Assert.assertEquals(8,brands.size());

        BrandUtil.printBrandShopAddress(brands);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void getBrandsByCriteriaAPI() {

        CriteriaBuilder criteriaBuilder = entityManagerFactory.getCriteriaBuilder();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaQuery<Brand> brandCriteriaQuery = criteriaBuilder.createQuery(Brand.class);
        brandCriteriaQuery.distinct(true);
        Root<Brand> root = brandCriteriaQuery.from(Brand.class);
        root.fetch("webShops", JoinType.LEFT).fetch("address", JoinType.LEFT);


        TypedQuery<Brand> query = entityManager.createQuery(brandCriteriaQuery);
        List<Brand> brands = query.getResultList();

        Assert.assertEquals(8,brands.size());

        BrandUtil.printBrandShopAddress(brands);


        entityManager.close();
    }

}
