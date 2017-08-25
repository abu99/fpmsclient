/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.view;

import com.fpms.client.presenter.ViewProfitLostPresenter;
import com.fpms.client.widgets.CustomGrid;
import com.fpms.client.widgets.DataType;
import com.fpms.client.widgets.InformationPanel;
import com.fpms.client.widgets.NairaFormat;
import com.fpms.client.widgets.SelectionMode;
import com.fpms.shared.dtos.ProfitDto;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import java.util.LinkedHashMap;

/**
 *
 * @author kip
 */
public class ViewProfitLossView extends Composite implements ViewProfitLostPresenter.Display {
    private final InformationPanel infoPanel;
    private final GridControlView<ProfitDto> grid;
    
    public ViewProfitLossView() {
        VerticalPanel vPanel = new VerticalPanel();
        initWidget(vPanel);
        grid = buildGrid();
        vPanel.add(grid);
        infoPanel = new InformationPanel();
        vPanel.add(infoPanel);
    }
    
    
    private GridControlView<ProfitDto> buildGrid() {
        TextColumn<ProfitDto> itemId = new TextColumn<ProfitDto>() {

            @Override
            public String getValue(ProfitDto object) {
                return object.getItemId() + "";
            }
        };
        TextColumn<ProfitDto> expenditure = new TextColumn<ProfitDto>() {

            @Override
            public String getValue(ProfitDto object) {
                return object.isExpenditure() ? "Expenditure" : "Income";
            }
        };
        TextColumn<ProfitDto> expenseType = new TextColumn<ProfitDto>() {

            @Override
            public String getValue(ProfitDto object) {
                return object.getExpenseType();
            }
        };
        TextColumn<ProfitDto> section = new TextColumn<ProfitDto>() {

            @Override
            public String getValue(ProfitDto object) {
                return object.getSectionExpendedTo();
            }
        };
        TextColumn<ProfitDto> amount = new TextColumn<ProfitDto>() {

            @Override
            public String getValue(ProfitDto object) {
                return object.getAmount() + "";
            }
        };
        
        
        LinkedHashMap<String, Column> parameters = new LinkedHashMap<String, Column>();
        parameters.put("Item Id", itemId);
        parameters.put("Income / Expenditure", expenditure);
        parameters.put("Expense Type", expenseType);
        parameters.put("Section Expended to", section);
        parameters.put("Amount (" + NairaFormat.NAIRA_SYMBOL+")", amount);
        
        CustomGrid<ProfitDto> grid = new CustomGrid<ProfitDto>(parameters, 
                SelectionMode.SINGLE, 
                false, 
                true, 
                DataType.STATIC);
        
        return new GridControlView<ProfitDto>(grid);
    }

    @Override
    public GridControlView<ProfitDto> getGrid() {
        return grid;
    }

    @Override
    public InformationPanel getSummaryPanel() {
        return infoPanel;
    }
    
}
