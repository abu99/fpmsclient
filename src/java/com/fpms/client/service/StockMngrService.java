/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.service;

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
@RemoteServiceRelativePath("service/stockmngrservice")
public interface StockMngrService extends RemoteService {

    StockDto addStock(StockDto stockDto);
    
    StockDto updateStock(StockDto stockDto);
    
    void deleteStock(String productId, String sectionId, Date dateCreated);
    
    StockDto getStock(String productId, String sectionId, Date dateCreated);
    
    List<StockDto> getStocks();
    
    List<StockDto> getStocks(String sectionId, Date StartDate);
    
    List<StockDto> getStocks(Date from, Date to);
    
    List<StockDto> getStocks(String sectionId, Date StartDate, String stockType);
    
    List<StockDto> getStocks(int month, int year);
    
    List<StockDto> getStocks(int month, int year, String stockType);
    
    List<StockDto> getStocks(Date from, Date to , String stockType);
    
    List<StockDto> getStockBySection(String sectionId);
    
    List<StockDto> getStockBySection(String sectionId, int month, int year);
    
    List<StockDto> getStockBySection(String sectionId, int month, int year, String stockType);
    
    List<StockDto> getStockBySection(String sectionId, Date from, Date to);
    
    List<StockDto> getStockBySection(String sectionId, Date from, Date to, String stockType);
    
    List<StockDto> getStockByProduct(String productId);
    
    List<StockDto> getStockByProduct(String sectionId, Date StartDate, String productId);
    
    List<StockDto> getStockByProduct(String sectionId, Date StartDate, String productId, String stockType);
    
    List<StockDto> getStockByProduct(String productId, int month, int year);
    
    List<StockDto> getStockByProduct(String productId, int month, int year, String stockType);
    
    List<StockDto> getStockByProduct(String productId, Date from, Date to);
    
    List<StockDto> getStockByProduct(String productId, Date from, Date to, String stockType);
    
    List<StockDto> getStockByExpenseType(String stockType);
    
    List<StockDto> getStockByProductAndSection(String productId, String sectionId);
 
    public static class Util{
        
        private static StockMngrServiceAsync instance;
        public static StockMngrServiceAsync getInstance(){
            
            if(instance == null){
               instance = GWT.create(StockMngrService.class);
            }
            
            return instance;
        }
    }
}
