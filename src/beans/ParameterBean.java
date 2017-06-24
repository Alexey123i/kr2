package beans;

import dao.ParameterDAO;
import tables.Parameter;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.util.List;

/**
 * Created by Alexey on 23.06.2017.
 */
@Named
@SessionScoped
public class ParameterBean {
    @EJB
    ParameterDAO parameterDAO;

    Parameter tmpParameter = new Parameter();

    public List<Parameter> getParametersByGroupOfProduct() {
        return parameterDAO.findByGroupOfProduct();
    }

//    public List<Parameter> getParameters() {
//        return parameterDAO.findAll();
//    }}
}
