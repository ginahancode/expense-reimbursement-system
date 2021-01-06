package com.ex.project_1.dao;

import com.ex.project_1.model.Employee;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Implementation for the EmployeeDAO, responsible for querying the database for Employee objects.
 */
public class EmployeeDAOImpl extends DAO implements EmployeeDAO {

    /**
     * Used by a manager to view a list of all employees.
     *
     * @return A List containing all of the Employees in the database.
     */
    @Override
    public List<Employee> getEmployees() {
        Session session = null;
        List<Employee> employees = null;

        try {
            session = this.sessionFactory.openSession();
            String hql = "FROM Employee";
            Query query = session.createQuery(hql);

            employees = query.list();
        }
        finally {
            System.out.println("here");
            session.close();
        }

        return employees;
    }

    /**
     * Used to obtain information about an employee after they provide their username.
     *
     * @param username - The username of the Employee we want to retrieve.
     * @return - The Employee whose username was provided.
     */
    @Override
    public Employee getEmployeeByUsername(String username) {
        Session session = null;
        Employee employee = null;

        try {
            session = this.sessionFactory.openSession();
            String hql = "FROM Employee WHERE username = :username";
            Query query = session.createQuery(hql);
            query.setString("username", username);

            List<Employee> result = query.list();
            for(Employee e:result) {
                employee = e;
            }
        }
        finally {
            session.close();
        }

        return employee;
    }

    /**
     * Used when a manager registers an employee.
     *
     * @param employee - An Employee object containing information about the new employee.
     * @return - True if the Employee was successfully added, false if not.
     */
    @Override
    public boolean addEmployee(Employee employee) {
        Session session = null;

        try {
            session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.save(employee);
            tx.commit();
        }
        finally {
            session.close();
        }

        return true;
    }

    /**
     * Used when an employee updates their information.
     *
     * @param employee - The updated Employee object.
     * @return - True if the Employee was successfully updated, false if not.
     */
    @Override
    public void updateEmployee(Employee employee) {
        Session session = null;

        try {
            session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            Employee oldEmployee = (Employee) session.load(Employee.class, employee.getEmployeeID());

            oldEmployee.setPassword(employee.getPassword());
            oldEmployee.setEmail(employee.getEmail());
            oldEmployee.setFirstName(employee.getFirstName());
            oldEmployee.setLastName(employee.getLastName());
            oldEmployee.setDateOfBirth(employee.getDateOfBirth());
            oldEmployee.setStreet(employee.getStreet());
            oldEmployee.setCity(employee.getCity());
            oldEmployee.setZipcode(employee.getZipcode());
            oldEmployee.setPhone(employee.getPhone());
            oldEmployee.setTextOK(employee.isTextOK());

            session.save(oldEmployee);
            tx.commit();
        }
        finally {
            session.close();
        }
    }

    /**
     * Used by a manager to delete an existing Employee.
     *
     * @param username - The username of the Employee we want to delete.
     * @return - True if the Employee was successfully deleted, false if not.
     */
    @Override
    public boolean deleteEmployee(String username) {
        Session session = null;

        try {
            session = this.sessionFactory.openSession();
            Transaction t = session.beginTransaction();

            String hql = "DELETE Employee WHERE username = :username";
            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            int result = query.executeUpdate();

            t.commit();
        }
        finally {
            session.close();
        }

        return true;
    }

    /**
     * For testing only.
     */
    @Override
    public void deleteEmployees() {
        Session session = null;

        try {
            session = this.sessionFactory.openSession();
            Transaction t = session.beginTransaction();

            String sql = "TRUNCATE Employees";
            SQLQuery query = session.createSQLQuery(sql);
            int result = query.executeUpdate();
            System.out.println(result);

            t.commit();
        }
        finally {
            session.close();
        }
    }
}
