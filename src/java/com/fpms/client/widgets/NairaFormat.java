/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.widgets;

import com.google.gwt.i18n.client.CurrencyData;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.i18n.client.impl.CurrencyDataImpl;

/**
 *
 * @author faiz
 */
public class NairaFormat {
    public static final String NAIRA_SYMBOL = "\u20A6";
    
    private static CurrencyData getCurrencyData() {
        return new CurrencyDataImpl("NGN", "\u20A6", 2);
    }
    
    public static String format(double amount) {
        return NumberFormat.getCurrencyFormat(NairaFormat.getCurrencyData())
                .format(amount);
    }
    
}
