package com.java.employee_management_system.repository;

import com.java.employee_management_system.entity.DepartmentEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long>{

}
