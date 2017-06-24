package tables;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by user on 23.06.17.
 */
@Entity
@NamedQueries(
        //@NamedQuery(name = "GroupOfProduct.getParameters", query = "SELECT gpr.groupsOfParameter FROM GroupOfProduct gpr")
        @NamedQuery(name = "GroupOfProduct.getParameters", query = "SELECT par from Groups_Parameters g_p, GroupOfParameter gpar, Parameter par, GroupOfProduct gprod " +
                "WHERE g_p.groupOfParameter=gpar AND g_p.parameter=par AND gprod.groupsOfParameter=g_p.groupOfParameter AND gprod.name=:name")
)
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
