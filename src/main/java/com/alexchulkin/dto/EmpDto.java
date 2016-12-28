package com.alexchulkin.dto;

import com.alexchulkin.domain.Emp;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.xml.bind.annotation.*;
import java.util.Date;

/**
 * Created by alexc_000 on 2016-12-21.
 */
@XmlRootElement(name = "emp")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmpDto {
    private static Long nextSerialNum = 0L;

    @XmlAttribute
    private Long id;
    @XmlElement(required=true)
    private Integer serialNumber;
    @XmlElement(nillable=true, required=true)
    private String fullName;
    @XmlElement(nillable = true, required=true)
    private Date hiredDate;
    @XmlElement(required=true)
    private Long numberOfClosedTkts;

    public EmpDto() {
    }

    public EmpDto(Emp emp, Long numberOfClosedTkts) {
        this.id = emp.getId();
        this.fullName = emp.getName() + " " + emp.getLastName();
        this.hiredDate = emp.getHiredDate();
        this.numberOfClosedTkts = numberOfClosedTkts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    public Long getNumberOfClosedTkts() {
        return numberOfClosedTkts;
    }

    public void setNumberOfClosedTkts(Long numberOfClosedTkts) {
        this.numberOfClosedTkts = numberOfClosedTkts;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
