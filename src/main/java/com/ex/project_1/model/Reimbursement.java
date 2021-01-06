package com.ex.project_1.model;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Models a record in the reimbursements database table, with instance variables corresponding to properties.
 */
@Entity
@Table(name="REIMBURSEMENTS")
public class Reimbursement {

    @Id
    @Column(name="REIMBURSEMENT_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int reimbursementID;

    @Column(name="EMPLOYEE")
    private String employee;

    @Column(name="PURCHASE_DATE")
    private LocalDate purchase_date;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="AMOUNT")
    private double amount;

    @Column(name="STATUS")
    private String status;

    @Column(name="MANAGER")
    private String manager;

    public Reimbursement() {}

    public Reimbursement(String employee, double amount, String description, String status, String manager) {
        this.employee = employee;
        this.amount = amount;
        this.description = description;
        this.status = status;
        this.manager = manager;
    }

    public int getReimbursementID() {
        return reimbursementID;
    }

    public void setReimbursementID(int reimbursementID) {
        this.reimbursementID = reimbursementID;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public LocalDate getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(LocalDate purchase_date) {
        this.purchase_date = purchase_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Reimbursements{" +
                "reimbursementID=" + reimbursementID +
                ", employee='" + employee + '\'' +
                ", purchase_date=" + purchase_date +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}
