/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.view;

import com.fpms.client.presenter.EditSectionPresenter;
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
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author aabello
 */
public class EditSectionView extends DialogBox implements 
        EditSectionPresenter.Display{
    
        private TextBox idBox;
        private TextBox nameBox;
        private TextArea descBox;
        private Button saveButton;
        private Button cancelButton;
        private FlexTable details;

    public EditSectionView(String title) {
        
        setText(title);
        VerticalPanel content = new VerticalPanel();
        content.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
        content.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        content.setWidth("350px");
        
        idBox = new TextBox();
        nameBox = new TextBox();
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
    public Widget asWidget(){
        return this;
    }
        

    @Override
    public HasValue<String> getSectionId() {
        return idBox;
    }

    @Override
    public HasValue<String> getSectionName() {
        return nameBox;
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
        details.setWidget(0, 0, new Label("Section ID :"));
        details.setWidget(0, 1, idBox);
        details.setWidget(1, 0, new Label("Section Name: "));
        details.setWidget(1, 1, nameBox);
        details.setWidget(2, 0, new Label("Description"));
        details.setWidget(2, 1, descBox);
        idBox.setFocus(true);
    }
    
}
