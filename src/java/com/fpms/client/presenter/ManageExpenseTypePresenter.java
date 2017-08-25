/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.presenter;

import com.fpms.client.service.FpmsConfigMngrService;
import com.fpms.client.util.StatusMessageHandler;
import com.fpms.client.view.EditExpenseTypeView;
import com.fpms.client.view.GridControlView;
import com.fpms.client.widgets.CustomGrid;
import com.fpms.client.widgets.LoadingWidget;
import com.fpms.shared.dtos.ExpenseTypeDto;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SingleSelectionModel;
import java.util.List;

/**
 *
 * @author aabello
 */
public class ManageExpenseTypePresenter implements Presenter{

    private Display display;
    
    public interface Display{
        CustomGrid<ExpenseTypeDto> getCustomGrid();
        GridControlView<ExpenseTypeDto> getControlView();
        Widget asWidget();
    }
    
       public ManageExpenseTypePresenter(Display display) {
        this.display = display;
        bind();
        fetchData();
    }
    
    private void bind() {
        this.display.getControlView().getAddButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                EditExpenseTypeView view = new EditExpenseTypeView("ADD Expense Type");
                EditExpenseTypePresenter presenter = new 
                        EditExpenseTypePresenter(view, display.getCustomGrid());
                view.center();
                view.show();
            }
        });
        
        this.display.getControlView().getUpdateButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                CustomGrid<ExpenseTypeDto> customGrid = display.getCustomGrid();
         
         SingleSelectionModel<ExpenseTypeDto> singleSelect = 
                 (SingleSelectionModel<ExpenseTypeDto>) customGrid.getGrid()
                 .getSelectionModel();
         
         if(singleSelect.getSelectedObject() == null){
             StatusMessageHandler.showStatus("You haven't selected any object"
                     + " to be updated");
             return;
         }
         
         EditExpenseTypeView view = new EditExpenseTypeView("Update Expense Type");
         EditExpenseTypePresenter present = new EditExpenseTypePresenter(view, 
                 display.getCustomGrid().getSelectedObject(),
                 display.getCustomGrid());
         view.center();
         view.show();
            }
        });
        
        this.display.getControlView().getDeleteButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                deleteSelectedExpenseType();
            }
        });
   
    }
    
     @Override
    public void go(HasWidgets container) {
        container.clear();
        container.add(display.asWidget());
    }

     private void fetchData(){
         FpmsConfigMngrService.Util.getInstance().getExpenseTypes(new AsyncCallback<List<ExpenseTypeDto>>() {

             @Override
             public void onFailure(Throwable caught) {
                 Window.alert("Error getting grid data");
             }

             @Override
             public void onSuccess(List<ExpenseTypeDto> result) {
                 display.getCustomGrid().setData(result);
             }
         });
     }
     
     private void deleteSelectedExpenseType(){
         
         CustomGrid<ExpenseTypeDto> customGrid = display.getCustomGrid();
         
         SingleSelectionModel<ExpenseTypeDto> singleSelect = 
                 (SingleSelectionModel<ExpenseTypeDto>) customGrid.getGrid()
                 .getSelectionModel();
         
         if(singleSelect.getSelectedObject() == null){
             StatusMessageHandler.showStatus("You haven't selected any object"
                     + " to be deleted");
             return;
         }
         
         if(Window.confirm("Are you sure?")){
             LoadingWidget.INSTANCE.show();
             String typeId = singleSelect.getSelectedObject().getTypeId();
             
             FpmsConfigMngrService.Util.getInstance().deleteExpenseType(typeId, new AsyncCallback<Void>() {

                 @Override
                 public void onFailure(Throwable caught) {
                     StatusMessageHandler.showStatus("Error deleting selected Expense Type");
                 }

                 @Override
                 public void onSuccess(Void result) {
                     display.getCustomGrid().removeSelectedRow();
                     StatusMessageHandler.showStatus("Successfully deleted Expense Type");
                     LoadingWidget.INSTANCE.hide();
                 }
             });
         }
     }
    
}
