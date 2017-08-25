/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.service;

import com.fpms.shared.dtos.ExpenseDto;
import com.fpms.shared.dtos.ProfitDto;
import com.fpms.shared.dtos.StockDto;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aabello
 */
public interface ProfitMngrServiceAsync {

    public void getTotalProfitBySection(String sectionId, AsyncCallback<Double> asyncCallback);

    public void getTotalProfitBySeason(String sectionId, Date date, AsyncCallback<Double> asyncCallback);

    public void getTotalProfitByDate(Date from, Date to, AsyncCallback<Double> asyncCallback);

    public void getTotalProfitByYear(int Month, int Year, AsyncCallback<Double> asyncCallback);

    public void getTotalProfit(AsyncCallback<Double> asyncCallback);

    public void getStock(AsyncCallback<List<StockDto>> asyncCallback);

    public void getExpenses(AsyncCallback<List<ExpenseDto>> asyncCallback);

    public void getProfit(AsyncCallback<List<ProfitDto>> asyncCallback);
}
