package com.devsuperior.demo.dto;

import com.devsuperior.demo.entities.Department;

import java.io.Serializable;

public class DepartmentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    public Long id;
    public String name;

    public DepartmentDTO() {
    }

    public DepartmentDTO( Long id, String name ) {
        this.id = id;
        this.name = name;
    }

    public DepartmentDTO( Department entity ) {
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }
}
