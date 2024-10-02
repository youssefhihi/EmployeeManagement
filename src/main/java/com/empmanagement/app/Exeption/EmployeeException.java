package com.empmanagement.app.Exeption;

public class EmployeeException extends Exception {
    public EmployeeException(String message) {
        super(message);
    }

    public EmployeeException(String message, Throwable cause) {
        super(message, cause);
    }
}
