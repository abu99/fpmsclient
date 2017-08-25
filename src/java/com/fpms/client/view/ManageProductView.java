/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.view;

import com.fpms.client.presenter.ManageProductPresenter;
import com.fpms.client.widgets.CustomGrid;
import com.fpms.client.widgets.DataType;
import com.fpms.client.widgets.SelectionMode;
import com.fpms.shared.dtos.ProductDto;
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
public class ManageProductView extends Composite implements 
        ManageProductPresenter.Display{
    
    private GridControlView<ProductDto> productGrid;

    public ManageProductView() {
        
        VerticalPanel centerPanel = new VerticalPanel();
        initWidget(centerPanel);
        centerPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
        centerPanel.setHeight("0");
        
        productGrid = buildGrid();
        
        centerPanel.add(productGrid);
        
    }
    
    

    @Override
    public CustomGrid<ProductDto> getCustomGrid() {
        return productGrid.getGrid();
    }

    @Override
    public GridControlView<ProductDto> getCustomControlView() {
        return productGrid;
    }

    private GridControlView<ProductDto> buildGrid() {
        TextColumn<ProductDto> idColumn = new TextColumn<ProductDto>() {

            @Override
            public String getValue(ProductDto object) {
                return object.getProductId();
            }
        };
        
        TextColumn<ProductDto> sectionColumn = new TextColumn<ProductDto>() {

            @Override
            public String getValue(ProductDto object) {
                return object.getSectionId().getSectionName();
            }
        };
        
        TextColumn<ProductDto> nameColumn = new TextColumn<ProductDto>() {

            @Override
            public String getValue(ProductDto object) {
                return object.getProductName();
            }
        };
        
        TextColumn<ProductDto> stdUnitColumn = new TextColumn<ProductDto>() {

            @Override
            public String getValue(ProductDto object) {
                return object.getStandardUnit();
            }
        };
        
        TextColumn<ProductDto> descColumn = new TextColumn<ProductDto>() {

            @Override
            public String getValue(ProductDto object) {
                return object.getDescription();
            }
        };
        
        LinkedHashMap<String, Column> parameters = new LinkedHashMap<String, Column>();
        parameters.put("Product ID", idColumn);
        parameters.put("Section", sectionColumn);
        parameters.put("Name", nameColumn);
        parameters.put("Standard Unit", stdUnitColumn);
        parameters.put("Description", descColumn);
        
        CustomGrid<ProductDto> grid = new CustomGrid<ProductDto>(parameters,
                SelectionMode.SINGLE,
                false, 
                true,
                DataType.STATIC);
        
        return new GridControlView<ProductDto>(grid);
    }
    
}
