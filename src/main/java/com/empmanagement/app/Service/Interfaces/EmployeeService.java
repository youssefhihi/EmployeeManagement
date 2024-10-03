package com.empmanagement.app.Service.Interfaces;

import com.empmanagement.app.Exeption.EmployeeException;
import com.empmanagement.app.model.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    String addEmployee(Employee employee) throws EmployeeException;
    Employee findEmployeeById(UUID id) throws EmployeeException;
    List<Employee> getAllEmployees() throws EmployeeException;
    String updateEmployee(Employee employee) throws EmployeeException;
    String deleteEmployee(UUID id) throws EmployeeException;
    List<Employee> searchEmployee(String query) throws EmployeeException;
    List<Employee> filterEmployees(String post, String department) throws EmployeeException;

}
