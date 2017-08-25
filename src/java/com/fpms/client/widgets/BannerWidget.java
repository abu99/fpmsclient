/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.widgets;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

/**
 *
 * @author aim
 */
public class BannerWidget extends Composite {
    public final static BannerWidget INSTANCE = new BannerWidget();
    
    private BannerWidget() {
        HorizontalPanel hPanel = new HorizontalPanel();
        initWidget(hPanel);
        //setHeight("0px");
        hPanel.setStylePrimaryName("bannerPanel");
        
        Label schoolTitle = new Label("FARM PRODUCTS MANAGEMENT SYSTEM");
        schoolTitle.setStylePrimaryName("schoolTitle");
        schoolTitle.setWidth((Window.getClientWidth() - 240) + "px");
        
        hPanel.add(schoolTitle);
        hPanel.setCellHorizontalAlignment(schoolTitle, 
                HasHorizontalAlignment.ALIGN_CENTER);
        
        
        //hPanel.setHeight("50px");
        
        //Image logo = AbstractImagePrototype.create(
          //                OaaResources.INSTANCE.logo()).createImage();
        
        //Image logo = new Image("welcome_files/adamawapolylogo.jpg");
        
        //hPanel.add(logo);  
//        hPanel.setCellHorizontalAlignment(logo, 
//                HasHorizontalAlignment.ALIGN_LOCALE_START);
        //hPanel.add(LogoutWidget.INSTANCE);
//        hPanel.setCellHorizontalAlignment(LogoutWidget.INSTANCE, 
//                HasHorizontalAlignment.ALIGN_LOCALE_END);
    }
}