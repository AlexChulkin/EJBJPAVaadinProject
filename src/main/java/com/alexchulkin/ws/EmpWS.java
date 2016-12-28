package com.alexchulkin.ws;

import com.alexchulkin.dto.EmpsListDto;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by alexc_000 on 2016-12-22.
 */
@WebService
@SOAPBinding(style=SOAPBinding.Style.RPC)
public interface EmpWS {
    @WebMethod
    EmpsListDto listAllEmps();
}

