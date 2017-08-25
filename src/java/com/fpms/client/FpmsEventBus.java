/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpms.client;

import com.google.gwt.event.shared.SimpleEventBus;

/**
 *
 * @author faizbash
 */
public class FpmsEventBus {
    private static SimpleEventBus simpleEventBus = new SimpleEventBus();

    private FpmsEventBus() {
        
    }
    
    public static SimpleEventBus getEventBus() {
	return simpleEventBus;
    }
}
