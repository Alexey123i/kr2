package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Alexey on 22.06.2017.
 */
public class GroupOfParameterDAO {
    @PersistenceContext
    EntityManager em;
}
