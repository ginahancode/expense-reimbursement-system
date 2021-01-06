package com.ex.project_1.servlets;

import com.ex.project_1.dao.EmployeeDAO;
import com.ex.project_1.dao.EmployeeDAOImpl;
import com.ex.project_1.dao.ManagerDAO;
import com.ex.project_1.dao.ManagerDAOImpl;
import com.ex.project_1.model.Employee;
import com.ex.project_1.model.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet that displays a manager's homepage.
 */
@WebServlet("/manager-homepage")
public class ManagerHomepageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String managerUsername = (String) session.getAttribute("managerUsername");

        // Gets current manager's first name to display on their homepage
        ManagerDAO mDAO = new ManagerDAOImpl();
        Manager manager = mDAO.getManagerByUsername(managerUsername);
        String managerName = manager.getFirstName();

        req.setAttribute("managerName", managerName);
        req.getRequestDispatcher("managerHomepage.jsp").forward(req, res);
    }
}