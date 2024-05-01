package com.ideyalabs.demoproject.service;

import com.ideyalabs.demoproject.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto getProductById(int productId);
    List<ProductDto> getAllProducts();
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(int productId, ProductDto productDto);
    String deleteProductById(int productId);
}
