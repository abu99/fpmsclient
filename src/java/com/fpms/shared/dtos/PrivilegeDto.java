/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.shared.dtos;

/**
 *
 * @author aim
 */
public class PrivilegeDto {
    private String privilegeId;
    private String description;

    public PrivilegeDto(String privilegeId, String description) {
        this.privilegeId = privilegeId;
        this.description = description;
    }

    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(String privilegeId) {
        this.privilegeId = privilegeId;
    }
    
    
}
