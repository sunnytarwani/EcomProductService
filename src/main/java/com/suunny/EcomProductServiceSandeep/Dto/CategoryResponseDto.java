package com.suunny.EcomProductServiceSandeep.Dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CategoryResponseDto {

    private UUID categoryId;
    private String categoryName;
    private List<ProductResponseDto> productResponseList;
}
