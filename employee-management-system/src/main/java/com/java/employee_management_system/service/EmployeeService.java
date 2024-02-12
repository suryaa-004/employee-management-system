package com.java.employee_management_system.service;

import com.java.employee_management_system.entity.EmployeeEntity;
import com.java.employee_management_system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    EmployeeEntity employeeEntity;



    public EmployeeEntity createEmployee(EmployeeEntity employeeEntity) {

        //
        if (employeeEntity.getName() == null || employeeEntity.getName().isEmpty()){
            throw new IllegalArgumentException("Employee name is required");
        }
        if (employeeEntity.getEmail() == null || ! isValidEmail(employeeEntity.getEmail())){
            throw new IllegalArgumentException("Employee email is required");
        }
        if (employeeEntity.getDepartmentEntity() != null && employeeEntity.getDepartmentEntity().isEmpty()){
            throw new IllegalArgumentException("Employee department  is required");
        }
        if (employeeEntity.getRole() != null && employeeEntity.getRole().isEmpty()){
            throw new IllegalArgumentException("Employee department  is required");
        }
        if (employeeEntity.getSalary()<=0){
            throw new IllegalArgumentException("salary must be greater than zero and it is required");
        }
        if (employeeEntity.getPhoneNumber()==0){
            throw new IllegalArgumentException("Phone number is required");
        }
        if (employeeEntity.getExperience()<0){
            throw new IllegalArgumentException("Experience cannot  be negative and it is required");
        }
        return employeeRepository.save(employeeEntity);
    }

    // using regex to validate the email address
    private boolean isValidEmail(String email){
        String regex ="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public EmployeeEntity updateEmployee(Long id, EmployeeEntity employeeDetails) {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);
        if (optionalEmployeeEntity.isEmpty())
        {
            throw new IllegalArgumentException("Employee id no "+id +" is not found");
        }

        EmployeeEntity existingEmployee = optionalEmployeeEntity.get();

        if (employeeDetails.getName() != null && !employeeDetails.getName().isEmpty()) {
            existingEmployee.setName(employeeDetails.getName());
        }

        if (employeeDetails.getDepartmentEntity() != null && !employeeDetails.getDepartmentEntity().isEmpty()) {
            existingEmployee.setName(employeeDetails.getName());
        }

        if (employeeDetails.getEmail() != null && !employeeDetails.getEmail().isEmpty()) {
            existingEmployee.setName(employeeDetails.getName());
        }

        if (employeeDetails.getRole() != null && !employeeDetails.getRole().isEmpty()) {
            existingEmployee.setName(employeeDetails.getName());
        }
        if (employeeDetails.getPhoneNumber() !=0){
            existingEmployee.setPhoneNumber(employeeDetails.getPhoneNumber());
        }

        if (employeeDetails.getSalary()!=0.0){
            existingEmployee.setSalary(employeeDetails.getSalary());
        }

        if (employeeDetails.getExperience()!=0 && employeeDetails.getExperience()>=2){
            int newExperience = employeeDetails.getExperience();
            if (newExperience>existingEmployee.getExperience()){
                double currentSalary =  existingEmployee.getSalary();
                double incrementPercentage = 0.06 * (newExperience - existingEmployee.getExperience());
                double newSalary = currentSalary + (incrementPercentage *  currentSalary);
                existingEmployee.setSalary(newSalary);
            }
            existingEmployee.setExperience(newExperience);
        }
        return employeeRepository.save(existingEmployee);
    }

}
