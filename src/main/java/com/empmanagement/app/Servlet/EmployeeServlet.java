package com.empmanagement.app.Servlet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.empmanagement.app.Controller.EmployeeController;
import com.empmanagement.app.Exeption.EmployeeException;
import com.empmanagement.app.model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class EmployeeServlet extends HttpServlet {
    private EmployeeController employeeController;

    public void init() {
         this.employeeController = new EmployeeController();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
       List<String> errors  = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        try {
            employees = employeeController.getAllEmployees();
        } catch (EmployeeException e) {
            errors.add(e.getMessage());
        }

        request.setAttribute("employees",employees);
        request.setAttribute("errors", errors);
        getServletContext().getRequestDispatcher("/employees.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        List<String> errors  = new ArrayList<>();
        String success = "";
       Employee employee = new Employee(
                request.getParameter("name"),
                request.getParameter("email"),
                request.getParameter("department"),
                request.getParameter("phone"),
                request.getParameter("post"));
        try{
            success =  employeeController.addEmployee(employee);
        } catch (EmployeeException e) {
            errors.add(e.getMessage());
        }

        request.setAttribute("success", success);
        request.setAttribute("errors", errors);

        doGet(request, response);
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        List<String> errors  = new ArrayList<>();
        String success = "";
        UUID employeeId = UUID.fromString(request.getParameter("id"));
        try{
           success = employeeController.deleteEmployee(employeeId);
        } catch (EmployeeException e) {
            errors.add(e.getMessage());
        }
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        List<String> errors  = new ArrayList<>();
        String success = "";
        Employee employee = new Employee(
                request.getParameter("name"),
                request.getParameter("email"),
                request.getParameter("department"),
                request.getParameter("phone"),
                request.getParameter("post")
        );
        employee.setId(UUID.fromString(request.getParameter("id")));
        try {
            success = employeeController.updateEmployee(employee);
        } catch (EmployeeException e) {
            errors.add(e.getMessage());
        }

        request.setAttribute("success", success);
        request.setAttribute("errors", errors);
        getServletContext().getRequestDispatcher("/employees.jsp").forward(request,response);
    }

    public void destroy() {
    }
}
