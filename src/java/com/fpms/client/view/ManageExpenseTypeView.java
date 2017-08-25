/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.view;

import com.fpms.client.presenter.ManageExpenseTypePresenter;
import com.fpms.client.widgets.CustomGrid;
import com.fpms.client.widgets.DataType;
import com.fpms.client.widgets.SelectionMode;
import com.fpms.shared.dtos.ExpenseTypeDto;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import java.util.LinkedHashMap;

/**
 *
 * @author aabello
 */
public class ManageExpenseTypeView extends Composite implements 
        ManageExpenseTypePresenter.Display{
    private GridControlView<ExpenseTypeDto> typeGrid;

    public ManageExpenseTypeView() {
        
        VerticalPanel centerPanel = new VerticalPanel();
        initWidget(centerPanel);
        centerPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
        centerPanel.setHeight("0");
        
        typeGrid = buildGrid();
        
        centerPanel.add(typeGrid);
    }
    
    

    @Override
    public CustomGrid<ExpenseTypeDto> getCustomGrid() {
        return typeGrid.getGrid();
    }

    @Override
    public GridControlView<ExpenseTypeDto> getControlView() {
        return typeGrid;
    }

    private GridControlView<ExpenseTypeDto> buildGrid() {
        TextColumn<ExpenseTypeDto> idColumn = new TextColumn<ExpenseTypeDto>() {

            @Override
            public String getValue(ExpenseTypeDto object) {
                return object.getTypeId();
            }
        };
        
        TextColumn<ExpenseTypeDto> nameColumn = new TextColumn<ExpenseTypeDto>() {

            @Override
            public String getValue(ExpenseTypeDto object) {
                return object.getTypeName();
            }
        };
        
        TextColumn<ExpenseTypeDto> descColumn = new TextColumn<ExpenseTypeDto>() {

            @Override
            public String getValue(ExpenseTypeDto object) {
                return object.getDescription();
            }
        };
        
        LinkedHashMap<String, Column> parameters = new LinkedHashMap<String, Column>();
        parameters.put("Expense Type ID", idColumn);
        parameters.put("Type Name", nameColumn);
        parameters.put("Description", descColumn);
        
        CustomGrid<ExpenseTypeDto> grid = new CustomGrid<ExpenseTypeDto>
                (parameters,
                SelectionMode.SINGLE, 
                false, 
                true, 
                DataType.STATIC);
        
        return new GridControlView<ExpenseTypeDto>(grid);
                
    }
    
}
