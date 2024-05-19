package com.suunny.EcomProductServiceSandeep.Service;

import com.suunny.EcomProductServiceSandeep.Model.Category;
import com.suunny.EcomProductServiceSandeep.Model.Product;
import com.suunny.EcomProductServiceSandeep.Repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {

    @Mock
    CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @BeforeEach
    public void setUp(){
        //Not required now a days this is taken care by the spring but for learning purpose and understanding we will add it.
        //MockitoAnnotations.initMocks(this);
    }


    @Test
    public void getTotalPriceForMultipleProduct(){
        //This would return the total cost for all the products under a category

        //Arrange
        UUID categoryId = UUID.randomUUID();
        Optional<Category> optionalCategory = getCategoryMockData();
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(optionalCategory);
        double expectedCost = 300.00;

        //Act
        double totalCost = categoryService.getTotalPriceForCategory(categoryId);

        //Assert
        Assertions.assertEquals(totalCost , expectedCost);

    }


    @Test
    public void testGetTotalPriceForZeroProducts(){

        //Arrange
        UUID categoryId = UUID.randomUUID();
        Optional<Category> categoryOptional = getCategoryMockDataWithZeroProducts();
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(categoryOptional);
        double expectedCost = 0.0;

        //Act
        double totalCost = categoryService.getTotalPriceForCategory(categoryId);

        //Assert
        Assertions.assertEquals(totalCost , expectedCost);
        Mockito.verify(categoryRepository).findById(categoryId);
    }

    public void testCategoryNotFoundExceptionThrown(){
        //Arrange
        UUID categoryId = UUID.randomUUID();
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(Optional.empty());
        //Act and assert
        double totalCost = categoryService.getTotalPriceForCategory(categoryId);
        Assertions.assertThrows(ClassNotFoundException.class, () -> categoryService.getTotalPriceForCategory(categoryId));


    }

    public Optional<Category> getCategoryMockDataWithZeroProducts(){
        UUID randomCategoryId = UUID.randomUUID();
        Category category = new Category();
        category.setId(randomCategoryId);
        category.setName("CategoryName");

        List<Product>products = new ArrayList<>();
        category.setProducts(products);
        return Optional.of(category);
    }
    public Optional<Category> getCategoryMockData(){
        UUID randomCategoryId = UUID.randomUUID();
        Category category = new Category();
        category.setId(randomCategoryId);
        category.setName("CategoryName");

        Product product1 = new Product();
        product1.setId(UUID.randomUUID());
        product1.setTitle("Product1");
        product1.setPrice(100.0);
        product1.setCategory(category);

        Product product2 = new Product();
        product2.setId(UUID.randomUUID());
        product2.setTitle("Product2");
        product2.setPrice(200.0);
        product2.setCategory(category);

        List<Product>products = new ArrayList<>();
        products.add(product2);
        products.add(product1);

        category.setProducts(products);
        return Optional.of(category);
    }
}
