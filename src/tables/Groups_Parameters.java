package tables;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by user on 23.06.17.
 */
@Entity
public class Groups_Parameters {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Basic
    private String Value;

    @ManyToOne
    private GroupOfParameter groupOfParameter;

    @ManyToOne
    private Parameter parameter;

    public GroupOfParameter getGroupOfParameter() {
        return groupOfParameter;
    }

    public void setGroupOfParameter(GroupOfParameter groupOfParameter) {
        this.groupOfParameter = groupOfParameter;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToMany(mappedBy = "parameters")
    private Collection<Product> products;

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}
