/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.shared.types;

import com.google.gwt.user.client.rpc.IsSerializable;
import java.io.Serializable;

/**
 *
 * @author aim
 */
public enum ExceptionCode implements Serializable, IsSerializable {
    SCORE_VERIFIED_EXCEPTION,
    INVALID_DATA_EXCEPTION,   
    GENERAL_EXCEPTION,
    ACCESS_DENIED_EXCEPTION,   
    SHOW_ERROR_MESSAGE
}
