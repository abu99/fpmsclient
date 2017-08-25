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
public class ManageProductOtherUnitsEvent extends 
        GwtEvent<ManageProductOtherUnitsEventHandler>{

    public static Type<ManageProductOtherUnitsEventHandler> Type = new
            Type<ManageProductOtherUnitsEventHandler>();
    
    @Override
    public Type<ManageProductOtherUnitsEventHandler> getAssociatedType() {
        return Type;
    }

    @Override
    protected void dispatch(ManageProductOtherUnitsEventHandler handler) {
        handler.onManageProduct(this);
    }
    
}
