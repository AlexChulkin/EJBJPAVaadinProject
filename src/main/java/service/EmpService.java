package service;

import com.alexchulkin.dto.TktDto;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by alexc_000 on 2016-12-28.
 */
@Local
public interface EmpService {
    List<TktDto> getEmpTkts(Long id);
    void addEmp(String name, String lastName);
}
