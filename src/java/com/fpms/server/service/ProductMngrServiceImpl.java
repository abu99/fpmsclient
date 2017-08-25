/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpms.server.service;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import com.fpms.client.service.ProductMngrService;
import com.fpms.controllers.ProductMngrLocal;
import com.fpms.persistence.entities.Product;
import com.fpms.shared.dtos.ProductDto;
import java.util.List;
import javax.ejb.EJB;
import static com.fpms.service.EntityMapper.*;
import java.util.ArrayList;

/**
 *
 * @author aabello
 */
public class ProductMngrServiceImpl extends RemoteServiceServlet implements ProductMngrService {

    @EJB
    private ProductMngrLocal productMngr;
    
    @Override
    public ProductDto addProduct(ProductDto productDto) {
        return mapToProductDto(productMngr.addProduct(mapToProduct(productDto)));
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        return mapToProductDto(productMngr.updateProduct(mapToProduct(productDto)));
    }

    @Override
    public void deleteProduct(String productId) {
        productMngr.deleteProduct(productId);
    }

    @Override
    public ProductDto getProduct(String productId) {
        return mapToProductDto(productMngr.getProduct(productId));
    }

    @Override
    public List<ProductDto> getProducts() {
        
        List<Product> product = productMngr.getProducts();
        List<ProductDto> productDto = new ArrayList<ProductDto>();
        for(Product p : product){
            
            productDto.add(mapToProductDto(p));
        }
        
        return productDto;
    }

   

    
}
