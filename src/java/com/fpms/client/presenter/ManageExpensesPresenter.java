/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.presenter;

import com.fpms.client.service.ExpensesMngrService;
import com.fpms.client.util.StatusMessageHandler;
import com.fpms.client.view.EditExpensesView;
import com.fpms.client.view.GridControlView;
import com.fpms.client.widgets.CustomGrid;
import com.fpms.client.widgets.CustomListBox;
import com.fpms.client.widgets.LoadingWidget;
import com.fpms.client.widgets.WidgetsFactory;
import com.fpms.shared.dtos.ExpenseDto;
import com.fpms.shared.dtos.ExpenseTypeDto;
import com.fpms.shared.dtos.FarmSectionDto;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
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
public class ManageExpensesPresenter implements Presenter{

    private Display display;

    public ManageExpensesPresenter(Display display) {
        this.display = display;
        WidgetsFactory.setExpenseTypes(display.getExpenseTypeList());
        WidgetsFactory.setSections(display.getSectionList());
        
        bind();
        fetchData();
    }
    
    public interface Display{
        CustomGrid<ExpenseDto> getCustomGrid();
        GridControlView<ExpenseDto> getGridControlView();
        Widget asWidget();
        CustomListBox<FarmSectionDto> getSectionList();
        CustomListBox<ExpenseTypeDto> getExpenseTypeList();
    }

    private void bind() {
        this.display.getGridControlView().getAddButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                EditExpensesView view = new EditExpensesView("ADD New Expenses");
                EditExpensesPresenter present = new EditExpensesPresenter(view,
                        display.getCustomGrid());
                view.center();
                view.show();
            }
        });
        
        this.display.getGridControlView().getDeleteButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                deleteSelectedExpense();
            }
        });
        
        this.display.getGridControlView().getUpdateButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                CustomGrid<ExpenseDto> customGrid = display.getCustomGrid();
        
        SingleSelectionModel<ExpenseDto> singleSelect = (SingleSelectionModel<ExpenseDto>)
                customGrid.getGrid().getSelectionModel();
        
        if(singleSelect.getSelectedObject() == null){
            StatusMessageHandler.showStatus("you haven't selected any expense to be updated");
            return;
        }
        
        EditExpensesView view = new EditExpensesView("Update EXpenses");
        EditExpensesPresenter present = new EditExpensesPresenter(view, 
                display.getCustomGrid().getSelectedObject(), 
                display.getCustomGrid());
        view.center();
        view.show();
            }
        });
                
        this.display.getSectionList().addChangeHandler(new ChangeHandler() {

            @Override
            public void onChange(ChangeEvent event) {
                fetchFilteredData();
            }
        });
        
        this.display.getExpenseTypeList().addChangeHandler(new ChangeHandler() {

            @Override
            public void onChange(ChangeEvent event) {
                fetchFilteredData();
            }
        });
    }
  
    @Override
    public void go(HasWidgets container) {
        container.clear();
        container.add(display.asWidget());
    }
    
    private void fetchData(){
        ExpensesMngrService.Util.getInstance()
                .getExpense(new AsyncCallback<List<ExpenseDto>>() {

            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Error getting grid data");
            }

            @Override
            public void onSuccess(List<ExpenseDto> result) {
                display.getCustomGrid().setData(result);
            }
        });
    }
    
    private void fetchFilteredData(){
    
        if(display.getSectionList().getSelectedIndex() == 0 && display.getExpenseTypeList().getSelectedIndex() == 0){
            fetchData();
        }else if(display.getSectionList().getSelectedIndex() !=0 && display.getExpenseTypeList().getSelectedIndex() == 0){
            LoadingWidget.INSTANCE.show();
            String sectionId = display.getSectionList().getSelectedItem().getSectionId();
            ExpensesMngrService.Util.getInstance().getExpenseBySection(sectionId,
                    new AsyncCallback<List<ExpenseDto>>() {

                @Override
                public void onFailure(Throwable caught) {
                    
                    StatusMessageHandler.showStatus("Error fetching get Expense By Section");
                }

                @Override
                public void onSuccess(List<ExpenseDto> result) {
                    display.getCustomGrid().setData(result);
                    LoadingWidget.INSTANCE.hide();
                }
            });
        }else if(display.getSectionList().getSelectedIndex() == 0 &&
                display.getExpenseTypeList().getSelectedIndex() !=0){
            LoadingWidget.INSTANCE.show();
            String typeId = display.getExpenseTypeList().getSelectedItem().getTypeId();
            
            ExpensesMngrService.Util.getInstance().getExpenseByExpenseType(typeId, 
                    new AsyncCallback<List<ExpenseDto>>() {

                @Override
                public void onFailure(Throwable caught) {
                    StatusMessageHandler.showStatus("Error getting Expense by Expense Type");
                }

                @Override
                public void onSuccess(List<ExpenseDto> result) {
                    display.getCustomGrid().setData(result);
                    LoadingWidget.INSTANCE.hide();
                }
            });
        
        }else if(display.getSectionList().getSelectedIndex()!=0 && 
                display.getExpenseTypeList().getSelectedIndex() !=0){
            LoadingWidget.INSTANCE.show();
            String sectionId = display.getSectionList().getSelectedItem().getSectionId();
            String expenseId = display.getExpenseTypeList().getSelectedItem().getTypeId();
            
            ExpensesMngrService.Util.getInstance().getExpenseBySection(sectionId,
                    expenseId, new AsyncCallback<List<ExpenseDto>>() {

                @Override
                public void onFailure(Throwable caught) {
                    StatusMessageHandler.showStatus("Error getting Expenses BY Section & Expense");
               }

                @Override
                public void onSuccess(List<ExpenseDto> result) {
                    display.getCustomGrid().setData(result);
                    LoadingWidget.INSTANCE.hide();
                }
            });
        }
    }
    
    private void deleteSelectedExpense(){
    
        CustomGrid<ExpenseDto> customGrid = display.getCustomGrid();
        
        SingleSelectionModel<ExpenseDto> singleSelect = (SingleSelectionModel<ExpenseDto>)
                customGrid.getGrid().getSelectionModel();
        
        if(singleSelect.getSelectedObject() == null){
            StatusMessageHandler.showStatus("you haven't selected any expense to be deleted");
            return;
        }
        
        if(Window.confirm("Are you sure?")){
            LoadingWidget.INSTANCE.show();
            String expenseId = singleSelect.getSelectedObject().getExpenseId();
            
            ExpensesMngrService.Util.getInstance().deleteExpense(expenseId, new AsyncCallback<Void>() {

                @Override
                public void onFailure(Throwable caught) {
                    StatusMessageHandler.showStatus("Error deleting Selected Expenses");
                }

                @Override
                public void onSuccess(Void result) {
                    display.getCustomGrid().removeSelectedRow();
                    StatusMessageHandler.showStatus("Successfully deleted Expenses");
                    LoadingWidget.INSTANCE.hide();
                }
            });
        }
    }
    
}
