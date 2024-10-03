package com.empmanagement.app.utils.validation;

import com.empmanagement.app.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeValidation {

        public static List<String> validateEmployee(Employee employee) {
            List<String> errors = new ArrayList<>();

            if (employee.getName() == null || employee.getName().length() < 2 || employee.getName().length() > 50) {
                errors.add("Name must be between 2 and 50 characters.\n");
                System.out.println(employee.getName());
            }

            if (employee.getEmail() == null || !employee.getEmail().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                errors.add("Please enter a valid email.\n");
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
