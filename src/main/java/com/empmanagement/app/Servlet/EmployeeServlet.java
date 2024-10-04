package com.empmanagement.app.Servlet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.empmanagement.app.Controller.EmployeeController;
import com.empmanagement.app.Exeption.EmployeeException;
import com.empmanagement.app.model.Employee;
import com.empmanagement.app.utils.validation.EmployeeValidation;
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
        List <String> departments = employees.stream().map(Employee::getDepartment).distinct().toList();
        List <String> posts = employees.stream().map(Employee::getPost).distinct().toList();
        request.setAttribute("departments",departments);
        request.setAttribute("posts",posts);
        request.setAttribute("employees",employees);
        request.setAttribute("errorsCatch", errors);
        getServletContext().getRequestDispatcher("/employees.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String method = request.getParameter("method");
        switch (method){
            case "delete":
                doDelete(request, response);
                break;
            case "update":
                doPut(request, response);
                break;
            case "post":
                List<String> errors  = new ArrayList<>();
                String success = "";
                Employee employee = new Employee(
                        request.getParameter("name"),
                        request.getParameter("email"),
                        request.getParameter("department"),
                        request.getParameter("phone"),
                        request.getParameter("post"));
                try{
                    List<String> validationErrors = EmployeeValidation.validateEmployee(employee,false);
                if(validationErrors.isEmpty()){
                    success =  employeeController.addEmployee(employee);
                }else {
                    errors = validationErrors;
                }
                } catch (EmployeeException e) {
                    errors.add(e.getMessage());
                }
                request.setAttribute("success", success);
                request.setAttribute("errors", errors);
                doGet(request, response);
                break;
            default:
                break;
        }

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
        request.setAttribute("success", success);
        request.setAttribute("errors", errors);
        doGet(request, response);
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
            List<String> validationErrors = EmployeeValidation.validateEmployee(employee,true);
            if(validationErrors.isEmpty()){
                success = employeeController.updateEmployee(employee);
            }else {
                errors = validationErrors;
            }
        } catch (EmployeeException e) {
            errors.add(e.getMessage());
        }
        request.setAttribute("success", success);
        request.setAttribute("errors", errors);
        doGet(request, response);
    }


    public void destroy() {
    }
}
