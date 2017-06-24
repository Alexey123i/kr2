package beans;

import dao.ProductDAO;
import tables.Product;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.util.List;

/**
 * Created by Alexey on 22.06.2017.
 */
@Named
@SessionScoped
public class ProductBean {
    @EJB
    ProductDAO productDAO;

    Product tmpProduct = new Product();

    public List<Product> getProducts() {
        System.out.println("hello2");
        return productDAO.findNotParam();
    }}
