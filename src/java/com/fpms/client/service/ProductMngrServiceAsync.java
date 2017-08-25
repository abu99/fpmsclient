/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.client.service;

import com.fpms.shared.dtos.ProductDto;
import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.List;

/**
 *
 * @author aabello
 */
public interface ProductMngrServiceAsync {

    public void addProduct(ProductDto productDto, AsyncCallback<ProductDto> asyncCallback);

    public void updateProduct(ProductDto productDto, AsyncCallback<ProductDto> asyncCallback);

    public void deleteProduct(String productId, AsyncCallback<Void> asyncCallback);

    public void getProduct(String productId, AsyncCallback<ProductDto> asyncCallback);

    public void getProducts(AsyncCallback<List<ProductDto>> asyncCallback);
}
