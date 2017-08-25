/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.presenter;

import com.fpms.client.service.FpmsConfigMngrService;
import com.fpms.client.type.UpdateType;
import com.fpms.client.util.StatusMessageHandler;
import com.fpms.client.widgets.CustomGrid;
import com.fpms.client.widgets.LoadingWidget;
import com.fpms.shared.dtos.ExpenseTypeDto;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
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
public class EditExpenseTypePresenter implements Presenter{

    private Display display;
    private ExpenseTypeDto type;
    private CustomGrid<ExpenseTypeDto> typeGrid;

    public EditExpenseTypePresenter(Display display, CustomGrid<ExpenseTypeDto> typeGrid) {
        this.display = display;
        this.typeGrid = typeGrid;
        bind(UpdateType.ADD);
    }

    public EditExpenseTypePresenter(Display display, ExpenseTypeDto type, CustomGrid<ExpenseTypeDto> typeGrid) {
        this.display = display;
        this.type = type;
        this.typeGrid = typeGrid;
        bind(UpdateType.EDIT);
        
        TextBox idBox = (TextBox) display;
        idBox.setEnabled(false);
        
        display.getExpenseTypeId().setValue(type.getTypeId());
        display.getExpenseTypeName().setValue(type.getTypeName());
        display.getDescription().setValue(type.getDescription());
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
            ExpenseTypeDto typeDto = new ExpenseTypeDto();
            typeDto.setTypeId(display.getExpenseTypeId().getValue());
            typeDto.setTypeName(display.getExpenseTypeName().getValue());
            typeDto.setDescription(display.getDescription().getValue());
            
            FpmsConfigMngrService.Util.getInstance().addExpenseType(typeDto, new AsyncCallback<ExpenseTypeDto>() {

                @Override
                public void onFailure(Throwable caught) {
                    Window.alert("Adding Expense type wasn't successful");
                }

                @Override
                public void onSuccess(ExpenseTypeDto result) {
                    typeGrid.addData(result, 0);
                    DialogBox box = (DialogBox) display;
                    box.hide();
                    Window.alert("Adding New Expense Type successful");
                }
            });
        }
    }
    private void doUpdate(){
        
        if(validate()){
            LoadingWidget.INSTANCE.show();
            
            FpmsConfigMngrService.Util.getInstance().updateExpenseType(type, new AsyncCallback<ExpenseTypeDto>() {

                @Override
                public void onFailure(Throwable caught) {
                    StatusMessageHandler.showStatus("Error updating selected Expense Type");
                }

                @Override
                public void onSuccess(ExpenseTypeDto result) {
                    typeGrid.updateSelectedData(result);
                    DialogBox box = (DialogBox) display;
                    box.hide();
                    StatusMessageHandler.showStatus("Successfully updated Expense Type");
                    LoadingWidget.INSTANCE.hide();
                }
            });
        }
    }
    
    private boolean validate(){
        TextBox idBox = (TextBox) display.getExpenseTypeId();
        if(display.getExpenseTypeId().getValue().isEmpty()){
            Window.alert("Expense Type ID must be inputed");
            idBox.setFocus(true);
            
            return false;
        }
        
        TextBox nameBox = (TextBox) display.getExpenseTypeName();
        if(display.getExpenseTypeName().getValue().isEmpty()){
            Window.alert("Expense Type Name must be inputed");
            nameBox.setFocus(true);
            
            return false;
        }
        return true;
    }
    public interface Display{
        HasValue<String> getExpenseTypeId();
        HasValue<String> getExpenseTypeName();
        HasValue<String> getDescription();
        HasClickHandlers getSaveButton();
        HasClickHandlers getCancelButton();
        Widget asWidget();
        
    }
    
    @Override
    public void go(HasWidgets container) {
        
    }
    
}
