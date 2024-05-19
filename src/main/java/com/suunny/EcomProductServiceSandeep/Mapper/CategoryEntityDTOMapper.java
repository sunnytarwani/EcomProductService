package com.suunny.EcomProductServiceSandeep.Mapper;


import com.suunny.EcomProductServiceSandeep.Dto.CategoryResponseDto;
import com.suunny.EcomProductServiceSandeep.Dto.CreateCategoryRequestDto;
import com.suunny.EcomProductServiceSandeep.Dto.ProductResponseDto;
import com.suunny.EcomProductServiceSandeep.Model.Category;
import com.suunny.EcomProductServiceSandeep.Model.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryEntityDTOMapper {

    public static CategoryResponseDto convertCategoryToCategoryResponseDTO(Category category){
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        categoryResponseDto.setCategoryName(category.getName());
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        if(!(category.getProducts() == null || category.getProducts().isEmpty())){
            for(Product product : category.getProducts()){
                productResponseDtos.add(ProductEntityDtoMapper.convertProductToProductResponseDto(product));
            }
        }

        categoryResponseDto.setProductResponseList(productResponseDtos);
        return categoryResponseDto;
    }



    public static Category convertCreateCategoryDTOToCategory(CreateCategoryRequestDto createCategoryRequestDto){
        Category category = new Category();
        category.setName(createCategoryRequestDto.getCategoryName());
        return category;
    }

}
