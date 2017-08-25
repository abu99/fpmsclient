/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.presenter;

import com.fpms.client.service.ExpensesMngrService;
import com.fpms.client.type.UpdateType;
import com.fpms.client.util.StatusMessageHandler;
import com.fpms.client.widgets.CustomGrid;
import com.fpms.client.widgets.CustomListBox;
import com.fpms.client.widgets.LoadingWidget;
import com.fpms.client.widgets.WidgetsFactory;
import com.fpms.shared.dtos.ExpenseDto;
import com.fpms.shared.dtos.ExpenseTypeDto;
import com.fpms.shared.dtos.FarmSectionDto;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

/**
 *
 * @author aabello
 */
public class EditExpensesPresenter implements Presenter{
    
    private Display display;
    private ExpenseDto expense;
    private CustomGrid<ExpenseDto> expenseGrid;

   
    public interface Display{
        HasValue<String> getExpenseId();
        CustomListBox<ExpenseTypeDto> getExpenseTypeList();
        CustomListBox<FarmSectionDto> getSectionList();
        DoubleBox getAmount();
        DateBox getDate();
        HasValue<String> getDesc();
        HasClickHandlers getSaveButton();
        HasClickHandlers getCancelButton();
        Widget asWidget();
        
    }

    public EditExpensesPresenter(Display display, CustomGrid<ExpenseDto> expenseGrid) {
        this.display = display;
        this.expenseGrid = expenseGrid;
        bind(UpdateType.ADD);
        loadTypes();
        loadSections();
    }

    public EditExpensesPresenter(Display display, ExpenseDto expense, CustomGrid<ExpenseDto> expenseGrid) {
        this.display = display;
        this.expense = expense;
        this.expenseGrid = expenseGrid;
        bind(UpdateType.EDIT);
        loadTypes(expense.getExpenseTypeId());
        loadSections(expense.getSectionId());
        
        TextBox expenseIdBox = (TextBox) display.getExpenseId();
        expenseIdBox.setEnabled(false);
        
        display.getExpenseId().setValue(expense.getExpenseId());
        display.getExpenseTypeList().setSelectedItem(expense.getExpenseTypeId());
        display.getSectionList().setSelectedItem(expense.getSectionId());
        display.getAmount().setValue(expense.getAmount());
        display.getDate().setValue(expense.getCreatedDate());
        display.getDesc().setValue(expense.getDescription());
    }
    
    private void loadTypes(){
        WidgetsFactory.setExpenseTypes(display.getExpenseTypeList());
    }
    
    private void loadTypes(ExpenseTypeDto typeDto){
        WidgetsFactory.setExpenseTypes(display.getExpenseTypeList(), typeDto);
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
            
            ExpenseDto expenseDto = new ExpenseDto();
            expenseDto.setExpenseId(display.getExpenseId().getValue());
            expenseDto.setExpenseTypeId(display.getExpenseTypeList().getSelectedItem());
            expenseDto.setSectionId(display.getSectionList().getSelectedItem());
            expenseDto.setAmount(display.getAmount().getValue());
            expenseDto.setCreatedDate(display.getDate().getValue());
            expenseDto.setDescription(display.getDesc().getValue());
            
            ExpensesMngrService.Util.getInstance().addExpense(expenseDto, new AsyncCallback<ExpenseDto>() {

                @Override
                public void onFailure(Throwable caught) {
                    Window.alert("Adding Expenses wasn't successful");
                }

                @Override
                public void onSuccess(ExpenseDto result) {
                    expenseGrid.addData(result, 0);
                    DialogBox box = (DialogBox) display;
                    box.hide();
                    Window.alert("Added Expenses Successfully");
                }
            });
        }
    }
    private void doUpdate(){
        
        if(validate()){
            LoadingWidget.INSTANCE.show();
            
            ExpensesMngrService.Util.getInstance().updateExpense(expense, new AsyncCallback<ExpenseDto>() {

                @Override
                public void onFailure(Throwable caught) {
                    StatusMessageHandler.showStatus("Error updating Expenses");
                }

                @Override
                public void onSuccess(ExpenseDto result) {
                    
                    DialogBox box = (DialogBox) display;
                    box.hide();
                    expenseGrid.updateSelectedData(result);
                    StatusMessageHandler.showStatus("Successfully updated Expenses");
                    LoadingWidget.INSTANCE.hide();
                }
            });
        }
    }
    
    public boolean validate(){
        
        TextBox idBox = (TextBox) display.getExpenseId();
        if(display.getExpenseId().getValue().isEmpty()){
            Window.alert("Expense ID must be inputed");
            idBox.setFocus(true);
            
            return false;
        }
        
        CustomListBox<ExpenseTypeDto> typeListBox = (CustomListBox<ExpenseTypeDto>) 
                display.getExpenseTypeList();
        if(display.getExpenseTypeList().getSelectedIndex() == 0){
            Window.alert("Expense Type must be Selected");
            typeListBox.setFocus(true);
            
            return false;
        }
        
        CustomListBox<FarmSectionDto> sectionListBox = (CustomListBox<FarmSectionDto>) 
                display.getSectionList();
        if(display.getSectionList().getSelectedIndex() == 0){
            Window.alert("Section must be Selected");
            sectionListBox.setFocus(true);
            
            return false;
        }
        
        DoubleBox amountBox = (DoubleBox) display.getAmount();
        if(display.getAmount().getValue() == 0.0){
            Window.alert("A valid Amount must be inputed");
            amountBox.setFocus(true);
            
            return false;
        }
        
        DateBox dateBox = (DateBox) display.getDate();
        if(display.getDate().getValue() == null){
            Window.alert("A valid date must be Selected");
            dateBox.setFocus(true);
            
            return false;
        }
        
        TextArea descBox = (TextArea) display.getDesc();
        if(display.getDesc().getValue().isEmpty()){
            Window.alert("Description must be inputed");
            descBox.setFocus(true);
            
            return false;
        }
        return true;
    }
    
    @Override
    public void go(HasWidgets container) {
        
    }
    
}
