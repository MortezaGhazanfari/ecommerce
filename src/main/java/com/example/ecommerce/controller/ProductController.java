package com.example.ecommerce.controller;

import com.example.ecommerce.common.ApiResponse;
import com.example.ecommerce.dto.product.ProductDto;
import com.example.ecommerce.entity.Category;
import com.example.ecommerce.service.CategoryService;
import com.example.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<List<ProductDto>> getProducts(){
        List<ProductDto> body = productService.listProducts();
        return new ResponseEntity<List<ProductDto>>(body, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductDto productDto){
        Optional<Category> optionalCategory = categoryService.readCategory((productDto.getCategoryId()));
        if (!optionalCategory.isPresent()) return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
        Category category = optionalCategory.get();
        productService.addProduct(productDto, category);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been added"), HttpStatus.CREATED);
    }

    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productID") Long productID, @RequestBody @Valid ProductDto productDto){
        Optional<Category> optionalCategory = categoryService.readCategory((productDto.getCategoryId()));
        if (!optionalCategory.isPresent()) return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category is invalid"), HttpStatus.CONFLICT);
        Category category = optionalCategory.get();
        productService.updateProduct(productID, productDto, category);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
    }
}
