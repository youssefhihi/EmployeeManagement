package com.empmanagement.app;

import java.io.*;

import com.empmanagement.app.model.Employee;
import com.empmanagement.app.utils.HibernateUtil;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Transaction;
import org.hibernate.Session;
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Create a new employee and save it to the database
        Employee employee = new Employee("Jane Doe", "jane@example.com", "HR", "0987654321", "HR Manager");
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(employee);  // Persist the employee object
            transaction.commit();    // Commit the transaction
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();  // Rollback if an error occurs
            }
            e.printStackTrace();
        }

        // Send response back to client
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
