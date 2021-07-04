package com.airxelerate.challenge.domainobject;

import com.airxelerate.challenge.domainvalue.RoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class RoleDO
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleEnum name;

    public RoleDO() {

    }

    public RoleDO(RoleEnum name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RoleEnum getName() {
        return name;
    }

    public void setName(RoleEnum name) {
        this.name = name;
    }
}
