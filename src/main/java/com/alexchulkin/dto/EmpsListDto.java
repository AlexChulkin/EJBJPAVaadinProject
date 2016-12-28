package com.alexchulkin.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by alexc_000 on 2016-12-24.
 */
@XmlRootElement(name = "emps")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmpsListDto {
    @XmlElement(name = "emp")
    private List<EmpDto> emps = new LinkedList<>();

    public EmpsListDto() {
    }

    public EmpsListDto(List<EmpDto> emps) {
        this.setEmps(emps);
    }

    public List<EmpDto> getEmps() {
        return emps;
    }

    public void setEmps(List<EmpDto> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return emps.toString();
    }
}
