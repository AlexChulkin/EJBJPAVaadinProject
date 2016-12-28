package service;

import com.alexchulkin.domain.Emp;
import com.alexchulkin.dto.TktDto;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by alexc_000 on 2016-12-28.
 */
@Stateless
public class DefaultEmpService implements EmpService {
    @PersistenceContext(name="em")
    EntityManager entityManager;

    @PostConstruct
    public void init(){
        System.out.println("Entering EmpService.init()");
        try {
            InitialContext context = new InitialContext();
            entityManager = (EntityManager)context.lookup("java:comp/env/em");
            System.out.println("Object of mySessionBeanLocal " + entityManager);
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Exiting EmpService.init()");
    }

    @Override
    public List<TktDto> getEmpTkts(Long id) {
        TypedQuery<TktDto> query = entityManager
                .createNamedQuery("Emp.getEmpTickets",TktDto.class)
                .setParameter("id", id);
        return Collections.unmodifiableList(query.getResultList());
    }

    @Override
    public void addEmp(String name, String lastName) {
        Emp newEmp = new Emp();
        newEmp.setName(name);
        newEmp.setLastName(lastName);
        newEmp.setHiredDate(new Date());
        entityManager.persist(newEmp);
    }
}
