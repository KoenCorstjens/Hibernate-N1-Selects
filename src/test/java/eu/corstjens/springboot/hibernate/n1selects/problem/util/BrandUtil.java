package eu.corstjens.springboot.hibernate.n1selects.problem.util;

import eu.corstjens.hibernate.n1selects.model.Brand;
import eu.corstjens.hibernate.n1selects.model.Category;
import eu.corstjens.hibernate.n1selects.model.Product;
import eu.corstjens.hibernate.n1selects.model.WebShop;

import java.util.List;

/**
 * Created by koencorstjens on 17/04/16.
 */
public class BrandUtil {
    public static void printBrandShopAddress(List<Brand> brands) {
        for (Brand brand : brands) {
            System.out.println("Brand Id: " + brand.getId());
            System.out.println("Brand Name: " + brand.getName());
            System.out.println("Shops: ");
            for (WebShop webShop : brand.getWebShops()) {
                System.out.println("  " + webShop.getName());
            }
            System.out.println("--------------------");
        }
    }

    public static void printBrandShop(List<Brand> brands) {
        for (Brand brand : brands) {
            System.out.println("Brand Id: " + brand.getId());
            System.out.println("Brand Name: " + brand.getName());
            System.out.println("Shops: ");
            for (WebShop webShop : brand.getWebShops()) {
                System.out.println("  " + webShop.getName());
            }
            System.out.println("--------------------");
        }
    }

    public static void print(List<Category> categories) {
        for (Category category : categories) {
            System.out.println("category Id: " + category.getId());
            System.out.println("category Name: " + category.getName());
            System.out.println("producten: ");
            for (Product product : category.getProducts()) {
                System.out.println("  " + product.getName());
            }
            System.out.println("--------------------");
        }

    }
}
