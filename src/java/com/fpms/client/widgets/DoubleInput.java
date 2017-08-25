/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.widgets;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.user.client.ui.TextBox;

/**
 *
 * @author kip
 */
public class DoubleInput extends TextBox {

    private double doubleValue;

    public DoubleInput() {
        super();
        super.setValue(String.valueOf(0.00));
        handleBlur();
    }

    public DoubleInput(String doubleString) {
        try {
            doubleValue = Double.parseDouble(doubleString);
            super.setValue(String.valueOf(doubleValue));

        } catch (NumberFormatException e) {
            super.setValue(String.valueOf(0.00));
        }
        handleBlur();
    }

    private void handleBlur() {
        addBlurHandler(new BlurHandler() {
            @Override
            public void onBlur(BlurEvent event) {
                try {
                    double val = Double.parseDouble(DoubleInput.super.getValue());
                    doubleValue = val;
                } catch (NumberFormatException e) {
                    setValue(String.valueOf(doubleValue));
                }
            }
        });
    }

    @Override
    public void setValue(String value) {
        super.setValue(value);
    }

    public double getAmount() {
        return Double.parseDouble(getValue());
    }

    @Override
    public String getValue() {
        return super.getValue();
    }
}
