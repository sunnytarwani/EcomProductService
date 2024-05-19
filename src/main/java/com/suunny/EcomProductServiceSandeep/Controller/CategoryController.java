package com.suunny.EcomProductServiceSandeep.Controller;


import com.suunny.EcomProductServiceSandeep.Dto.CategoryResponseDto;
import com.suunny.EcomProductServiceSandeep.Dto.CreateCategoryRequestDto;
import com.suunny.EcomProductServiceSandeep.Service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryServiceImpl categoryService;


    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getAllCategory(){
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getCategory(@PathVariable("id")UUID categoryId){
        return ResponseEntity.ok(categoryService.getCategory(categoryId));
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDto> createCategory(@RequestBody CreateCategoryRequestDto createCategoryRequestDto){
        return ResponseEntity.ok(categoryService.createCategory(createCategoryRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> updateCategory(@PathVariable("id") UUID categoryId , @RequestBody CreateCategoryRequestDto createCategoryRequestDto){
        return ResponseEntity.ok(categoryService.updateCategory(categoryId,createCategoryRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("id") UUID categoryId){
        return ResponseEntity.ok(categoryService.deleteCategory(categoryId));
    }


    @GetMapping("/totalPrice/{categoryId}")
    public ResponseEntity<Double> getTotalPriceForCategory(@PathVariable("categoryId") UUID categoryId){
        return ResponseEntity.ok(categoryService.getTotalPriceForCategory(categoryId));
    }

}
