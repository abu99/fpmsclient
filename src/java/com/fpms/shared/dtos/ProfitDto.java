/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.shared.dtos;

import com.google.gwt.user.client.rpc.IsSerializable;
import java.io.Serializable;

/**
 *
 * @author kip
 */
public class ProfitDto implements Serializable, IsSerializable {
    private int itemId;
    private StockDto stock;
    private boolean expenditure;
    private String expenseType;
    private String sectionExpendedTo;
    private double amount;
    private String expenseDescription;

    private double totalExpense;
    private double totalIncome;
    private double totalProfit;
    
    public ProfitDto() {
    }

    public StockDto getStock() {
        return stock;
    }

    public void setStock(StockDto stock) {
        this.stock = stock;
    }

    public boolean isExpenditure() {
        return expenditure;
    }

    public void setExpenditure(boolean expenditure) {
        this.expenditure = expenditure;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public String getSectionExpendedTo() {
        return sectionExpendedTo;
    }

    public void setSectionExpendedTo(String sectionExpendedTo) {
        this.sectionExpendedTo = sectionExpendedTo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.itemId;
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
        final ProfitDto other = (ProfitDto) obj;
        if (this.itemId != other.itemId) {
            return false;
        }
        return true;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(double totalProfit) {
        this.totalProfit = totalProfit;
    }
    
}
