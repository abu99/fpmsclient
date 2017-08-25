/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.presenter;

import com.fpms.client.service.FpmsConfigMngrService;
import com.fpms.client.type.UpdateType;
import com.fpms.client.util.StatusMessageHandler;
import com.fpms.client.widgets.CustomGrid;
import com.fpms.client.widgets.CustomListBox;
import com.fpms.client.widgets.LoadingWidget;
import com.fpms.client.widgets.WidgetsFactory;
import com.fpms.shared.dtos.FarmSectionDto;
import com.fpms.shared.dtos.ProductDto;
import com.fpms.shared.dtos.ProductOtherUnitsDto;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author aabello
 */
public class EditProductOtherUnitsPresenter implements Presenter{

    private Display display;
    private ProductOtherUnitsDto otherUnits;
    private CustomGrid<ProductOtherUnitsDto> otherUnitsGrid;

    public EditProductOtherUnitsPresenter(Display display, CustomGrid<ProductOtherUnitsDto> otherUnitsGrid) {
        this.display = display;
        this.otherUnitsGrid = otherUnitsGrid;
        bind(UpdateType.ADD);
        loadProducts();
        loadSections();
    }

    public EditProductOtherUnitsPresenter(Display display, ProductOtherUnitsDto otherUnits, CustomGrid<ProductOtherUnitsDto> otherUnitsGrid) {
        this.display = display;
        this.otherUnits = otherUnits;
        this.otherUnitsGrid = otherUnitsGrid;
        bind(UpdateType.EDIT);
        loadProducts(otherUnits.getProductId());
        loadSections(otherUnits.getSectionId());
        
        CustomListBox<ProductDto> productBox = (CustomListBox<ProductDto>)
                display.getProductList();
        CustomListBox<FarmSectionDto> sectionBox = (CustomListBox<FarmSectionDto>)
                display.getSectionList();
        TextBox unitBox = (TextBox) display.getUnitName();
        productBox.setEnabled(false);
        sectionBox.setEnabled(false);
        unitBox.setEnabled(false);
        
        display.getProductList().setSelectedItem(otherUnits.getProductId());
        display.getSectionList().setSelectedItem(otherUnits.getSectionId());
        display.getUnitName().setValue(otherUnits.getUnitName());
        display.getCount().setValue(otherUnits.getCount());
        
        
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
                }else{
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
            
            ProductOtherUnitsDto unitsDto = new ProductOtherUnitsDto();
            unitsDto.setProductId(display.getProductList().getSelectedItem());
            unitsDto.setSectionId(display.getSectionList().getSelectedItem());
            unitsDto.setUnitName(display.getUnitName().getValue());
            unitsDto.setCount(display.getCount().getValue());
            
            LoadingWidget.INSTANCE.show();
            FpmsConfigMngrService.Util.getInstance().addOtherUnits(unitsDto, new AsyncCallback<ProductOtherUnitsDto>() {

                @Override
                public void onFailure(Throwable caught) {
                   StatusMessageHandler.showStatus("Adding Other Units Wasn't successful");
                }

                @Override
                public void onSuccess(ProductOtherUnitsDto result) {
                    
                    otherUnitsGrid.addData(result, 0);
                    DialogBox box = (DialogBox) display;
                    box.hide();
                    StatusMessageHandler.showStatus("Product Units Successfully added");
                    LoadingWidget.INSTANCE.hide();
                }
            });
            
        }
    }
    private void doUpdate(){
        if(validate()){
            LoadingWidget.INSTANCE.show();
            
            FpmsConfigMngrService.Util.getInstance().updateOtherUnits(otherUnits, 
                    new AsyncCallback<ProductOtherUnitsDto>() {

                @Override
                public void onFailure(Throwable caught) {
                    StatusMessageHandler.showStatus("Error updating Product Other Units");
                }

                @Override
                public void onSuccess(ProductOtherUnitsDto result) {
                    LoadingWidget.INSTANCE.hide();
                    otherUnitsGrid.updateSelectedData(result);
                    DialogBox box = (DialogBox) display;
                    box.hide();
                    StatusMessageHandler.showStatus("Product Other Units was updated Successfully");
                }
            });
        }
    }
    
    private boolean validate(){
        CustomListBox<ProductDto> productList = (CustomListBox<ProductDto>) 
                display.getProductList();
        if(display.getProductList().getSelectedIndex() == 0){
            StatusMessageHandler.showStatus("You haven't selected any product");
            productList.setFocus(true);
            
            return false;
        }
        
        CustomListBox<FarmSectionDto> sectionList = (CustomListBox<FarmSectionDto>)
                display.getSectionList();
        if(display.getSectionList().getSelectedIndex() == 0){
            StatusMessageHandler.showStatus("You haven't selected any Section");
            sectionList.setFocus(true);
            
            return false;
        }
        
        TextBox unitNameBox = (TextBox) display.getUnitName();
        if(display.getUnitName().getValue().isEmpty()){
            StatusMessageHandler.showStatus("You must input a valid unit name");
            unitNameBox.setFocus(true);
            
            return false;
        }
        
        IntegerBox count = (IntegerBox) display.getCount();
        if(display.getCount().getValue() == 0){
            StatusMessageHandler.showStatus("Input a valid integer count");
            count.setFocus(true);
            
            return false;
        }
        
        return true;
    }
    
    public interface Display{
        CustomListBox<ProductDto> getProductList();
        CustomListBox<FarmSectionDto> getSectionList();
        HasValue<String> getUnitName();
        HasValue<Integer> getCount();
        HasClickHandlers getSaveButton();
        HasClickHandlers getCancelButton();
        Widget asWidget();
    }
    
    @Override
    public void go(HasWidgets container) {
    }
    
}
