/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.view;

import com.fpms.client.presenter.ManageStockPresenter;
import com.fpms.client.util.FpmsClientUtil;
import com.fpms.client.widgets.CustomGrid;
import com.fpms.client.widgets.CustomListBox;
import com.fpms.client.widgets.DataType;
import com.fpms.client.widgets.SelectionMode;
import com.fpms.client.widgets.gridcolumns.NumberColumn;
import com.fpms.shared.dtos.FarmSectionDto;
import com.fpms.shared.dtos.ProductDto;
import com.fpms.shared.dtos.StockDto;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import java.util.LinkedHashMap;

/**
 *
 * @author aabello
 */
public class ManageStockView extends Composite implements 
        ManageStockPresenter.Display{
    
    private GridControlView<StockDto> stockGrid;
    private final CustomListBox<ProductDto> productList;
    private final CustomListBox<FarmSectionDto> sectionList;

    public ManageStockView() {
        
        VerticalPanel centerPanel = new VerticalPanel();
        initWidget(centerPanel);
        centerPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
        centerPanel.setHeight("0");
        productList = new CustomListBox<ProductDto>();
        sectionList = new CustomListBox<FarmSectionDto>();
        
        FlexTable filterTable = new FlexTable();
        filterTable.setWidget(0, 0, new Label("Filter By => Product: "));
        filterTable.setWidget(0, 1, productList);
        filterTable.setWidget(0, 2, new Label("Section:"));
        filterTable.setWidget(0, 3, sectionList);
        
        DecoratorPanel filterPanel = new DecoratorPanel();
        filterPanel.add(filterTable);
        
        stockGrid = buildGrid();
        centerPanel.add(filterPanel);
        centerPanel.add(stockGrid);
    }
    
    

    @Override
    public CustomGrid<StockDto> getCustomGrid() {
        return stockGrid.getGrid();
    }

    @Override
    public GridControlView<StockDto> getGridControlView() {
        return stockGrid;
    }

    private GridControlView<StockDto> buildGrid() {
        TextColumn<StockDto> prodColumn = new TextColumn<StockDto>() {

            @Override
            public String getValue(StockDto object) {
                return object.getProductId().getProductName();
            }
        };
        
        TextColumn<StockDto> sectColumn = new TextColumn<StockDto>() {

            @Override
            public String getValue(StockDto object) {
                return object.getSectionId().getSectionName();
            }
        };
        
        NumberColumn<StockDto> qColumn = new NumberColumn<StockDto>() {

            @Override
            public Number getValue(StockDto object) {
                return object.getQuantity();
            }
        };
        
        NumberColumn<StockDto> amountColumn = new NumberColumn<StockDto>() {

            @Override
            public Number getValue(StockDto object) {
                return object.getAmount();
            }
        };
        
        TextColumn<StockDto> typeColumn = new TextColumn<StockDto>() {

            @Override
            public String getValue(StockDto object) {
                return object.getStockType();
            }
        };
        
        TextColumn<StockDto> dateColumn = new TextColumn<StockDto>() {

            @Override
            public String getValue(StockDto object) {
                return FpmsClientUtil.getShortDate(object.getCreatedDate());
            }
        };
        
        TextColumn<StockDto> descColumn = new TextColumn<StockDto>() {

            @Override
            public String getValue(StockDto object) {
                return object.getDescription();
            }
        };
        
        LinkedHashMap<String, Column> parameters = new LinkedHashMap<String, Column>();
        parameters.put("Product", prodColumn);
        parameters.put("Section", sectColumn);
        parameters.put("Quantity", qColumn);
        parameters.put("Amount", amountColumn);
        parameters.put("Stock Type", typeColumn);
        parameters.put("Date", dateColumn);
        parameters.put("Description", descColumn);
        
        CustomGrid<StockDto> grid = new CustomGrid<StockDto>(parameters, 
                SelectionMode.SINGLE, 
                false, 
                true, 
                DataType.STATIC);
        
        return new GridControlView<StockDto>(grid);
    }

    @Override
    public CustomListBox<ProductDto> getProductList() {
        return productList;
    }

    @Override
    public CustomListBox<FarmSectionDto> getSectionList() {
        return sectionList;
    }
    
    
}
