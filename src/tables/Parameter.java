package tables;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Parameter {
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

    @Basic
    private String unit;

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @OneToMany(mappedBy = "parameter")
    private Collection<ParameterValue> groups_parameters;

    public Collection<ParameterValue> getGroups_parameters() {
        return groups_parameters;
    }

    public void setGroups_parameters(Collection<ParameterValue> groups_parameters) {
        this.groups_parameters = groups_parameters;
    }

    @ManyToOne(optional = false)
    private GroupOfParameter groupOfParameter;

    public GroupOfParameter getGroupOfParameter() {
        return groupOfParameter;
    }

    public void setGroupOfParameter(GroupOfParameter groupOfParameter) {
        this.groupOfParameter = groupOfParameter;
    }
}
