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
public class ManageSectionEvent extends GwtEvent<ManageSectionEventHandler>{
    
    public static Type<ManageSectionEventHandler> Type 
            = new Type<ManageSectionEventHandler>();

    @Override
    public Type<ManageSectionEventHandler> getAssociatedType() {
        return Type;
    }

    @Override
    protected void dispatch(ManageSectionEventHandler handler) {
        handler.onManageSection(this);
    }

    
    
}
