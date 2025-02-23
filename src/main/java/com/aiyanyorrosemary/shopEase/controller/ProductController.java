package com.aiyanyorrosemary.shopEase.controller;

import com.aiyanyorrosemary.shopEase.dto.ProductDto;
import com.aiyanyorrosemary.shopEase.entities.Product;
import com.aiyanyorrosemary.shopEase.services.ProductService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    private static final Logger log = (Logger) LoggerFactory.getLogger(ProductController.class);


    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody ProductDto productRequest) {

        log.info("Adding product {}");

        Product createdProduct = productService.createProduct(productRequest);

        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> products = productService.getAllProduct();

        return new ResponseEntity<>(products, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
       productService.deleteProduct(id);
       return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }




}
