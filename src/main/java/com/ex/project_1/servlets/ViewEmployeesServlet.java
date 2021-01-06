package com.ex.project_1.servlets;

import com.ex.project_1.dao.EmployeeDAO;
import com.ex.project_1.dao.EmployeeDAOImpl;
import com.ex.project_1.dao.ReimbursementDAO;
import com.ex.project_1.dao.ReimbursementDAOImpl;
import com.ex.project_1.model.Employee;
import com.ex.project_1.model.Reimbursement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Servlet that displays all employees for the manager to see.
 * Also handles manager's input to view a specific employee's requests.
 */
@WebServlet("/view-employees")
public class ViewEmployeesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // List of all employees
        EmployeeDAO eDAO = new EmployeeDAOImpl();
        List<Employee> employees = eDAO.getEmployees();

        req.setAttribute("employees", employees);
        req.getRequestDispatcher("viewEmployees.jsp").forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String employeeUsername = req.getParameter("employeeUsername");

        EmployeeDAO eDAO = new EmployeeDAOImpl();
        Employee employee = eDAO.getEmployeeByUsername(employeeUsername);
        String employeeName = employee.getFirstName();

        ReimbursementDAO rDAO = new ReimbursementDAOImpl();
        List<Reimbursement> specificEmployeeRequests = rDAO.getRequestsForEmployee(employeeUsername);

        HttpSession session = req.getSession();
        session.setAttribute("employeeName", employeeName);
        session.setAttribute("specificEmployeeRequests", specificEmployeeRequests);
        res.sendRedirect(req.getContextPath() + "/specific-employee-requests");
    }
}
