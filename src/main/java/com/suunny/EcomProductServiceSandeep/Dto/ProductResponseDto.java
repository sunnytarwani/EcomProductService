package com.suunny.EcomProductServiceSandeep.Dto;


import com.suunny.EcomProductServiceSandeep.Model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {

    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String imageUrl;
    private double rating;
}
