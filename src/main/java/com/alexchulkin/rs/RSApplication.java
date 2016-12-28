package com.alexchulkin.rs;


import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;
import java.util.Arrays;
import java.util.HashSet;

@ApplicationPath("/rest-prefix")
public class RSApplication extends ResourceConfig {

    public RSApplication() {
        super(new HashSet<>(Arrays.asList(DefaultEmpRS.class)));
        register(new ApplicationBinder());
        packages(true, "com.alexchulkin.rs");
    }
//    @Override
//    public Set<Class<?>> getClasses() {
//        return new HashSet<>(Arrays.asList(DefaultEmpRS.class));
//    }
}