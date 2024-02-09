package com.assignment.springboot.domain.db.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "department")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Department extends BaseModel{
    @Column(name = "name")
    private String name;
}
