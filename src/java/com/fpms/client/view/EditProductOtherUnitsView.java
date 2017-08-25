/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.view;

import com.fpms.client.presenter.EditProductOtherUnitsPresenter;
import com.fpms.client.widgets.CustomListBox;
import com.fpms.shared.dtos.FarmSectionDto;
import com.fpms.shared.dtos.ProductDto;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 *
 * @author aabello
 */
public class EditProductOtherUnitsView extends DialogBox implements
        EditProductOtherUnitsPresenter.Display{
    
    private CustomListBox<ProductDto> productListBox;
    private CustomListBox<FarmSectionDto> sectionListBox;
    private TextBox unitNameBox;
    private IntegerBox countBox;
    private Button saveButton;
    private Button cancelButon;
    private FlexTable details;

    public EditProductOtherUnitsView(String title) {
        
        setText(title);
        VerticalPanel content = new VerticalPanel();
        content.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);
        content.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        content.setWidth("200px");
        
        productListBox = new CustomListBox<ProductDto>();
        sectionListBox = new CustomListBox<FarmSectionDto>();
        unitNameBox = new TextBox();
        countBox = new IntegerBox();
        saveButton = new Button("Save");
        cancelButon = new Button("Cancel");
        details = new FlexTable();
        
        build();
        
        HorizontalPanel buttonPanel = new HorizontalPanel();
        buttonPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButon);
        
        content.add(details);
        content.add(buttonPanel);
        
        add(content);
    }
    
    

    @Override
    public CustomListBox<ProductDto> getProductList() {
        return productListBox;
    }

    @Override
    public CustomListBox<FarmSectionDto> getSectionList() {
        return sectionListBox;
    }

    @Override
    public HasValue<String> getUnitName() {
        return unitNameBox;
    }

    @Override
    public HasValue<Integer> getCount() {
        return countBox;
    }

    @Override
    public HasClickHandlers getSaveButton() {
        return saveButton;
    }

    @Override
    public HasClickHandlers getCancelButton() {
        return cancelButon;
    }

    private void build() {
        details.setCellSpacing(7);
        details.setCellPadding(5);
        details.setWidth("100%");
        details.setStyleName("contacts-ListContainer");
        details.setWidget(0, 0, new Label("Product"));
        details.setWidget(0, 1, productListBox);
        details.setWidget(1, 0, new Label("Section"));
        details.setWidget(1, 1, sectionListBox);
        details.setWidget(2, 0, new Label("Unit Name"));
        details.setWidget(2, 1, unitNameBox);
        details.setWidget(3, 0, new Label("Unit Count"));
        details.setWidget(3, 1, countBox);
        productListBox.setFocus(true);
        }
    
}
