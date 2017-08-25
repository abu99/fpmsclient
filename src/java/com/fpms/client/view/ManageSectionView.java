/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.view;

import com.fpms.client.presenter.ManageSectionPresenter;
import com.fpms.client.widgets.CustomGrid;
import com.fpms.client.widgets.DataType;
import com.fpms.client.widgets.SelectionMode;
import com.fpms.shared.dtos.FarmSectionDto;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.LinkedHashMap;

/**
 *
 * @author aabello
 */
public class ManageSectionView extends Composite implements 
        ManageSectionPresenter.Display{
    
    private GridControlView<FarmSectionDto> sectionGrid;

    public ManageSectionView() {
        
        VerticalPanel centerPanel = new VerticalPanel();
        initWidget(centerPanel);
        centerPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
        centerPanel.setHeight("0");
        
        sectionGrid = buildGrid();
        
        centerPanel.add(sectionGrid);
    }
    
    @Override
    public Widget asWidget(){
        return this;
    }
    
    private GridControlView<FarmSectionDto> buildGrid() {
        
        TextColumn<FarmSectionDto> idColumn = new TextColumn<FarmSectionDto>() {

            @Override
            public String getValue(FarmSectionDto object) {
                return object.getSectionId();
            }
        };
        
        TextColumn<FarmSectionDto> nameColumn = new TextColumn<FarmSectionDto>() {

            @Override
            public String getValue(FarmSectionDto object) {
                return object.getSectionName();
            }
        };
        
        TextColumn<FarmSectionDto> DescColumn = new TextColumn<FarmSectionDto>() {

            @Override
            public String getValue(FarmSectionDto object) {
                return object.getDescription();
            }
        };
        
        LinkedHashMap<String, Column> parameters = new LinkedHashMap<String, Column>();
        parameters.put("Section ID", idColumn);
        parameters.put("Name", nameColumn);
        parameters.put("Description", DescColumn);
        
        CustomGrid<FarmSectionDto> grid = new CustomGrid<FarmSectionDto>
                (parameters,
                SelectionMode.SINGLE, 
                false, 
                true, 
                DataType.STATIC);
        
        return new GridControlView<FarmSectionDto>(grid);
        
    }

    @Override
    public CustomGrid<FarmSectionDto> getCustomGrid() {
        return sectionGrid.getGrid();
    }

    @Override
    public GridControlView<FarmSectionDto> getGridControlView() {
        return sectionGrid;
    }

    
    
}
