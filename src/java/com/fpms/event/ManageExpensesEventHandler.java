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
public interface ManageExpensesEventHandler extends EventHandler{
    
    void onManageExpense(ManageExpensesEvent event);
    
}
