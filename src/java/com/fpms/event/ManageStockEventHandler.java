/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.event;

import com.google.gwt.event.shared.EventHandler;

/**
 *
 * @author aabello
 */
public interface ManageStockEventHandler extends EventHandler{
    
    void onManageStock(ManageStockEvent event);
    
}
