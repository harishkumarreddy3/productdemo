package com.ideyalabs.demoproject.service;
import com.ideyalabs.demoproject.dto.ProductDto;
import com.ideyalabs.demoproject.dto.ProductDto2;
import com.ideyalabs.demoproject.entity.Product;
import com.ideyalabs.demoproject.exceptions.IdNotFoundException;
import com.ideyalabs.demoproject.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ModelMapper mapper;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public ProductDto getProductById(int productId) {
        if (productRepository.existsById(productId)) {
            Optional<Product> optionalProduct = productRepository.findById(productId);
            return optionalProduct.map(product -> mapper.map(product, ProductDto.class)).orElse(null);
        }
        throw new IdNotFoundException("Product with id " + productId + " not found");
    }


    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(product -> mapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public ProductDto2 createProduct(ProductDto2 productDto2) {
            Product product=productRepository.save(mapper.map(productDto2, Product.class));
        return mapper.map(product, ProductDto2.class);
    }

    @Override
    public ProductDto updateProduct(int id, ProductDto productDto) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setProductName(productDto.getProductName());
            existingProduct.setProductCost(productDto.getProductCost());
            existingProduct.setProductDescription(productDto.getProductDescription());
            existingProduct.setProductCompany(productDto.getProductCompany());
            Product updatedProduct = productRepository.save(existingProduct);
            return mapper.map(updatedProduct, ProductDto.class);
        } else {
            throw new IdNotFoundException("Id not found ");
        }
    }


    @Override
    public String deleteProductById(int productId){
        if(productRepository.existsById(productId)){
            productRepository.deleteById(productId);
            return "Product  with id: "+productId+" has been deleted";
        }
        throw new IdNotFoundException("Id not found");
    }
}
