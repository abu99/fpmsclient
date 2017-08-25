/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.presenter;

import com.fpms.client.service.StockMngrService;
import com.fpms.client.type.UpdateType;
import com.fpms.client.util.StatusMessageHandler;
import com.fpms.client.widgets.CustomGrid;
import com.fpms.client.widgets.CustomListBox;
import com.fpms.client.widgets.LoadingWidget;
import com.fpms.client.widgets.WidgetsFactory;
import com.fpms.shared.dtos.FarmSectionDto;
import com.fpms.shared.dtos.ProductDto;
import com.fpms.shared.dtos.StockDto;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

/**
 *
 * @author aabello
 */
public class EditStockPresenter implements Presenter{
    
    private Display display;
    private StockDto stock;
    private CustomGrid<StockDto> stockGrid;

    public EditStockPresenter(Display display, CustomGrid<StockDto> stockGrid) {
        this.display = display;
        this.stockGrid = stockGrid;
        bind(UpdateType.ADD);
        loadProducts();
        loadSections();
    }

    public EditStockPresenter(Display display, StockDto stock, CustomGrid<StockDto> stockGrid) {
        this.display = display;
        this.stock = stock;
        this.stockGrid = stockGrid;
        bind(UpdateType.EDIT);
        loadProducts(stock.getProductId());
        loadSections(stock.getSectionId());
        
        CustomListBox<ProductDto> productList = (CustomListBox<ProductDto>)
                display.getProductList();
        CustomListBox<FarmSectionDto> sectionList = (CustomListBox<FarmSectionDto>)
                display.getSectionList();
        DateBox createdDate = (DateBox) display.getDate();
        
        productList.setEnabled(false);
        sectionList.setEnabled(false);
        createdDate.setEnabled(false);
        
        display.getProductList().setSelectedItem(stock.getProductId());
        display.getSectionList().setSelectedItem(stock.getSectionId());
        display.getQuantity().setValue(stock.getQuantity());
        display.getAmount().setValue(stock.getAmount());
        if(stock.getStockType().equalsIgnoreCase("IN"))
            display.getINStockType().setValue(true);
        if(stock.getStockType().equalsIgnoreCase("OUT"))
            display.getOUTStockType().setValue(true);
        
        
        display.getDate().setValue(stock.getCreatedDate());
        display.getDesc().setValue(stock.getDescription());
        
    }
    
    private void loadProducts(){
        WidgetsFactory.setProducts(display.getProductList());
    }
    
    private void loadProducts(ProductDto productDto){
        WidgetsFactory.setProducts(display.getProductList(), productDto);
    }
    
    private void loadSections(){
        WidgetsFactory.setSections(display.getSectionList());
    }
    
    private void loadSections(FarmSectionDto sectionDto){
        WidgetsFactory.setSections(display.getSectionList(), sectionDto);
    }
    
    private void bind(final UpdateType updateType){
        this.display.getSaveButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                if(updateType.equals(UpdateType.ADD)){
                    doSave();
                } else {
                    doUpdate();
                }
            }
        });
        
        this.display.getCancelButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                DialogBox box = (DialogBox) display;
                box.hide();
            }
        });
    
    }
    
    private void doSave(){
        if(validate()){
            LoadingWidget.INSTANCE.show();
            StockDto stockDto = new StockDto();
            stockDto.setProductId(display.getProductList().getSelectedItem());
            stockDto.setSectionId(display.getSectionList().getSelectedItem());
            stockDto.setQuantity(display.getQuantity().getValue());
            stockDto.setAmount(display.getAmount().getValue());
            String stockType;
            if(display.getINStockType().getValue()){
                stockType = "IN";
                stockDto.setStockType(stockType);
            } else if(display.getOUTStockType().getValue()){
                stockType = "OUT";
                stockDto.setStockType(stockType);
            }
            
            stockDto.setCreatedDate(display.getDate().getValue());
            stockDto.setDescription(display.getDesc().getValue());
            
            StockMngrService.Util.getInstance().addStock(stockDto, new AsyncCallback<StockDto>() {

                @Override
                public void onFailure(Throwable caught) {
                    Window.alert("Adding Stock wasn't successful");
                }

                @Override
                public void onSuccess(StockDto result) {
                    stockGrid.addData(result, 0);
                    DialogBox box = (DialogBox) display;
                    box.hide();
                    Window.alert("Added Stock Successfully");
                    LoadingWidget.INSTANCE.hide();
                }
            });
        }
    }
    
    private void doUpdate(){
        
        if(validate()){
            
            LoadingWidget.INSTANCE.show();
            
            StockMngrService.Util.getInstance().updateStock(stock, new AsyncCallback<StockDto>() {

                @Override
                public void onFailure(Throwable caught) {
                    StatusMessageHandler.showStatus("Error updating stock");
                }

                @Override
                public void onSuccess(StockDto result) {
                    stockGrid.updateSelectedData(result);
                    DialogBox box = (DialogBox) display;
                    box.hide();
                    StatusMessageHandler.showStatus("Successfully updated stock");
                    LoadingWidget.INSTANCE.hide();
                }
            });
        }
    
    }
    
    private boolean validate(){
        CustomListBox<ProductDto> prodListBox = (CustomListBox<ProductDto>)
                display.getProductList();
        if(display.getProductList().getSelectedIndex() == 0){
            Window.alert("You must select a Product");
            prodListBox.setFocus(true);
            return false;
        }
        
        CustomListBox<FarmSectionDto> sectListBox = (CustomListBox<FarmSectionDto>)
                display.getSectionList();
        if(display.getSectionList().getSelectedIndex() == 0){
            Window.alert("You must select a Section");
            sectListBox.setFocus(true);
            return false;
        }
        
        IntegerBox qbox = (IntegerBox) display.getQuantity();
        if(display.getQuantity().getValue() == 0){
            Window.alert("Input a valid quantity");
            qbox.setFocus(true);
            return false;
        }
        
        DoubleBox amountBox = (DoubleBox) display.getAmount();
        if(display.getAmount().getValue() == null){
            Window.alert("Input a valid amount");
            amountBox.setFocus(true);
            return false;
        }
        
        if((!display.getINStockType().isChecked()) && 
                (!display.getOUTStockType().isChecked())){
            Window.alert("You must select a correct stock type");
        }
        
        DateBox dateBox = (DateBox) display.getDate();
        if(display.getDate().getValue() == null){
            Window.alert("Pick a Valid Date");
            dateBox.setFocus(true);
            return false;
        }
        
        TextArea descBox = (TextArea) display.getDesc();
        if(display.getDesc().getValue().isEmpty()){
            Window.alert("Input a valid Description");
            descBox.setFocus(true);
            return false;
        }
        return true;
    }
    
    public interface Display{
        CustomListBox<ProductDto> getProductList();
        CustomListBox<FarmSectionDto> getSectionList();
        IntegerBox getQuantity();
        DoubleBox getAmount();
        RadioButton getINStockType();
        RadioButton getOUTStockType();
        DateBox getDate();
        HasValue<String> getDesc();
        HasClickHandlers getSaveButton();
        HasClickHandlers getCancelButton();
        Widget asWidget();
        
    }
    
    
    @Override
    public void go(HasWidgets container) {
        
    }
    
}
