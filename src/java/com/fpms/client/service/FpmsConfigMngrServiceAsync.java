/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.service;

import com.fpms.shared.dtos.ExpenseTypeDto;
import com.fpms.shared.dtos.FarmInfoDto;
import com.fpms.shared.dtos.FarmSectionDto;
import com.fpms.shared.dtos.FarmingSeasonDto;
import com.fpms.shared.dtos.ProductOtherUnitsDto;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aabello
 */
public interface FpmsConfigMngrServiceAsync {

    public void addSection(FarmSectionDto sectionDto, AsyncCallback<FarmSectionDto> asyncCallback);
    
    public void updateSection(FarmSectionDto sectionDto, AsyncCallback<FarmSectionDto> asyncCallback);
    
    public void getSection(String sectionId, AsyncCallback<FarmSectionDto> asyncCallback);
    
    public void getSections(AsyncCallback<List<FarmSectionDto>> asyncCallback);
    
    public void getSeasons(AsyncCallback<List<FarmingSeasonDto>> asyncCallback);
    
    public void addExpenseType(ExpenseTypeDto expenseTypeDto, AsyncCallback<ExpenseTypeDto> asyncCallback);
    
    public void updateExpenseType(ExpenseTypeDto expenseTypeDto, AsyncCallback<ExpenseTypeDto> asyncCallback);
    
    public void getExpenseType(String typeId, AsyncCallback<ExpenseTypeDto> asyncCallback);
    
    public void getExpenseTypes(AsyncCallback<List<ExpenseTypeDto>> asyncCallback);
    
    public void addOtherUnits(ProductOtherUnitsDto otherUnitsDto, AsyncCallback<ProductOtherUnitsDto> asyncCallback);
    
    public void updateOtherUnits(ProductOtherUnitsDto otherUnitsDto, AsyncCallback<ProductOtherUnitsDto> asyncCallback);
    
    public void getOtherUnits(AsyncCallback<List<ProductOtherUnitsDto>> asyncCallback);

    public void deleteSections(String sectionId, AsyncCallback<Void> asyncCallback);

    public void deleteExpenseType(String typeId, AsyncCallback<Void> asyncCallback);

    public void addSeason(FarmingSeasonDto season, AsyncCallback<FarmingSeasonDto> asyncCallback);

    public void updateSeason(FarmingSeasonDto season, AsyncCallback<FarmingSeasonDto> asyncCallback);

    public void deleteOtherUnits(String productId, String sectionId, String unitName, AsyncCallback<Void> asyncCallback);

    public void getOtherUnit(String productId, String sectionId, String unitName, AsyncCallback<ProductOtherUnitsDto> asyncCallback);

    public void deleteSeason(String seasonId, Date startDate, AsyncCallback<Void> asyncCallback);

    public void getSeason(String seasonId, Date startDate, AsyncCallback<FarmingSeasonDto> asyncCallback);

    public void addFarmInfo(FarmInfoDto farmInfo, AsyncCallback<FarmInfoDto> asyncCallback);

    public void updateInfo(FarmInfoDto farmInfo, AsyncCallback<FarmInfoDto> asyncCallback);

    public void deleteInfo(String farmId, AsyncCallback<Void> asyncCallback);

    public void getFarmInfo(String farmId, AsyncCallback<FarmInfoDto> asyncCallback);

    public void getFarmInfos(AsyncCallback<List<FarmInfoDto>> asyncCallback);

}
