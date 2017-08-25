
package com.fpms.client.util;

import com.fpms.client.widgets.InformationPopup;

/**
 *
 * @author faizbash
 */
public class StatusMessageHandler {

    public static void showStatus(String status) {
	InformationPopup.get().showStatusMessage(status);
    }
}
