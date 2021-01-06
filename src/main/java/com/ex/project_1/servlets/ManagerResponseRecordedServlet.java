package com.ex.project_1.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet that displays the response recorded page on the manager's side.
 */
@WebServlet("/manager-response-recorded")
public class ManagerResponseRecordedServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("managerResponseRecorded.jsp").forward(req, res);
    }
}
