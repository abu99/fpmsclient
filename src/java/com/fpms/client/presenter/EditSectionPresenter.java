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
import com.fpms.shared.dtos.FarmSectionDto;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
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
public class EditSectionPresenter implements Presenter{
    private Display display;
    private FarmSectionDto sectionDto;
    CustomGrid<FarmSectionDto> sectionGrid;

    public EditSectionPresenter(Display display, CustomGrid<FarmSectionDto> sectionGrid) {
        this.display = display;
        this.sectionGrid = sectionGrid;
        bind(UpdateType.ADD);
        
    }

    public EditSectionPresenter(Display display, FarmSectionDto sectionDto, 
            CustomGrid<FarmSectionDto> sectionGrid) {
        this.display = display;
        this.sectionDto = sectionDto;
        this.sectionGrid = sectionGrid;
        bind(UpdateType.EDIT);
        
        TextBox idBox = (TextBox) this.display.getSectionId();
        idBox.setEnabled(false);
        
        display.getSectionId().setValue(sectionDto.getSectionId());
        display.getSectionName().setValue(sectionDto.getSectionName());
        display.getDescription().setValue(sectionDto.getDescription());
    }

    private void bind(final UpdateType updateType) {
        
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
    
    
    private void doSave() {
                if(validate()){
                    LoadingWidget.INSTANCE.show();
                    FarmSectionDto section = new FarmSectionDto();
                    section.setSectionId(display.getSectionId().getValue());
                    section.setSectionName(display.getSectionName().getValue());
                    section.setDescription(display.getDescription().getValue());
                    
                    FpmsConfigMngrService.Util.getInstance().addSection(section, 
                            new AsyncCallback<FarmSectionDto>() {

                        @Override
                        public void onFailure(Throwable caught) {
                            StatusMessageHandler.showStatus("Error adding Section");
                        }

                        @Override
                        public void onSuccess(FarmSectionDto result) {
                            sectionGrid.addData(result, 0);
                            DialogBox box = (DialogBox)display;
                            box.hide();
                            StatusMessageHandler.showStatus("Section added Successfully");
                            LoadingWidget.INSTANCE.hide();
                        }
                    });
                    
                    
                }
            }

    private void doUpdate() {
        if(validate()){
            
                    FpmsConfigMngrService.Util.getInstance().updateSection(sectionDto, 
                            new AsyncCallback<FarmSectionDto>() {

                        @Override
                        public void onFailure(Throwable caught) {
                            StatusMessageHandler.showStatus("Error updating Section");
                        }

                        @Override
                        public void onSuccess(FarmSectionDto result) {
                            sectionGrid.updateSelectedData(result);
                            DialogBox box = (DialogBox)display;
                            box.hide();
                            StatusMessageHandler.showStatus("Section updated Successfully");
                        }
                    });
            
        }
    }
    

    private boolean validate() {
        
        TextBox IdBox = (TextBox)display.getSectionId();
        if(display.getSectionId().getValue().isEmpty()){
            StatusMessageHandler.showStatus("Enter a valid Section ID");
            IdBox.setFocus(true);
            return false;
        }
        
        TextBox nameBox = (TextBox)display.getSectionName();
        if(display.getSectionName().getValue().isEmpty()){
            StatusMessageHandler.showStatus("Enter a Valid Section Name");
            IdBox.setFocus(true);
            return false;
        }
        return true;
    }
    
    public interface Display{
        
        HasValue<String> getSectionId();
        
        HasValue<String> getSectionName();
        
        HasValue<String> getDescription();
        
        HasClickHandlers getSaveButton();
        
        HasClickHandlers getCancelButton();
        
        Widget asWidget();
        
    }
    @Override
    public void go(HasWidgets container) {
    }
    
}
