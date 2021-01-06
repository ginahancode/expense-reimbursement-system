package com.ex.project_1.servlets;

import com.ex.project_1.dao.ReimbursementDAO;
import com.ex.project_1.dao.ReimbursementDAOImpl;
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
 * Servlet that displays an employee's list of pending requests and list of resolved requests.
 */
@WebServlet("/requests")
public class EmployeeRequestsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String employeeUsername = (String) session.getAttribute("employeeUsername");

        // Get pending and resolved requests for current employee
        ReimbursementDAO rDAO = new ReimbursementDAOImpl();
        List<Reimbursement> pendingRequests = rDAO.getPendingRequestsForEmployee(employeeUsername);
        List<Reimbursement> resolvedRequests = rDAO.getResolvedRequestsForEmployee(employeeUsername);

        request.setAttribute("pendingRequests", pendingRequests);
        request.setAttribute("resolvedRequests", resolvedRequests);
        request.getRequestDispatcher("employeePendingRequests.jsp").forward(request, response);
    }
}
