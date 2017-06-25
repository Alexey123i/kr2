package tables;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class GroupOfParameter {
    @GeneratedValue (strategy = GenerationType.IDENTITY)
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

    @ManyToMany(mappedBy = "groupsOfParameter")
    private Collection<GroupOfProduct> groupsOfProducts;

    public Collection<GroupOfProduct> getGroupsOfProducts() {
        return groupsOfProducts;
    }

    public void setGroupsOfProducts(Collection<GroupOfProduct> groupsOfProducts) {
        this.groupsOfProducts = groupsOfProducts;
    }

    @OneToMany(mappedBy = "groupOfParameter")
    private Collection<Parameter> parameters;

    public Collection<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(Collection<Parameter> parameters) {
        this.parameters = parameters;
    }
}
