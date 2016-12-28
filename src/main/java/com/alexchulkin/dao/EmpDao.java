package com.alexchulkin.dao;

import com.alexchulkin.dto.EmpDto;
import com.alexchulkin.dto.TktDto;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by alexc_000 on 2016-12-21.
 */
@Local
public interface EmpDao {
    List<EmpDto> listAllEmps();
    List<TktDto> getEmpTkts(Long id);
    void addEmp(String name, String lastName);
}
