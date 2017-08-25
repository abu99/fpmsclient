/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.server.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import com.fpms.client.service.FpmsConfigMngrService;
import com.fpms.controllers.FpmsConfigMngrLocal;
import com.fpms.persistence.entities.ExpenseType;
import com.fpms.persistence.entities.FarmInfo;
import com.fpms.persistence.entities.FarmSection;
import com.fpms.persistence.entities.FarmingSeason;
import com.fpms.persistence.entities.ProductOtherUnits;
import com.fpms.shared.dtos.ExpenseTypeDto;
import com.fpms.shared.dtos.FarmSectionDto;
import com.fpms.shared.dtos.FarmingSeasonDto;
import com.fpms.shared.dtos.ProductOtherUnitsDto;
import java.util.List;
import javax.ejb.EJB;
import static com.fpms.service.EntityMapper.*;
import com.fpms.shared.dtos.FarmInfoDto;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author aabello
 */
public class FpmsConfigMngrServiceImpl extends RemoteServiceServlet 
implements FpmsConfigMngrService {

    @EJB
    private FpmsConfigMngrLocal configMngr;
    
    @Override
    public FarmSectionDto addSection(FarmSectionDto section) {
        return mapToFarmSectionDto(configMngr.addSection(mapToFarmSection(section)));
    }

    @Override
    public FarmSectionDto updateSection(FarmSectionDto section) {
        return mapToFarmSectionDto(configMngr.updateSection(mapToFarmSection(section)));
    }

    @Override
    public void deleteSections(String sectionId) {
        configMngr.deleteSection(sectionId);
    }

    @Override
    public FarmSectionDto getSection(String sectionId) {
        return mapToFarmSectionDto(configMngr.getSection(sectionId));
    }

    @Override
    public List<FarmSectionDto> getSections() {
        List<FarmSection> sections = configMngr.getSections();
        List<FarmSectionDto> sectionDto = new ArrayList<FarmSectionDto>();
        
        for(FarmSection s : sections){
        
            sectionDto.add(mapToFarmSectionDto(s));
        }
        
        return sectionDto;
    }

    @Override
    public FarmingSeasonDto addSeason(FarmingSeasonDto season) {
        return mapToFarmingSeasonDto(configMngr.addSeason(mapToFarmingSeason(season)));
    }

    @Override
    public FarmingSeasonDto updateSeason(FarmingSeasonDto season) {
        return mapToFarmingSeasonDto(configMngr.updateSeason(mapToFarmingSeason(season)));
    }

    @Override
    public void deleteSeason(String sectionId, Date date) {
        configMngr.deleteSeason(sectionId, date);
    }

    @Override
    public FarmingSeasonDto getSeason(String sectionId, Date date) {
        return mapToFarmingSeasonDto(configMngr.getSeason(sectionId, date));
    }

    @Override
    public List<FarmingSeasonDto> getSeasons() {
        List<FarmingSeason> season = configMngr.getSeasons();
        List<FarmingSeasonDto> seasonDto = new ArrayList<FarmingSeasonDto>();
        
        for(FarmingSeason s: season){
            
            seasonDto.add(mapToFarmingSeasonDto(s));
        }
        
        return seasonDto;
    }

    @Override
    public ExpenseTypeDto addExpenseType(ExpenseTypeDto expenseType) {
        return mapToExpenseTypeDto(configMngr.addExpenseType(mapToExpenseType(expenseType)));
    }

    @Override
    public ExpenseTypeDto updateExpenseType(ExpenseTypeDto expenseType) {
        return mapToExpenseTypeDto(configMngr.updateExpenseType(mapToExpenseType(expenseType)));
    }

    @Override
    public void deleteExpenseType(String typeId) {
        configMngr.deleteExpenseType(typeId);
    }

    @Override
    public ExpenseTypeDto getExpenseType(String typeId) {
        return mapToExpenseTypeDto(configMngr.getExpenseType(typeId));
    }

    @Override
    public List<ExpenseTypeDto> getExpenseTypes() {
        List<ExpenseType> expenseTypes = configMngr.getExpenseTypes();
        List<ExpenseTypeDto> expenseTypeDto = new ArrayList<ExpenseTypeDto>();
        
        for(ExpenseType e : expenseTypes){
            
            expenseTypeDto.add(mapToExpenseTypeDto(e));
         
        }
        
        return expenseTypeDto;
        
    }

    @Override
    public ProductOtherUnitsDto addOtherUnits(ProductOtherUnitsDto otherUnits) {
        return mapToProductOtherUnitsDto(configMngr.addOtherUnit(mapToProductOtherUnits(otherUnits)));
    }

    @Override
    public ProductOtherUnitsDto updateOtherUnits(ProductOtherUnitsDto otherUnits) {
        return mapToProductOtherUnitsDto(configMngr.updateOtherUnit(mapToProductOtherUnits(otherUnits)));
    }

    @Override
    public void deleteOtherUnits(String productId, String sectionId, String unitName) {
        configMngr.deleteOtherUnit(productId, sectionId, unitName);
    }

    @Override
    public ProductOtherUnitsDto getOtherUnit(String productId, String sectionId, String unitName) {
        return mapToProductOtherUnitsDto(configMngr.getOtherUnit(productId, sectionId, unitName));
    }

    @Override
    public List<ProductOtherUnitsDto> getOtherUnits() {
        
        List<ProductOtherUnits> poUs = configMngr.getOtherUnits();
        List<ProductOtherUnitsDto> PoUDto = new ArrayList<ProductOtherUnitsDto>();
        
        for(ProductOtherUnits p : poUs ){
            
            PoUDto.add(mapToProductOtherUnitsDto(p));
        }
        
        return PoUDto;
    }
    
    @Override
    public FarmInfoDto addFarmInfo(FarmInfoDto farmInfo) {
        return mapToFarmInfoDto(configMngr.addFarm(mapToFarmInfo(farmInfo)));
    }

    @Override
    public FarmInfoDto updateInfo(FarmInfoDto farmInfo) {
        return mapToFarmInfoDto(configMngr.updateFarm(mapToFarmInfo(farmInfo)));
    }

    @Override
    public void deleteInfo(String farmId) {
        configMngr.deleteFarm(farmId);
    }

    @Override
    public FarmInfoDto getFarmInfo(String farmId) {
        return mapToFarmInfoDto(configMngr.getFarm(farmId));
    }

    @Override
    public List<FarmInfoDto> getFarmInfos() {
        List<FarmInfo> farmInfos = configMngr.getFarms();
        List<FarmInfoDto> farmInfoDtos = new ArrayList<FarmInfoDto>();
        
        for(FarmInfo f : farmInfos){
            farmInfoDtos.add(mapToFarmInfoDto(f));
        }
        
        return farmInfoDtos;
    }
}
