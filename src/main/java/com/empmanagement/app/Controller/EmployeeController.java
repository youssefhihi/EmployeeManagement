package com.empmanagement.app.Controller;

import com.empmanagement.app.Exeption.EmployeeException;
import com.empmanagement.app.Service.Impl.EmployeeServiceImpl;
import com.empmanagement.app.Service.Interfaces.EmployeeService;
import com.empmanagement.app.model.Employee;

import java.util.List;
import java.util.UUID;

public class EmployeeController {
    private final EmployeeService employeeService = new EmployeeServiceImpl();

    public String addEmployee(Employee employee) throws EmployeeException {
       return employeeService.addEmployee(employee);
    }

    public Employee getEmployee(UUID id) throws EmployeeException {
        return employeeService.findEmployeeById(id);
    }

    public List<Employee> getAllEmployees() throws EmployeeException {
        return employeeService.getAllEmployees();
    }

    public String updateEmployee(Employee employee) throws EmployeeException {
       return employeeService.updateEmployee(employee);
    }

    public String deleteEmployee(UUID id) throws EmployeeException {
       return employeeService.deleteEmployee(id);
    }
}
