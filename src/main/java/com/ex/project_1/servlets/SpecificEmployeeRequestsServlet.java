package com.ex.project_1.servlets;

import com.ex.project_1.dao.*;
import com.ex.project_1.model.Employee;
import com.ex.project_1.model.Manager;
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
 * Servlet that displays all requests for a specific employee for the manager to see.
 */
@WebServlet("/specific-employee-requests")
public class SpecificEmployeeRequestsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // List of specific employee requests
        HttpSession session = req.getSession();
        List<Reimbursement> specificEmployeeRequests = (List<Reimbursement>) session.getAttribute("specificEmployeeRequests");


        req.setAttribute("specificEmployeeRequests", specificEmployeeRequests);
        req.getRequestDispatcher("specificEmployeeRequests.jsp").forward(req, res);
    }
}
