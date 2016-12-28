package com.alexchulkin.ws;

import com.alexchulkin.dao.EmpDao;
import com.alexchulkin.dto.EmpsListDto;

import javax.ejb.EJB;
import javax.jws.WebService;

/**
 * Created by alexc_000 on 2016-12-22.
 */
@WebService(endpointInterface = "com.alexchulkin.ws.EmpWS", serviceName = "DefaultEmpWS")
public class DefaultEmpWS implements EmpWS {

    @EJB
    private EmpDao empDao;

    @Override
    public EmpsListDto listAllEmps() {
        return new EmpsListDto(empDao.listAllEmps());
    }
}
