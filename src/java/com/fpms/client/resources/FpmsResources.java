/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 *
 * @author aabello
 */
public interface FpmsResources extends ClientBundle{
    
    public static final FpmsResources INSTANCE = GWT.create(FpmsResources.class);

	@Source("loading.gif")
	public ImageResource loading();
    
}
