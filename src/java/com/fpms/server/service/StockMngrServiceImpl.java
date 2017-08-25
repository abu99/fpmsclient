/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.server.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import com.fpms.client.service.StockMngrService;
import com.fpms.controllers.StockMngrLocal;
import com.fpms.persistence.entities.Stock;
import com.fpms.shared.dtos.StockDto;
import java.util.Date;
import java.util.List;
import static com.fpms.service.EntityMapper.*;
import java.util.ArrayList;
import javax.ejb.EJB;

/**
 *
 * @author aabello
 */
public class StockMngrServiceImpl extends RemoteServiceServlet implements 
        StockMngrService {
    
    @EJB
    private StockMngrLocal stockMngr;    

    @Override
    public StockDto addStock(StockDto stockDto) {
        return mapToStockDto(stockMngr.addStock(mapToStock(stockDto)));
    }

    @Override
    public StockDto updateStock(StockDto stockDto) {
        return mapToStockDto(stockMngr.updateStock(mapToStock(stockDto)));
    }

    @Override
    public void deleteStock(String productId, String sectionId, Date dateCreated) {
        stockMngr.deleteStock(productId, sectionId, dateCreated);
    }

    @Override
    public StockDto getStock(String productId, String sectionId, Date dateCreated) {
        return mapToStockDto(stockMngr.getStock(productId, sectionId, dateCreated));
    }

    @Override
    public List<StockDto> getStocks() {
        List<Stock> stock = stockMngr.getStocks();
        List<StockDto> stockDto = new ArrayList<StockDto>();
        
        for(Stock s: stock){
            stockDto.add(mapToStockDto(s));
        }
        
        return stockDto;
    }

    @Override
    public List<StockDto> getStocks(String sectionId, Date StartDate) {
        List<Stock> stock = stockMngr.getStocks(sectionId, StartDate);
        List<StockDto> stockDto = new ArrayList<StockDto>();
        
        for(Stock s: stock){
            stockDto.add(mapToStockDto(s));
        }
        
        return stockDto;
    }

    @Override
    public List<StockDto> getStocks(Date from, Date to) {
        List<Stock> stock = stockMngr.getStocks(from, to);
        List<StockDto> stockDto = new ArrayList<StockDto>();
        
        for(Stock s: stock){
            stockDto.add(mapToStockDto(s));
        }
        
        return stockDto;
    }

    @Override
    public List<StockDto> getStocks(String sectionId, Date StartDate, String stockType) {
        List<Stock> stock = stockMngr.getStocks(sectionId, StartDate, stockType);
        List<StockDto> stockDto = new ArrayList<StockDto>();
        
        for(Stock s: stock){
            stockDto.add(mapToStockDto(s));
        }
        
        return stockDto;
    }

    @Override
    public List<StockDto> getStocks(int month, int year) {
        List<Stock> stock = stockMngr.getStocks(month, year);
        List<StockDto> stockDto = new ArrayList<StockDto>();
        
        for(Stock s: stock){
            stockDto.add(mapToStockDto(s));
        }
        
        return stockDto;
    }

    @Override
    public List<StockDto> getStocks(int month, int year, String stockType) {
        List<Stock> stock = stockMngr.getStocks(month, year, stockType);
        List<StockDto> stockDto = new ArrayList<StockDto>();
        
        for(Stock s: stock){
            stockDto.add(mapToStockDto(s));
        }
        
        return stockDto;
    }

    @Override
    public List<StockDto> getStocks(Date from, Date to, String stockType) {
        List<Stock> stock = stockMngr.getStocks(from, to, stockType);
        List<StockDto> stockDto = new ArrayList<StockDto>();
        
        for(Stock s: stock){
            stockDto.add(mapToStockDto(s));
        }
        
        return stockDto;
    }

    @Override
    public List<StockDto> getStockBySection(String sectionId, int month, int year) {
        List<Stock> stock = stockMngr.getStockBySection(sectionId, month, year);
        List<StockDto> stockDto = new ArrayList<StockDto>();
        
        for(Stock s: stock){
            stockDto.add(mapToStockDto(s));
        }
        
        return stockDto;
    }

    @Override
    public List<StockDto> getStockBySection(String sectionId, int month, int year, String stockType) {
        List<Stock> stock = stockMngr.getStockBySection(sectionId, month, year, stockType);
        List<StockDto> stockDto = new ArrayList<StockDto>();
        
        for(Stock s: stock){
            stockDto.add(mapToStockDto(s));
        }
        
        return stockDto;
    }

    @Override
    public List<StockDto> getStockBySection(String sectionId, Date from, Date to) {
        List<Stock> stock = stockMngr.getStockBySection(sectionId, from, to);
        List<StockDto> stockDto = new ArrayList<StockDto>();
        
        for(Stock s: stock){
            stockDto.add(mapToStockDto(s));
        }
        
        return stockDto;
    }

    @Override
    public List<StockDto> getStockBySection(String sectionId, Date from, Date to, String stockType) {
        List<Stock> stock = stockMngr.getStockBySection(sectionId, from, to, stockType);
        List<StockDto> stockDto = new ArrayList<StockDto>();
        
        for(Stock s: stock){
            stockDto.add(mapToStockDto(s));
        }
        
        return stockDto;
    }

    @Override
    public List<StockDto> getStockByProduct(String sectionId, Date StartDate, String productId) {
        List<Stock> stock = stockMngr.getStockByProduct(sectionId, StartDate, productId);
        List<StockDto> stockDto = new ArrayList<StockDto>();
        
        for(Stock s: stock){
            stockDto.add(mapToStockDto(s));
        }
        
        return stockDto;
    }

    @Override
    public List<StockDto> getStockByProduct(String sectionId, Date StartDate, String productId, String stockType) {
        List<Stock> stock = stockMngr.getStockByProduct(sectionId, StartDate, productId, stockType);
        List<StockDto> stockDto = new ArrayList<StockDto>();
        
        for(Stock s: stock){
            stockDto.add(mapToStockDto(s));
        }
        
        return stockDto;
    }

    @Override
    public List<StockDto> getStockByProduct(String productId, int month, int year) {
        List<Stock> stock = stockMngr.getStockByProduct(productId, month, year);
        List<StockDto> stockDto = new ArrayList<StockDto>();
        
        for(Stock s: stock){
            stockDto.add(mapToStockDto(s));
        }
        
        return stockDto;
    }

    @Override
    public List<StockDto> getStockByProduct(String productId, int month, int year, String stockType) {
        List<Stock> stock = stockMngr.getStockByProduct(productId, month, year, stockType);
        List<StockDto> stockDto = new ArrayList<StockDto>();
        
        for(Stock s: stock){
            stockDto.add(mapToStockDto(s));
        }
        
        return stockDto;
    }

    @Override
    public List<StockDto> getStockByProduct(String productId, Date from, Date to) {
        List<Stock> stock = stockMngr.getStockByProduct(productId, from, to);
        List<StockDto> stockDto = new ArrayList<StockDto>();
        
        for(Stock s: stock){
            stockDto.add(mapToStockDto(s));
        }
        
        return stockDto;
    }

    @Override
    public List<StockDto> getStockByProduct(String productId, Date from, Date to, String stockType) {
        List<Stock> stock = stockMngr.getStockByProduct(productId, from, to, stockType);
        List<StockDto> stockDto = new ArrayList<StockDto>();
        
        for(Stock s: stock){
            stockDto.add(mapToStockDto(s));
        }
        
        return stockDto;
    }

    @Override
    public List<StockDto> getStockBySection(String sectionId) {
        List<Stock> stocks = stockMngr.getStocksBySection(sectionId);
        List<StockDto> stockDtos = new ArrayList<StockDto>();
        
        for(Stock s: stocks){
            stockDtos.add(mapToStockDto(s));
        }
        
        return stockDtos;
    }

    @Override
    public List<StockDto> getStockByProduct(String productId) {
        List<Stock> stocks = stockMngr.getStockByProduct(productId);
        List<StockDto> stockDtos = new ArrayList<StockDto>();
        
        for(Stock s: stocks){
            stockDtos.add(mapToStockDto(s));
        }
        return stockDtos;
    }

    @Override
    public List<StockDto> getStockByExpenseType(String stockType) {
        List<StockDto> stockDtos = new ArrayList<StockDto>();
        List<Stock> stocks = stockMngr.getStockByStockType(stockType);
        
        for(Stock s: stocks){
            stockDtos.add(mapToStockDto(s));
        }
        return stockDtos;
    }

    @Override
    public List<StockDto> getStockByProductAndSection(String productId, String sectionId) {
        List<Stock> stocks = stockMngr.getStockByProductAndSection(productId, sectionId);
        List<StockDto> stockDtos = new ArrayList<StockDto>();
        
        for(Stock s: stocks){
            stockDtos.add(mapToStockDto(s));
        }
        
        return stockDtos;
    }


   
}
