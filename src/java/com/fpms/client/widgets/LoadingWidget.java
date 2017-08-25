/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpms.client.widgets;

import com.fpms.client.resources.FpmsResources;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

/**
 *
 * @author faizbash
 */
public class LoadingWidget extends PopupPanel {
    public static LoadingWidget INSTANCE = new LoadingWidget();

    private VerticalPanel vPanel;

    private LoadingWidget() {
        setAnimationEnabled(true);
        setSize(Window.getClientWidth() + "px", "100%");
        setStylePrimaryName("loadingPanel");
        
        vPanel = new VerticalPanel();
        vPanel.setStylePrimaryName("loadingPanel");
        vPanel.setWidth("100%");
	//vPanel.getElement().setId("statusMessage");
        add(vPanel);
        
        Image image = new Image(FpmsResources.INSTANCE.loading());
        vPanel.add(image);
        vPanel.setCellHorizontalAlignment(image, HasHorizontalAlignment.ALIGN_CENTER);
        vPanel.setVisible(true);
    }

    public void showLoading() {
        //StatusMessageHandler.showStatus("here");
        setPopupPosition(0, Window.getScrollTop());
        show();
        //center();
    }

    public void hideLoading() {
        hide();
    }
}
