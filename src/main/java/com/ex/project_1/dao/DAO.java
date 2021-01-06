package com.ex.project_1.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Sets up the sessionFactory to be used in all of the DAO classes.
 */
public abstract class DAO {
    private static final Logger logger = LogManager.getLogger(DAO.class);

    protected SessionFactory sessionFactory;

    public DAO() {
        configure();
    }

    protected void configure() {
        Configuration config  = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        this.sessionFactory = config.buildSessionFactory(builder.build());
        logger.info("Configuration set up");
    }
}
