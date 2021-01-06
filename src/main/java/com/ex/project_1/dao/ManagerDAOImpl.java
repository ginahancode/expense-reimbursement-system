package com.ex.project_1.dao;

import com.ex.project_1.model.Manager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.*;

import java.util.List;

/**
 * Implementation for the ManagerDAO, responsible for querying the database for Manager objects.
 */
public class ManagerDAOImpl extends DAO implements ManagerDAO {

    /**
     * Used to obtain information about a manager after they provide their username.
     *
     * @param username - The username of the Manager we want to retrieve.
     * @return - The Manager whose username was provided.
     */
    @Override
    public Manager getManagerByUsername(String username) {
        Session session = null;
        Manager manager = null;

        try {
            session = this.sessionFactory.openSession();
            String hql = "FROM Manager WHERE username = :username";
            Query query = session.createQuery(hql);
            query.setString("username", username);

            List<Manager> result = query.list();
            for(Manager m:result) {
                manager = m;
            }
        }
        finally {
            session.close();
        }

        return manager;
    }

//    /**
//     * For testing only.
//     *
//     * @return - A List containing all of the Managers in the database.
//     */
//    @Override
//    public List<Manager> getManagers() {
//        Session session = null;
//        List<Manager> managers = null;
//
//        try {
//            session = this.sessionFactory.openSession();
//            String hql = "FROM Manager";
//            Query query = session.createQuery(hql);
//
//            managers = query.list();
//        }
//        finally {
//            session.close();
//        }
//
//        return managers;
//    }

    /**
     * For testing only.
     *
     * @param manager - The Manager object that we want to add.
     * @return - Whether or not the specified Manager was successfully added.
     */
    @Override
    public boolean addManager(Manager manager) {
        Session session = null;

        try {
            session = this.sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            session.save(manager);

            tx.commit();
        }
        finally {
            session.close();
        }

        return true;
    }

    /**
     * For testing only.
     *
     * @param username - The username of the Manager we want to delete.
     * @return - Whether or not the specified Manager was successfully deleted.
     */
    @Override
    public boolean deleteManager(String username) {
        Session session = null;

        try {
            session = this.sessionFactory.openSession();
            Transaction t = session.beginTransaction();

            String hql = "DELETE Manager WHERE username = :username";
            Query query = session.createQuery(hql);
            query.setParameter("username", username);
            query.executeUpdate();

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
    public void deleteManagers() {
        Session session = null;

        try {
            session = this.sessionFactory.openSession();
            Transaction t = session.beginTransaction();

            String sql = "TRUNCATE Managers";
            SQLQuery query = session.createSQLQuery(sql);
            query.executeUpdate();

            t.commit();
        }
        finally {
            session.close();
        }
    }
}
