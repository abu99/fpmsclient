/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.service;

import com.fpms.shared.dtos.ExpenseDto;
import com.fpms.shared.dtos.ProfitDto;
import com.fpms.shared.dtos.StockDto;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aabello
 */
@RemoteServiceRelativePath("service/profitmngrservice")
public interface ProfitMngrService extends RemoteService {
    
    double getTotalProfitBySection(String sectionId);
    
    double getTotalProfitBySeason(String sectionId, Date date);
    
    double getTotalProfitByDate(Date from, Date to);
    
    double getTotalProfitByYear(int Month, int Year);
    
    double getTotalProfit();
    
    List<StockDto> getStock();
    
    List<ExpenseDto> getExpenses();
    
    List<ProfitDto> getProfit();

    public static class Util{
       private static ProfitMngrServiceAsync instance;
       public static ProfitMngrServiceAsync getInstance(){
           if(instance == null){
               instance = GWT.create(ProfitMngrService.class);
           }
           return instance;
       }
    }
}
