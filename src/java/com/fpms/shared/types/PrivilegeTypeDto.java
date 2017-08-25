/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpms.shared.types;

import com.google.gwt.user.client.rpc.IsSerializable;


/**
 *
 * @author faizbash
 */
public enum PrivilegeTypeDto implements IsSerializable {
    
    //Admin
    MANAGE_SECTION("MANAGE FARM SECTION"),
    MANAGE_SEASON("MANAGE FARM SECTION's SEASON"),
    MANAGE_PRODUCT("MANAGE FARM PRODUCT"),
    MANAGE_PRODUCT_OTHER_UNITS("MANAGE PRODUCT OTHER UNITS"),
    MANAGE_EXPENSE_TYPE("MANAGE EXPENSE TYPE"),
    MANAGE_EXPENSE("MANAGE EXPENSES"),
    MANAGE_STOCK("MANAGE FARM STOCK"), 
    MANAGE_FARM_INFO("MANAGE FARM INFO"),
    VIEW_PROFIT_AND_LOSS("View Profit / Loss");
    
    private String description;

    private PrivilegeTypeDto(String description) {
	this.description = description;
    }

    public String getDescrption() {
	return description;
    }
    
}
