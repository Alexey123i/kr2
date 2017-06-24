package tables;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created by user on 23.06.17.
 */
@Entity
@NamedQueries(
        //@NamedQuery(name = "Product.FindAll", query = "SELECT p FROM Product p")
        @NamedQuery(name = "Product.FindNotParam", query = "Select gp.products FROM Groups_Parameters gp WHERE gp.id<>2")
)
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
    private Collection<Groups_Parameters> parameters;

    public Collection<Groups_Parameters> getParameters() {
        return parameters;
    }

    public void setParameters(Collection<Groups_Parameters> parameters) {
        this.parameters = parameters;
    }
}
