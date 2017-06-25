package dao;

import tables.GroupOfProduct;
import tables.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ProductDAO {
    @PersistenceContext
    EntityManager em;

    public List<Product> findWithParam(String parameterName) {
        Query query = em.createNamedQuery("Product.FindWithParametr");
        query.setParameter("parameterName", parameterName);
        return query.getResultList();
       // return em.createNamedQuery("Product.FindNotParam").getResultList();
    }

    public List<Product> findByGroup(String groupName) {
        Query query = em.createNamedQuery("Product.FindByGroup");
        query.setParameter("groupName", groupName);
        return query.getResultList();
    }

    public List<Product> findByName(String productName) {
        Query query = em.createNamedQuery("Product.FindByName");
        query.setParameter("productName", productName);
        return query.getResultList();
    }

    public List<GroupOfProduct> findGroup(String productName) {
        Query query = em.createNamedQuery("GroupOfProduct.FindByProductName");
        query.setParameter("productName", productName);
        return query.getResultList();
    }


    public void deleteByParameter(List<Product> products) {
        System.out.println("khdfjkjsfjdhfkjsdhfjdshjsf000000 00000000 00000000");
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println("Removed "+products.get(i).getDescription());
            if (!em.contains(product)) {
                product = em.merge(products.get(i));
            }
            em.remove(product);
        }
    }
}
