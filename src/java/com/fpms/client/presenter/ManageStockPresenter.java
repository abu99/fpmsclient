/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.presenter;

import com.fpms.client.service.StockMngrService;
import com.fpms.client.util.StatusMessageHandler;
import com.fpms.client.view.EditStockView;
import com.fpms.client.view.GridControlView;
import com.fpms.client.widgets.CustomGrid;
import com.fpms.client.widgets.CustomListBox;
import com.fpms.client.widgets.LoadingWidget;
import com.fpms.client.widgets.WidgetsFactory;
import com.fpms.shared.dtos.FarmSectionDto;
import com.fpms.shared.dtos.ProductDto;
import com.fpms.shared.dtos.StockDto;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.SingleSelectionModel;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aabello
 */
public class ManageStockPresenter implements Presenter{
    
    private Display display;
    
    public interface Display{
        CustomListBox<ProductDto> getProductList();
        CustomListBox<FarmSectionDto> getSectionList();
        CustomGrid<StockDto> getCustomGrid();
        GridControlView<StockDto> getGridControlView();
        Widget asWidget();
    }

    public ManageStockPresenter(Display display) {
        this.display = display;
        WidgetsFactory.setProducts(display.getProductList());
        WidgetsFactory.setSections(display.getSectionList());
        bind();
        fetchData();
    }
    
    private void bind(){
        this.display.getGridControlView().getAddButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                EditStockView view = new EditStockView("ADD New Stock");
                EditStockPresenter presenter = new EditStockPresenter(view, 
                        display.getCustomGrid());
                view.center();
                view.show();
            }
        });
        
        this.display.getGridControlView().getUpdateButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                CustomGrid<StockDto> customGrid = display.getCustomGrid();
                
                SingleSelectionModel<StockDto> singleselect = (SingleSelectionModel<StockDto>)
                        customGrid.getGrid().getSelectionModel();
                
                if(singleselect.getSelectedObject() == null){
                    StatusMessageHandler.showStatus("You haven't selected any stock to be updated");
                    return;
                }
                
                EditStockView view = new EditStockView("ADD New Stock");
                EditStockPresenter presenter = new EditStockPresenter(view, 
                        display.getCustomGrid().getSelectedObject(),
                        display.getCustomGrid());
                view.center();
                view.show();
            }
        });
        
        this.display.getGridControlView().getDeleteButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                deleteSelectedStock();
            }
        });
        
        this.display.getProductList().addChangeHandler(new ChangeHandler() {

            @Override
            public void onChange(ChangeEvent event) {
                fetchFilteredData();
            }
        });
        
        this.display.getSectionList().addChangeHandler(new ChangeHandler() {

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
        StockMngrService.Util.getInstance().getStocks(new AsyncCallback<List<StockDto>>() {

            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Error getting grid data");
            }

            @Override
            public void onSuccess(List<StockDto> result) {
                display.getCustomGrid().setData(result);
            }
        });
    }
    
    private void fetchFilteredData(){
    
        if(display.getProductList().getSelectedIndex() == 0 && 
                display.getSectionList().getSelectedIndex() ==0){
            fetchData();
        }else if(display.getProductList().getSelectedIndex() !=0 &&
                display.getSectionList().getSelectedIndex() == 0){
            LoadingWidget.INSTANCE.show();
            String productId = display.getProductList().getSelectedItem().getProductId();
            
            StockMngrService.Util.getInstance().getStockByProduct(productId, new AsyncCallback<List<StockDto>>() {

                @Override
                public void onFailure(Throwable caught) {
                    StatusMessageHandler.showStatus("Error fetching stock grid");
                }

                @Override
                public void onSuccess(List<StockDto> result) {
                    display.getCustomGrid().setData(result);
                    LoadingWidget.INSTANCE.hide();
                }
            });
            
        }else if(display.getProductList().getSelectedIndex() ==0 &&
                display.getSectionList().getSelectedIndex()!=0){
            LoadingWidget.INSTANCE.show();
            String sectionId = display.getSectionList().getSelectedItem().getSectionId();
            
            StockMngrService.Util.getInstance().getStockBySection(sectionId, 
                    new AsyncCallback<List<StockDto>>() {

                @Override
                public void onFailure(Throwable caught) {
                    StatusMessageHandler.showStatus("Error fetching stock grid");
                }

                @Override
                public void onSuccess(List<StockDto> result) {
                    display.getCustomGrid().setData(result);
                    LoadingWidget.INSTANCE.hide();
                }
            });
        }else if(display.getProductList().getSelectedIndex()!=0 && 
                display.getSectionList().getSelectedIndex()!=0){
            LoadingWidget.INSTANCE.show();
            String productId = display.getProductList().getSelectedItem().getProductId();
            String sectionId = display.getSectionList().getSelectedItem().getSectionId();
            
            StockMngrService.Util.getInstance().getStockByProductAndSection(productId, sectionId, new AsyncCallback<List<StockDto>>() {

                @Override
                public void onFailure(Throwable caught) {
                    StatusMessageHandler.showStatus("Error fetching filtered stock grid");
                }

                @Override
                public void onSuccess(List<StockDto> result) {
                   display.getCustomGrid().setData(result);
                   LoadingWidget.INSTANCE.hide();
                }
            });
        }
    }
    
    private void deleteSelectedStock(){
        
        CustomGrid<StockDto> customGrid = display.getCustomGrid();
                
        SingleSelectionModel<StockDto> singleselect = (SingleSelectionModel<StockDto>)
        customGrid.getGrid().getSelectionModel();
                
        if(singleselect.getSelectedObject() == null){
            StatusMessageHandler.showStatus("You haven't selected any stock to be deleted");
            return;
        }
        
        if(Window.confirm("Are you sure?")){
            LoadingWidget.INSTANCE.show();
            String productId = singleselect.getSelectedObject().getProductId().getProductId();
            String sectionId = singleselect.getSelectedObject().getSectionId().getSectionId();
            Date createdate = singleselect.getSelectedObject().getCreatedDate();
            
            StockMngrService.Util.getInstance().deleteStock(productId, sectionId, 
                    createdate, new AsyncCallback<Void>() {

                @Override
                public void onFailure(Throwable caught) {
                    StatusMessageHandler.showStatus("Error deleting stock");
                }

                @Override
                public void onSuccess(Void result) {
                    display.getCustomGrid().removeSelectedRow();
                    StatusMessageHandler.showStatus("Successfully deleted Stock");
                    LoadingWidget.INSTANCE.hide();
                }
            });
        }
    }
}
