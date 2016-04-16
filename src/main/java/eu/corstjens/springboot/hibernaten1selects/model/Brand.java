package eu.corstjens.springboot.hibernaten1selects.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by koencorstjens on 17/04/16.
 */
@Entity
@NamedEntityGraphs({
    @NamedEntityGraph(name = "graph.BrandWebshop", attributeNodes = @NamedAttributeNode("webShops")),

    @NamedEntityGraph(name = "graph.BrandWebshopAddress",
        attributeNodes = @NamedAttributeNode(value = "webShops", subgraph = "webShops"),
        subgraphs = @NamedSubgraph(name = "webShops", attributeNodes = @NamedAttributeNode("address"))
    )
}
)
public class Brand implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @ManyToMany(mappedBy = "brands")
    private Set<WebShop> webShops = new HashSet<WebShop>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<WebShop> getWebShops() {
        return webShops;
    }

    public void setWebShops(Set<WebShop> webShops) {
        this.webShops = webShops;
    }
}
