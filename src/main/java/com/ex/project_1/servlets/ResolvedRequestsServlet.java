package com.ex.project_1.servlets;

import com.ex.project_1.dao.ReimbursementDAO;
import com.ex.project_1.dao.ReimbursementDAOImpl;
import com.ex.project_1.model.Reimbursement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet that displays all resolved requests in the database for the manager to see.
 */
@WebServlet("/resolved-requests")
public class ResolvedRequestsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // List of all resolved requests
        ReimbursementDAO rDAO = new ReimbursementDAOImpl();
        List<Reimbursement> resolvedRequests = rDAO.getResolvedRequests();

        req.setAttribute("resolvedRequests", resolvedRequests);
        req.getRequestDispatcher("resolvedRequests.jsp").forward(req, res);
    }
}
