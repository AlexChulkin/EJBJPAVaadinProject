package com.alexchulkin.rs;

import com.alexchulkin.dao.EmpDao;
import com.alexchulkin.dto.TktDto;
import service.EmpService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;
import java.util.List;
import java.util.stream.Collectors;

//import com.alexchulkin.dto.TktsListDto;

/**
 * Created by alexc_000 on 2016-12-22.
 */
@Path("empRS")
@Stateless
public class DefaultEmpRS implements EmpRS {
    @EJB
    EmpDao empDao;
    @Inject
    EmpService empService;

    @Override
    public List<TktDto> getEmpTkts(Long id) {
//        try {
//            InitialContext ctx = new InitialContext();
//            empDao = (EmpDao) ctx.lookup("java:comp/env/empDao");
//        } catch (NamingException e) {
//            e.printStackTrace();
//            return null;
//        }
        List<TktDto> res = empService.getEmpTkts(id).stream().filter(t -> t!=null).collect(Collectors.toList());

        return res;
    }

    @Override
    public void addEmp(String name, String lastName) {
        empService.addEmp(name, lastName);
    }
}
