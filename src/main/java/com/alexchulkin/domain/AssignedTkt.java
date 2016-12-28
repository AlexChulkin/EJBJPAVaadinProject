package com.alexchulkin.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by alexc_000 on 2016-12-21.
 */
@Entity
@Table(name = "assigned_tickets", uniqueConstraints = @UniqueConstraint(columnNames = {"employee_id", "ticket_id"}))
public class AssignedTkt implements Serializable {
    private static final long serialVersionUID = 9230295721L;

    private Long id;
    private Emp emp;
    private Tkt tkt;
    private Status status;
    private Date assignedDate;
    private Date resolvedDate;
    private Date closedDate;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "employee_id")
    public Emp getEmp() {
        return emp;
    }

    public void setEmp(Emp emp) {
        this.emp = emp;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    public Tkt getTkt() {
        return tkt;
    }

    public void setTkt(Tkt tkt) {
        this.tkt = tkt;
    }

    @Enumerated(EnumType.STRING)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="assigned_date")
    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="resolved_date")
    public Date getResolvedDate() {
        return resolvedDate;
    }

    public void setResolvedDate(Date resolvedDate) {
        this.resolvedDate = resolvedDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="closed_date")
    public Date getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
    }
}
