package com.suunny.EcomProductServiceSandeep.Service;

import com.suunny.EcomProductServiceSandeep.Dto.CategoryResponseDto;
import com.suunny.EcomProductServiceSandeep.Dto.CreateProductRequestDto;
import com.suunny.EcomProductServiceSandeep.Dto.ProductResponseDto;
import com.suunny.EcomProductServiceSandeep.Exception.CategoryNotFoundException;
import com.suunny.EcomProductServiceSandeep.Exception.ProductNotFoundException;
import com.suunny.EcomProductServiceSandeep.Mapper.ProductEntityDtoMapper;
import com.suunny.EcomProductServiceSandeep.Model.Category;
import com.suunny.EcomProductServiceSandeep.Model.Product;
import com.suunny.EcomProductServiceSandeep.Repository.CategoryRepository;
import com.suunny.EcomProductServiceSandeep.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Service("ProductService")
public class ProductServiceImpl implements ProductService{


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<Product> savedProducts = productRepository.findAll();
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for(Product product : savedProducts){
            productResponseDtos.add(ProductEntityDtoMapper.convertProductToProductResponseDto(product));
        }

        return productResponseDtos;
    }

    @Override
    public ProductResponseDto getProduct(UUID productId) throws ProductNotFoundException {
        /*

        Basic code to check null check we will use Lambda
        Product saveProduct = productRepository.findById(productId).get();
        if(saveProduct == null){
            throw new ProductNotFoundException("The id " + productId + " is not present in the DB! ")
        }

        return saveProduct;
         */

        Product product = productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("The id " + productId + " is not present in the DB! ")
        );

        return ProductEntityDtoMapper.convertProductToProductResponseDto(product);
    }

    @Override
    public ProductResponseDto createProduct(CreateProductRequestDto product) {
       Product product1 = ProductEntityDtoMapper.convertCreateProductRequestDtoToProduct(product);
       Category category = categoryRepository.findById(product.getCategoryId()).orElseThrow(
               () -> new CategoryNotFoundException("The id " + product.getCategoryId() + " is not present in the DB! ")
       );
       product1.setCategory(category);
       product1 = productRepository.save(product1);
       return ProductEntityDtoMapper.convertProductToProductResponseDto(product1);
    }

    @Override
    public ProductResponseDto updateProduct(CreateProductRequestDto updatedProduct, UUID productId) {
        Product savedProduct = productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("The id " + productId + " is not present in the DB! ")
        );

        savedProduct.setTitle(updatedProduct.getTitle());
        savedProduct.setPrice(updatedProduct.getPrice());
        savedProduct.setDescription(updatedProduct.getDescription());
        savedProduct.setImageUrl(updatedProduct.getImageURL());
        savedProduct = productRepository.save(savedProduct);
        return ProductEntityDtoMapper.convertProductToProductResponseDto(savedProduct);
    }

    @Override
    public boolean deleteProduct(UUID productId) {
        productRepository.deleteById(productId);
        return true;
    }

    @Override
    public ProductResponseDto getProduct(String title) {
        return ProductEntityDtoMapper.convertProductToProductResponseDto(productRepository.findProductByTitle(title));
    }

    @Override
    public List<Product> getProduct(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetween(minPrice , maxPrice);
    }


}
