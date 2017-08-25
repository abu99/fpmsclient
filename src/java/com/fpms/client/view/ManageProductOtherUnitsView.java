/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.view;

import com.fpms.client.presenter.ManageProductOtherUnitsPresenter;
import com.fpms.client.widgets.CustomGrid;
import com.fpms.client.widgets.DataType;
import com.fpms.client.widgets.SelectionMode;
import com.fpms.client.widgets.gridcolumns.NumberColumn;
import com.fpms.shared.dtos.ProductOtherUnitsDto;
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
public class ManageProductOtherUnitsView extends Composite implements
        ManageProductOtherUnitsPresenter.Display{
    private GridControlView<ProductOtherUnitsDto> otherUnitsGrid;

    public ManageProductOtherUnitsView() {
        VerticalPanel centerPanel = new VerticalPanel();
        initWidget(centerPanel);
        centerPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
        centerPanel.setHeight("0");
        
        otherUnitsGrid = buildGrid();
        
        centerPanel.add(otherUnitsGrid);
        
    }

    
    
    @Override
    public CustomGrid<ProductOtherUnitsDto> getCustomGrid() {
        return otherUnitsGrid.getGrid();
    }

    @Override
    public GridControlView<ProductOtherUnitsDto> getGridControlView() {
        return otherUnitsGrid;
    }

    private GridControlView<ProductOtherUnitsDto> buildGrid() {
        TextColumn<ProductOtherUnitsDto> productColumn = new 
                TextColumn<ProductOtherUnitsDto>() {
            @Override
            public String getValue(ProductOtherUnitsDto object) {
                return object.getProductId().getProductName();
            }
        };
        
        TextColumn<ProductOtherUnitsDto> sectionColumn = new
                TextColumn<ProductOtherUnitsDto>() {

            @Override
            public String getValue(ProductOtherUnitsDto object) {
                return object.getSectionId().getSectionName();
            }
        };
        
        TextColumn<ProductOtherUnitsDto> unitNameColumn = new
                TextColumn<ProductOtherUnitsDto>() {

            @Override
            public String getValue(ProductOtherUnitsDto object) {
                return object.getUnitName();
            }
        };
        
        NumberColumn<ProductOtherUnitsDto> countColumn = new 
                NumberColumn<ProductOtherUnitsDto>() {

            @Override
            public Number getValue(ProductOtherUnitsDto object) {
                return object.getCount();
            }
        };
        
        LinkedHashMap<String, Column> parameters = new LinkedHashMap<String, Column>();
        parameters.put("Product", productColumn);
        parameters.put("Section", sectionColumn);
        parameters.put("Unit Name", unitNameColumn);
        parameters.put("Unit Count", countColumn);
        
        CustomGrid<ProductOtherUnitsDto> grid = new CustomGrid<ProductOtherUnitsDto>
                (parameters, 
                SelectionMode.SINGLE,
                false,
                true, 
                DataType.STATIC);
        
        return new GridControlView<ProductOtherUnitsDto>(grid);
        
    }
    
}
