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
public class FarmSectionDto implements Serializable, IsSerializable{
    
    private String sectionId;
    private String sectionName;
    private String Description;

    public FarmSectionDto() {
    }

    public FarmSectionDto(String sectionId, String sectionName, String desc) {
        this.sectionId = sectionId;
        this.sectionName = sectionName;
        this.Description = desc;
    }

    public String getSectionId() {
        return sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public String getDescription() {
        return Description;
    }
    
    public static FarmSectionDto getEmptySection(){
        return new FarmSectionDto(null, "-- Select Section --", null);
    }
    

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (this.sectionId != null ? this.sectionId.hashCode() : 0);
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
        final FarmSectionDto other = (FarmSectionDto) obj;
        if ((this.sectionId == null) ? (other.sectionId != null) : !this.sectionId.equals(other.sectionId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return sectionName;
    }
    
    
    
}
