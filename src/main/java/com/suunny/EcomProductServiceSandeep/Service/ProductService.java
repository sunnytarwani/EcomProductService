package com.suunny.EcomProductServiceSandeep.Service;

import com.suunny.EcomProductServiceSandeep.Dto.CreateProductRequestDto;
import com.suunny.EcomProductServiceSandeep.Dto.ProductResponseDto;
import com.suunny.EcomProductServiceSandeep.Exception.ProductNotFoundException;
import com.suunny.EcomProductServiceSandeep.Model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<ProductResponseDto> getAllProducts();
    ProductResponseDto getProduct(UUID productId) throws ProductNotFoundException;
    ProductResponseDto createProduct(CreateProductRequestDto product);
    ProductResponseDto updateProduct(CreateProductRequestDto updatedProduct , UUID productId);
    boolean deleteProduct(UUID productId);
    ProductResponseDto getProduct(String title);
    List<Product> getProduct(double minPrice , double maxPrice);

}
