/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.shared.dtos;

import com.google.gwt.user.client.rpc.IsSerializable;
import java.io.Serializable;

/**
 *
 * @author aabello
 */
public enum ExpenseSortTypeDto implements Serializable, IsSerializable{
    
    SECTION("SECTION"),
    EXPENSE_TYPE("EXPENSE TYPE");
    
    private String description;

    private ExpenseSortTypeDto(String description) {
        this.description = description;
    }
    
    

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return description;
    }
    
    
    
    
    
}
