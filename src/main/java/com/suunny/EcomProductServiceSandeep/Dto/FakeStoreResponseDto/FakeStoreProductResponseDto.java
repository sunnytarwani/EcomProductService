package com.suunny.EcomProductServiceSandeep.Dto.FakeStoreResponseDto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductResponseDto {

    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private FakeStoreProductRatingDto rating;
}
