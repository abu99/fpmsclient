/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.exceptions;

import com.fpms.shared.types.ExceptionCode;
import com.google.gwt.user.client.rpc.IsSerializable;

/**
 *
 * @author aabello
 */
public class FpmsClientException extends Exception implements IsSerializable {
    private ExceptionCode errorCode;

    public FpmsClientException() {}
    
    public FpmsClientException(String msg) {
        super(msg);
    }

    public FpmsClientException(ExceptionCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ExceptionCode getErrorCode() {
        return errorCode;
    }
    
}
