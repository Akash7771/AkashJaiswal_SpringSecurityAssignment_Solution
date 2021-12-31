package com.greatlearning.repositories;

import com.greatlearning.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends  JpaRepository<Employee,Integer> {
    //public List<Employee> findByFirstNameContainingIgnoreCase(String searchText);
}
