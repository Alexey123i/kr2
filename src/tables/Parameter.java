package tables;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by user on 23.06.17.
 */
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
    private Collection<Groups_Parameters> groups_parameters;

    public Collection<Groups_Parameters> getGroups_parameters() {
        return groups_parameters;
    }

    public void setGroups_parameters(Collection<Groups_Parameters> groups_parameters) {
        this.groups_parameters = groups_parameters;
    }
}
