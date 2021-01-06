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
 * Servlet that displays the page where employees can view their information.
 * Also handles employee's input to update their information.
 */
@WebServlet("/update-information")
public class UpdateInformationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String employeeUsername = (String) session.getAttribute("employeeUsername");

        EmployeeDAO eDAO = new EmployeeDAOImpl();
        Employee employee = eDAO.getEmployeeByUsername(employeeUsername);

        request.setAttribute("employee", employee);
        request.getRequestDispatcher("updateInformation.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String employeeUsername = (String) session.getAttribute("employeeUsername");

        EmployeeDAO eDAO = new EmployeeDAOImpl();
        Employee employee = eDAO.getEmployeeByUsername(employeeUsername);

        employee.setEmail(req.getParameter("email"));
        employee.setFirstName(req.getParameter("firstName"));
        employee.setLastName(req.getParameter("lastName"));
        employee.setStreet(req.getParameter("street"));
        employee.setCity(req.getParameter("city"));
        employee.setZipcode(Integer.parseInt(req.getParameter("zipcode")));
        employee.setPhone(Integer.parseInt(req.getParameter("phone")));

        eDAO.updateEmployee(employee);

        resp.sendRedirect(req.getContextPath() + "/response-recorded");
    }
}