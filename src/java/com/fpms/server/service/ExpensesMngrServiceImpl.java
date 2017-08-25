/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.server.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import com.fpms.client.service.ExpensesMngrService;
import com.fpms.controllers.ExpensesMngrLocal;
import com.fpms.persistence.entities.Expenses;
import com.fpms.shared.dtos.ExpenseDto;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import static com.fpms.service.EntityMapper.*;
import java.util.ArrayList;

/**
 *
 * @author aabello
 */
public class ExpensesMngrServiceImpl extends RemoteServiceServlet implements ExpensesMngrService {

    @EJB
    private ExpensesMngrLocal expensesMngr;
    @Override
    public ExpenseDto addExpense(ExpenseDto expense) {
        return mapToExpenseDto(expensesMngr.addExpense(mapToExpense(expense)));
    }

    @Override
    public ExpenseDto updateExpense(ExpenseDto expense) {
        return mapToExpenseDto(expensesMngr.updateExpense(mapToExpense(expense)));
    }
 
    @Override
    public void deleteExpense(String expenseId) {
        expensesMngr.deleteExpense(expenseId);
    }

    @Override
    public ExpenseDto getExpense(String expenseId) {
        return mapToExpenseDto(expensesMngr.getExpense(expenseId));
    }

    @Override
    public List<ExpenseDto> getExpense() {
        
        List<Expenses> expense = expensesMngr.getExpenses();
        List<ExpenseDto> expenses = new ArrayList<ExpenseDto>();
        
        for (Expenses e: expense){
            
            expenses.add(mapToExpenseDto(e));
        }
        return expenses;
    }

    @Override
    public List<ExpenseDto> getExpense(String sectionId, Date date) {
        
        List<Expenses> expense = expensesMngr.getExpenses(sectionId, date);
        List<ExpenseDto> expenses = new ArrayList<ExpenseDto>();
        for(Expenses e: expense){
            
            expenses.add(mapToExpenseDto(e));
        }
        
        return expenses;
    }

    @Override
    public List<ExpenseDto> getExpense(List<String> expenseIds) {
        
        List<Expenses> expense = expensesMngr.getExpenses(expenseIds);
        List<ExpenseDto> expenses = new ArrayList<ExpenseDto>();
        for (Expenses e: expense){
            
            expenses.add(mapToExpenseDto(e));
        }
        
        return expenses;
    }

    @Override
    public List<ExpenseDto> getExpense(Date from, Date to) {
        List<Expenses> expense = expensesMngr.getExpenses(from, to);
        List<ExpenseDto> expenses = new ArrayList<ExpenseDto>();
        
        for(Expenses e: expense){
            
            expenses.add(mapToExpenseDto(e));
        }
        
        return expenses;
    }

    @Override
    public List<ExpenseDto> getExpense(String sectionId, Date date, String typeId) {
        List<Expenses> expense = expensesMngr.getExpenses(sectionId, date, typeId);
        List<ExpenseDto> expenses = new ArrayList<ExpenseDto>();
        
        for(Expenses e: expense){
            
            expenses.add(mapToExpenseDto(e));
        }
        
        return expenses;
    }

    @Override
    public List<ExpenseDto> getExpense(int month, int year) {
        List<Expenses> expense = expensesMngr.getExpenses(month, year);
        List<ExpenseDto> expenses = new ArrayList<ExpenseDto>();
        
        for(Expenses e: expense){
        
            expenses.add(mapToExpenseDto(e));
        }
        
        return expenses;
    }

    @Override
    public List<ExpenseDto> getExpense(int month, int year, String typeId) {
        List<Expenses> expense = expensesMngr.getExpenses(month, year, typeId);
        List<ExpenseDto> expenses = new ArrayList<ExpenseDto>();
        
        for(Expenses e: expense){
            expenses.add(mapToExpenseDto(e));
        }
        return expenses;
    }

    @Override
    public List<ExpenseDto> getExpense(Date from, Date to, String typeId) {
        List<Expenses> expense = expensesMngr.getExpenses(from, to, typeId);
        List<ExpenseDto> expenses = new ArrayList();
        
        for(Expenses e: expense){
            expenses.add(mapToExpenseDto(e));
        }
        
        return expenses;
    }

    @Override
    public List<ExpenseDto> getExpenseBySection(String sectionId) {
        List<Expenses> expense = expensesMngr.getExpensesBySection(sectionId);
        List<ExpenseDto> expenses = new ArrayList<ExpenseDto>();
        
        for(Expenses e : expense){
            
            expenses.add(mapToExpenseDto(e));
        }
        
        return expenses;
    }
    
