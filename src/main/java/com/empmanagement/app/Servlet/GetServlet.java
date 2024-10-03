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
        List <String> departments = new ArrayList<>();
        List<String> posts = new ArrayList<>();
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
            case "/employees/filter":
                    try {
                        String post = request.getParameter("post");
                        String department = request.getParameter("department");
                        post = (post != null && !post.isEmpty()) ? post : " ";
                        department = (department != null && !department.isEmpty()) ? department : " ";
                        employees = employeeController.filterEmployees(post,department);
                        List<Employee> all  = employeeController.getAllEmployees();
                        departments = all.stream().map(Employee::getDepartment).distinct().toList();
                        posts = all.stream().map(Employee::getPost).distinct().toList();
                    } catch (EmployeeException e) {
                        errors.add(e.getMessage());
                    }
                    request.setAttribute("departments",departments);
                    request.setAttribute("posts",posts);
                    request.setAttribute("errorsCatch", errors);
                    request.setAttribute("employees", employees);
                    getServletContext().getRequestDispatcher("/employees.jsp").forward(request,response);
                break;
            case "/employees/search":

                try {
                    String query = request.getParameter("search");
                    employees = employeeController.searchEmployee(query);
                    List<Employee> all  = employeeController.getAllEmployees();
                    departments = all.stream().map(Employee::getDepartment).distinct().toList();
                    posts = all.stream().map(Employee::getPost).distinct().toList();
                } catch (EmployeeException e) {
                    errors.add(e.getMessage());
                }
                request.setAttribute("departments",departments);
                request.setAttribute("posts",posts);
                request.setAttribute("errorsCatch", errors);
                request.setAttribute("employees", employees);
                getServletContext().getRequestDispatcher("/employees.jsp").forward(request,response);
                break;
            default:
                break;
        }

    }


}
