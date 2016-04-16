package eu.corstjens.springboot.hibernate.n1selects.problem;

import eu.corstjens.hibernate.n1selects.model.Category;
import eu.corstjens.springboot.hibernate.n1selects.problem.util.BrandUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by koencorstjens on 17/04/16.
 */
public class SolutionFetchMode {

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
    public void getCathegories() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Category> categories = entityManager.createQuery("select b from Category b", Category.class).getResultList();
        Assert.assertEquals(9, categories.size());
        BrandUtil.print(categories);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
