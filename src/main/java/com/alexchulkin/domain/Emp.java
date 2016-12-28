package com.alexchulkin.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by alexc_000 on 2016-12-21.
 */
@NamedQueries({
        @NamedQuery(name = "Emp.listAllEmps",
                query = "SELECT new com.alexchulkin.dto.EmpDto(e, COUNT (a)) " +
                        "FROM Emp e LEFT JOIN e.assignedTkts a " +
                        "ON a.status = com.alexchulkin.domain.Status.CLOSED GROUP BY e.id"),
        @NamedQuery(name = "Emp.getEmpTickets",
                query = "SELECT new com.alexchulkin.dto.TktDto(t)" +
                        " FROM Emp e LEFT JOIN e.assignedTkts a LEFT JOIN a.tkt t " +
                        "WHERE e.id = :id AND e.assignedTkts IS NOT EMPTY")
})
@Entity
@Table(name="employee")
public class Emp implements Serializable {
    private static final long serialVersionUID = 1775396841L;

    private Long id;
    private String name;
    private String lastName;
    private Date hiredDate;

    private Set<AssignedTkt> assignedTkts = new HashSet<>();

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotEmpty(message = "Name cannot be empty")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotEmpty(message = "Last name cannot be empty")
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Temporal(value = TemporalType.DATE)
    @Column(name = "hired_date")
    public Date getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    @OneToMany(mappedBy = "emp", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<AssignedTkt> getAssignedTkts() {
        return assignedTkts;
    }

    public void setAssignedTkts(Set<AssignedTkt> assignedTkts) {
        this.assignedTkts = assignedTkts;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }

    @Override
    public boolean equals (Object obj) {
        if (!(obj instanceof  Emp)) {
            return false;
        }
        Emp emp = (Emp) obj;
        return this.id == emp.getId();
    }

    @Override
    public int hashCode () {
        return this.id.hashCode();
    }
}
