package tables;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by user on 23.06.17.
 */
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
    private Collection<Groups_Parameters> groups_parameters;

    public Collection<Groups_Parameters> getGroups_parameters() {
        return groups_parameters;
    }

    public void setGroups_parameters(Collection<Groups_Parameters> groups_parameters) {
        this.groups_parameters = groups_parameters;
    }
}
