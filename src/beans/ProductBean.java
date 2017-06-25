package beans;

import dao.ProductDAO;
import tables.GroupOfProduct;
import tables.ParameterValue;
import tables.Product;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class ProductBean {
    @EJB
    private
    ProductDAO productDAO;

    private Product tmpProduct = new Product();

    private String parameterName;
    private String groupName;
    private String productName;

    private List<Product> products;
    private List<ParameterValue> values = new ArrayList<>();

    public void productsWithParameter() {
        products=productDAO.findWithParam(parameterName);
    }

    public void productsByGroup() {
        products=productDAO.findByGroup(groupName);}

    public void productsByName() {
        tmpProduct=productDAO.findByName(productName).get(0);
        values.clear();
        values.addAll(tmpProduct.getParameters());
    }

    public void productDeleteByParameter() {
        productDAO.deleteByParameter(productDAO.findWithParam(parameterName));
    }


    public List<Product> getProducts() { return products; }

    public void setProducts(List<Product> products) { this.products = products; }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Product getTmpProduct() { return tmpProduct; }

    public void setTmpProduct(Product tmpProduct) { this.tmpProduct = tmpProduct; }

    public List<ParameterValue> getValues() { return values; }

    public void setValues(List<ParameterValue> values) { this.values = values; }


}
