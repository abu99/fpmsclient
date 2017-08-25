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
public class FarmInfoDto implements Serializable, IsSerializable{
    
    private String farmId;
    private String farmName;
    private String address;
    private String city;
    private String farmState;
    private String phoneNumber;
    private String email;
    private String website;

    public FarmInfoDto(String farmId) {
        this.farmId = farmId;
    }

    public FarmInfoDto() {
        
    }

    public String getFarmId() {
        return farmId;
    }

    public void setFarmId(String farmId) {
        this.farmId = farmId;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFarmState() {
        return farmState;
    }

    public void setFarmState(String farmState) {
        this.farmState = farmState;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.farmId != null ? this.farmId.hashCode() : 0);
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
        final FarmInfoDto other = (FarmInfoDto) obj;
        if ((this.farmId == null) ? (other.farmId != null) : !this.farmId.equals(other.farmId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return farmName;
    }
    
    
    
    
}
