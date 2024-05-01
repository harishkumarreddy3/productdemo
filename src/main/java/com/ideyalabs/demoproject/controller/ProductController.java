package com.ideyalabs.demoproject.controller;
import com.ideyalabs.demoproject.dto.ProductDto;
import com.ideyalabs.demoproject.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product-api/v1")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping(value = "/products/{productId}")
    public ProductDto getProductById(@PathVariable int productId){
       return productService.getProductById(productId);
    }
    @GetMapping(value = "/products")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }
    @PostMapping(value = "/products")
    public ProductDto createProduct(@Valid @RequestBody ProductDto productDto){
        return productService.createProduct(productDto);
    }
    @PutMapping(value = "/products/{productId}")
    public ProductDto updateProduct(@PathVariable int productId,@RequestBody ProductDto productDto) {
       return productService.updateProduct(productId,productDto);
    }
    @DeleteMapping(value = "/products/{productId}")
    public String deleteProductById(@PathVariable int productId){
       return productService.deleteProductById(productId);
    }
}
