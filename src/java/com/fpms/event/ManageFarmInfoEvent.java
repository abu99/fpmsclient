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
public class ManageFarmInfoEvent extends GwtEvent<ManageFarmInfoEventHandler>{

    public static Type<ManageFarmInfoEventHandler> Type = new 
            Type<ManageFarmInfoEventHandler>();
    
    @Override
    public Type<ManageFarmInfoEventHandler> getAssociatedType() {
        return Type;
    }

    @Override
    protected void dispatch(ManageFarmInfoEventHandler handler) {
        handler.onManageFarmInfo(this);
    }
    
}
