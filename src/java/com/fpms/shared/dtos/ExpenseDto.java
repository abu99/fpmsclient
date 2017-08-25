/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.shared.dtos;

import com.google.gwt.user.client.rpc.IsSerializable;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author aabello
 */
public class ExpenseDto implements Serializable, IsSerializable{
    
    private String expenseId;
    private ExpenseTypeDto expenseTypeId;
    private FarmSectionDto sectionId;
    private double amount;
    private Date createdDate;
    private String description;

    public ExpenseDto() {
    }
    

    public ExpenseDto(String expenseId, ExpenseTypeDto expenseTypeId, 
            FarmSectionDto sectionId, double amount, Date createdDate,
            String description) {
        this.expenseId = expenseId;
        this.expenseTypeId = expenseTypeId;
        this.sectionId = sectionId;
        this.amount = amount;
        this.createdDate = createdDate;
        this.description = description;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public ExpenseTypeDto getExpenseTypeId() {
        return expenseTypeId;
    }

    public void setExpenseTypeId(ExpenseTypeDto expenseTypeId) {
        this.expenseTypeId = expenseTypeId;
    }

    public FarmSectionDto getSectionId() {
        return sectionId;
    }

    public void setSectionId(FarmSectionDto sectionId) {
        this.sectionId = sectionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.expenseId != null ? this.expenseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExpenseDto other = (ExpenseDto) obj;
        if ((this.expenseId == null) ? (other.expenseId != null) : !this.expenseId.equals(other.expenseId)) {
            return false;
        }
        return true;
    }
    
    
    
}
