package com.ideyalabs.demoproject.service;

import com.ideyalabs.demoproject.dto.ProductDto;
import com.ideyalabs.demoproject.dto.ProductDto2;

import java.util.List;

public interface ProductService {

    ProductDto getProductById(int productId);
    List<ProductDto> getAllProducts();
    ProductDto2 createProduct(ProductDto2 productDto2);
    ProductDto updateProduct(int productId, ProductDto productDto);
    String deleteProductById(int productId);
}
