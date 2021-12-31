package com.greatlearning.service;

import com.greatlearning.entities.Employee;
import java.util.List;

public interface EmployeeService {
    public Employee findByEmployeeId(Integer employeeId);
    public List<Employee> findAllEmployees();
    public List<Employee> sortAllEmployees(String sort);
    public List<Employee> searchEmployeesByFirstName(String searchText);
    public Integer saveOrUpdate(Employee employee);
    public void merge(Employee employee);
    public void delete(Integer employeeId);
}
