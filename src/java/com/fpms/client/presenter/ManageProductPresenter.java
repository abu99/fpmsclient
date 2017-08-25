/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.presenter;

import com.fpms.client.service.ProductMngrService;
import com.fpms.client.util.StatusMessageHandler;
import com.fpms.client.view.EditProductView;
import com.fpms.client.view.GridControlView;
import com.fpms.client.widgets.CustomGrid;
import com.fpms.client.widgets.LoadingWidget;
import com.fpms.shared.dtos.ProductDto;
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
public class ManageProductPresenter implements Presenter{

    private Display display;

    public ManageProductPresenter(Display display) {
        this.display = display;
        bind();
        fetchData();
    }

    private void bind() {
        this.display.getCustomControlView().getAddButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                EditProductView view = new EditProductView("ADD New Product");
                EditProductPresenter presenter = new EditProductPresenter(view, 
                        display.getCustomGrid());
                view.center();
                view.show();
            }
        });
        
        this.display.getCustomControlView().getDeleteButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                deleteSelectedProduct();
            }
        });
        
        this.display.getCustomControlView().getUpdateButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                CustomGrid<ProductDto> productGrid = display.getCustomGrid();
                SingleSelectionModel<ProductDto> selcModel = (SingleSelectionModel<ProductDto>)
                productGrid.getGrid().getSelectionModel();
        
        if(selcModel.getSelectedObject() == null){
            StatusMessageHandler.showStatus("Select the Product you wish to update");
            return;
        }
        
        EditProductView view = new EditProductView("Update Product");
        EditProductPresenter presenter = new EditProductPresenter(view, 
                display.getCustomGrid().getSelectedObject(), 
                display.getCustomGrid());
        view.center();
        view.show();
                
            }
        });
    }
    
    public interface Display{
        CustomGrid<ProductDto> getCustomGrid();
        GridControlView<ProductDto> getCustomControlView();
        Widget asWidget();
    }
    
    @Override
    public void go(HasWidgets container) {
        container.clear();
        container.add(display.asWidget());
    }
    
    private void fetchData(){
        ProductMngrService.Util.getInstance().getProducts(new AsyncCallback<List<ProductDto>>() {

            @Override
            public void onFailure(Throwable caught) {
                StatusMessageHandler.showStatus("Error getting grid data");
            }

            @Override
            public void onSuccess(List<ProductDto> result) {
                display.getCustomGrid().setData(result);
            }
        });
    }
    
    private void deleteSelectedProduct(){
        CustomGrid<ProductDto> productGrid = display.getCustomGrid();
        
        SingleSelectionModel<ProductDto> selcModel = (SingleSelectionModel<ProductDto>)
                productGrid.getGrid().getSelectionModel();
        
        if(selcModel.getSelectedObject() == null){
            StatusMessageHandler.showStatus("Select the Product you wish to delete");
            return;
        }
        
        if(Window.confirm("Are you sure you want to delete the selected Product")){
            LoadingWidget.INSTANCE.show();
            
            String productId = selcModel.getSelectedObject().getProductId();
            ProductMngrService.Util.getInstance().deleteProduct(productId, new AsyncCallback<Void>() {

                @Override
                public void onFailure(Throwable caught) {
                    StatusMessageHandler.showStatus("Error deleting Product");
                }

                @Override
                public void onSuccess(Void result) {
                    LoadingWidget.INSTANCE.hide();
                    display.getCustomGrid().removeSelectedRow();
                    StatusMessageHandler.showStatus("Successfully deleted Product"); 
                }
            });
        }
    }
}
