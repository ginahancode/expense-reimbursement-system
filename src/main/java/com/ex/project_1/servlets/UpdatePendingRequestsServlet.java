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
 * Servlet that displays all pending requests for the manager to see.
 * Also handles manager's input to update a specific pending request.
 */
@WebServlet("/update-pending-requests")
public class UpdatePendingRequestsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // List of all pending requests
        ReimbursementDAO rDAO = new ReimbursementDAOImpl();
        List<Reimbursement> pendingRequests = rDAO.getPendingRequests();

        req.setAttribute("pendingRequests", pendingRequests);
        req.getRequestDispatcher("updatePendingRequests.jsp").forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int reimbursementID = Integer.parseInt(req.getParameter("reimbursementID"));
        String newStatus = req.getParameter("newStatus");

        HttpSession session = req.getSession();
        String managerUsername = (String) session.getAttribute("managerUsername");

        ReimbursementDAO rDAO = new ReimbursementDAOImpl();
        rDAO.updatePendingRequestStatus(reimbursementID, newStatus, managerUsername);

        // Show a success or failure message
        res.sendRedirect(req.getContextPath() + "/manager-response-recorded");
    }
}
