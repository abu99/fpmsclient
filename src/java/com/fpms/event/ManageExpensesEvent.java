/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 *
 * @author aabello
 */
public class ManageExpensesEvent extends GwtEvent<ManageExpensesEventHandler> {

    public static Type<ManageExpensesEventHandler> Type 
            = new Type<ManageExpensesEventHandler>();
        
    @Override
    public Type<ManageExpensesEventHandler> getAssociatedType() {
        return Type;
    }

    @Override
    protected void dispatch(ManageExpensesEventHandler handler) {
        handler.onManageExpense(this);
    }
    
    
    
}
