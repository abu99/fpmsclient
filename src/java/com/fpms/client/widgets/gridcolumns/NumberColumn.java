package com.fpms.client.widgets.gridcolumns;

import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.user.cellview.client.Column;

/**
 * A column that displays its contents with a {@link NumberCell}
 *
 * @param <T> the row type
 *
 * @author faizbash
 */
public abstract class NumberColumn<T> extends Column<T, Number> {

  /**
   * Construct a new DateColumn.
   */
  public NumberColumn() {
    super(new NumberCell());
  }
}