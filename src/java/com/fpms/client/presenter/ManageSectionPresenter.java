/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.presenter;

import com.fpms.client.service.FpmsConfigMngrService;
import com.fpms.client.util.StatusMessageHandler;
import com.fpms.client.view.CenterPageLabel;
import com.fpms.client.view.EditSectionView;
import com.fpms.client.view.GridControlView;
import com.fpms.client.widgets.CustomGrid;
import com.fpms.client.widgets.LoadingWidget;
import com.fpms.shared.dtos.FarmSectionDto;
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
public class ManageSectionPresenter implements Presenter{
    
    private Display display;

    public ManageSectionPresenter(Display display) {
        this.display = display;
        
        bind();
        CenterPageLabel.get().setLabel("Farm Sections");
        fetchData();
    }

    private void bind() {
        display.getGridControlView().getAddButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                EditSectionView view = new EditSectionView("Add New Section");
                EditSectionPresenter presenter = new EditSectionPresenter(view,
                        display.getCustomGrid());
                view.center();
                view.show();
            }
        });
        
        display.getGridControlView().getDeleteButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                deleteSelectedSection();
            }
        });
        
        display.getGridControlView().getUpdateButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
        CustomGrid<FarmSectionDto> sectionList = display.getCustomGrid();
        
        SingleSelectionModel<FarmSectionDto> single = (SingleSelectionModel<FarmSectionDto>)
                sectionList.getGrid().getSelectionModel();
        
        if(single.getSelectedObject() == null){
            StatusMessageHandler.showStatus("Select the section to be updated");
            return;
        }
        
               
        EditSectionView view = new EditSectionView("Update Section");
                
        EditSectionPresenter present = new EditSectionPresenter(view, 
                        display.getCustomGrid().getSelectedObject(), 
                        display.getCustomGrid());
                        view.center();
                        view.show();
            }
        });
    }
    
    
    public interface Display{
        CustomGrid<FarmSectionDto> getCustomGrid();
        GridControlView<FarmSectionDto> getGridControlView();
        Widget asWidget();
    }
    
    @Override
    public void go(HasWidgets container) {
        container.clear();
        container.add(display.asWidget());
    }
    
    private void fetchData(){
        FpmsConfigMngrService.Util.getInstance().getSections(new AsyncCallback<List<FarmSectionDto>>() {

            @Override
            public void onFailure(Throwable caught) {
                StatusMessageHandler.showStatus("Error getting grid data");
            }

            @Override
            public void onSuccess(List<FarmSectionDto> result) {
                display.getCustomGrid().setData(result);
            }
        });
    }
    
    private void deleteSelectedSection(){
        
        CustomGrid<FarmSectionDto> sectionList = display.getCustomGrid();
        
        SingleSelectionModel<FarmSectionDto> single = (SingleSelectionModel<FarmSectionDto>)
                sectionList.getGrid().getSelectionModel();
        
        if(single.getSelectedObject() == null){
            StatusMessageHandler.showStatus("Select the section to be deleted");
            return;
        }
        
        if(Window.confirm("Are you sure you want to delete this section")){
            String sectionId = single.getSelectedObject().getSectionId();
            
            LoadingWidget.INSTANCE.show();
            FpmsConfigMngrService.Util.getInstance().deleteSections(sectionId, new AsyncCallback<Void>() {

                @Override
                public void onFailure(Throwable caught) {
                    StatusMessageHandler.showStatus("Error deleting Section");
                }

                @Override
                public void onSuccess(Void result) {
                    LoadingWidget.INSTANCE.hide();
                    display.getCustomGrid().removeSelectedRow();
                    StatusMessageHandler.showStatus("Successfully deleted section");
                }
            });
        }
        
    }
    
}
