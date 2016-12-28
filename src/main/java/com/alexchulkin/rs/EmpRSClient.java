package com.alexchulkin.rs;

/**
 * Created by alexc_000 on 2016-12-25.
 */

import com.alexchulkin.dto.TktDto;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

//import com.alexchulkin.dto.TktsListDto;

public class EmpRSClient {
    ClientConfig config;
    Client client;
    WebTarget webtarget;

    public EmpRSClient() {
        config = new ClientConfig();
        client = ClientBuilder.newClient(config);
        webtarget = client.target("http://localhost:8080/1/");
    }

    public List<TktDto> getEmpTktsXML(Long id) {
        List<TktDto> answer =
                webtarget.path("server").path("empRS")
                        .path("getEmpTkts")
                        .path(id.toString())
                        .request()
                        .accept(MediaType.APPLICATION_XML)
                        .get(new GenericType<List<TktDto>>(){});

        return answer;
    }
}

