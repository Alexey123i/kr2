package beans;

import dao.GroupOfProductDAO;
import tables.GroupOfProduct;
import tables.Parameter;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Alexey on 22.06.2017.
 */
@Named
@SessionScoped
public class GroupOfProductBean {
    @EJB
    private
    GroupOfProductDAO groupOfProductDAO;

    GroupOfProduct tmpGroupOfProduct = new GroupOfProduct();

    public HashSet<Parameter> getGroupOfProduct() {
        return new HashSet<Parameter>(groupOfProductDAO.findAll(tmpGroupOfProduct.getName()));
    }

    public GroupOfProduct getTmpGroupOfProduct() {
        return tmpGroupOfProduct;
    }

    public void setTmpGroupOfProduct(GroupOfProduct tmpGroupOfProduct) {
        this.tmpGroupOfProduct = tmpGroupOfProduct;
    }

    public GroupOfProductDAO getGroupOfProductDAO() {
        return groupOfProductDAO;
    }

    public void setGroupOfProductDAO(GroupOfProductDAO groupOfProductDAO) {
        this.groupOfProductDAO = groupOfProductDAO;
    }

    public String grByName() {
        this.list=getGroupOfProduct();
        return null;
    }

    HashSet<Parameter> list;

    public HashSet<Parameter> getList() {
        return list;
    }

    public void setList(HashSet<Parameter> list) {
        this.list = list;
    }
}

