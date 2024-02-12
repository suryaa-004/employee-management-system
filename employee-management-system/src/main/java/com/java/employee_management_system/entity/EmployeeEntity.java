package com.java.employee_management_system.entity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data        //annotation for Getter,Setter,toString() method
@Entity            //defines that a class can be mapped to a table
@Table(name = "employees",schema = "employee")

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
