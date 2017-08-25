/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.widgets.navigation;

import com.fpms.shared.types.PrivilegeTypeDto;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;

/**
 *
 * @author faizbash
 */
public class NavigationButton extends Composite {
    public NavigationButton(final PrivilegeTypeDto privilege) {
        Button button = new Button(privilege.getDescrption());
        button.setStylePrimaryName("navigationButton");
        button.setWidth("207px");
        initWidget(button);
        
        button.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                NavigationPresenter.doNavigate(privilege);
            }
        });
    }
}
