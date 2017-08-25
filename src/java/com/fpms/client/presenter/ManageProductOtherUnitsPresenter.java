/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.presenter;

import com.fpms.client.service.FpmsConfigMngrService;
import com.fpms.client.util.StatusMessageHandler;
import com.fpms.client.view.EditProductOtherUnitsView;
import com.fpms.client.view.GridControlView;
import com.fpms.client.widgets.CustomGrid;
import com.fpms.client.widgets.LoadingWidget;
import com.fpms.shared.dtos.ProductOtherUnitsDto;
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
public class ManageProductOtherUnitsPresenter implements Presenter{

    private Display display;

    private void bind() {
        
        this.display.getGridControlView().getAddButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                EditProductOtherUnitsView view = new 
                        EditProductOtherUnitsView("ADD Product Other Units");
                EditProductOtherUnitsPresenter presenter = new 
                        EditProductOtherUnitsPresenter(view, display.getCustomGrid());
                view.center();
                view.show();
            }
        });
        
        this.display.getGridControlView().getDeleteButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                deleteSelectedPoU();
            }
        });
        
        this.display.getGridControlView().getUpdateButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                CustomGrid<ProductOtherUnitsDto> customGrid = display.getCustomGrid();
        
        SingleSelectionModel<ProductOtherUnitsDto> singleSelect = 
                (SingleSelectionModel<ProductOtherUnitsDto>) customGrid.
                getGrid().getSelectionModel();
        
        if(singleSelect.getSelectedObject() == null){
            StatusMessageHandler.showStatus("You haven't selected any unit to be updated");
            return;
        }
        
        EditProductOtherUnitsView view = new EditProductOtherUnitsView("Update Product Other Units");
        EditProductOtherUnitsPresenter pr = new EditProductOtherUnitsPresenter(view, 
                display.getCustomGrid().getSelectedObject(), display.getCustomGrid());
        view.center();
        view.show();
            }
        });
    }
    
    public interface Display{
        CustomGrid<ProductOtherUnitsDto> getCustomGrid();
        GridControlView<ProductOtherUnitsDto> getGridControlView();
        Widget asWidget();
    }

    public ManageProductOtherUnitsPresenter(Display display) {
        this.display = display;
        bind();
        fetchData();
    }
    
    
    @Override
    public void go(HasWidgets container) {
        container.clear();
        container.add(display.asWidget());
    }
    
    private void fetchData(){
        FpmsConfigMngrService.Util.getInstance().getOtherUnits(new AsyncCallback<List<ProductOtherUnitsDto>>() {

            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Error getting grid data");
            }

            @Override
            public void onSuccess(List<ProductOtherUnitsDto> result) {
                display.getCustomGrid().setData(result);
            }
        });
    }
    
    private void deleteSelectedPoU(){
        CustomGrid<ProductOtherUnitsDto> customGrid = display.getCustomGrid();
        
        SingleSelectionModel<ProductOtherUnitsDto> singleSelect = 
                (SingleSelectionModel<ProductOtherUnitsDto>) customGrid.
                getGrid().getSelectionModel();
        
        if(singleSelect.getSelectedObject() == null){
            StatusMessageHandler.showStatus("You haven't selected any unit to be deleted");
            return;
        }
        
        if(Window.confirm("Are you sure?")){
            LoadingWidget.INSTANCE.show();
            String productId = singleSelect.getSelectedObject().getProductId().getProductId();
            String sectionId = singleSelect.getSelectedObject().getSectionId().getSectionId();
            String unitName = singleSelect.getSelectedObject().getUnitName();
            
            FpmsConfigMngrService.Util.getInstance().deleteOtherUnits(productId,
                    sectionId, unitName, new AsyncCallback<Void>() {

                @Override
                public void onFailure(Throwable caught) {
                    StatusMessageHandler.showStatus("Error deleting selected object");
                }

                @Override
                public void onSuccess(Void result) {
                    
                    display.getCustomGrid().removeSelectedRow();
                    StatusMessageHandler.showStatus("Successfully deleted object");
                    LoadingWidget.INSTANCE.hide();
                }
            });
        }
    }
}
