/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.view;

import com.fpms.client.widgets.BannerWidget;
import com.fpms.client.widgets.navigation.NavigationButton;
import com.fpms.shared.types.PrivilegeTypeDto;
import com.google.gwt.user.client.ui.*;

/**
 *
 * @author faizbash
 */
public class MainView extends Composite {
    private final VerticalPanel contentPanel;
    private final VerticalPanel navigationPanel;
    private final static MainView singleton = new MainView();
    
    private MainView() {
        VerticalPanel rootPanel = new VerticalPanel();
        rootPanel.setSize("100%", "100%");
        initWidget(rootPanel);
                
        VerticalPanel mainBody = new VerticalPanel();
        rootPanel.add(mainBody);
        rootPanel.setCellHorizontalAlignment(mainBody, 
                HasHorizontalAlignment.ALIGN_CENTER);
        mainBody.setSize("100%", "100%");
        
        mainBody.getElement().setId("mainBody");
        mainBody.add(BannerWidget.INSTANCE);

        
        //nav and content
        HorizontalPanel navAndContentPanel = new HorizontalPanel();
        navAndContentPanel.setSpacing(2);
        navAndContentPanel.setHeight("100%");
//        navAndContentPanel.setSize("0px", "100%");
        mainBody.add(navAndContentPanel);
        
        navigationPanel = new VerticalPanel();
        navigationPanel.setStylePrimaryName("navigationPanel");
//        navigationPanel.setWidth("150px");
        
        VerticalPanel labelandContent = new VerticalPanel();
        labelandContent.setWidth("100%");
        DecoratorPanel stackPanel = new DecoratorPanel();
        
        
        
        contentPanel = new VerticalPanel();
//        contentPanel.setSize("0px","100%");
        CenterPageLabel.get().setStyleName("CenterPageLabelPadding");
        CenterPageLabel.get().setWidth("100%");
        stackPanel.add(CenterPageLabel.get());
        stackPanel.setWidth("100%");
//	contentPanel.add(CenterPageLabel.get());
        labelandContent.add(stackPanel);
        labelandContent.add(contentPanel);
        
        navAndContentPanel.add(navigationPanel);
        navAndContentPanel.add(labelandContent);
        
    }
    
    public HasWidgets getContentPanel() {
        return contentPanel;
    }
    
//    public void addNagivationButton(Widget button) {
//        navigationPanel.add(button);
//    }
    
    public static MainView get() {
        return singleton;
    }

//    public void createMenus(LinkedHashMap<RoleDto, List<PrivilegeDto>> privileges) {
//        navigationPanel.clear();
//        
//        for (RoleDto r: privileges.keySet()) {     
//            for (PrivilegeDto p: privileges.get(r)) {
//                NavigationButton nb = new NavigationButton(p);
//                navigationPanel.add(nb);
//            }
//        }
//    }
    public void createMenus() {
        navigationPanel.clear();
        
        for (PrivilegeTypeDto dto : PrivilegeTypeDto.values()) {
            //Window.alert(dto.name());
            NavigationButton nb = new NavigationButton(dto);
            navigationPanel.add(nb);
        }
    } 

//    public void addNewApplicationPrivilege() {
//        NavigationButton nb = new NavigationButton(new PrivilegeDto(
//                PrivilegeTypeDto.MANAGE_SEASON.name(), 
//                PrivilegeTypeDto.MANAGE_SEASON.getDescrption()));
//        navigationPanel.add(nb);
//    }

}
