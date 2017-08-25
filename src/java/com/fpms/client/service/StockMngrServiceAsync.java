/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.service;

import com.fpms.shared.dtos.StockDto;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aabello
 */
public interface StockMngrServiceAsync {

    public void addStock(StockDto stockDto, AsyncCallback<StockDto> asyncCallback);

    public void updateStock(StockDto stockDto, AsyncCallback<StockDto> asyncCallback);

    public void deleteStock(String productId, String sectionId, Date dateCreated, AsyncCallback<Void> asyncCallback);

    public void getStock(String productId, String sectionId, Date dateCreated, AsyncCallback<StockDto> asyncCallback);

    public void getStocks(AsyncCallback<List<StockDto>> asyncCallback);

    public void getStocks(String sectionId, Date StartDate, AsyncCallback<List<StockDto>> asyncCallback);

    public void getStocks(Date from, Date to, AsyncCallback<List<StockDto>> asyncCallback);

    public void getStocks(String sectionId, Date StartDate, String stockType, AsyncCallback<List<StockDto>> asyncCallback);

    public void getStocks(int month, int year, AsyncCallback<List<StockDto>> asyncCallback);

    public void getStocks(int month, int year, String stockType, AsyncCallback<List<StockDto>> asyncCallback);

    public void getStocks(Date from, Date to, String stockType, AsyncCallback<List<StockDto>> asyncCallback);

    public void getStockBySection(String sectionId, int month, int year, AsyncCallback<List<StockDto>> asyncCallback);

    public void getStockBySection(String section, int month, int year, String stockType, AsyncCallback<List<StockDto>> asyncCallback);

    public void getStockBySection(String sectionId, Date from, Date to, AsyncCallback<List<StockDto>> asyncCallback);

    public void getStockBySection(String sectionId, Date from, Date to, String stockType, AsyncCallback<List<StockDto>> asyncCallback);

    public void getStockByProduct(String sectionId, Date StartDate, String productId, AsyncCallback<List<StockDto>> asyncCallback);

    public void getStockByProduct(String sectionId, Date StartDate, String productId, String stockType, AsyncCallback<List<StockDto>> asyncCallback);

    public void getStockByProduct(String productId, int month, int year, AsyncCallback<List<StockDto>> asyncCallback);

    public void getStockByProduct(String productId, int month, int year, String stockType, AsyncCallback<List<StockDto>> asyncCallback);

    public void getStockByProduct(String productId, Date from, Date to, AsyncCallback<List<StockDto>> asyncCallback);

    public void getStockByProduct(String productId, Date from, Date to, String stockType, AsyncCallback<List<StockDto>> asyncCallback);

    public void getStockBySection(String sectionId, AsyncCallback<List<StockDto>> asyncCallback);

    public void getStockByProduct(String productId, AsyncCallback<List<StockDto>> asyncCallback);

    public void getStockByExpenseType(String stockType, AsyncCallback<List<StockDto>> asyncCallback);

    public void getStockByProductAndSection(String productId, String sectionId, AsyncCallback<List<StockDto>> asyncCallback);
}
