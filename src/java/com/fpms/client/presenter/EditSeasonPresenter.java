/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.presenter;

import com.fpms.client.service.FpmsConfigMngrService;
import com.fpms.client.type.UpdateType;
import com.fpms.client.util.StatusMessageHandler;
import com.fpms.client.widgets.CustomGrid;
import com.fpms.client.widgets.CustomListBox;
import com.fpms.client.widgets.LoadingWidget;
import com.fpms.client.widgets.WidgetsFactory;
import com.fpms.shared.dtos.FarmSectionDto;
import com.fpms.shared.dtos.FarmingSeasonDto;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

/**
 *
 * @author aabello
 */
public class EditSeasonPresenter implements Presenter{

    private Display display;
    private FarmingSeasonDto season;
    private CustomGrid<FarmingSeasonDto> seasonGrid;

    public EditSeasonPresenter(Display display, CustomGrid<FarmingSeasonDto> seasonGrid) {
        this.display = display;
        this.seasonGrid = seasonGrid;
        bind(UpdateType.ADD);
        loadSections();
    }

    public EditSeasonPresenter(Display display, FarmingSeasonDto season, CustomGrid<FarmingSeasonDto> seasonGrid) {
        this.display = display;
        this.season = season;
        this.seasonGrid = seasonGrid;
        bind(UpdateType.EDIT);
        loadSections(season.getSectionId());
        
        CustomListBox<FarmSectionDto> sectionBox = (CustomListBox<FarmSectionDto>)
                display.getSectionList();
        sectionBox.setEnabled(false);
        DateBox dateBox = (DateBox) display.getStartDate();
        dateBox.setEnabled(false);
        
        display.getSectionList().setSelectedItem(season.getSectionId());
        display.getStartDate().setValue(season.getStartDate());
        display.getEndDate().setValue(season.getEndDate());
        display.getDescription().setValue(season.getDescription());
    }
    
    private void loadSections(){
        WidgetsFactory.setSections(display.getSectionList());
    }
    
    private void loadSections(FarmSectionDto sectionDto){
        WidgetsFactory.setSections(display.getSectionList(), sectionDto);
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
            FarmingSeasonDto seasonDto = new FarmingSeasonDto();
            seasonDto.setSectionId(display.getSectionList().getSelectedItem());
            seasonDto.setStartDate(display.getStartDate().getValue());
            seasonDto.setEndDate(display.getEndDate().getValue());
            seasonDto.setDescription(display.getDescription().getValue());
            
            FpmsConfigMngrService.Util.getInstance().addSeason(seasonDto, new AsyncCallback<FarmingSeasonDto>() {

                @Override
                public void onFailure(Throwable caught) {
                    StatusMessageHandler.showStatus("Error adding section");
                }

                @Override
                public void onSuccess(FarmingSeasonDto result) {
                    seasonGrid.addData(result, 0);
                    DialogBox box = (DialogBox) display;
                    box.hide();
                    StatusMessageHandler.showStatus("Section Added Successfully");
                    
                }
            });
        }
    }
    
    private void doUpdate(){
        
        if(validate()){
        LoadingWidget.INSTANCE.show();
        
        FpmsConfigMngrService.Util.getInstance().updateSeason(season, new AsyncCallback<FarmingSeasonDto>() {

            @Override
            public void onFailure(Throwable caught) {
                StatusMessageHandler.showStatus("Error Updating Season");
            }

            @Override
            public void onSuccess(FarmingSeasonDto result) {
                
                seasonGrid.updateSelectedData(result);
                DialogBox box = (DialogBox) display;
                box.hide();
                StatusMessageHandler.showStatus("Successfully updated Season");
                LoadingWidget.INSTANCE.hide();
            }
        });
        }
    }
    
    private boolean validate(){
        CustomListBox<FarmSectionDto> sectionList = (CustomListBox<FarmSectionDto>)
                display.getSectionList();
        if(display.getSectionList().getSelectedIndex() ==0){
            StatusMessageHandler.showStatus("You haven't Selected any Section");
            sectionList.setFocus(true);
            return false;
        }
        
        DateBox startDate = (DateBox) display.getStartDate();
        if(display.getStartDate().getValue() == null){
            StatusMessageHandler.showStatus("you must pick a start date");
            startDate.setFocus(true);
            return false;
        }
        
        DateBox endDate = (DateBox) display.getEndDate();
        if(display.getEndDate().getValue() == null){
            StatusMessageHandler.showStatus("You must pick an end date");
            startDate.setFocus(true);
            return false;
        }
        
        TextArea descBox = (TextArea) display.getDescription();
        if(display.getDescription().getValue().isEmpty()){
            StatusMessageHandler.showStatus("you must input a valid Description");
            descBox.setFocus(true);
            return false;
        }
        return true;
    }
    
    public interface Display{
        
        CustomListBox<FarmSectionDto> getSectionList();
        DateBox getStartDate();
        DateBox getEndDate();
        HasValue<String> getDescription();
        HasClickHandlers getSaveButton();
        HasClickHandlers getCancelButton();
        Widget asWidget();
    }
    
    
    @Override
    public void go(HasWidgets container) {
    }
    
}
