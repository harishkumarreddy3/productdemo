package com.ideyalabs.demoproject.service;
import com.ideyalabs.demoproject.dto.ProductDto;
import com.ideyalabs.demoproject.entity.Product;
import com.ideyalabs.demoproject.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
//comment
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto getProductById(int productId) {
        ModelMapper mapper=new ModelMapper();
        if(productRepository.findById(productId).isPresent()) {
            Product product = productRepository.findById(productId).get();
            return mapper.map(product, ProductDto.class);
        }
        else {
            return null;
        }
    }

    @Override
    public List<ProductDto> getAllProducts() {
        ModelMapper mapper=new ModelMapper();
        List<Product> products = productRepository.findAll();
        return mapper.map(products, List.class);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        ModelMapper mapper=new ModelMapper();
            Product product=productRepository.save(mapper.map(productDto, Product.class));
        return mapper.map(product, ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(int id,ProductDto productDto) {
        ModelMapper modelMapper=new ModelMapper();
        boolean result=productRepository.existsById(id);
        Optional<Product> product=productRepository.findById(id);
        if(result){
            Product p1=product.get();
            p1.setProductName(productDto.getProductName());
            p1.setProductCost(productDto.getProductCost());
            p1.setProductDescription(productDto.getProductDescription());
            p1.setProductCompany(productDto.getProductCompany());
            Product updatedProduct=productRepository.save(p1);
            return modelMapper.map(updatedProduct, ProductDto.class);
        }
        return null;
    }

    @Override
    public String deleteProductById(int productId){
        if(productRepository.existsById(productId)){
            productRepository.deleteById(productId);
        }
        return "Product deleted";
    }
}
