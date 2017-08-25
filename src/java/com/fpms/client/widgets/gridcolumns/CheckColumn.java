package com.fpms.client.widgets.gridcolumns;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.cell.client.SelectionCell;
import com.google.gwt.user.cellview.client.Column;

/**
 * A column that displays its contents with a {@link SelectionCell}.
 *
 * @param <T> the row type
 */
public abstract class CheckColumn<T> extends Column<T, Boolean> {

  /**
   * Construct a new CheckBoxColumn.
   */
  public CheckColumn(boolean isSelected) { 
	  super(new CheckboxCell(isSelected));
  }
  
  public CheckColumn() {
	  this(false);
  }
}