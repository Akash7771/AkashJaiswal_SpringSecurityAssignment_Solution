package com.greatlearning.service.impl;

import com.greatlearning.entities.Employee;
import com.greatlearning.repositories.EmployeeRepository;
import com.greatlearning.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee findByEmployeeId(Integer employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);

    }

    @Override
    public List<Employee> findAllEmployees() {
        Iterable<Employee> employeeIterable = employeeRepository.findAll();
        List<Employee> employeesList = new ArrayList<>();
        employeeIterable.iterator().forEachRemaining(employeesList::add);
        return employeesList;
    }

    @Override
    public List<Employee> sortAllEmployees(String sort) {
        Sort sortBy ;
        if(sort!=null && sort.equalsIgnoreCase("asc"))
            sortBy = Sort.by(Sort.Direction.ASC , "firstName");
        else
            sortBy = Sort.by(Sort.Direction.DESC , "firstName");

        Iterable<Employee> employeeIterable = employeeRepository.findAll(sortBy);
        List<Employee> employeesList = new ArrayList<>();
        employeeIterable.iterator().forEachRemaining(employeesList::add);
        return employeesList;
    }

    @Override
    public List<Employee> searchEmployeesByFirstName(String searchText) {
        Employee employee = new Employee();
        employee.setFirstName(searchText);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("firstName" , ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withIgnoreNullValues();

        Example<Employee> employeeExample = Example.of(employee , matcher);
        return employeeRepository.findAll(employeeExample);
    }

    @Override
    @Transactional
    public Integer saveOrUpdate(Employee employee) {
        Employee employee1 = employeeRepository.save(employee);
        return employee1.getEmployeeId();
    }

    @Override
    @Transactional
    public void merge(Employee employee) {
        if(findByEmployeeId(employee.getEmployeeId())!=null){
            employeeRepository.save(employee);
        }
    }

    @Override
    @Transactional
    public void delete(Integer employeeId) {
        if(employeeId!=null){
            Employee employee = findByEmployeeId(employeeId);
            if(null!= employee){
                employeeRepository.delete(employee);
            }
        }
    }

}
