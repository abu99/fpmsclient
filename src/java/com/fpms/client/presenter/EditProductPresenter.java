/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.presenter;

import com.fpms.client.service.ProductMngrService;
import com.fpms.client.type.UpdateType;
import com.fpms.client.util.StatusMessageHandler;
import com.fpms.client.widgets.CustomGrid;
import com.fpms.client.widgets.CustomListBox;
import com.fpms.client.widgets.LoadingWidget;
import com.fpms.client.widgets.WidgetsFactory;
import com.fpms.shared.dtos.FarmSectionDto;
import com.fpms.shared.dtos.ProductDto;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author aabello
 */
public class EditProductPresenter implements Presenter{

    private Display display;
    private ProductDto product;
    private CustomGrid<ProductDto> productGrid;

    public interface Display{
        HasValue<String> getProductId();
        CustomListBox<FarmSectionDto> getSectionList();
        HasValue<String> getProductName();
        HasValue<String> getStandardUnit();
        HasValue<String> getDesc();
        HasClickHandlers getSaveButton();
        HasClickHandlers getCancelButton();
        Widget asWidget();
    }

    public EditProductPresenter(Display display, CustomGrid<ProductDto> productGrid) {
        this.display = display;
        this.productGrid = productGrid;
        bind(UpdateType.ADD);
        loadSections();
    }

    public EditProductPresenter(Display display, ProductDto product, CustomGrid<ProductDto> productGrid) {
        this.display = display;
        this.product = product;
        this.productGrid = productGrid;
        bind(UpdateType.EDIT);
        loadSections(product.getSectionId());
        
        TextBox idBox = (TextBox) display;
        idBox.setEnabled(false);
        
        display.getProductId().setValue(product.getProductId());
        display.getProductName().setValue(product.getProductName());
        display.getSectionList().setSelectedItem(product.getSectionId());
        display.getStandardUnit().setValue(product.getStandardUnit());
        display.getDesc().setValue(product.getDescription());
    }
    
    private void loadSections(){
        WidgetsFactory.setSections(display.getSectionList());
    }
    
    private void loadSections(FarmSectionDto sectionDto){
        WidgetsFactory.setSections(display.getSectionList(), sectionDto);
    }
    
    private void bind(final UpdateType updateType) {
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
            ProductDto productDto = new ProductDto();
            productDto.setProductId(display.getProductId().getValue());
            productDto.setSectionId(display.getSectionList().getSelectedItem());
            productDto.setProductName(display.getProductName().getValue());
            productDto.setStandardUnit(display.getStandardUnit().getValue());
            productDto.setDescription(display.getDesc().getValue());
            
            LoadingWidget.INSTANCE.show();
            ProductMngrService.Util.getInstance().addProduct(productDto, new AsyncCallback<ProductDto>() {

                @Override
                public void onFailure(Throwable caught) {
                    StatusMessageHandler.showStatus("Adding Product wasn't successful");
                }

                @Override
                public void onSuccess(ProductDto result) {
                    
                    productGrid.addData(result, 0);
                    DialogBox box = (DialogBox) display;
                    box.hide();
                    StatusMessageHandler.showStatus("Product was added successfully");
                    LoadingWidget.INSTANCE.hide();
                    
                }
            });
        }
    }
    private void doUpdate(){
        if(validate()){
            LoadingWidget.INSTANCE.show();
            
            ProductMngrService.Util.getInstance().updateProduct(product, new AsyncCallback<ProductDto>() {

                @Override
                public void onFailure(Throwable caught) {
                    StatusMessageHandler.showStatus("Error updating product");
                }

                @Override
                public void onSuccess(ProductDto result) {
                    LoadingWidget.INSTANCE.hide();
                    productGrid.updateSelectedData(result);
                    DialogBox box = (DialogBox) display;
                    box.hide();
                    StatusMessageHandler.showStatus("Successfully updated product");
                }
            });
        }
    }
    private boolean validate(){
        TextBox idBox = (TextBox) display.getProductId();
        if(display.getProductId().getValue().isEmpty()){
            StatusMessageHandler.showStatus("Product Id must be inputed");
            idBox.setFocus(true);
            return false;
        }
        
        CustomListBox<FarmSectionDto> sectionList =(CustomListBox<FarmSectionDto>)
                display.getSectionList();
        if(display.getSectionList().getSelectedIndex() == 0){
            StatusMessageHandler.showStatus("Select a section to continue");
            sectionList.setFocus(true);
            return false;
        }
        
        TextBox nameBox = (TextBox) display.getProductName();
        if(display.getProductName().getValue().isEmpty()){
            StatusMessageHandler.showStatus("Product Name must be inputed");
            nameBox.setFocus(true);
            return false;
        }
        return true;
    }
    
    @Override
    public void go(HasWidgets container) {
    
    }
    
}
