package com.empmanagement.app.utils.validation;

import com.empmanagement.app.Exeption.EmployeeException;
import com.empmanagement.app.Service.Impl.EmployeeServiceImpl;
import com.empmanagement.app.Service.Interfaces.EmployeeService;
import com.empmanagement.app.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeValidation {
    private final static EmployeeService employeeService = new EmployeeServiceImpl();

    public static List<String> validateEmployee(Employee employee, boolean isUpdate) throws EmployeeException {
        List<String> errors = new ArrayList<>();

        if (employee.getName() == null || employee.getName().length() < 2 || employee.getName().length() > 50) {
            errors.add("Name must be between 2 and 50 characters.\n");
        }

        if (employee.getEmail() == null || !employee.getEmail().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            errors.add("Please enter a valid email.\n");
        }

        if (isUpdate) {
            Employee existingEmployee = employeeService.findEmployeeById(employee.getId());
            if (!existingEmployee.getEmail().equals(employee.getEmail())) {
                if (employeeService.findByEmail(employee.getEmail()).isPresent()) {
                    errors.add("This email address is already in use.\n");
                }
            }
        } else {
            if (employeeService.findByEmail(employee.getEmail()).isPresent()) {
                errors.add("This email address is already in use.\n");
            }
        }

        if (employee.getDepartment() == null || employee.getDepartment().length() < 2 || employee.getDepartment().length() > 50) {
            errors.add("Department must be between 2 and 50 characters.\n");
        }

        if (employee.getPhone() == null || !employee.getPhone().matches("\\d{10}")) {
            errors.add("Phone number must be 10 digits.\n");
        }

        if (employee.getPost() == null || employee.getPost().length() < 2 || employee.getPost().length() > 50) {
            errors.add("Post must be between 2 and 50 characters.\n");
        }

        return errors;
    }
}
