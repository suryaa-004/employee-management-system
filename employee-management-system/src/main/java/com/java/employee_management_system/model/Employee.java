package com.java.employee_management_system.model;
import lombok.Data;

import javax.persistence.*;
@Data        /*annotation for Getter,Setter,toString() method ,
               equals() and hashCode() implementations ,
               Constructor that initializes all final fields*/


@Entity            //defines that a class can be mapped to a table
@Table(name = "employees",schema = "employee")
public class Employee {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "emp_id")
    private  long empId;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "emp_email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id",nullable = false)
    private Department department ;

    @Column(name = "Job_role")
    private String role;

    @Column(name = "ph_number")
    private long phoneNumber;

    @Column(name = "salary")
    private double salary;

}
