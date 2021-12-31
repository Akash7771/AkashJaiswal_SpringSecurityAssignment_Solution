package com.greatlearning.controller;

import com.greatlearning.entities.Employee;
import com.greatlearning.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
@CrossOrigin
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "" , method = RequestMethod.GET)
    public @ResponseBody List<Employee> fetchAllEmployees(){
        return employeeService.findAllEmployees();
    }

    @RequestMapping(value = "" , method = RequestMethod.POST)
    public @ResponseBody Employee saveEmployee(@RequestBody Employee employee){
        Integer employeeId = employeeService.saveOrUpdate(employee);
        return employeeService.findByEmployeeId(employeeId);
    }

    @RequestMapping(value = "/{employeeId}" , method = RequestMethod.GET)
    public @ResponseBody Employee fetchEmployeeById(@PathVariable("employeeId") Integer employeeId){
        return employeeService.findByEmployeeId(employeeId);
    }

    @RequestMapping(value = "/search/{searchText}" , method = RequestMethod.GET)
    public @ResponseBody List<Employee> searchEmployeeByFirstName(@PathVariable("searchText") String searchText){
        return employeeService.searchEmployeesByFirstName(searchText);
    }

    @RequestMapping(value = "/sort" , method = RequestMethod.GET)
    public @ResponseBody List<Employee> fetchEmployeeOrderBy(@RequestParam(value = "order" ,defaultValue = "desc") String order ){
        return employeeService.sortAllEmployees(order);
    }

    @RequestMapping(value = "/delete/{employeeId}" , method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity deleteEmployee(@PathVariable("employeeId") Integer employeeId){
        employeeService.delete(employeeId);

        return  new ResponseEntity("Deleted employee id - " + employeeId , HttpStatus.OK);
    }

}
