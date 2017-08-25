/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.view;

import com.fpms.client.presenter.ManageSeasonPresenter;
import com.fpms.client.util.FpmsClientUtil;
import com.fpms.client.widgets.CustomGrid;
import com.fpms.client.widgets.DataType;
import com.fpms.client.widgets.SelectionMode;
import com.fpms.shared.dtos.FarmingSeasonDto;
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
public class ManageSeasonView extends Composite implements ManageSeasonPresenter.Display{
    
    private GridControlView<FarmingSeasonDto> seasonGrid;

    public ManageSeasonView() {
        
        VerticalPanel centerPanel = new VerticalPanel();
        initWidget(centerPanel);
        centerPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
        centerPanel.setHeight("0");
        
        seasonGrid = buildGrid();
        
        centerPanel.add(seasonGrid);
    }
    
    
    @Override
    public CustomGrid<FarmingSeasonDto> getCustomGrid() {
        return seasonGrid.getGrid();
    }

    @Override
    public GridControlView<FarmingSeasonDto> getGridControlView() {
        return seasonGrid;
    }

    private GridControlView<FarmingSeasonDto> buildGrid() {
        TextColumn<FarmingSeasonDto> sectionColumn = new TextColumn<FarmingSeasonDto>() {

            @Override
            public String getValue(FarmingSeasonDto object) {
                return object.getSectionId().getSectionName();
            }
        };
        
        TextColumn<FarmingSeasonDto> statDateColumn = new TextColumn<FarmingSeasonDto>() {

            @Override
            public String getValue(FarmingSeasonDto object) {
                return FpmsClientUtil.getShortDate(object.getStartDate());
            }
        };
        
        TextColumn<FarmingSeasonDto> endDateColumn = new TextColumn<FarmingSeasonDto>() {

            @Override
            public String getValue(FarmingSeasonDto object) {
                return FpmsClientUtil.getShortDate(object.getEndDate());
            }
        };
        
        TextColumn<FarmingSeasonDto> descColumn = new TextColumn<FarmingSeasonDto>() {

            @Override
            public String getValue(FarmingSeasonDto object) {
                return object.getDescription();
            }
        };
        
        LinkedHashMap<String, Column> parameters = new LinkedHashMap<String, Column>();
        parameters.put("Section", sectionColumn);
        parameters.put("Start Date", statDateColumn);
        parameters.put("End Date", endDateColumn);
        parameters.put("Description", descColumn);
        
        CustomGrid<FarmingSeasonDto> grid = new CustomGrid<FarmingSeasonDto>(parameters, 
                SelectionMode.SINGLE,
                false, 
                true,
                DataType.STATIC);
        
        return new GridControlView<FarmingSeasonDto>(grid);
        
    }
}
