/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.view;

import com.fpms.client.presenter.EditExpenseTypePresenter;
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
public class EditExpenseTypeView extends DialogBox implements 
        EditExpenseTypePresenter.Display{
    
    private TextBox typeIdBox;
    private TextBox typeNameBox;
    private TextArea descBox;
    private Button saveButton;
    private Button cancelButton;
    private FlexTable details;

    public EditExpenseTypeView(String title) {
        
        setText(title);
        VerticalPanel content = new VerticalPanel();
        content.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
        content.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        content.setWidth("400px");
        
        typeIdBox = new TextBox();
        typeNameBox = new TextBox();
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
    public HasValue<String> getExpenseTypeId() {
        return typeIdBox;
    }

    @Override
    public HasValue<String> getExpenseTypeName() {
        return typeNameBox;
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

    private void build() {
        details.setCellSpacing(7);
        details.setCellPadding(5);
        details.setWidth("100%");
        details.setStyleName("contacts-ListContainer");
        details.setWidget(0, 0, new Label("Expense Type ID:"));
        details.setWidget(0, 1, typeIdBox);
        details.setWidget(1, 0, new Label("Expense Type Name:"));
        details.setWidget(1, 1, typeNameBox);
        details.setWidget(2, 0, new Label("Description:"));
        details.setWidget(2, 1, descBox);
        typeIdBox.setFocus(true);
        
        
    }
    
}
