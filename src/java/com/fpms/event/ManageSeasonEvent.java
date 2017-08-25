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
public class ManageSeasonEvent extends GwtEvent<ManageSeasonEventHandler>{

    public static Type<ManageSeasonEventHandler> Type 
            = new Type<ManageSeasonEventHandler>();
    
    @Override
    public Type<ManageSeasonEventHandler> getAssociatedType() {
        return Type;
    }

    @Override
    protected void dispatch(ManageSeasonEventHandler handler) {
        handler.onManageSeason(this);
    }
    
}
