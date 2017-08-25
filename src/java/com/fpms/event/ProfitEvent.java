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
public class ProfitEvent extends GwtEvent<ProfitEventHandler>{
    
    public static Type<ProfitEventHandler> Type = new
            Type<ProfitEventHandler>();

    @Override
    public Type<ProfitEventHandler> getAssociatedType() {
        return Type;
    }

    @Override
    protected void dispatch(ProfitEventHandler handler) {
        handler.onViewProfit(this);
    }
    
}
