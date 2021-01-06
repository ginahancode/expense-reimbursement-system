package com.ex.project_1.dao;

import com.ex.project_1.model.Manager;

import java.util.List;

/**
 * Interface for our Data Access Object to handle database queries related to Managers.
 */
public interface ManagerDAO {
    public Manager getManagerByUsername(String username);

    // For testing only
    // public List<Manager> getManagers();
    public boolean addManager(Manager manager);
    public boolean deleteManager(String username);
    public void deleteManagers();
}
