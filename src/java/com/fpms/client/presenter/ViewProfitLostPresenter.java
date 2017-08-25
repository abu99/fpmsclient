/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.presenter;

import com.fpms.client.service.ProfitMngrService;
import com.fpms.client.view.CenterPageLabel;
import com.fpms.client.view.GridControlView;
import com.fpms.client.widgets.CustomListBox;
import com.fpms.client.widgets.InformationPanel;
import com.fpms.client.widgets.LoadingWidget;
import com.fpms.client.widgets.NairaFormat;
import com.fpms.shared.dtos.FarmingSeasonDto;
import com.fpms.shared.dtos.ProfitDto;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import java.util.List;

/**
 *
 * @author kip
 */
public class ViewProfitLostPresenter implements Presenter {
    private Display display;
    private SimpleEventBus eventBus;

    public ViewProfitLostPresenter(Display display, SimpleEventBus eventBus) {
        this.display = display;
        this.eventBus = eventBus;
        CenterPageLabel.get().setLabel("Profit and loss Analysis");
        display.getGrid().hideButtons();
        display.getGrid().showAddButton();
        display.getGrid().setAddButtonTitle("Print Report");
        fetchData();
        bind();
    }
    private void bind() {
        display.getGrid().getAddButton().addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                Window.open(GWT.getHostPageBaseURL() + "ProfitServlet", "_blank", null);
            }
        });
    }
    private void fetchData() {
        LoadingWidget.INSTANCE.show();
        ProfitMngrService.Util.getInstance().getProfit(
                new AsyncCallback<List<ProfitDto>>() {

            @Override
            public void onFailure(Throwable thrwbl) {
                LoadingWidget.INSTANCE.hide();
                Window.alert("An Error occured");
            }
            @Override
            public void onSuccess(List<ProfitDto> t) {
                LoadingWidget.INSTANCE.hide();
                display.getGrid().getGrid().setData(t);
                if (t.isEmpty()) {
                    return;
                }
                
                display.getSummaryPanel().setBoldInfo("Total Income: ", 0, 0);
                display.getSummaryPanel().setBoldInfo(NairaFormat.format(
                        t.get(0).getTotalIncome()), 0, 1);
                display.getSummaryPanel().setBoldInfo("Total Expenses: ", 1, 0);
                display.getSummaryPanel().setBoldInfo(
                        NairaFormat.format(t.get(0).getTotalExpense()), 1, 1);
                
                if (t.get(0).getTotalExpense() > t.get(0).getTotalIncome()) {
                    display.getSummaryPanel().setBoldInfo("Total Loss: ", 2, 0);
                    display.getSummaryPanel().setBoldInfo(" " 
                            +NairaFormat.format
                            (t.get(0).getTotalExpense() - t.get(0).getTotalIncome()), 2, 1);
                } else {
                    display.getSummaryPanel().setBoldInfo("Total Profit: ", 2, 0);
                    display.getSummaryPanel().setBoldInfo(" " 
                            +NairaFormat.format(t.get(0).getTotalIncome()- t.get(0).getTotalExpense()), 2, 1);
                }
            }
        });
    }
    public interface Display {
        Widget asWidget();
        GridControlView<ProfitDto> getGrid();
        InformationPanel getSummaryPanel();
    }
    @Override
    public void go(HasWidgets container) {
        container.clear();
        container.add(display.asWidget());
    }
    
}
