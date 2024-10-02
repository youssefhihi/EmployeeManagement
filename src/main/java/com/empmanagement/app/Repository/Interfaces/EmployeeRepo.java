package com.empmanagement.app.Repository.Interfaces;

import com.empmanagement.app.Exeption.EmployeeException;
import com.empmanagement.app.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepo {
    Boolean add(Employee employee) throws EmployeeException;
    Optional<Employee> findById(UUID id) throws EmployeeException;
    List<Employee> getAll() throws EmployeeException;
    Boolean update(Employee employee) throws EmployeeException;
    Boolean delete(Employee employee) throws EmployeeException;
}
