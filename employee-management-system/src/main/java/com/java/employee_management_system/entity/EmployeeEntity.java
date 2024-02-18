package com.java.employee_management_system.entity;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "employees")
public class EmployeeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "emp_id")
    private  long empId;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "emp_email")
    private String email;

    @Column(name = "department")
    private String department;

    @Column(name = "Job_role")
    private String role;

    @Column(name = "ph_number")
    private long phoneNumber;

    @Column(name = "salary")
    private double salary;

    @Column(name ="experience")
    private  int experience;
}
