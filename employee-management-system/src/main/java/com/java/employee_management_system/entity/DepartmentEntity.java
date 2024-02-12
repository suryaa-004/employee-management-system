package com.java.employee_management_system.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "department",schema = "employee")
public class DepartmentEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
     private  long id;

    @Column(name = "dep_id")
    private long departmentId;

    @Column(name = "dep_name")
    private String departmentName;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employeeEntity;


}
