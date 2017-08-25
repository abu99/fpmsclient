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
public class StockDto implements Serializable, IsSerializable{
    
    private ProductDto productId;
    private FarmSectionDto sectionId;
    private int quantity;
    private double amount;
    private String stockType;
    private Date createdDate;
    private String description;

    public StockDto() {
    }

    public StockDto(ProductDto productId, FarmSectionDto sectionId, int quantity, double amount, String stockType, Date createdDate, String description) {
        this.productId = productId;
        this.sectionId = sectionId;
        this.quantity = quantity;
        this.amount = amount;
        this.stockType = stockType;
        this.createdDate = createdDate;
        this.description = description;
    }

    public ProductDto getProductId() {
        return productId;
    }

    public void setProductId(ProductDto productId) {
        this.productId = productId;
    }

    public FarmSectionDto getSectionId() {
        return sectionId;
    }

    public void setSectionId(FarmSectionDto sectionId) {
        this.sectionId = sectionId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.productId != null ? this.productId.hashCode() : 0);
        hash = 59 * hash + (this.sectionId != null ? this.sectionId.hashCode() : 0);
        hash = 59 * hash + (this.createdDate != null ? this.createdDate.hashCode() : 0);
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
        final StockDto other = (StockDto) obj;
        if ((this.productId == null) ? (other.productId != null) : !this.productId.equals(other.productId)) {
            return false;
        }
        if ((this.sectionId == null) ? (other.sectionId != null) : !this.sectionId.equals(other.sectionId)) {
            return false;
        }
        if (this.createdDate != other.createdDate && (this.createdDate == null || !this.createdDate.equals(other.createdDate))) {
            return false;
        }
        return true;
    }
    
    
    
}
