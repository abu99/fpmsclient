/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.view;

import com.fpms.client.presenter.ManageFarmInfoPresenter;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 *
 * @author aabello
 */
public class FarmInfoView extends Composite implements ManageFarmInfoPresenter.Display{

    private final TextBox farmName;
    private final TextArea address;
    private final TextBox city;
    private final TextBox farmState;
    private final TextBox phoneNumber;
    private final TextBox website;
    private final TextBox email;
    private final Button updateButton;
    private final FlexTable details;

    public FarmInfoView() {
        
        VerticalPanel centerPanel = new VerticalPanel();
        initWidget(centerPanel);
        
        VerticalPanel detailsPanel = new VerticalPanel();
        detailsPanel.setWidth("100%");
        
        DecoratorPanel contentDetailsDecorator = new DecoratorPanel();
        contentDetailsDecorator.setWidth("600px");
        
        VerticalPanel contentDetailsPanel = new VerticalPanel();
        contentDetailsPanel.setHorizontalAlignment(
                HasHorizontalAlignment.ALIGN_CENTER);
        contentDetailsPanel.setWidth("100%");
        
        farmName = new TextBox();
        farmName.setWidth("350px");
        
        address = new TextArea();
        
        city = new TextBox();
        city.setWidth("300px");
        
        farmState = new TextBox();
        farmState.setWidth("300px");
        
        website = new TextBox();
        website.setWidth("350px");
        
        email = new TextBox();
        email.setWidth("350px");
        
        phoneNumber = new TextBox();
       
        updateButton = new Button("UPDATE");
        details = new FlexTable();
        details.setCellSpacing(0);
        details.setWidth("100%");
        details.addStyleName("contacts-ListContainer");
        build();
        
        
        contentDetailsPanel.add(details);
        contentDetailsDecorator.add(contentDetailsPanel);
        detailsPanel.add(contentDetailsDecorator);
        
        centerPanel.add(detailsPanel);
        
    }
    
    
    @Override
    public HasValue<String> getFarmName() {
        return farmName;
    }

    @Override
    public HasValue<String> getAddress() {
        return address;
    }

    @Override
    public HasValue<String> getCity() {
        return city;
    }

    @Override
    public HasValue<String> getState() {
        return farmState;
    }

    @Override
    public HasValue<String> getPhone() {
        return phoneNumber;
    }

    @Override
    public HasValue<String> getEmail() {
        return email;
    }

    @Override
    public HasValue<String> getWebsite() {
        return website;
    }

    @Override
    public HasClickHandlers getUpdateButton() {
        return updateButton;
    }
    
   
    private void build() {
        
        VerticalPanel vp = new VerticalPanel();
        vp.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
        vp.add(updateButton);
        
        details.setCellPadding(10);
        details.setCellSpacing(10);
        details.setWidget(0, 0, new Label("Farm Name : "));
        details.setWidget(0, 1, farmName);
        details.setWidget(1, 0, new Label("Address : "));
        details.setWidget(1, 1, address);
        details.setWidget(2, 0, new Label("City : "));
        details.setWidget(2, 1, city);
        details.setWidget(3, 0, new Label("State : "));
        details.setWidget(3, 1, farmState);
        details.setWidget(4, 0, new Label("Phone Number : "));
        details.setWidget(4, 1, phoneNumber);
        details.setWidget(5, 0, new Label("Email : "));
        details.setWidget(5, 1, email);
        details.setWidget(6, 0, new Label("Website : "));
        details.setWidget(6, 1, website);
        details.setWidget(7, 1, vp);
        
    }



}
