package tables;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "Product.FindAll",
                    query = "SELECT p FROM Product p"),

        @NamedQuery(name = "Product.FindWithParametr",
                    query = "SELECT p from GroupOfParameter gpar, Parameter par, GroupOfProduct gpr, Product p " +
                            "WHERE gpr=p.groupOfProduct AND gpar=gpr.groupsOfParameter AND par=gpar.parameters AND par.name=:parameterName"),

        @NamedQuery(name = "Product.FindByGroup",
                    query = "SELECT p FROM Product p, GroupOfProduct gpr WHERE gpr.name=:groupName AND p=gpr.products"),

        @NamedQuery(name = "Product.FindByName",
                query = "SELECT p FROM Product p WHERE p.description=:productName"),


})
public class Product {
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
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne(optional = false)
    private GroupOfProduct groupOfProduct;

    public GroupOfProduct getGroupOfProduct() {
        return groupOfProduct;
    }

    public void setGroupOfProduct(GroupOfProduct groupOfProduct) {
        this.groupOfProduct = groupOfProduct;
    }

    @ManyToMany
    private Collection<ParameterValue> parameters;

    public Collection<ParameterValue> getParameters() {
        return parameters;
    }

    public void setParameters(Collection<ParameterValue> parameters) {
        this.parameters = parameters;
    }
}
