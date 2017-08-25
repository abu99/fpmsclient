/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.view;

import com.fpms.client.presenter.ManageExpensesPresenter;
import com.fpms.client.util.FpmsClientUtil;
import com.fpms.client.widgets.CustomGrid;
import com.fpms.client.widgets.CustomListBox;
import com.fpms.client.widgets.DataType;
import com.fpms.client.widgets.SelectionMode;
import com.fpms.client.widgets.gridcolumns.NumberColumn;
import com.fpms.shared.dtos.ExpenseDto;
import com.fpms.shared.dtos.ExpenseTypeDto;
import com.fpms.shared.dtos.FarmSectionDto;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import java.util.LinkedHashMap;

/**
 *
 * @author aabello
 */
public class ManageExpensesView extends Composite implements 
        ManageExpensesPresenter.Display{
    
    private GridControlView<ExpenseDto> expenseGrid;
    private final CustomListBox<FarmSectionDto> sectionList;
    private final CustomListBox<ExpenseTypeDto> typeList;

    public ManageExpensesView() {
        
        VerticalPanel centerPanel = new VerticalPanel();
        initWidget(centerPanel);
        centerPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
        centerPanel.setHeight("0");
        
        sectionList = new CustomListBox<FarmSectionDto>();
        typeList = new CustomListBox<ExpenseTypeDto>();
        
        FlexTable table = new FlexTable();
        
        table.setWidget(0, 0, new Label("Filter By => Section :"));
        table.setWidget(0, 1, sectionList);
        table.setWidget(0, 2, new Label("Expense Type :"));
        table.setWidget(0, 3, typeList);
        DecoratorPanel tableDecorator = new DecoratorPanel();
        tableDecorator.add(table);
        
        
        centerPanel.add(tableDecorator);
        
        expenseGrid = buildGrid();
        
        centerPanel.add(expenseGrid);
    }
    
    

    @Override
    public CustomGrid<ExpenseDto> getCustomGrid() {
        return expenseGrid.getGrid();
    }

    @Override
    public GridControlView<ExpenseDto> getGridControlView() {
        return expenseGrid;
    }

    private GridControlView<ExpenseDto> buildGrid() {
        
        TextColumn<ExpenseDto> idColumn = new TextColumn<ExpenseDto>() {

            @Override
            public String getValue(ExpenseDto object) {
                return object.getExpenseId();
            }
        };
        
        TextColumn<ExpenseDto> typeColumn = new TextColumn<ExpenseDto>() {

            @Override
            public String getValue(ExpenseDto object) {
                return object.getExpenseTypeId().getTypeName();
            }
        };
        
        TextColumn<ExpenseDto> sectionColumn = new TextColumn<ExpenseDto>() {

            @Override
            public String getValue(ExpenseDto object) {
                return object.getSectionId().getSectionName();
            }
        };
        
        NumberColumn<ExpenseDto> amountColumn = new NumberColumn<ExpenseDto>() {

            @Override
            public Number getValue(ExpenseDto object) {
                return object.getAmount();
            }
        };
        
        TextColumn<ExpenseDto> dateColumn = new TextColumn<ExpenseDto>() {

            @Override
            public String getValue(ExpenseDto object) {
                return FpmsClientUtil.getShortDate(object.getCreatedDate());
            }
        };
        
        TextColumn<ExpenseDto> descColumn = new TextColumn<ExpenseDto>() {

            @Override
            public String getValue(ExpenseDto object) {
                return object.getDescription();
            }
        };
        
        LinkedHashMap<String, Column> Parameters = new LinkedHashMap<String, Column>();
        Parameters.put("Expense ID", idColumn);
        Parameters.put("Expense Type", typeColumn);
        Parameters.put("Section", sectionColumn);
        Parameters.put("Amount", amountColumn);
        Parameters.put("Date Created", dateColumn);
        Parameters.put("Description", descColumn);
        
        CustomGrid<ExpenseDto> grid = new CustomGrid<ExpenseDto>(Parameters, 
                SelectionMode.SINGLE, 
                false, 
                true, 
                DataType.STATIC);
        
        return new GridControlView<ExpenseDto>(grid);
    }

    @Override
    public CustomListBox<FarmSectionDto> getSectionList() {
        return sectionList;
    }
    @Override
    public CustomListBox<ExpenseTypeDto> getExpenseTypeList() {
        return typeList;
    }
    
    
}
