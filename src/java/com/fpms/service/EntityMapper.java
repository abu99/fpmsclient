/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.service;

import com.fpms.persistence.entities.ExpenseType;
import com.fpms.persistence.entities.Expenses;
import com.fpms.persistence.entities.FarmInfo;
import com.fpms.persistence.entities.FarmSection;
import com.fpms.persistence.entities.FarmingSeason;
import com.fpms.persistence.entities.FarmingSeasonPK;
import com.fpms.persistence.entities.Product;
import com.fpms.persistence.entities.ProductOtherUnits;
import com.fpms.persistence.entities.ProductOtherUnitsPK;
import com.fpms.persistence.entities.Stock;
import com.fpms.persistence.entities.StockPK;
import com.fpms.persistence.entities.User;
import com.fpms.shared.dtos.ExpenseDto;
import com.fpms.shared.dtos.ExpenseTypeDto;
import com.fpms.shared.dtos.FarmInfoDto;
import com.fpms.shared.dtos.FarmSectionDto;
import com.fpms.shared.dtos.FarmingSeasonDto;
import com.fpms.shared.dtos.ProductDto;
import com.fpms.shared.dtos.ProductOtherUnitsDto;
import com.fpms.shared.dtos.StockDto;
import com.fpms.shared.dtos.UserDto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aabello
 */
public class EntityMapper {
    
    public static FarmSectionDto mapToFarmSectionDto(FarmSection section){
    
        if(section == null){
            return null;
        }
        
        FarmSectionDto sectionDto = new FarmSectionDto(section.getSectionId(), 
                section.getSectionName(), section.getDescription());
        
        return sectionDto;
    }
    
    public static FarmSection mapToFarmSection(FarmSectionDto sectionDto){
        
        if(sectionDto == null){
            return null;
        }
        
        FarmSection section = new FarmSection(sectionDto.getSectionId(), 
                sectionDto.getSectionName());
        section.setDescription(sectionDto.getDescription());
        
        return section;
    
    }
    
    public static FarmingSeasonDto mapToFarmingSeasonDto(FarmingSeason season){
        
        if(season == null){
            return null;
        }
        
        FarmingSeasonDto seasonDto = 
                new FarmingSeasonDto(mapToFarmSectionDto(season.getFarmSection()),
                season.getFarmingSeasonPK().getStartDate(), season.getEndDate(),
                season.getDescription());
        
        return seasonDto;
        
    }
    
    public static FarmingSeason mapToFarmingSeason(FarmingSeasonDto seasonDto){
    
        if(seasonDto == null){
            return null;
        }
        FarmingSeasonPK seasonPK = new FarmingSeasonPK(seasonDto.getSectionId().getSectionId(),
                seasonDto.getStartDate());
        
        FarmingSeason season = new FarmingSeason(seasonPK, seasonDto.getEndDate());
        
        return season;
    }
    
    public static ProductDto mapToProductDto(Product product){
        
        if(product == null){
            return null;
        }
        
        ProductDto productDto = new ProductDto(product.getProductId(), 
                mapToFarmSectionDto(product.getSectionId()), product.getProductName(), 
                product.getStandardUnit());
                
       return productDto;  
    }
    
    public static Product mapToProduct(ProductDto productDto){
        if(productDto == null){
            return null;
        }
        
        Product product = new Product(productDto.getProductId(),
                productDto.getProductName(), 
                productDto.getStandardUnit());
        product.setSectionId(mapToFarmSection(productDto.getSectionId()));
        
        return product;
    }
    
    public static ExpenseTypeDto mapToExpenseTypeDto(ExpenseType expenseType){
        
        if(expenseType == null){
            return null;
        }
        
        ExpenseTypeDto expenseTypeDto = new ExpenseTypeDto(expenseType.getTypeId(),
                expenseType.getTypeName());
        
        return expenseTypeDto;
    }
    
    public static ExpenseType mapToExpenseType(ExpenseTypeDto expenseTypeDto){
    
        if(expenseTypeDto == null){
            return null;
        }
        
        ExpenseType expenseType = new ExpenseType(expenseTypeDto.getTypeId(), 
                expenseTypeDto.getTypeName());
        
        return expenseType;
    }
    
