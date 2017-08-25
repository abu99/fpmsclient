/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpms.client.widgets;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

/**
 *
 * @author faizbash
 */
public class InformationPopup extends PopupPanel {
    private static InformationPopup singleton = new InformationPopup();

    private Label errorMessageLabel;
    private HorizontalPanel errorPanel;
    private Label statusMessageLabel;
    private HorizontalPanel statusPanel;

    private InformationPopup() {
        setAnimationEnabled(true);
        
        setSize(Window.getClientWidth() + "px", "100%");
        setStyleName("empty");
        
	VerticalPanel vPanel = new VerticalPanel(); //main panel
	vPanel.setSize("100%", "100%");

	//status panel setup
	statusPanel = new HorizontalPanel();
	statusPanel.setSize("100%", "100%");
	statusPanel.getElement().setId("statusMessage");
	statusPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	statusPanel.setVisible(false); //not shown by default
	statusMessageLabel = new Label();
	statusPanel.add(statusMessageLabel);
	statusPanel.setCellHorizontalAlignment(statusMessageLabel,
		HasHorizontalAlignment.ALIGN_CENTER);
	vPanel.add(statusPanel);

	//error panel setup
	errorPanel = new HorizontalPanel();
	errorPanel.setSize("100%", "100%");
	errorPanel.getElement().setId("errorMessage");
	errorPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	errorPanel.setVisible(false); //not shown by default
	errorMessageLabel = new Label();
	errorPanel.add(errorMessageLabel);
	errorPanel.setCellHorizontalAlignment(errorMessageLabel,
		HasHorizontalAlignment.ALIGN_CENTER);
	vPanel.add(errorPanel);
        
        add(vPanel);        
    }

    public void showErrorMessage(String message) {
        setPopupPosition(0, Window.getScrollTop());
        show();
        
        //hide progress bar
        LoadingWidget.INSTANCE.hide();
        
	errorMessageLabel.setText(message);
	errorPanel.setVisible(true);
	Timer timer = new Timer() {
	    @Override
	    public void run() {
		errorPanel.setVisible(false);
                hide();
	    }
	};
	timer.schedule(5000);
    }

    public void showStatusMessage(String message) {
        setPopupPosition(0, Window.getScrollTop());
        show();
        
	statusMessageLabel.setText(message);
	statusPanel.setVisible(true);
	Timer timer = new Timer() {
	    @Override
	    public void run() {
		statusPanel.setVisible(false);
                hide();
	    }
	};
	timer.schedule(5000);
    }

    public static InformationPopup get() {
	return singleton;
    }

}
