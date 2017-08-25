/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.service;

import com.fpms.shared.dtos.ProductDto;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.List;

/**
 *
 * @author aabello
 */
@RemoteServiceRelativePath("service/productmngrservice")
public interface ProductMngrService extends RemoteService {

    ProductDto addProduct(ProductDto productDto);
    ProductDto updateProduct(ProductDto productDto);
    void deleteProduct(String productId);
    ProductDto getProduct(String productId);
    List<ProductDto> getProducts();
    
    /**
        * Utility class for simplifying access to the instance of async service.
        */
    public static class Util {
        private static ProductMngrServiceAsync instance;
        public static ProductMngrServiceAsync getInstance(){
                if (instance == null) {
                        instance = GWT.create(ProductMngrService.class);
                }
                return instance;
        }
    }
}
