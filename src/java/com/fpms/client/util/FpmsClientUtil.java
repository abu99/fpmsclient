/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.util;

import com.google.gwt.i18n.shared.DateTimeFormat;
import com.google.gwt.user.client.Window;
import java.util.Date;

/**
 *
 * @author aabello
 */
public class FpmsClientUtil {
    
    public static String getShortDate(Date date) {
        return date.getDate() + "/" + (date.getMonth()+1) + "/" + (date.getYear() 
                + 1900);
    }
    
    public static Date getShortDate(String date) {
        DateTimeFormat df = DateTimeFormat.getFormat("dd-MM-yyyy");
        Date d = df.parse(date);
        Window.alert(d.toString());
        return d;
    }
    
}
