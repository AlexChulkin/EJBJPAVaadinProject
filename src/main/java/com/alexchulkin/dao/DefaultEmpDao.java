package com.alexchulkin.dao;

import com.alexchulkin.dto.EmpDto;
import com.alexchulkin.dto.TktDto;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by alexc_000 on 2016-12-21.
 */
@Stateless
@EJB(name = "empDao", beanInterface = EmpDao.class)
public class DefaultEmpDao implements EmpDao {
    @PersistenceContext(name = "em")
    private EntityManager entityManager;

    @Override
    public void addEmp(String name, String lastName) {
//        Emp newEmp = new Emp();
//        newEmp.setName(name);
//        newEmp.setLastName(lastName);
//        newEmp.setHiredDate(new Date());
//        entityManager.persist(newEmp);
    }

    @Override
    public List<EmpDto> listAllEmps() {
        TypedQuery<EmpDto> query = entityManager.createNamedQuery("Emp.listAllEmps", EmpDto.class);
        List<EmpDto> resultList = query.getResultList();
        int initialSerNum = 1;
        for (EmpDto e: resultList) {
            e.setSerialNumber(initialSerNum++);
        }
        return resultList;
    }

    @Override
    public List<TktDto> getEmpTkts(Long id) {
//        TypedQuery<TktDto> query = entityManager
//                .createNamedQuery("Emp.getEmpTickets",TktDto.class)
//                .setParameter("id", id);
//        return Collections.unmodifiableList(query.getResultList());
        return null;
    }
}

