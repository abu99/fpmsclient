/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpms.client.widgets;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author faizbash
 */
public class InformationPanel extends Composite {

    private FlexTable infoTable;

    public InformationPanel() {
	infoTable = new FlexTable();
	infoTable.setStylePrimaryName("infoPanel");
	infoTable.setSize("100%", "100%");

	initWidget(infoTable);
    }

    public InformationPanel(String info) {
	this();

	setBoldInfo(info, 0, 0);
    }

    public void setInfo(String info) {
	infoTable.setWidget(0, 0, new InfoLabel(info));
    }

    public void setInfo(String info, int row, int column) {
	infoTable.setWidget(row, column, new InfoLabel(info));
    }

    public void setBoldInfo(String info) {
	infoTable.setWidget(0, 0, new BoldInfoLabel(info));
    }

    public void setBoldInfo(String info, int row, int column) {
	infoTable.setWidget(row, column, new BoldInfoLabel(info));
    }
    public void setWidget(int row, int column, Widget widget) {
        infoTable.setWidget(row, column, widget);
    }
    public void clear() {
        infoTable.removeAllRows();
    }
    
    private class InfoLabel extends Label {
	InfoLabel(String info) {
	    super(info);
	    setStylePrimaryName("infoLabel");
	}
    }

    private class BoldInfoLabel extends Label {
	BoldInfoLabel(String info) {
	    super(info);
	    setStylePrimaryName("boldInfoLabel");
	}
    }

    private void applyDataRowStyles() {
        HTMLTable.RowFormatter rf = infoTable.getRowFormatter();

        for (int row = 0; row < infoTable.getRowCount(); ++row) {
            rf.addStyleName(row, "flexTable-OddRow");
        }
    }
}
