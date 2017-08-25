/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.service;

import com.fpms.shared.dtos.ExpenseDto;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aabello
 */
public interface ExpensesMngrServiceAsync {

    public void addExpense(ExpenseDto expense, AsyncCallback<ExpenseDto> asyncCallback);

    public void updateExpense(ExpenseDto expense, AsyncCallback<ExpenseDto> asyncCallback);

    public void deleteExpense(String expenseId, AsyncCallback<Void> asyncCallback);

    public void getExpense(String expenseId, AsyncCallback<ExpenseDto> asyncCallback);

    public void getExpense(AsyncCallback<List<ExpenseDto>> asyncCallback);

    public void getExpense(String sectionId, Date date, AsyncCallback<List<ExpenseDto>> asyncCallback);

    public void getExpense(List<String> expenseIds, AsyncCallback<List<ExpenseDto>> asyncCallback);

    public void getExpense(Date from, Date to, AsyncCallback<List<ExpenseDto>> asyncCallback);

    public void getExpense(String sectionId, Date date, String typeId, AsyncCallback<List<ExpenseDto>> asyncCallback);

    public void getExpense(int month, int year, AsyncCallback<List<ExpenseDto>> asyncCallback);

    public void getExpense(int month, int year, String typeId, AsyncCallback<List<ExpenseDto>> asyncCallback);

    public void getExpense(Date from, Date to, String typeId, AsyncCallback<List<ExpenseDto>> asyncCallback);

    public void getExpenseBySection(String sectionId, AsyncCallback<List<ExpenseDto>> asyncCallback);

    public void getExpenseBySection(String sectionId, String typeId, AsyncCallback<List<ExpenseDto>> asyncCallback);

    public void getExpenseBySection(String sectionId, int month, int year, AsyncCallback<List<ExpenseDto>> asyncCallback);

    public void getExpenseBySection(String sectionId, int month, int year, String typeId, AsyncCallback<List<ExpenseDto>> asyncCallback);

    public void getExpenseBySection(String sectionId, Date from, Date to, AsyncCallback<List<ExpenseDto>> asyncCallback);

    public void getExpenseBySection(String sectionId, Date from, Date to, String typeId, AsyncCallback<List<ExpenseDto>> asyncCallback);

    public void getTotalExpense(String sectionId, Date date, AsyncCallback<Double> asyncCallback);

    public void getTotalExpense(String sectionId, Date date, String typeId, AsyncCallback<Double> asyncCallback);

    public void getTotalExpense(int month, int year, AsyncCallback<Double> asyncCallback);

    public void getTotalExpense(int month, int year, String typeId, AsyncCallback<Double> asyncCallback);

    public void getTotalExpense(Date from, Date to, AsyncCallback<Double> asyncCallback);

    public void getTotalExpense(Date from, Date to, String typeId, AsyncCallback<Double> asyncCallback);

    public void getTotalExpenseBySection(String sectionId, AsyncCallback<Double> asyncCallback);

    public void getTotalExpenseBySection(String sectionId, String typeId, AsyncCallback<Double> asyncCallback);

    public void getTotalExpenseBySection(String sectionId, int month, int year, AsyncCallback<Double> asyncCallback);

    public void getTotalExpenseBySection(String sectionId, int month, int year, String typeId, AsyncCallback<Double> asyncCallback);

    public void getTotalExpenseBySection(String sectionId, Date from, Date to, AsyncCallback<Double> asyncCallback);

    public void getTotalExpenseBySection(String sectionId, Date from, Date to, String typeId, AsyncCallback<Double> asyncCallback);

    public void getTotalExpense(List<ExpenseDto> expenses, AsyncCallback<Double> asyncCallback);

    public void getExpenseByExpenseType(String typeId, AsyncCallback<List<ExpenseDto>> asyncCallback);
}
