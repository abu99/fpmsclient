/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.view;

import com.fpms.client.presenter.EditSeasonPresenter;
import com.fpms.client.widgets.CustomListBox;
import com.fpms.shared.dtos.FarmSectionDto;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

/**
 *
 * @author aabello
 */
public class EditSeasonView extends DialogBox implements 
        EditSeasonPresenter.Display{
    
    private CustomListBox<FarmSectionDto> sectionList;
    private DateBox startDateBox;
    private DateBox EndDateBox;
    private TextArea descBox;
    private Button saveButton;
    private Button cancelButton;
    private FlexTable details;

    public EditSeasonView(String title) {
        
        setText(title);
        VerticalPanel content = new VerticalPanel();
        content.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
        content.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        content.setWidth("200px");
        
        sectionList = new CustomListBox<FarmSectionDto>();
        startDateBox = new DateBox();
        EndDateBox = new DateBox();
        descBox = new TextArea();
        saveButton = new Button("Save");
        cancelButton = new Button("Cancel");
        details = new FlexTable();
        build();
        
        HorizontalPanel buttonPanel = new HorizontalPanel();
        buttonPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        
        content.add(details);
        content.add(buttonPanel);
        
        add(content);
        
    }
    
    

    @Override
    public CustomListBox<FarmSectionDto> getSectionList() {
        return sectionList;
    }

    @Override
    public DateBox getStartDate() {
        return startDateBox;
    }

    @Override
    public DateBox getEndDate() {
        return EndDateBox;
    }

    @Override
    public HasValue<String> getDescription() {
        return descBox;
    }

    @Override
    public HasClickHandlers getSaveButton() {
        return saveButton;
    }

    @Override
    public HasClickHandlers getCancelButton() {
        return cancelButton;
    }
    
    @Override
    public Widget asWidget(){
        return this;
    }

    private void build() {
        details.setCellSpacing(7);
        details.setCellPadding(5);
        details.setWidth("100%");
        details.setStyleName("contacts-ListContainer");
        details.setWidget(0, 0, new Label("Section:"));
        details.setWidget(0, 1, sectionList);
        details.setWidget(1, 0, new Label("Start Date: "));
        details.setWidget(1, 1, startDateBox);
        details.setWidget(2, 0, new Label("End Date: "));
        details.setWidget(2, 1, EndDateBox);
        details.setWidget(3, 0, new Label("Description: "));
        details.setWidget(3, 1, descBox);
        sectionList.setFocus(true);
    }
    
}
