package dao;

import tables.GroupOfParameter;
import tables.GroupOfProduct;
import tables.Parameter;
import tables.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey on 22.06.2017.
 */
@Stateless
public class GroupOfProductDAO {
    @PersistenceContext
    EntityManager em;

    public List<Parameter> findAll(String name) {
        Query query = em.createNamedQuery("GroupOfProduct.getParameters");
        query.setParameter("name", name);
        return query.getResultList();
    }

}
