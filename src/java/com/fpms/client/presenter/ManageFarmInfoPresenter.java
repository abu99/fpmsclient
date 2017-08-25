/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.presenter;

import com.fpms.client.service.FpmsConfigMngrService;
import com.fpms.client.util.StatusMessageHandler;
import com.fpms.client.view.FarmInfoView;
import com.fpms.client.widgets.LoadingWidget;
import com.fpms.shared.dtos.FarmInfoDto;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author aabello
 */
public class ManageFarmInfoPresenter implements Presenter{
    
    private Display display;
    private FarmInfoDto farmDto;
    private final SimpleEventBus eventBus;
    
    public ManageFarmInfoPresenter(SimpleEventBus eventBus,Display display){
        this.display = display;
        this.eventBus = eventBus;
        bind();
        farmDto = new FarmInfoDto();
        
        getFarmInfo();
        
        
        
    }

//    public ManageFarmInfoPresenter(FarmInfoView farmInfoView) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }


    private void FetchData(FarmInfoDto result){
        
        display.getFarmName().setValue(result.getFarmName());
        display.getAddress().setValue(result.getAddress());
        display.getCity().setValue(result.getCity());
        display.getState().setValue(result.getFarmState());
        display.getPhone().setValue(result.getPhoneNumber());
        display.getEmail().setValue(result.getEmail());
        display.getWebsite().setValue(result.getWebsite());
        
        
    
    }
    
    private void bind() {
        
        this.display.getUpdateButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                
                
                farmDto.setFarmId("FRM001");
                farmDto.setFarmName(display.getFarmName().getValue());
                farmDto.setAddress(display.getAddress().getValue());
                farmDto.setCity(display.getCity().getValue());
                farmDto.setFarmState(display.getState().getValue());
                farmDto.setPhoneNumber(display.getPhone().getValue());
                farmDto.setEmail(display.getEmail().getValue());
                
                farmDto.setWebsite(display.getWebsite().getValue());
                LoadingWidget.INSTANCE.show();
                FpmsConfigMngrService.Util.getInstance().updateInfo(farmDto, new AsyncCallback<FarmInfoDto>() {

                    @Override
                    public void onFailure(Throwable caught) {
                        LoadingWidget.INSTANCE.hide();
                        StatusMessageHandler.showStatus("Error adding Farm information");
                    }

                    @Override
                    
                    public void onSuccess(FarmInfoDto result) {
                        FetchData(result);
                        LoadingWidget.INSTANCE.hide();
                        StatusMessageHandler.showStatus("Farm Information Saved Successfully");
                    }
                });
                
            }
        });
    }

    private void getFarmInfo() {
        LoadingWidget.INSTANCE.show();
        FpmsConfigMngrService.Util.getInstance().getFarmInfo(farmDto.getFarmId(), new AsyncCallback<FarmInfoDto>() {

            @Override
            public void onFailure(Throwable caught) {
                StatusMessageHandler.showStatus("Error fetching school info");
                LoadingWidget.INSTANCE.hide();
            }

            @Override
            public void onSuccess(FarmInfoDto result) {
                FetchData(result);
                LoadingWidget.INSTANCE.hide();
            }
        });
        
    }
    
    public interface Display{
        HasValue<String> getFarmName();
        HasValue<String> getAddress();
        HasValue<String> getCity();
        HasValue<String> getState();
        HasValue<String> getPhone();
        HasValue<String> getEmail();
        HasValue<String> getWebsite();
        HasClickHandlers getUpdateButton();
        Widget asWidget();
    }
    
    @Override
    public void go(HasWidgets container) {
        container.clear();
        container.add(display.asWidget());
    }
    
}
