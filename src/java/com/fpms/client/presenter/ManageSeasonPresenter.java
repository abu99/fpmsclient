/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.presenter;

import com.fpms.client.service.FpmsConfigMngrService;
import com.fpms.client.util.StatusMessageHandler;
import com.fpms.client.view.CenterPageLabel;
import com.fpms.client.view.EditSeasonView;
import com.fpms.client.view.GridControlView;
import com.fpms.client.widgets.CustomGrid;
import com.fpms.client.widgets.LoadingWidget;
import com.fpms.shared.dtos.FarmingSeasonDto;
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
public class ManageSeasonPresenter implements Presenter{

    private Display display;

    public ManageSeasonPresenter(Display display) {
        this.display = display;
        CenterPageLabel.get().setLabel("Section Farming Season");
        bind();
        fetchData();
    }

    private void bind() {
        this.display.getGridControlView().getAddButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                EditSeasonView view = new EditSeasonView("ADD New Season");
                EditSeasonPresenter presenter = new EditSeasonPresenter(view, 
                        display.getCustomGrid());
                view.center();
                view.show();
            }
        });
        
        this.display.getGridControlView().getUpdateButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                CustomGrid<FarmingSeasonDto> seasonCustomGrid = display.getCustomGrid();
                
                SingleSelectionModel<FarmingSeasonDto> singleselect =
                (SingleSelectionModel<FarmingSeasonDto>) seasonCustomGrid.
                        getGrid().getSelectionModel();
                
                if(singleselect.getSelectedObject() == null){
                    StatusMessageHandler.showStatus("Select a season to be updated");
                    return;
                }
                
                EditSeasonView view = new EditSeasonView("Update Season");
                EditSeasonPresenter presenter = new EditSeasonPresenter(view, 
                        display.getCustomGrid().getSelectedObject(), display.getCustomGrid());
                view.center();
                view.show();
            }
        });
        
        this.display.getGridControlView().getDeleteButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                deleteSelectedSeason();
            }
        });
    }
    
    
    
    public interface Display{
        
        CustomGrid<FarmingSeasonDto> getCustomGrid();
        GridControlView<FarmingSeasonDto> getGridControlView();
        Widget asWidget();
    }
    
    @Override
    public void go(HasWidgets container) {
        container.clear();
        container.add(display.asWidget());
    }
    
    private void fetchData(){
        FpmsConfigMngrService.Util.getInstance().getSeasons(new AsyncCallback<List<FarmingSeasonDto>>() {

            @Override
            public void onFailure(Throwable caught) {
               StatusMessageHandler.showStatus("Error getting grid data");
            }

            @Override
            public void onSuccess(List<FarmingSeasonDto> result) {
                display.getCustomGrid().setData(result);
            }
        });
    }
    
    private void deleteSelectedSeason(){
        CustomGrid<FarmingSeasonDto> seasonCustomGrid = display.getCustomGrid();
                
                SingleSelectionModel<FarmingSeasonDto> singleselect =
                (SingleSelectionModel<FarmingSeasonDto>) seasonCustomGrid.
                        getGrid().getSelectionModel();
                
                if(singleselect.getSelectedObject() == null){
                    StatusMessageHandler.showStatus("Select a season to be deleted");
                    return;
                }
                
                if(Window.confirm("Are you sure you want to delete this season")){
                    LoadingWidget.INSTANCE.show();
                    String sectionId = singleselect.getSelectedObject().getSectionId().getSectionId();
                    Date startDate = singleselect.getSelectedObject().getStartDate();
                    
                    
                    FpmsConfigMngrService.Util.getInstance().deleteSeason(sectionId, startDate, new AsyncCallback<Void>() {

                        @Override
                        public void onFailure(Throwable caught) {
                            StatusMessageHandler.showStatus("Error deleting Season");
                        }

                        @Override
                        public void onSuccess(Void result) {
                            LoadingWidget.INSTANCE.hide();
                            display.getCustomGrid().removeSelectedRow();
                            StatusMessageHandler.showStatus("Successfully deleted Season");
                        }
                    });
                }
    }
}
