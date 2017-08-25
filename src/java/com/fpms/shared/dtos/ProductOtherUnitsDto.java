/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.shared.dtos;

import com.fpms.persistence.entities.FarmSection;
import com.fpms.persistence.entities.Product;
import com.google.gwt.user.client.rpc.IsSerializable;
import java.io.Serializable;

/**
 *
 * @author aabello
 */
public class ProductOtherUnitsDto implements Serializable, IsSerializable{
    
    private ProductDto productId;
    private FarmSectionDto sectionId;
    private String unitName;
    private int count;

    public ProductOtherUnitsDto() {
    }

    public ProductOtherUnitsDto(ProductDto productId, FarmSectionDto sectionId, 
            String unitName, int count) {
        this.productId = productId;
        this.sectionId = sectionId;
        this.unitName = unitName;
        this.count = count;
    }

    public ProductDto getProductId() {
        return productId;
    }

    public FarmSectionDto getSectionId() {
        return sectionId;
    }

    public String getUnitName() {
        return unitName;
    }

    public int getCount() {
        return count;
    }

    public void setProductId(ProductDto productId) {
        this.productId = productId;
    }

    public void setSectionId(FarmSectionDto sectionId) {
        this.sectionId = sectionId;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.productId != null ? this.productId.hashCode() : 0);
        hash = 97 * hash + (this.sectionId != null ? this.sectionId.hashCode() : 0);
        hash = 97 * hash + (this.unitName != null ? this.unitName.hashCode() : 0);
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
        final ProductOtherUnitsDto other = (ProductOtherUnitsDto) obj;
        if ((this.productId == null) ? (other.productId != null) : !this.productId.equals(other.productId)) {
            return false;
        }
        if ((this.sectionId == null) ? (other.sectionId != null) : !this.sectionId.equals(other.sectionId)) {
            return false;
        }
        if ((this.unitName == null) ? (other.unitName != null) : !this.unitName.equals(other.unitName)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return unitName;
    }
    
}
