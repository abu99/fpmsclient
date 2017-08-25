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
public interface ProfitEventHandler extends EventHandler{
    
    void onViewProfit(ProfitEvent event);
    
}
