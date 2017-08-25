/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 *
 * @author faizbash
 */
public class ApplicationMngrEvent extends GwtEvent<ApplicationMngrEventHandler> {

    public static Type<ApplicationMngrEventHandler> TYPE =
            new Type<ApplicationMngrEventHandler>();

    public ApplicationMngrEvent() {
    }

    @Override
    public Type<ApplicationMngrEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ApplicationMngrEventHandler handler) {
        handler.onManageApplication(this);
    }
}