package com.empmanagement.app.Servlet;

import com.empmanagement.app.Controller.EmployeeController;
import com.empmanagement.app.Exeption.EmployeeException;
import com.empmanagement.app.model.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GetServlet extends HttpServlet {
    private EmployeeController employeeController;

    public void init() {
        this.employeeController = new EmployeeController();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        List<String> errors  = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
       // String method = request.getParameter("method");
        String path = request.getServletPath();
        switch (path) {
            case "/employees/edit":
                try {
                    UUID id = UUID.fromString(request.getParameter("id"));
                    Employee employee = employeeController.getEmployee(id);
                    request.setAttribute("employee", employee);
                } catch (EmployeeException e) {
                    errors.add(e.getMessage());
                }
                request.setAttribute("errorsCatch", errors);
                getServletContext().getRequestDispatcher("/update.jsp").forward(request,response);
                break;
            case "filter":
                break;
            case "search":
                break;
            default:
                break;
        }

    }
}
