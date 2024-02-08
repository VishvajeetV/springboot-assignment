package com.assignment.springboot.domain.db.models;

import jakarta.persistence.*;
@MappedSuperclass
public class BaseModel {
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    @Column(
        name = "id"
    )
    @Id
    private Long id;
    public BaseModel() {
    }
    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    
    public String toString() {
        return "BaseEntity [id=" + this.id + " ]";
    }
}
