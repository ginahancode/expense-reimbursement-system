package com.ex.project_1.dao;

import com.ex.project_1.model.Employee;
import com.ex.project_1.model.Manager;
import com.ex.project_1.model.Reimbursement;
import com.ex.project_1.servlets.EmployeeLoginServlet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Used to quickly test DAO methods during development.
 */
public class DAOTest {
    static Logger logger = LogManager.getLogger(DAOTest.class);

    public static void main(String[] args) {
        EmployeeDAO eDAO = new EmployeeDAOImpl();
       

        eDAO.deleteEmployee("ghan");
        eDAO.deleteEmployee("aduet");

        logger.info("Employee added");
    }
}
