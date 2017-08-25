/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.service;

import com.fpms.shared.dtos.ExpenseDto;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aabello
 */
@RemoteServiceRelativePath("service/expensesmngrservice")
public interface ExpensesMngrService extends RemoteService {

    ExpenseDto addExpense(ExpenseDto expense);
    ExpenseDto updateExpense(ExpenseDto expense);
    void deleteExpense(String expenseId);
    ExpenseDto getExpense(String expenseId);
    List<ExpenseDto> getExpense();
    List<ExpenseDto> getExpense(String sectionId, Date date);
    
    List<ExpenseDto> getExpense(List<String> expenseIds);
    
    List<ExpenseDto> getExpense(Date from, Date to);
    
    List<ExpenseDto> getExpense(String sectionId, Date date, String typeId);
    
    List<ExpenseDto> getExpense(int month, int year);
    
    List<ExpenseDto> getExpense(int month, int year, String typeId);
    
    List<ExpenseDto> getExpense(Date from, Date to, String typeId);
    
    List<ExpenseDto> getExpenseBySection(String sectionId);
    
    List<ExpenseDto> getExpenseBySection(String sectionId, 
            String typeId);
    
    List<ExpenseDto> getExpenseBySection(String sectionId, int month, int year);
    
    List<ExpenseDto> getExpenseBySection(String sectionId, int month, int year, 
            String typeId);
    
    List<ExpenseDto> getExpenseBySection(String sectionId, Date from, Date to);
    
    List<ExpenseDto> getExpenseBySection(String sectionId, Date from, 
            Date to, String typeId);
    List<ExpenseDto> getExpenseByExpenseType(String typeId);
    
    double getTotalExpense(String sectionId, Date date);
    
    double getTotalExpense(String sectionId, Date date, String typeId);
    
    double getTotalExpense(int month, int year);
    
    double getTotalExpense(int month, int year, String typeId);
    
    double getTotalExpense(Date from, Date to);
    
    double getTotalExpense(Date from, Date to, String typeId);
    
    double getTotalExpenseBySection(String sectionId);
    
    double getTotalExpenseBySection(String sectionId, 
            String typeId);
    
    double getTotalExpenseBySection(String sectionId, int month, int year);
    
    double getTotalExpenseBySection(String sectionId, int month, int year, 
            String typeId);
    
    double getTotalExpenseBySection(String sectionId, Date from, Date to);
    
    double getTotalExpenseBySection(String sectionId, Date from, 
            Date to, String typeId);
    
    double getTotalExpense(List<ExpenseDto> expenses);
    
   public static class Util{
       private static ExpensesMngrServiceAsync instance;
       public static ExpensesMngrServiceAsync getInstance(){
           if(instance == null){
               instance = GWT.create(ExpensesMngrService.class);
           }
           return instance;
       }
   }
}
