package com.alexchulkin.rs;

import com.alexchulkin.dao.DefaultEmpDao;
import com.alexchulkin.dao.EmpDao;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import service.DefaultEmpService;
import service.EmpService;

/**
 * Created by alexc_000 on 2016-12-28.
 */
public class ApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(DefaultEmpService.class).to(EmpService.class);
        bind(DefaultEmpDao.class).to(EmpDao.class);
//        bind(EntityManager.class).to(EntityManager.class);
    }
}
