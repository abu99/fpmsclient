/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.view;

import com.fpms.client.presenter.EditProductPresenter;
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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 *
 * @author aabello
 */
public class EditProductView extends DialogBox implements 
        EditProductPresenter.Display{
    
    private TextBox productIdBox;
    private CustomListBox<FarmSectionDto> sectionListBox;
    private TextBox productNameBox;
    private TextBox stdUnitBox;
    private TextArea descBox;
    private Button saveButton;
    private Button cancelButton;
    private FlexTable details;

    public EditProductView(String title) {
        
        setText(title);
        VerticalPanel content = new VerticalPanel();
        content.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
        content.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        content.setWidth("200px");
        
        productIdBox = new TextBox();
        sectionListBox = new CustomListBox<FarmSectionDto>();
        productNameBox = new TextBox();
        stdUnitBox = new TextBox();
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
    public HasValue<String> getProductId() {
        return productIdBox;
    }

    @Override
    public CustomListBox<FarmSectionDto> getSectionList() {
        return sectionListBox;
    }

    @Override
    public HasValue<String> getProductName() {
        return productNameBox;
    }

    @Override
    public HasValue<String> getStandardUnit() {
        return stdUnitBox;
    }

    @Override
    public HasValue<String> getDesc() {
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

    private void build() {
        details.setCellSpacing(7);
        details.setCellPadding(5);
        details.setWidth("100%");
        details.setStyleName("contacts-ListContainer");
        details.setWidget(0, 0, new Label("Product ID:"));
        details.setWidget(0, 1, productIdBox);
        details.setWidget(1, 0, new Label("Section:"));
        details.setWidget(1, 1, sectionListBox);
        details.setWidget(2, 0, new Label("Product Name:"));
        details.setWidget(2, 1, productNameBox);
        details.setWidget(3, 0, new Label("Standard Unit:"));
        details.setWidget(3, 1, stdUnitBox);
        details.setWidget(4, 0, new Label("Description: "));
        details.setWidget(4, 1, descBox);
        productIdBox.setFocus(true);
    }
    
    
}
