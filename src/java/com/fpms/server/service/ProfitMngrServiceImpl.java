/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.server.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import com.fpms.client.service.ProfitMngrService;
import com.fpms.controllers.ExpensesMngrLocal;
import com.fpms.controllers.ProfitMngrLocal;
import com.fpms.controllers.StockMngrLocal;
import com.fpms.persistence.entities.Stock;
import com.fpms.shared.dtos.ExpenseDto;
import com.fpms.shared.dtos.StockDto;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import static com.fpms.service.EntityMapper.*;
import com.fpms.shared.dtos.ProfitDto;
import java.util.ArrayList;

/**
 *
 * @author aabello
 */
public class ProfitMngrServiceImpl extends RemoteServiceServlet implements ProfitMngrService {

    @EJB
    private StockMngrLocal stockMngr;
    @EJB
    private ProfitMngrLocal profitMngr;
    @EJB
    private ExpensesMngrLocal expensesMngr;
    
    @Override
    public double getTotalProfitBySection(String sectionId) {
        return profitMngr.getTotalProfitBySection(sectionId);
    }

    @Override
    public double getTotalProfitBySeason(String sectionId, Date date) {
        return profitMngr.getTotalProfitBySeason(sectionId, date);
    }

    @Override
    public double getTotalProfitByDate(Date from, Date to) {
        return profitMngr.getTotalProfitByDate(from, to);
    }

    @Override
    public double getTotalProfitByYear(int Month, int Year) {
        return getTotalProfitByYear(Month, Year);
    }

    @Override
    public double getTotalProfit() {
        return getTotalProfit();
    }

    @Override
    public List<StockDto> getStock() {
        return mapToStocks(stockMngr.getStock());
    }
    @Override
    public List<ExpenseDto> getExpenses() {
        return mapToExpenses(expensesMngr.getExpenses());
    }

    @Override
    public List<ProfitDto> getProfit() {
       
        List<ProfitDto> profitDtos = new ArrayList<ProfitDto>();
        double totalExpended = 0;
        double totalGain = 0;
        
        int i = 1;
        for (ExpenseDto exp : getExpenses()) {
            ProfitDto profit = new ProfitDto();
            profit.setItemId(i);
            profit.setStock(null);
            profit.setAmount(exp.getAmount());
            profit.setExpenditure(true);
            profit.setExpenseDescription(exp.getDescription());
            profit.setExpenseType(exp.getExpenseTypeId().getTypeName());
            profit.setSectionExpendedTo(exp.getSectionId().getSectionName());
            
            profitDtos.add(profit);
            
            totalExpended = totalExpended + exp.getAmount();
            i++;
        }
        for (Stock stock : stockMngr.getStock()) {
            ProfitDto profitDto = new ProfitDto();
            profitDto.setItemId(i);
            profitDto.setAmount(stock.getAmount());
            profitDto.setExpenditure(stock.getStockType().equalsIgnoreCase("IN") ? 
                    true : false);
            profitDto.setExpenseDescription("- -");
            profitDto.setExpenseType("- -");
            profitDto.setExpenseType("- -");
            profitDto.setSectionExpendedTo("- -");
            profitDto.setStock(mapToStockDto(stock));
            
            if (profitDto.isExpenditure()) {
                totalExpended += totalExpended;
            } else {
                totalGain = totalGain + stock.getAmount();
            }
            profitDtos.add(profitDto);
            i++;
        }
        for (ProfitDto profit : profitDtos) {
            profit.setTotalExpense(totalExpended);
            profit.setTotalIncome(totalGain);
        }
        return profitDtos;
    }
}
