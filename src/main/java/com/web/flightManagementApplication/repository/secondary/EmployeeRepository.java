package com.web.flightManagementApplication.repository.secondary;

import com.web.flightManagementApplication.models.secondary.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Employee e SET e.salary = e.salary+100 WHERE e.email=:email")
    int updateSalaryByEmail(@Param("email") String email);
}
