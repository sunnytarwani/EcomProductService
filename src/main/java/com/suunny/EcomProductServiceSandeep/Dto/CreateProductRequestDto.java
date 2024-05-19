package com.suunny.EcomProductServiceSandeep.Dto;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateProductRequestDto {

    private String title;
    private double price;
    private String description;
    private String imageURL;
    private UUID categoryId;
}
