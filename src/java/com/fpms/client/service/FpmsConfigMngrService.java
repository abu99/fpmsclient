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
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aabello
 */
@RemoteServiceRelativePath("service/fpmsconfigmngrservice")
public interface FpmsConfigMngrService extends RemoteService {

    FarmSectionDto addSection(FarmSectionDto section);
    FarmSectionDto updateSection(FarmSectionDto section);
    void deleteSections(String sectionId);
    FarmSectionDto getSection(String sectionId);
    List<FarmSectionDto> getSections();
    
    FarmingSeasonDto addSeason(FarmingSeasonDto season);
    FarmingSeasonDto updateSeason(FarmingSeasonDto season);
    void deleteSeason(String seasonId, Date startDate);
    FarmingSeasonDto getSeason(String seasonId, Date startDate);
    List<FarmingSeasonDto> getSeasons();
    
    ExpenseTypeDto addExpenseType(ExpenseTypeDto expenseType);
    ExpenseTypeDto updateExpenseType(ExpenseTypeDto expenseType);
    void deleteExpenseType(String typeId);
    ExpenseTypeDto getExpenseType(String typeId);
    List<ExpenseTypeDto> getExpenseTypes();
    
    ProductOtherUnitsDto addOtherUnits(ProductOtherUnitsDto otherUnits);
    ProductOtherUnitsDto updateOtherUnits(ProductOtherUnitsDto otherUnits);
    void deleteOtherUnits(String productId, String sectionId, String unitName);
    ProductOtherUnitsDto getOtherUnit(String productId, String sectionId, String unitName);
    List<ProductOtherUnitsDto> getOtherUnits();
    
    FarmInfoDto addFarmInfo(FarmInfoDto farmInfo);
    FarmInfoDto updateInfo(FarmInfoDto farmInfo);
    void deleteInfo(String farmId);
    FarmInfoDto getFarmInfo(String farmId);
    List<FarmInfoDto> getFarmInfos();
    
    /**
        * Utility class for simplifying access to the instance of async service.
        */
    public static class Util {
        private static FpmsConfigMngrServiceAsync instance;
        public static FpmsConfigMngrServiceAsync getInstance(){
                if (instance == null) {
                        instance = GWT.create(FpmsConfigMngrService.class);
                }
                return instance;
        }
    }
}
