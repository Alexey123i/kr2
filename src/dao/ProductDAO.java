package dao;

import tables.Parameter;
import tables.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Alexey on 22.06.2017.
 */
@Stateless
public class ProductDAO {
    @PersistenceContext
    EntityManager em;

    public List<Product> findNotParam() {
        Query query = em.createNamedQuery("Product.FindNotParam");
//        Parameter parameter = new Parameter();
//        parameter.setId(2);
//        parameter.setName("ширина");
//        parameter.setUnit("мм");
//        query.setParameter("param", parameter);
        return query.getResultList();
       // return em.createNamedQuery("Product.FindNotParam").getResultList();
    }
}
