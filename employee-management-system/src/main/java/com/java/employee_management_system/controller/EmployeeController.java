package com.java.employee_management_system.controller;

import com.java.employee_management_system.entity.EmployeeEntity;
import com.java.employee_management_system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/employee" )
public class EmployeeController {

    @Autowired
     private  EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<EmployeeEntity> createEmployee (@RequestBody EmployeeEntity employeeEntity) {

        try {
            employeeService.createEmployee(employeeEntity);
            ResponseEntity response = new ResponseEntity("Employee created", HttpStatus.CREATED);
            return response;
        } catch (IllegalArgumentException ia) {
            ResponseEntity response = new ResponseEntity<>("Invalid data format", HttpStatus.BAD_REQUEST);
            return response;
        } catch (DuplicateKeyException dk) {
            ResponseEntity response = new ResponseEntity<>("Employee already Exist", HttpStatus.CONFLICT);
            return response;
        } catch (Exception e) {
            ResponseEntity response = new ResponseEntity<>("Invalid data format", HttpStatus.INTERNAL_SERVER_ERROR);
            return response;
        }

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable Long id ,@RequestBody EmployeeEntity employeeEntity){

        try {
            EmployeeEntity updatedEmployee =employeeService.updateEmployee( id,employeeEntity );
            if(updatedEmployee!=null){
                ResponseEntity response = new ResponseEntity("Employee updated", HttpStatus.OK);
                return response;
            }
            else {
                ResponseEntity response = new ResponseEntity("Employee not found", HttpStatus.NOT_FOUND);
                return response;
            }
        }
        catch (IllegalArgumentException ia) {
            ResponseEntity response = new ResponseEntity<>("Invalid data format", HttpStatus.BAD_REQUEST);
            return response;
        }
        catch (Exception e) {
            ResponseEntity response = new ResponseEntity<>("Invalid data format", HttpStatus.INTERNAL_SERVER_ERROR);
            return response;
        }
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<EmployeeEntity> deleteEmployee(@PathVariable Long id ){

        try {
            employeeService.deleteEmployee( id );
            ResponseEntity response =new ResponseEntity<>("Employee deleted",HttpStatus.OK);
            return response;
        }
        catch (IllegalArgumentException ia){
            ResponseEntity response =new ResponseEntity<>("Employee not found",HttpStatus.NOT_FOUND);
            return response;
        }
        catch (Exception e){
            ResponseEntity response =new ResponseEntity<>(" Internal server error",HttpStatus.INTERNAL_SERVER_ERROR);
            return response;
        }
    }
}
