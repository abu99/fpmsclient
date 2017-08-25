/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.view;

import com.fpms.client.presenter.EditExpensesPresenter;
import com.fpms.client.widgets.CustomListBox;
import com.fpms.shared.dtos.ExpenseTypeDto;
import com.fpms.shared.dtos.FarmSectionDto;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;

/**
 *
 * @author aabello
 */
public class EditExpensesView extends DialogBox implements 
        EditExpensesPresenter.Display{

    private TextBox idBox;
    private CustomListBox<ExpenseTypeDto> typeListBox;
    private CustomListBox<FarmSectionDto> sectionListBox;
    private DoubleBox amount;
    private DateBox date;
    private TextArea desc; 
    private Button saveButton;
    private Button cancelButton;
    private FlexTable details;

    public EditExpensesView(String title) {
        
        setText(title);
        VerticalPanel content = new VerticalPanel();
        content.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
        content.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        content.setWidth("200px");
        
        idBox = new TextBox();
        typeListBox = new CustomListBox<ExpenseTypeDto>();
        sectionListBox = new CustomListBox<FarmSectionDto>();
        amount = new DoubleBox();
        date = new DateBox();
        desc = new TextArea();
        saveButton =new Button("Save");
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
    public HasValue<String> getExpenseId() {
        return idBox;
    }

    @Override
    public CustomListBox<ExpenseTypeDto> getExpenseTypeList() {
        return typeListBox;
    }

    @Override
    public CustomListBox<FarmSectionDto> getSectionList() {
        return sectionListBox;
    }

    @Override
    public DoubleBox getAmount() {
        return amount;
    }

    @Override
    public DateBox getDate() {
        return date;
    }

    @Override
    public HasValue<String> getDesc() {
        return desc;
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
        details.setWidget(0, 0, new Label("Expense ID:"));
        details.setWidget(0, 1, idBox);
        details.setWidget(1, 0, new Label("Expense Type:"));
        details.setWidget(1, 1, typeListBox);
        details.setWidget(2, 0, new Label("Section:"));
        details.setWidget(2, 1, sectionListBox);
        details.setWidget(3, 0, new Label("Amount:"));
        details.setWidget(3, 1, amount);
        details.setWidget(4, 0, new Label("Date:"));
        details.setWidget(4, 1, date);
        details.setWidget(5, 0, new Label("Description:"));
        details.setWidget(5, 1, desc);
        idBox.setFocus(true);
    }
    
}
