/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpms.client.presenter;

import com.fpms.client.widgets.CustomGrid;
import com.google.gwt.event.dom.client.HasClickHandlers;

/**
 *
 * @author faizbash
 */
public interface GridDisplay<T> {
    HasClickHandlers getAddButton();
    HasClickHandlers getDeleteButton();
    HasClickHandlers getUpdateButton();
    HasClickHandlers getButton4();
    HasClickHandlers getButton5();
    HasClickHandlers getButton6();
    CustomGrid<T> getGrid();
}
