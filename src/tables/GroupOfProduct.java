package tables;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NamedQueries({
        @NamedQuery(name = "GroupOfProduct.getParameters", query ="select par FROM GroupOfProduct gprod, GroupOfParameter gparam, Parameter par WHERE gparam=gprod.groupsOfParameter AND par=gparam.parameters AND gprod.name=:name"),
        @NamedQuery(name = "GroupOfProduct.FindByProductName",
                query = "SELECT gpr FROM GroupOfProduct gpr, Product p WHERE p.description=:productName AND gpr.products=p")
})
public class GroupOfProduct {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "groupOfProduct")
    private Collection<Product> products;

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    @ManyToMany
    private Collection<GroupOfParameter> groupsOfParameter;

    public Collection<GroupOfParameter> getGroupsOfParameter() {
        return groupsOfParameter;
    }

    public void setGroupsOfParameter(Collection<GroupOfParameter> groupsOfParameter) {
        this.groupsOfParameter = groupsOfParameter;
    }
}
