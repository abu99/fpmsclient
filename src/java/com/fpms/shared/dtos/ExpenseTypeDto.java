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
public class ExpenseTypeDto implements Serializable, IsSerializable {

    
    
    private String typeId;
    private String typeName;
    private String description;

    public ExpenseTypeDto() {
    }

    public ExpenseTypeDto(String typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ExpenseTypeDto getEmptyExpenseType() {
        return new ExpenseTypeDto(null, "-- Select Expense Type --");
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.typeId != null ? this.typeId.hashCode() : 0);
        hash = 83 * hash + (this.typeName != null ? this.typeName.hashCode() : 0);
        hash = 83 * hash + (this.description != null ? this.description.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExpenseTypeDto other = (ExpenseTypeDto) obj;
        if ((this.typeId == null) ? (other.typeId != null) : !this.typeId.equals(other.typeId)) {
            return false;
        }
        if ((this.typeName == null) ? (other.typeName != null) : !this.typeName.equals(other.typeName)) {
            return false;
        }
        if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
    
        return typeName;
    }
    
}
