/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpms.client.widgets.navigation;


import com.fpms.client.FpmsEventBus;
import com.fpms.event.ManageExpenseTypeEvent;
import com.fpms.event.ManageExpensesEvent;
import com.fpms.event.ManageFarmInfoEvent;
import com.fpms.event.ManageProductEvent;
import com.fpms.event.ManageProductOtherUnitsEvent;
import com.fpms.event.ManageSeasonEvent;
import com.fpms.event.ManageSectionEvent;
import com.fpms.event.ManageStockEvent;
import com.fpms.event.ProfitEvent;
import com.fpms.shared.types.PrivilegeTypeDto;
import com.google.gwt.event.shared.SimpleEventBus;

/**
 *
 * @author faizbash
 */
public class NavigationPresenter {

    public static void doNavigate(PrivilegeTypeDto privilege) {
        SimpleEventBus eventBus = FpmsEventBus.getEventBus();
        
        if(privilege.equals(PrivilegeTypeDto.MANAGE_SEASON)) {
            eventBus.fireEvent(new ManageSeasonEvent());
        }
        
        if(privilege.equals(PrivilegeTypeDto.MANAGE_SECTION)) {
            eventBus.fireEvent(new ManageSectionEvent());
        }
        
        if(privilege.equals(PrivilegeTypeDto.MANAGE_PRODUCT)) {
            eventBus.fireEvent(new ManageProductEvent());
        }
        
        if(privilege.equals(PrivilegeTypeDto.MANAGE_PRODUCT_OTHER_UNITS)){
            eventBus.fireEvent(new ManageProductOtherUnitsEvent());
        }
        
        if(privilege.equals(PrivilegeTypeDto.MANAGE_EXPENSE_TYPE)){
            eventBus.fireEvent(new ManageExpenseTypeEvent());
        }
        
        if(privilege.equals(PrivilegeTypeDto.MANAGE_EXPENSE)){
            eventBus.fireEvent(new ManageExpensesEvent());
        }
        
        if(privilege.equals(PrivilegeTypeDto.MANAGE_STOCK)){
            eventBus.fireEvent(new ManageStockEvent());
        }
        if(privilege.equals(PrivilegeTypeDto.VIEW_PROFIT_AND_LOSS)){
            eventBus.fireEvent(new ProfitEvent());
        }
        if(privilege.equals(PrivilegeTypeDto.MANAGE_FARM_INFO)){
            eventBus.fireEvent(new ManageFarmInfoEvent());
        }
        
        
    }     
}
