package eu.corstjens.springboot.hibernaten1selects.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by koencorstjens on 17/04/16.
 */
@Entity
public class WebShop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "WebshopBrand",
            joinColumns = @JoinColumn(name = "webShopId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "brandId", referencedColumnName = "id"))
    private Set<Brand> brands = new HashSet<>();

    @OneToMany(mappedBy = "webShop")
    private Set<Address> address = new HashSet<>();

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

    public Set<Brand> getBrands() {
        return brands;
    }

    public void setBrands(Set<Brand> brands) {
        this.brands = brands;
    }

    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }
}
