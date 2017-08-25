/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.widgets;

import com.fpms.client.data.DataManager;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;

/**
 *
 * @author aim
 */
public class LogoutWidget extends Composite {
    public final static LogoutWidget INSTANCE = new LogoutWidget();
    
    private LogoutWidget() {
	//log out widget
	HTML logout = getLogoutHtml();
        
	HorizontalPanel logoutPanel = new HorizontalPanel();
	initWidget(logoutPanel);
        
	//logoutPanel.setSize("100%", "100%");
        //logoutPanel.setSize((Window.getClientWidth() - 100) + "px", "30px");
        HTML currentUserLabel = new HTML(DataManager.currentUser + " | ");
        currentUserLabel.setStylePrimaryName("currentUser");
        logoutPanel.add(currentUserLabel);
	logoutPanel.add(logout);
        logoutPanel.setSpacing(5);
        
	logoutPanel.setCellHorizontalAlignment(logout, 
                HasHorizontalAlignment.ALIGN_LOCALE_END);
	logoutPanel.setCellVerticalAlignment(logout, HasVerticalAlignment.ALIGN_BOTTOM);
    }

    private HTML getLogoutHtml() {
	final HTML logout = new HTML("<a href=\"#\">Logout</a>");
	//logout.addStyleName("color: white;");
	logout.addClickHandler(new ClickHandler() {

	    @Override
	    public void onClick(ClickEvent event) {
		if (DataManager.currentUser == null) {
		    return;
		}

//		UserAccountsMngrService.Util.getService().logout(DataManager.currentUser,
//			new AsyncCallback<Void>() {
//
//			    @Override
//			    public void onFailure(Throwable caught) {
//				Window.Location.reload();
//			    }
//
//			    @Override
//			    public void onSuccess(Void result) {
//				Window.Location.reload();
//			    }
//			});
	    }
	});

	return logout;
    }
}