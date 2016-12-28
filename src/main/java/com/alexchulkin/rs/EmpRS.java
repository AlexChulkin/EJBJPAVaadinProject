package com.alexchulkin.rs;

import com.alexchulkin.dto.TktDto;

import javax.ejb.Local;
import javax.ws.rs.*;
import java.util.List;

//import com.alexchulkin.dto.TktsListDto;

/**
 * Created by alexc_000 on 2016-12-21.
 */
@Local
public interface EmpRS {
    @GET
    @Path("getEmpTkts/{id}")
    @Produces({"application/xml"})
    List<TktDto> getEmpTkts(@PathParam("id") Long id);

    @POST
    @Path("/addEmp")
    @Consumes("application/xml")
    void addEmp(@QueryParam("name") String name, @QueryParam("lastName") String lastName);
}
