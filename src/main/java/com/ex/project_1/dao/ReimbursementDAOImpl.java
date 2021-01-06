package com.ex.project_1.dao;

import com.ex.project_1.model.Employee;
import com.ex.project_1.model.Reimbursement;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Implementation for the ReimbursementDAO, responsible for querying the database for Reimbursement objects.
 */
public class ReimbursementDAOImpl extends DAO implements ReimbursementDAO {

    /**
     * Used by a manager to view all pending reimbursement requests in the database.
     *
     * @return - A List of all pending reimbursement requests
     */
    @Override
    public List<Reimbursement> getPendingRequests() {
        Session session = null;
        List<Reimbursement> reimbursements = null;

        try {
            session = this.sessionFactory.openSession();

            String hql = "FROM Reimbursement WHERE status = :status";
            Query query = session.createQuery(hql);
            query.setString("status", "Pending");

            reimbursements = query.list();
        }
        finally {
            session.close();
        }

        return reimbursements;
    }

    /**
     * Used by a manager to view all resolved reimbursement requests in the database.
     *
     * @return - A List of all resolved reimbursement requests
     */
    @Override
    public List<Reimbursement> getResolvedRequests() {
        Session session = null;
        List<Reimbursement> reimbursements = null;

        try {
            session = this.sessionFactory.openSession();

            String hql = "FROM Reimbursement WHERE status = :approved OR status = :denied";
            Query query = session.createQuery(hql);
            query.setString("approved", "Approved");
            query.setString("denied", "Denied");

            reimbursements = query.list();
        }
        finally {
            session.close();
        }

        return reimbursements;
    }

    /**
     * Used by a manager to view all reimbursement requests for a specific employee.
     *
     * @return - A List of all reimbursement requests for the specified employee.
     */
    @Override
    public List<Reimbursement> getRequestsForEmployee(String employeeUsername) {
        Session session = null;
        List<Reimbursement> reimbursements = null;

        try {
            session = this.sessionFactory.openSession();
            String hql = "FROM Reimbursement WHERE employee = :employee";
            Query query = session.createQuery(hql);
            query.setString("employee", employeeUsername);

            reimbursements = query.list();
        }
        finally {
            session.close();
        }

        return reimbursements;
    }

    /**
     * Used by an employee to view all of their pending requests.
     *
     * @return - A List of all pending reimbursement requests for the specified employee.
     */
    @Override
    public List<Reimbursement> getPendingRequestsForEmployee(String employeeUsername) {
        Session session = null;
        List<Reimbursement> reimbursements = null;

        try {
            session = this.sessionFactory.openSession();
            String hql = "FROM Reimbursement WHERE employee = :employee AND status = :status";
            Query query = session.createQuery(hql);
            query.setString("employee", employeeUsername);
            query.setString("status", "Pending");

            reimbursements = query.list();
        }
        finally {
            session.close();
        }

        return reimbursements;
    }

    /**
     * Used by an employee to view all of their resolved requests.
     *
     * @return - A List of all resolved reimbursement requests for the specified employee.
     */
    @Override
    public List<Reimbursement> getResolvedRequestsForEmployee(String employeeUsername) {
        Session session = null;
        List<Reimbursement> reimbursements = null;

        try {
            session = this.sessionFactory.openSession();
            String hql = "FROM Reimbursement WHERE employee = :employee AND (status = :approved OR status = :denied)";
            Query query = session.createQuery(hql);
            query.setString("employee", employeeUsername);
            query.setString("approved", "Approved");
            query.setString("denied", "Denied");

            reimbursements = query.list();

        }
        finally {
            session.close();
        }

        return reimbursements;
    }

    /**
     * Used when an employee submits a new reimbursement request.
     *
     * @param reimbursement - Reimbursement object containing information for the new request.
     * @return - True if the Reimbursement was successfully added, false if not.
     */
    @Override
    public boolean addRequest(Reimbursement reimbursement) {
        Session session = null;

        try {
            session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.save(reimbursement);
            tx.commit();
        }
        finally {
            session.close();
        }

        return true;
    }

    /**
     * Used when a manager updates the status of a pending request to either resolved or denied.
     *
     * @param reimbursementID - The ID of the request whose status needs to be updated.
     * @param newStatus - Either approved or denied.
     * @return - True if the update was successful, false if not.
     */
    @Override
    public void updatePendingRequestStatus(int reimbursementID, String newStatus, String manager) {
        Session session = null;

        try {
            session = this.sessionFactory.openSession();
            Transaction t = session.beginTransaction();

            String hql = "UPDATE Reimbursement " +
                    "SET status = :newStatus, " +
                    "manager = :manager " +
                    "WHERE reimbursementID = :reimbursementID";

            Query query = session.createQuery(hql);
            query.setParameter("newStatus", newStatus);
            query.setParameter("manager", manager);
            query.setParameter("reimbursementID", reimbursementID);
            int result = query.executeUpdate();

            t.commit();
        }
        finally {
            session.close();
        }
    }

    /**
     * For testing only.
     *
     * @param reimbursementID - The ID of the request that needs to be deleted.
     * @return - True if the Reimbursement was successfully deleted, false if not.
     */
    @Override
    public boolean deleteRequest(int reimbursementID) {
        Session session = null;

        try {
            session = this.sessionFactory.openSession();
            Transaction t = session.beginTransaction();

            String hql = "DELETE Reimbursement WHERE reimbursementID = :reimbursementID";
            Query query = session.createQuery(hql);
            query.setParameter("reimbursementID", reimbursementID);
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
    public void deleteRequests() {
        Session session = null;

        try {
            session = this.sessionFactory.openSession();
            Transaction t = session.beginTransaction();

            String sql = "TRUNCATE Reimbursements";
            SQLQuery query = session.createSQLQuery(sql);
            query.executeUpdate();

            t.commit();
        }
        finally {
            session.close();
        }
    }

    /**
     * For testing only.
     *
     * @param description - The description of the Reimbursement we want to retrieve.
     * @return - The Reimbursement with the supplied description.
     */
    @Override
    public Reimbursement getReimbursement(String description) {
        Session session = null;
        Reimbursement reimbursement = null;

        try {
            session = this.sessionFactory.openSession();
            String hql = "FROM Reimbursement WHERE description = :description";
            Query query = session.createQuery(hql);
            query.setString("description", description);

            List<Reimbursement> result = query.list();
            for(Reimbursement r:result) {
                reimbursement = r;
            }
        }
        finally {
            session.close();
        }

        return reimbursement;
    }
}
