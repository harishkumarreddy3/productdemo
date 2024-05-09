package com.ideyalabs.demoproject.controller;
import com.ideyalabs.demoproject.dto.ProductDto;
import com.ideyalabs.demoproject.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/product-api/v1")
public class ProductController {
    private final ProductService productService;
    Logger logger = Logger.getLogger(this.getClass().getName());
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping(value = "/products/{productId}")
    public ProductDto getProductById(@PathVariable int productId){
        logger.info("getProductById called");
       return productService.getProductById(productId);
    }
    @GetMapping(value = "/products")
    public List<ProductDto> getAllProducts() {
        logger.info("getAllProducts called");
        return productService.getAllProducts();
    }
    @PostMapping(value = "/products")
    public ProductDto createProduct(@Valid @RequestBody ProductDto productDto){
        logger.info("createProduct called");
        return productService.createProduct(productDto);

    }
    @PutMapping(value = "/products/{productId}")
    public ProductDto updateProduct(@PathVariable int productId,@RequestBody ProductDto productDto) {
        logger.info("updateProduct called");
       return productService.updateProduct(productId,productDto);
    }
    @DeleteMapping(value = "/products/{productId}")
    public String deleteProductById(@PathVariable int productId){
        logger.info("deleteProductById called");
       return productService.deleteProductById(productId);
    }
}
