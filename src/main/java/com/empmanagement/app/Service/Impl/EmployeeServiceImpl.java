package com.empmanagement.app.Service.Impl;

import com.empmanagement.app.Exeption.EmployeeException;
import com.empmanagement.app.Repository.Impl.EmployeeRepoImpl;
import com.empmanagement.app.Repository.Interfaces.EmployeeRepo;
import com.empmanagement.app.Service.Interfaces.EmployeeService;
import com.empmanagement.app.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepo employeeRepo = new EmployeeRepoImpl();

    @Override
    public String addEmployee(Employee employee) throws EmployeeException {
        Boolean isAdded = employeeRepo.add(employee);
        if (isAdded) {
            return "Employee added successfully";
        }
        throw new EmployeeException("failed to add employee");
    }

    @Override
    public Employee findEmployeeById(UUID id) throws EmployeeException {
        Optional<Employee> employee = employeeRepo.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }else {
            throw new EmployeeException("Employee not found");
        }
    }

    @Override
    public List<Employee> getAllEmployees() throws EmployeeException {
        return employeeRepo.getAll();
    }

    @Override
    public String updateEmployee(Employee employee) throws EmployeeException {
        Boolean isExit = employeeRepo.findById(employee.getId()).isPresent();
        if (isExit) {
            Boolean isUpdated = employeeRepo.update(employee);
            if (isUpdated) {
                return "Employee updated successfully";
            }else {
                throw new EmployeeException("failed to update employee");
            }
        }else {
            throw new EmployeeException("Employee not found");
        }
    }

    @Override
    public String deleteEmployee(UUID id) throws EmployeeException {
        Optional<Employee> employee = employeeRepo.findById(id);
        Boolean isDeleted = employeeRepo.delete(employee.orElse(null));
        if (isDeleted) {
            return "Employee deleted successfully";
        }else {
            throw new EmployeeException("failed to delete employee");
        }
    }
}
