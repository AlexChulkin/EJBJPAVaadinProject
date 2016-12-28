package com.alexchulkin.dto;

import com.alexchulkin.domain.Tkt;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.xml.bind.annotation.*;

/**
 * Created by alexc_000 on 2016-12-22.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TktDto {
    @XmlElement(nillable = true, required = true)
    private Long parentTktId;

    @XmlAttribute
    private Long id;

    @XmlElement(required = true)
    private String code;

    @XmlElement(nillable = true, required = true)
    private String description;

    public TktDto() {
    }

    public TktDto(Tkt tkt) {
        this.id = tkt.getId();
        this.code = tkt.getCode();
        this.description = tkt.getDescription();
        Tkt parent = tkt.getParentTkt();
        this.parentTktId = parent != null ? parent.getId() : null;
    }

    public long getParentTktId() {
        return parentTktId;
    }

    public void setParentTkt(long parentTktId) {
        this.parentTktId = parentTktId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
