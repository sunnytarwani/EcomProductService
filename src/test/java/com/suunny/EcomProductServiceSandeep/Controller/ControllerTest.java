package com.suunny.EcomProductServiceSandeep.Controller;

import com.suunny.EcomProductServiceSandeep.Dto.CategoryResponseDto;
import com.suunny.EcomProductServiceSandeep.Dto.CreateCategoryRequestDto;
import com.suunny.EcomProductServiceSandeep.Service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    CategoryController categoryController;


    @Test
    public void testUpdateCategory(){

        //Arrange
        CreateCategoryRequestDto createCategoryRequestDto =
                new CreateCategoryRequestDto();

        createCategoryRequestDto.setCategoryName("NewCategoryName");

        UUID randomId = UUID.randomUUID();
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        categoryResponseDto.setCategoryId(randomId);
        categoryResponseDto.setCategoryName("NewCategoryName");

        Mockito.when(
                categoryService.updateCategory(randomId , createCategoryRequestDto))
                .thenReturn(categoryResponseDto);

        //Act
        ResponseEntity<CategoryResponseDto> categoryResponseDtoResponseEntity
                = categoryController.updateCategory(randomId , createCategoryRequestDto);

        //Assert
        Assertions.assertEquals(categoryResponseDtoResponseEntity.getBody() , categoryResponseDto);
    }
}
