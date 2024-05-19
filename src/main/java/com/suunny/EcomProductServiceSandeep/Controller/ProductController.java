package com.suunny.EcomProductServiceSandeep.Controller;

import com.suunny.EcomProductServiceSandeep.Dto.CreateProductRequestDto;
import com.suunny.EcomProductServiceSandeep.Dto.ProductResponseDto;
import com.suunny.EcomProductServiceSandeep.Exception.RandomException;
import com.suunny.EcomProductServiceSandeep.Model.Product;
import com.suunny.EcomProductServiceSandeep.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    @Qualifier("ProductServiceImpl")
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProduct(){
        List<ProductResponseDto> products = productService.getAllProducts();
        return ResponseEntity.of(Optional.ofNullable(products));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable("id") UUID id){
       return ResponseEntity.ok(productService.getProduct(id));
    }


    //User for Demo checking for Controller Advice annotation
    //No other Use
    @GetMapping("/productexception")
    public ResponseEntity getProductException(){
        throw new RandomException("Exception from Product");
    }


    @PostMapping
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody CreateProductRequestDto product){
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable("id") UUID id , @RequestBody CreateProductRequestDto product){
        return ResponseEntity.ok(productService.updateProduct(product , id));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") UUID id){
        return ResponseEntity.ok(productService.deleteProduct(id));
    }



    //New crud operation for created specific operation

    @GetMapping("/name/{productName}")
    public ResponseEntity<ProductResponseDto> getProductByTitle(@PathVariable("productName") String title){
        return ResponseEntity.ok(productService.getProduct(title));
    }

    @GetMapping("/{min}/{max}")
    public ResponseEntity getProductRange(@PathVariable("min") double minPrice , @PathVariable("max") double maxPrice){
       return ResponseEntity.ok(
               productService.getProduct(minPrice, maxPrice)
       );
    }
}
