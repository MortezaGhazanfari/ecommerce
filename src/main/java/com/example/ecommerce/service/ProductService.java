package com.example.ecommerce.service;

import com.example.ecommerce.dto.product.ProductDto;
import com.example.ecommerce.entity.Category;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.exception.ProductNotExistException;
import com.example.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductDto> listProducts(){
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            ProductDto productDto = getDtoFromProduct(product);
            productDtos.add(productDto);
        }
        return productDtos;
    }
    public static ProductDto getDtoFromProduct(Product product) {
        ProductDto productDto = new ProductDto(product);
        return productDto;
    }
    public static Product getProductFromDto(ProductDto productDto, Category category) {
        Product product = new Product(productDto, category);
        return product;
    }

    public void addProduct(ProductDto productDto, Category category){
        Product product = getProductFromDto(productDto,category);
        productRepository.save(product);
    }

    public void updateProduct(Long productID, ProductDto productDto, Category category) {
        Product product = getProductFromDto(productDto, category);
        product.setId(productID);
        productRepository.save(product);
    }
    public Product getProductById(Long productId) throws ProductNotExistException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent())
            throw new ProductNotExistException("Product id is invalid " + productId);
        return optionalProduct.get();
    }
}