    public static ExpenseDto mapToExpenseDto(Expenses expense){
        
        if(expense == null){
            return null;
        }
        
        ExpenseDto expenseDto = new ExpenseDto(expense.getExpensesId(), 
                mapToExpenseTypeDto(expense.getTypeId()), mapToFarmSectionDto(expense.getSectionId()), 
                expense.getAmount(), expense.getDateCreated(), 
                expense.getRemarks());
        
        return expenseDto;
    }
    public static List<ExpenseDto> mapToExpenses(List<Expenses> list) {
        List<ExpenseDto> result = new ArrayList<ExpenseDto>();
        for (Expenses exp : list) {
            result.add(mapToExpenseDto(exp));
        }
        return result;
    }
    public static List<StockDto> mapToStocks(List<Stock> list) {
        List<StockDto> stocks = new ArrayList<StockDto>();
        for (Stock stock : list) {
            stocks.add(mapToStockDto(stock));
        }
        return stocks;
    }
    public static Expenses mapToExpense(ExpenseDto expenseDto){
        
        if(expenseDto == null){
            return null;
        }
        
        Expenses expenses = new Expenses(expenseDto.getExpenseId(), 
                expenseDto.getAmount(), expenseDto.getCreatedDate(), 
                expenseDto.getDescription());
        expenses.setSectionId(mapToFarmSection(expenseDto.getSectionId()));
        expenses.setTypeId(mapToExpenseType(expenseDto.getExpenseTypeId()));
        
        return expenses;
    }
    
    public static ProductOtherUnitsDto mapToProductOtherUnitsDto
            (ProductOtherUnits productOtherUnits){
        if (productOtherUnits == null){
            return null;
        }
        
        ProductOtherUnitsDto productOtherUnitsDto = new ProductOtherUnitsDto(
                mapToProductDto(productOtherUnits.getProduct()),
                mapToFarmSectionDto(productOtherUnits.getFarmSection()), 
                productOtherUnits.getProductOtherUnitsPK().getUnitName(), 
                productOtherUnits.getCount());
        
        return productOtherUnitsDto;
    }
    
    public static ProductOtherUnits mapToProductOtherUnits
            (ProductOtherUnitsDto productOtherUnitsDto){
        if(productOtherUnitsDto == null){
            return null;
        }
        
        ProductOtherUnitsPK PoUpk = new 
                ProductOtherUnitsPK(productOtherUnitsDto.getProductId().getProductId(),
                productOtherUnitsDto.getSectionId().getSectionId(), 
                productOtherUnitsDto.getUnitName());
        
        ProductOtherUnits productOtherUnits = new ProductOtherUnits(PoUpk,
                productOtherUnitsDto.getCount());
        
        return productOtherUnits;
    }
    
    public static StockDto mapToStockDto(Stock stock){
            
        if(stock == null){
            
            return null;
        }
        
        StockDto stockDto = new StockDto(mapToProductDto(stock.getProduct()), 
                mapToFarmSectionDto(stock.getFarmSection()), stock.getQuatity(),
                stock.getAmount(), stock.getStockType(),
                stock.getStockPK().getDateCreated(), stock.getRemarks());
        
        return stockDto;
    }
    
    public static Stock mapToStock(StockDto stockDto){
        
        if(stockDto == null){
            return null;
        }
        StockPK stockPK = new StockPK(stockDto.getProductId().getProductId(), 
                stockDto.getSectionId().getSectionId(), stockDto.getCreatedDate());
        Stock stock = new Stock(stockPK, stockDto.getQuantity(), stockDto.getAmount(),
                stockDto.getStockType(), stockDto.getDescription());
        
        return stock;
    }
    
    public static UserDto mapToUserDto(User user){
        
        if(user == null){
            return null;
        }
        
        UserDto userDto = new UserDto(user.getUserId(), user.getFullName(), 
                user.getPassword(), user.getRole());
        
        return userDto;
    }
    
    public static User mapToUser(UserDto userDto){
        if(userDto == null){
            return null;
        }
        
        User user = new User(userDto.getUserId(), userDto.getName(), 
                userDto.getPassword(), userDto.getRole());
        
        return user;
    }
    
    public static FarmInfoDto mapToFarmInfoDto(FarmInfo farmInfo){
        
        if(farmInfo == null){
            return null;
        }
        
        FarmInfoDto farmInfoDto = new FarmInfoDto(farmInfo.getFarmId());
        
        return farmInfoDto;
    }
    
    public static FarmInfo mapToFarmInfo(FarmInfoDto farmInfoDto){
        if(farmInfoDto == null){
            return null;
        }
        
        FarmInfo farmInfo = new FarmInfo(farmInfoDto.getFarmId());
        
        return farmInfo;
    }
    
}

