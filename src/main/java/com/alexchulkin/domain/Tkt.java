package com.alexchulkin.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by alexc_000 on 2016-12-21.
 */
@Entity
@Table(name="ticket")
public class Tkt implements Serializable {
    private static final long serialVersionUID = 2793481329L;

    private Long id;
    private Tkt parentTkt;
    private String code;
    private String description;
    private Set<Tkt> childTkts = new HashSet<>();
    private Set<AssignedTkt> assignedTkts = new HashSet<>();

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "parent_ticket_id")
    public Tkt getParentTkt() {
        return parentTkt;
    }

    public void setParentTkt(Tkt parentTkt) {
        this.parentTkt = parentTkt;
    }

    @OneToMany(mappedBy = "parentTkt", cascade = CascadeType.ALL)
    public Set<Tkt> getChildTkts() {
        return childTkts;
    }

    public void setChildTkts(Set<Tkt> childTkts) {
        this.childTkts = childTkts;
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

    @OneToMany(mappedBy = "tkt", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<AssignedTkt> getAssignedTkts() {
        return assignedTkts;
    }

    public void setAssignedTkts(Set<AssignedTkt> assignedTkts) {
        this.assignedTkts = assignedTkts;
    }

    @Override
    public boolean equals (Object obj) {
        if (!(obj instanceof  Tkt)) {
            return false;
        }
        Tkt tkt = (Tkt) obj;
        return this.id == tkt.getId();
    }

    @Override
    public int hashCode () {
        return this.id.hashCode();
    }


}

