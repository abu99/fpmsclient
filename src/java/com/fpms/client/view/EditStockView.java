/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.view;

import com.fpms.client.presenter.EditStockPresenter;
import com.fpms.client.widgets.CustomListBox;
import com.fpms.shared.dtos.FarmSectionDto;
import com.fpms.shared.dtos.ProductDto;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;

/**
 *
 * @author aabello
 */
public class EditStockView extends DialogBox implements EditStockPresenter.Display{

    private CustomListBox<ProductDto> prodListBox;
    private CustomListBox<FarmSectionDto> sectListBox;
    private IntegerBox quantityBox;
    private DoubleBox amountBox;
    private RadioButton inType;
    private RadioButton outType;
    private DateBox dateBox;
    private TextArea descBox;
    private Button saveButton;
    private Button cancelButton;
    private FlexTable details;

    public EditStockView(String title) {
        
        setText(title);
        VerticalPanel content = new VerticalPanel();
        content.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
        content.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        content.setWidth("200px");
        
        prodListBox = new CustomListBox<ProductDto>();
        sectListBox = new CustomListBox<FarmSectionDto>();
        quantityBox = new IntegerBox();
        amountBox = new DoubleBox();
        inType = new RadioButton("TYPE","IN");
        outType = new RadioButton("TYPE","OUT");
        dateBox = new DateBox();
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
    public CustomListBox<ProductDto> getProductList() {
        return prodListBox;
    }

    @Override
    public CustomListBox<FarmSectionDto> getSectionList() {
        return sectListBox;
    }

    @Override
    public IntegerBox getQuantity() {
        return quantityBox;
    }

    @Override
    public DoubleBox getAmount() {
        return amountBox;
    }

    @Override
    public RadioButton getINStockType() {
        return inType;
    }

    @Override
    public RadioButton getOUTStockType() {
        return outType;
    }

    @Override
    public DateBox getDate() {
        return dateBox;
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
        details.setWidget(0, 0, new Label("Product"));
        details.setWidget(0, 1, prodListBox);
        details.setWidget(1, 0, new Label("Section"));
        details.setWidget(1, 1, sectListBox);
        details.setWidget(2, 0, new Label("Quantity"));
        details.setWidget(2, 1, quantityBox);
        details.setWidget(3, 0, new Label("Amount"));
        details.setWidget(3, 1, amountBox);
        details.setWidget(4, 0, new Label("Stock Type"));
        HorizontalPanel stockType = new HorizontalPanel();
        stockType.add(inType);
        stockType.add(outType);
        details.setWidget(4, 1, stockType);
        details.setWidget(5, 0, new Label("Date"));
        details.setWidget(5, 1, dateBox);
        details.setWidget(6, 0, new Label("Description"));
        details.setWidget(6, 1, descBox);
        prodListBox.setFocus(true);
    }
    
}
