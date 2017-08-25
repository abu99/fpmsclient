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
public class ManageExpenseTypeEvent extends GwtEvent<ManageExpenseTypeEventHandler>{
    
    public static Type<ManageExpenseTypeEventHandler> Type = new
            Type<ManageExpenseTypeEventHandler>();

    @Override
    public Type<ManageExpenseTypeEventHandler> getAssociatedType() {
        return Type;
    }

    @Override
    protected void dispatch(ManageExpenseTypeEventHandler handler) {
        handler.onManageExpense(this);
    }
    
}
