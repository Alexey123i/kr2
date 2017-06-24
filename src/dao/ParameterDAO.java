package dao;

import tables.Parameter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Alexey on 22.06.2017.
 */
public class ParameterDAO {
    @PersistenceContext
    EntityManager em;

    public List<Parameter> findByGroupOfProduct() {

        return null;//em.createNamedQuery("Parameter.FindByGroupOfProduct").getResultList();
    }
}
