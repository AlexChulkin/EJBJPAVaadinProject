package com.alexchulkin.ws;

import com.alexchulkin.dto.EmpDto;

import javax.ejb.Stateless;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by alexc_000 on 2016-12-25.
 */
@Stateless
public class EmpWSClient {
    private static final QName qname = new QName("http://ws.alexchulkin.com/", "DefaultEmpWS");
    private static URL url;
    private static Service service;
    private static EmpWS empWS;


    public EmpWSClient() {
        try {
            url = new URL("http://localhost:8080/1/DefaultEmpWS?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        service = Service.create(url, qname);
        empWS = service.getPort(EmpWS.class);
    }

    public List<EmpDto> listAllEmps() {
        return empWS.listAllEmps().getEmps();
    }
}
