package com.ex.project_1.servlets;

import com.ex.project_1.dao.ManagerDAO;
import com.ex.project_1.dao.ManagerDAOImpl;
import com.ex.project_1.model.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet that displays the manager login page.
 * Also authenticates the manager using their input.
 */
@WebServlet("/manager-login")
public class ManagerLoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("managerLogin.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        ManagerDAO mDAO = new ManagerDAOImpl();
        Manager manager = mDAO.getManagerByUsername(username);

        if (manager != null) {
            if (password.equals(manager.getPassword())) {
                // Save Manager globally
                HttpSession session = req.getSession();
                session.setAttribute("managerUsername", username);

                // Redirect to Manager Homepage
                resp.sendRedirect(req.getContextPath() + "/manager-homepage");
            } else {
                // If password isn't correct
                resp.sendRedirect(req.getContextPath() + "/invalid-login");
            }
        } else {
            // If username doesn't exist
            resp.sendRedirect(req.getContextPath() + "/invalid-login");
        }
    }
}
