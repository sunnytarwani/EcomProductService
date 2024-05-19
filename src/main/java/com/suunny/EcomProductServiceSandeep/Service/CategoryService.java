package com.suunny.EcomProductServiceSandeep.Service;


import com.suunny.EcomProductServiceSandeep.Dto.CategoryResponseDto;
import com.suunny.EcomProductServiceSandeep.Dto.CreateCategoryRequestDto;

import java.util.List;
import java.util.UUID;

public interface CategoryService {


    CategoryResponseDto getCategory(UUID categoryId);
    List<CategoryResponseDto> getAllCategory();
    CategoryResponseDto createCategory(CreateCategoryRequestDto createCategoryRequestDto);
    CategoryResponseDto updateCategory(UUID categoryId , CreateCategoryRequestDto createCategoryRequestDto);
    Boolean deleteCategory(UUID categoryId);

    double getTotalPriceForCategory(UUID categoryId);
}
