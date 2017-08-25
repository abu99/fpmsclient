/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

/**
 *
 * @author aabello
 */
public class ManageProductEvent extends GwtEvent<ManageProductEventHandler> {
    
    public static Type<ManageProductEventHandler> Type 
            = new Type<ManageProductEventHandler>();

    @Override
    public Type<ManageProductEventHandler> getAssociatedType() {
        return Type;
    }

    @Override
    protected void dispatch(ManageProductEventHandler handler) {
        handler.onManageProduct(this);
    }
    
}
