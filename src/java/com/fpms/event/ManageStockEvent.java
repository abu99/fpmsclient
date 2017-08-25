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
public  class ManageStockEvent extends GwtEvent<ManageStockEventHandler>{

    public static Type<ManageStockEventHandler> Type = 
            new Type<ManageStockEventHandler>();
   

    @Override
    public Type<ManageStockEventHandler> getAssociatedType() {
        return Type;
    }

    @Override
    protected void dispatch(ManageStockEventHandler handler) {
        handler.onManageStock(this);
    }
   
}
