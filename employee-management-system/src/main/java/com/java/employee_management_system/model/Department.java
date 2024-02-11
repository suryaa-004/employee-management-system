package com.java.employee_management_system.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "department",schema = "employee")
public class Department {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @OneToMany
    @JoinColumn(name = "department",nullable = false)
     private  long id;

    @Column(name = "dep_id")
    private long departmentId;

    @Column(name = "dep_name")
    private String departmentName;


}
