package com.suunny.EcomProductServiceSandeep.Mapper;

import com.suunny.EcomProductServiceSandeep.Dto.CreateProductRequestDto;
import com.suunny.EcomProductServiceSandeep.Dto.ProductResponseDto;
import com.suunny.EcomProductServiceSandeep.Model.Product;

public class ProductEntityDtoMapper {

  public static ProductResponseDto convertProductToProductResponseDto(Product product){
      ProductResponseDto productResponseDto = new ProductResponseDto();
      //productResponseDto.setId(product.getId());
      productResponseDto.setTitle(product.getTitle());
      //productResponseDto.setCategory(product.getCategory());
      productResponseDto.setRating(product.getRating());
      productResponseDto.setDescription(product.getDescription());
      productResponseDto.setImageUrl(product.getImageUrl());
      productResponseDto.setPrice(product.getPrice());
      productResponseDto.setCategory(product.getCategory().getName());
      return productResponseDto;
  }

  public static Product convertCreateProductRequestDtoToProduct(CreateProductRequestDto createProductRequestDto){
      Product product = new Product();
      product.setTitle(createProductRequestDto.getTitle());
      product.setRating(0);
      product.setPrice(createProductRequestDto.getPrice());
      product.setImageUrl(createProductRequestDto.getImageURL());
      product.setDescription(createProductRequestDto.getDescription());
      return product;
  }

}
