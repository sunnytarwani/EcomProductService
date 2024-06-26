package com.suunny.EcomProductServiceSandeep.Repository;


import com.suunny.EcomProductServiceSandeep.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product , UUID> {

    Product findProductByTitle(String title);
    Product findFirstProductByTitle(String Title);
    List<Product> findByPriceBetween(double minPrice , double maxPrice);


}

//write in camel case with attributes name properly, basic methods