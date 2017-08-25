/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpms.client.widgets;

import com.google.gwt.user.client.ui.ListBox;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A custom drop down list that can hold any object items.
 *
 * @author faizbash
 */
public class CustomListBox<T> extends ListBox implements Iterable<T>{
    private List<T> items;

    public CustomListBox() {
        super();
        items = new ArrayList<T>();
    }

    public CustomListBox(boolean isMultipleSelect) {
        super(isMultipleSelect);
        items = new ArrayList<T>();
    }

    public CustomListBox(List<T> items) {
        this(items, false);
    }

    public CustomListBox(List<T> items, boolean isMultipleSelect) {
        super(isMultipleSelect);        
        this.items = new ArrayList<T>();
        //this.items = items;

        //add items
        //for (T item: items) {
        //    addListItem(item.toString());
        //}
        addItems(items);
    }

    public void addListItem(T item) {
        this.items.add(item);
        super.addItem(item.toString());
    }

    @Override
    public void removeItem(int index) {
        items.remove(index);
        super.removeItem(index);
    }

    public void removeItem(T item) {
        int index = items.indexOf(item);
        removeItem(index);
    }
    
    public void removeAllItems() {
        while (items.size() > 0) {
            items.remove(0);
            super.removeItem(0);
        }
    }

    public T getItem(int index) {
        return items.get(index);
    }

    public T getSelectedItem() {
        return items.get(getSelectedIndex());
    }

    public void setSelectedItem(T item) {
        //if (!items.contains(item)) //not existing
        //    return;

        setSelectedIndex(items.indexOf(item));
    }

    public void addItems(List<T> items) {
        for (T item: items) {
            addListItem(item);
        }
    }

    public boolean contains(T item) {
        return items.contains(item);
    }
    
    public void setItems(List<T> items) {
        removeAllItems();   //remove all
        
        for (T item: items) {
            addListItem(item);
        }
    }

    @Override
    public void clear() {
        removeAllItems();
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = items.iterator();
        return iterator;
    }

}
