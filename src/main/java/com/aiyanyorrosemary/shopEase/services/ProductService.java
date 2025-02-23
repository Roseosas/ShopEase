package com.aiyanyorrosemary.shopEase.services;

import com.aiyanyorrosemary.shopEase.dto.ProductDto;
import com.aiyanyorrosemary.shopEase.entities.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(ProductDto product);

    List<Product> getAllProduct();

    Product getProductById(Long id);

    Product updateProduct(Long id, Product product);

    Product deleteProduct(Long id);
}

