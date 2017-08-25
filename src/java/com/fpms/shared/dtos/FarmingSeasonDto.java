/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.shared.dtos;

import com.google.gwt.user.client.rpc.IsSerializable;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author aabello
 */
public class FarmingSeasonDto implements Serializable, IsSerializable{
    
    private FarmSectionDto sectionId;
    private Date StartDate;
    private Date EndDate;
    private String description;

    public FarmingSeasonDto() {
    }

    public FarmingSeasonDto(FarmSectionDto sectionId, Date StartDate, 
            Date EndDate, String description) {
        this.sectionId = sectionId;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.description = description;
    }

    public FarmSectionDto getSectionId() {
        return sectionId;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public String getDescription() {
        return description;
    }

    public void setSectionId(FarmSectionDto sectionId) {
        this.sectionId = sectionId;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.sectionId != null ? this.sectionId.hashCode() : 0);
        hash = 67 * hash + (this.StartDate != null ? this.StartDate.hashCode() : 0);
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
        final FarmingSeasonDto other = (FarmingSeasonDto) obj;
        if ((this.sectionId == null) ? (other.sectionId != null) : !this.sectionId.equals(other.sectionId)) {
            return false;
        }
        if (this.StartDate != other.StartDate && (this.StartDate == null || !this.StartDate.equals(other.StartDate))) {
            return false;
        }
        return true;
    }
    
    
    
}
