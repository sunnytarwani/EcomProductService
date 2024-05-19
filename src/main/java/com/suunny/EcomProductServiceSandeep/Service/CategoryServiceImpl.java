package com.suunny.EcomProductServiceSandeep.Service;

import com.suunny.EcomProductServiceSandeep.Dto.CategoryResponseDto;
import com.suunny.EcomProductServiceSandeep.Dto.CreateCategoryRequestDto;
import com.suunny.EcomProductServiceSandeep.Exception.CategoryNotFoundException;
import com.suunny.EcomProductServiceSandeep.Mapper.CategoryEntityDTOMapper;
import com.suunny.EcomProductServiceSandeep.Model.Category;
import com.suunny.EcomProductServiceSandeep.Model.Product;
import com.suunny.EcomProductServiceSandeep.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public CategoryResponseDto getCategory(UUID categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found!"));

        return CategoryEntityDTOMapper.convertCategoryToCategoryResponseDTO(category);
    }

    @Override
    public List<CategoryResponseDto> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponseDto> categoryResponseDtos = new ArrayList<>();

        for(Category category : categories){
            categoryResponseDtos.add(CategoryEntityDTOMapper.convertCategoryToCategoryResponseDTO(category));
        }

        return categoryResponseDtos;
    }

    @Override
    public CategoryResponseDto createCategory(CreateCategoryRequestDto createCategoryRequestDto) {
        Category category = CategoryEntityDTOMapper.convertCreateCategoryDTOToCategory(createCategoryRequestDto);
        category = categoryRepository.save(category);
        return CategoryEntityDTOMapper.convertCategoryToCategoryResponseDTO(category);
    }

    @Override
    public CategoryResponseDto updateCategory(UUID categoryId, CreateCategoryRequestDto createCategoryRequestDto) {
        return null;
    }

    @Override
    public Boolean deleteCategory(UUID categoryId) {
        return null;
    }

    @Override
    public double getTotalPriceForCategory(UUID categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found in the DB!"));

        if(category.getProducts().isEmpty()){
            return 0;
        }
        else{
            double sum = 0;
            for(Product product : category.getProducts()){
                sum += product.getPrice();
            }

            return sum;

            /**
             * Lambda stream
             *  return category.getProducts()
             *                     .stream()
             *                     .mapToDouble(Product::getPrice)
             *                     .sum();
             */
        }
    }
}
