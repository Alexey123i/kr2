package beans;

import dao.GroupOfProductDAO;
import tables.GroupOfProduct;
import tables.Parameter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ManagedBean
@SessionScoped
public class GroupOfProductBean {
    
    @EJB
    private
    GroupOfProductDAO groupOfProductDAO;

    GroupOfProduct tmpGroupOfProduct = new GroupOfProduct();

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void grByName() {
        System.out.println(name);
        list=new HashSet<>(groupOfProductDAO.findAll(name));
        System.out.println(list.size());
    }

    private HashSet<Parameter> list = new HashSet<>();

    public HashSet<Parameter> getList() {
        return list;
    }

    public void setList(HashSet<Parameter> list) {
        this.list = list;
    }
}

