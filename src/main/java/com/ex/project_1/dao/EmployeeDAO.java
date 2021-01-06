package com.ex.project_1.dao;

import com.ex.project_1.model.Employee;

import java.util.List;

/**
 * Interface for our Data Access Object to handle database queries related to Employees.
 */
public interface EmployeeDAO {
    public List<Employee> getEmployees();
    public Employee getEmployeeByUsername(String username);

    public boolean addEmployee(Employee employee);
    public void updateEmployee(Employee employee);

    // For testing only
    public boolean deleteEmployee(String username);
    public void deleteEmployees();
}
