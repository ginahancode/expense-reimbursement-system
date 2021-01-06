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
import java.time.LocalDate;

/**
 * Servlet that displays the page where employees can submit a new request.
 * Also handles the employee's input for the request itself.
 */
@WebServlet("/submit-request")
public class SubmitRequestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("submitRequest.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Double amount = Double.parseDouble(req.getParameter("amount"));
        String description = req.getParameter("description");

        HttpSession session = req.getSession();
        String employeeUsername = (String) session.getAttribute("employeeUsername");

        // Create the Reimbursement object to add
        Reimbursement request = new Reimbursement();
        request.setEmployee(employeeUsername);
        request.setPurchase_date(LocalDate.now());
        request.setAmount(amount);
        request.setDescription(description);
        request.setStatus("Pending");
        request.setManager("Pending");

        // Add the new object to the appropriate database table
        ReimbursementDAO rDAO = new ReimbursementDAOImpl();
        rDAO.addRequest(request);

        resp.sendRedirect(req.getContextPath() + "/response-recorded");
    }
}
