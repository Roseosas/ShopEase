package com.aiyanyorrosemary.shopEase.services.Implementation;

import com.aiyanyorrosemary.shopEase.dto.ProductDto;
import com.aiyanyorrosemary.shopEase.entities.Product;
import com.aiyanyorrosemary.shopEase.exception.ResourceNotFoundException;
import com.aiyanyorrosemary.shopEase.repository.ProductRepository;
import com.aiyanyorrosemary.shopEase.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product createProduct(ProductDto productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .image(productRequest.getImage())
                .build();
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();

    }

   @Override
    public Product getProductById(Long id) {

      Optional<Product> productOpt = productRepository.findById(id);
        if (productOpt.isPresent()) {
            return productOpt.get();
        } else {
            throw new ResourceNotFoundException("Product Not Found");
        }
    }
@Override
    public Product updateProduct(Long id, Product product) {
        if (productRepository.existsById(id)) {

            product.setName(product.getName());
            product.setDescription(product.getDescription());
            product.setImage(product.getImage());
            return productRepository.save(product);
        } else {
            throw new ResourceNotFoundException("Product Not Found");
        }
    }
@Override
    public Product deleteProduct(Long id) {
    if (productRepository.existsById(id)) {
        productRepository.deleteById(id);
    } else {
        throw new ResourceNotFoundException("Product not Found");
    }
    return null;
    }
}

