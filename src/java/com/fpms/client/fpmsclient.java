/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client;

import com.fpms.client.view.MainView;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Main entry point.
 *
 * @author aabello
 */
public class fpmsclient implements EntryPoint {

    /**
     * Creates a new instance of fpmsclientEntryPoint
     */
    public fpmsclient() {
    }

    /**
     * The entry point method, called automatically by loading a module that
     * declares an implementing class as an entry-point
     */
    @Override
    public void onModuleLoad() {
        initApp();
    }
    
    private void initApp() {
        AppController appViewer = new AppController(FpmsEventBus.getEventBus());
        MainView.get().createMenus();
        RootPanel.getBodyElement().removeChild(RootPanel
                        .get("loadingWrapper").getElement());
        RootPanel.get().add(MainView.get());
        appViewer.go(MainView.get().getContentPanel());
        
    }
}
