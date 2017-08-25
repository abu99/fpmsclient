package com.fpms.client;

import com.fpms.client.presenter.ManageExpenseTypePresenter;
import com.fpms.client.presenter.ManageExpensesPresenter;
import com.fpms.client.presenter.ManageFarmInfoPresenter;
import com.fpms.client.presenter.ManageProductOtherUnitsPresenter;
import com.fpms.client.presenter.ManageProductPresenter;
import com.fpms.client.presenter.ManageSeasonPresenter;
import com.fpms.client.presenter.ManageSectionPresenter;
import com.fpms.client.presenter.ManageStockPresenter;
import com.fpms.client.presenter.Presenter;
import com.fpms.client.presenter.ViewProfitLostPresenter;
import com.fpms.client.view.FarmInfoView;
import com.fpms.client.view.ManageExpenseTypeView;
import com.fpms.client.view.ManageExpensesView;
import com.fpms.client.view.ManageProductOtherUnitsView;
import com.fpms.client.view.ManageProductView;
import com.fpms.client.view.ManageSeasonView;
import com.fpms.client.view.ManageSectionView;
import com.fpms.client.view.ManageStockView;
import com.fpms.client.view.ViewProfitLossView;
import com.fpms.event.ManageExpenseTypeEvent;
import com.fpms.event.ManageExpenseTypeEventHandler;
import com.fpms.event.ManageExpensesEvent;
import com.fpms.event.ManageExpensesEventHandler;
import com.fpms.event.ManageFarmInfoEvent;
import com.fpms.event.ManageFarmInfoEventHandler;
import com.fpms.event.ManageProductEvent;
import com.fpms.event.ManageProductEventHandler;
import com.fpms.event.ManageProductOtherUnitsEvent;
import com.fpms.event.ManageProductOtherUnitsEventHandler;
import com.fpms.event.ManageSeasonEvent;
import com.fpms.event.ManageSeasonEventHandler;
import com.fpms.event.ManageSectionEvent;
import com.fpms.event.ManageSectionEventHandler;
import com.fpms.event.ManageStockEvent;
import com.fpms.event.ManageStockEventHandler;
import com.fpms.event.ProfitEvent;
import com.fpms.event.ProfitEventHandler;
import com.fpms.shared.types.PrivilegeTypeDto;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements Presenter, ValueChangeHandler<String> {

    private final SimpleEventBus eventBus;
    private HasWidgets container;

    public AppController(SimpleEventBus eventBus) {
        this.eventBus = eventBus;

        bind();
    }

    private String getTokenPrefix() {
        return HistoryTokenManager.getTokenPrefix(AppController.class);
    }

    private void bind() {
        History.addValueChangeHandler(this);

        eventBus.addHandler(ManageSeasonEvent.Type, new ManageSeasonEventHandler() {
            @Override
            public void onManageSeason(ManageSeasonEvent event) {
                History.newItem(getTokenPrefix()+PrivilegeTypeDto.MANAGE_SEASON.name().hashCode());
            }
        });

        eventBus.addHandler(ManageSectionEvent.Type, new ManageSectionEventHandler() {
            @Override
            public void onManageSection(ManageSectionEvent event) {
                History.newItem(getTokenPrefix()+PrivilegeTypeDto.MANAGE_SECTION.name().hashCode());
            }
        });
        
        eventBus.addHandler(ManageProductEvent.Type, new ManageProductEventHandler() {

            @Override
            public void onManageProduct(ManageProductEvent event) {
                History.newItem(getTokenPrefix()+ PrivilegeTypeDto.MANAGE_PRODUCT.name().hashCode());
            }
        });
        
        eventBus.addHandler(ManageProductOtherUnitsEvent.Type, new ManageProductOtherUnitsEventHandler() {

            @Override
            public void onManageProduct(ManageProductOtherUnitsEvent event) {
                History.newItem(getTokenPrefix()+ PrivilegeTypeDto.MANAGE_PRODUCT_OTHER_UNITS.name().hashCode());
            }
        });
        
        eventBus.addHandler(ManageExpenseTypeEvent.Type, new ManageExpenseTypeEventHandler() {

            @Override
            public void onManageExpense(ManageExpenseTypeEvent event) {
                History.newItem(getTokenPrefix()+ PrivilegeTypeDto.MANAGE_EXPENSE_TYPE.name().hashCode());
            }
        });
        
        eventBus.addHandler(ManageExpensesEvent.Type, new ManageExpensesEventHandler() {

            @Override
            public void onManageExpense(ManageExpensesEvent event) {
                History.newItem(getTokenPrefix()+ PrivilegeTypeDto.MANAGE_EXPENSE.name().hashCode());
            }
        });
        
        eventBus.addHandler(ManageStockEvent.Type, new ManageStockEventHandler() {

            @Override
            public void onManageStock(ManageStockEvent event) {
                History.newItem(getTokenPrefix()+ PrivilegeTypeDto.MANAGE_STOCK.name().hashCode());
            }
        });
        
        eventBus.addHandler(ManageFarmInfoEvent.Type, new ManageFarmInfoEventHandler() {

            @Override
            public void onManageFarmInfo(ManageFarmInfoEvent event) {
                History.newItem(getTokenPrefix()+ 
                        PrivilegeTypeDto.MANAGE_FARM_INFO.name().hashCode());
            }
        });
        eventBus.addHandler(ManageFarmInfoEvent.Type, new ManageFarmInfoEventHandler() {

            @Override
            public void onManageFarmInfo(ManageFarmInfoEvent event) {
                History.newItem(getTokenPrefix()+ 
                        PrivilegeTypeDto.MANAGE_FARM_INFO.name().hashCode());
            }
        });
        eventBus.addHandler(ProfitEvent.Type, new ProfitEventHandler() {

            @Override
            public void onViewProfit(ProfitEvent event) {
                History.newItem(getTokenPrefix()+ 
                        PrivilegeTypeDto.VIEW_PROFIT_AND_LOSS.name().hashCode());
            
            }
        });
        
    }

    @Override
    public void go(final HasWidgets container) {
        this.container = container;

        if ("".equals(History.getToken())) {
            History.newItem(getTokenPrefix()+ PrivilegeTypeDto.MANAGE_SECTION.name().hashCode());
        } else {
            History.fireCurrentHistoryState();
        }
    }

    @Override
    public void onValueChange(final ValueChangeEvent<String> event) {
        navigate(event);
    }

    private void navigate(ValueChangeEvent<String> event) {
        String token = event.getValue();

        if (token != null) {
            Presenter presenter = null;
            if (token.equals(getTokenPrefix()+PrivilegeTypeDto.MANAGE_SECTION.name().hashCode())) {
                presenter = new ManageSectionPresenter(new ManageSectionView());
            } else if (token.equals(getTokenPrefix()+PrivilegeTypeDto.MANAGE_SEASON.name().hashCode())) {
                presenter = new ManageSeasonPresenter(new ManageSeasonView());
            } else if (token.equals(getTokenPrefix()+PrivilegeTypeDto.MANAGE_PRODUCT.name().hashCode())){
                presenter = new ManageProductPresenter(new ManageProductView());
            } else if (token.equals(getTokenPrefix()+PrivilegeTypeDto.MANAGE_PRODUCT_OTHER_UNITS.name().hashCode())){
                presenter = new ManageProductOtherUnitsPresenter(new ManageProductOtherUnitsView());
            } else if (token.equals(getTokenPrefix()+PrivilegeTypeDto.MANAGE_EXPENSE_TYPE.name().hashCode())){
                presenter = new ManageExpenseTypePresenter(new ManageExpenseTypeView());
            } else if (token.equals(getTokenPrefix()+PrivilegeTypeDto.MANAGE_EXPENSE.name().hashCode())){
                presenter = new ManageExpensesPresenter(new ManageExpensesView());
            } else if (token.equals(getTokenPrefix()+PrivilegeTypeDto.MANAGE_STOCK.name().hashCode())){
                presenter = new ManageStockPresenter(new ManageStockView());
            } else if (token.equals(getTokenPrefix()+PrivilegeTypeDto.MANAGE_FARM_INFO.name().hashCode())){
                presenter = new ManageFarmInfoPresenter(eventBus, new FarmInfoView());
            }
            else if (token.equals(getTokenPrefix()+PrivilegeTypeDto.VIEW_PROFIT_AND_LOSS.name().hashCode())){
                presenter = new ViewProfitLostPresenter(new ViewProfitLossView(), eventBus);
            }
             else if (token.equals(getTokenPrefix()+
                     PrivilegeTypeDto.MANAGE_FARM_INFO.name().hashCode())){
                presenter = 
                        new ManageFarmInfoPresenter(eventBus, new FarmInfoView());
            }
            if (presenter != null) {
                presenter.go(container);
            }
        }
    }
}
