package com.suunny.EcomProductServiceSandeep.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product extends BaseModel {

    private String title;
    private double price;
    private String description;
    @ManyToOne
    private Category category;
    private String imageUrl;
    private double rating;
}
