package eu.corstjens.springboot.hibernaten1selects.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by koencorstjens on 17/04/16.
 */
@Entity
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String url;

    @ManyToOne
    @JoinColumn(name = "WEBSHOPID")
    private WebShop webShop;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WebShop getWebShop() {
        return webShop;
    }

    public void setWebShop(WebShop webShop) {
        this.webShop = webShop;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
