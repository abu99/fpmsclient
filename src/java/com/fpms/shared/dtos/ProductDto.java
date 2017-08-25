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
public class ProductDto implements Serializable, IsSerializable{

    private String productId;
    private FarmSectionDto sectionId;
    private String productName;
    private String standardUnit;
    private String description;

    public ProductDto() {
    }

    public ProductDto(String productId, FarmSectionDto sectionId, String productName, String standardUnit) {
        this.productId = productId;
        this.sectionId = sectionId;
        this.productName = productName;
        this.standardUnit = standardUnit;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public FarmSectionDto getSectionId() {
        return sectionId;
    }

    public void setSectionId(FarmSectionDto sectionId) {
        this.sectionId = sectionId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStandardUnit() {
        return standardUnit;
    }

    public void setStandardUnit(String standardUnit) {
        this.standardUnit = standardUnit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public static ProductDto getEmptySection() {
        return new ProductDto(null, null, "-- Select Product --", null);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.productId != null ? this.productId.hashCode() : 0);
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
        final ProductDto other = (ProductDto) obj;
        if ((this.productId == null) ? (other.productId != null) : !this.productId.equals(other.productId)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return productName;
    }
    
}