    @Override
    public List<ExpenseDto> getExpenseByExpenseType(String typeId) {
        
        List<Expenses> expenses = expensesMngr.getExpensesByExpenseType(typeId);
        List<ExpenseDto> expenseDtos = new ArrayList<ExpenseDto>();
        
        for(Expenses e : expenses){
        
            expenseDtos.add(mapToExpenseDto(e));
        }
        
        return expenseDtos;
        
    }

    @Override
    public List<ExpenseDto> getExpenseBySection(String sectionId, String typeId) {
        List<Expenses> expense = expensesMngr.getExpensesBySection(sectionId, typeId);
        List<ExpenseDto> expenses = new ArrayList();
        
        for(Expenses e: expense){
            expenses.add(mapToExpenseDto(e));
        }
        return expenses;
    }

    @Override
    public List<ExpenseDto> getExpenseBySection(String sectionId, int month, int year) {
        List<Expenses> expense = expensesMngr.getExpensesBySection(sectionId, month, year);
        List<ExpenseDto> expenses = new ArrayList<ExpenseDto>();
        
        for(Expenses e: expense){
            expenses.add(mapToExpenseDto(e));
        }
        
        return expenses;
    }

    @Override
    public List<ExpenseDto> getExpenseBySection(String sectionId, int month, int year, String typeId) {
        List<Expenses> expense = expensesMngr.getExpensesBySection(sectionId, month, year, typeId);
        List<ExpenseDto> expenses = new ArrayList();
        
        for(Expenses e: expense){
            
            expenses.add(mapToExpenseDto(e));
        }
        return expenses;
    }

    @Override
    public List<ExpenseDto> getExpenseBySection(String sectionId, Date from, Date to) {
        List<Expenses> expense = expensesMngr.getExpensesBySection(sectionId, from, to);
        List<ExpenseDto> expenses = new ArrayList<ExpenseDto>();
        
        for(Expenses e: expense){
            expenses.add(mapToExpenseDto(e));
        }
        return expenses;
    }

    @Override
    public List<ExpenseDto> getExpenseBySection(String sectionId, Date from, Date to, String typeId) {
        List<Expenses> expense = expensesMngr.getExpensesBySection(sectionId, from, to, typeId);
        List<ExpenseDto> expenses = new ArrayList<ExpenseDto>();
        
        for(Expenses e: expense){
            expenses.add(mapToExpenseDto(e));
        }
        return expenses;
    }

    @Override
    public double getTotalExpense(String sectionId, Date date) {
        
        return expensesMngr.getTotalExpenses(sectionId, date);
    }

    @Override
    public double getTotalExpense(String sectionId, Date date, String typeId) {
        return expensesMngr.getTotalExpenses(sectionId, date, typeId);
    }

    @Override
    public double getTotalExpense(int month, int year) {
        return expensesMngr.getTotalExpenses(month, year);
    }

    @Override
    public double getTotalExpense(int month, int year, String typeId) {
        return expensesMngr.getTotalExpenses(month, year, typeId);
    }

    @Override
    public double getTotalExpense(Date from, Date to) {
        return expensesMngr.getTotalExpenses(from, to);
    }

    @Override
    public double getTotalExpense(Date from, Date to, String typeId) {
        return expensesMngr.getTotalExpenses(from, to, typeId);
    }

    @Override
    public double getTotalExpenseBySection(String sectionId) {
        return expensesMngr.getTotalExpensesBySection(sectionId);
    }

    @Override
    public double getTotalExpenseBySection(String sectionId, String typeId) {
        return expensesMngr.getTotalExpensesBySection(sectionId, typeId);
    }

    @Override
    public double getTotalExpenseBySection(String sectionId, int month, int year) {
        return expensesMngr.getTotalExpensesBySection(sectionId, month, year);
    }

    @Override
    public double getTotalExpenseBySection(String sectionId, int month, int year, String typeId) {
        return expensesMngr.getTotalExpensesBySection(sectionId, month, year, typeId);
    }

    @Override
    public double getTotalExpenseBySection(String sectionId, Date from, Date to) {
        return expensesMngr.getTotalExpensesBySection(sectionId, from, to);
    }

    @Override
    public double getTotalExpenseBySection(String sectionId, Date from, Date to, String typeId) {
        return expensesMngr.getTotalExpensesBySection(sectionId, from, to, typeId);
    }

    @Override
    public double getTotalExpense(List<ExpenseDto> expenses) {
        List<Expenses> expense = new ArrayList<Expenses>();
        
        for(ExpenseDto e: expenses){
        
            expense.add(mapToExpense(e));
        }
        
        return expensesMngr.getTotalExpenses(expense);
    }

    

}
