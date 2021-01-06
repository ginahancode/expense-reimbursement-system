package com.ex.project_1.dao;

import com.ex.project_1.model.Reimbursement;

import java.util.List;

/**
 * Interface for our Data Access Object to handle database queries related to Reimbursements.
 */
public interface ReimbursementDAO {
    public List<Reimbursement> getPendingRequests();
    public List<Reimbursement> getResolvedRequests();
    public List<Reimbursement> getRequestsForEmployee(String employeeUsername);

    public List<Reimbursement> getPendingRequestsForEmployee(String employeeUsername);
    public List<Reimbursement> getResolvedRequestsForEmployee(String employeeUsername);

    public boolean addRequest(Reimbursement reimbursement);
    public void updatePendingRequestStatus(int reimbursementID, String newStatus, String manager);

    // For testing only
    public boolean deleteRequest(int reimbursementID);
    public void deleteRequests();
    public Reimbursement getReimbursement(String description);
}
