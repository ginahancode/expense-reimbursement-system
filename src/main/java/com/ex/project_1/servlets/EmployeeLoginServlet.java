package com.ex.project_1.servlets;

import com.ex.project_1.dao.EmployeeDAO;
import com.ex.project_1.dao.EmployeeDAOImpl;
import com.ex.project_1.model.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet that displays the employee login page.
 * Also authenticates the employee using their input.
 */
@WebServlet("/employee-login")
public class EmployeeLoginServlet extends HttpServlet {
    Logger logger = LogManager.getLogger(EmployeeLoginServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("employeeLogin.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        EmployeeDAO eDAO = new EmployeeDAOImpl();
        Employee employee = eDAO.getEmployeeByUsername(username);

        if (employee != null) {
            if (password.equals(employee.getPassword())) {
                // Save Employee globally
                HttpSession session = req.getSession();
                session.setAttribute("employeeUsername", username);

                // Redirect to Employee Homepage
                resp.sendRedirect(req.getContextPath() + "/employee-homepage");
            } else {
                // If password isn't correct
                logger.error("Invalid employee login");
                resp.sendRedirect(req.getContextPath() + "/invalid-login");
            }
        } else {
            // If username doesn't exist
            logger.error("Invalid employee login");
            resp.sendRedirect(req.getContextPath() + "/invalid-login");
        }
    }
}