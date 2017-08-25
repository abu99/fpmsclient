package com.fpms.client.view;

import com.fpms.client.presenter.GridDisplay;
import com.fpms.client.widgets.CustomGrid;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.HasData;

public class GridControlView<T> extends Composite implements GridDisplay<T> {
  private final Button addButton;
  private final Button deleteButton;
  private final Button updateButton;
  private final Button button4;	//extra button
  private final Button button5; //extra button
  private final Button button6; //extra button

  private CustomGrid<T> dataTable;
  private final FlexTable contentTable;

  public GridControlView(CustomGrid<T> dataTable) {
      this.dataTable = dataTable;

    DecoratorPanel contentTableDecorator = new DecoratorPanel();
    //contentTableDecorator.setWidth("100%");

    initWidget(contentTableDecorator);

    //setWidth("100%");
    //contentTableDecorator.setWidth("18em");

    contentTable = new FlexTable();
    //contentTable.setWidth("100%");
    contentTable.getCellFormatter().addStyleName(0, 0, "contacts-ListContainer");
    //contentTable.getCellFormatter().setWidth(0, 0, "100%");
    contentTable.getFlexCellFormatter().setVerticalAlignment(0, 0, DockPanel.ALIGN_TOP);
    contentTable.setStyleName("gridTable");

    // Create the menu
    //
    HorizontalPanel hPanel = new HorizontalPanel();
    hPanel.setBorderWidth(0);
    hPanel.setSpacing(0);
    hPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_LEFT);
    addButton = new Button("Add");
    hPanel.add(addButton);
    deleteButton = new Button("Delete");
    hPanel.add(deleteButton);
    updateButton = new Button("Update");
    hPanel.add(updateButton);
    button4 = new Button("Button 4");
    button4.setVisible(false); //not visible by default
    hPanel.add(button4);
    button5 = new Button("Button 5");
    button5.setVisible(false); //not visible by defaul
    hPanel.add(button5);
    button6 = new Button("Button 6");
    button6.setVisible(false); //not visible by defaul
    hPanel.add(button6);

    contentTable.getCellFormatter().addStyleName(0, 0, "contacts-ListMenu");
    contentTable.setWidget(0, 0, hPanel);

    // Create the contacts list
    //
    /*dataTable = new FlexTable();
    dataTable.setCellSpacing(0);
    dataTable.setCellPadding(0);
    dataTable.setWidth("100%");
    dataTable.addStyleName("contacts-ListRow");
    dataTable.getRowFormatter().addStyleName(0, "contacts-ListHeader");
    dataTable.getColumnFormatter().setWidth(0, "15px");*/
    
    contentTable.setWidget(1, 0, dataTable);

    contentTableDecorator.add(contentTable);
  }

    @Override
  public HasClickHandlers getAddButton() {
    return addButton;
  }

    @Override
  public HasClickHandlers getDeleteButton() {
    return deleteButton;
  }

    @Override
    public HasClickHandlers getUpdateButton() {
        return updateButton;
    }

    @Override
    public HasClickHandlers getButton4() {
	return button4;
    }

    @Override
    public HasClickHandlers getButton5() {
	return button5;
    }

    @Override
    public HasClickHandlers getButton6() {
	return button6;
    }
    
      @Override
      public CustomGrid<T> getGrid() {
	return dataTable;
      }

      @Override
      public Widget asWidget() {
	return this;
      }

      public HasData<T> getCellTable() {
	  return dataTable.getGrid();
      }

      public void setAddButtonTitle(String title) {
	  addButton.setText(title);
      }
      public void hideAddButton() {
	  addButton.setVisible(false);
      }
      public void setDeleteButtonTitle(String title) {
	  deleteButton.setText(title);
      }
      public void hideDeleteButton() {
	  deleteButton.setVisible(false);
      }
      public void setUpdateButtonTitle(String title) {
	  updateButton.setText(title);
      }
      public void hideUpdateButton() {
	  updateButton.setVisible(false);
      }

      public void setButton4Title(String title) {
	  button4.setText(title);
      }
      public void showButton4() {
	  button4.setVisible(true);
      }

      public void setButton5Title(String title) {
	  button5.setText(title);
      }
      
      public void showButton5() {
	  button5.setVisible(true);
      }

      public void setButton6Title(String title) {
	  button6.setText(title);
      }
      
      public void showButton6() {
	  button6.setVisible(true);
      }
      
      public void hideButtons() {
	  hideAddButton();
	  hideDeleteButton();
	  hideUpdateButton();
      }

    public void showAddButton() {
	addButton.setVisible(true);
    }

    public void showDeleteButton() {
	deleteButton.setVisible(true);
    }
    
    public void showUpdateButton() {
	updateButton.setVisible(true);
    }
}
