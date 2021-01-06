package com.ex.project_1.servlets;

import com.ex.project_1.dao.EmployeeDAO;
import com.ex.project_1.dao.EmployeeDAOImpl;
import com.ex.project_1.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet that displays an employee's homepage.
 */
@WebServlet("/employee-homepage")
public class EmployeeHomepageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String employeeUsername = (String) session.getAttribute("employeeUsername");

        // Gets current employee's first name to display on their homepage
        EmployeeDAO eDAO = new EmployeeDAOImpl();
        Employee employee = eDAO.getEmployeeByUsername(employeeUsername);
        String employeeName = employee.getFirstName();

        request.setAttribute("employeeName", employeeName);
        request.getRequestDispatcher("employeeHomepage.jsp").forward(request, response);
    }
}