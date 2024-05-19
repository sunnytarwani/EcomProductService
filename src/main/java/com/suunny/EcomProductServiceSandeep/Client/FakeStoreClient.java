package com.suunny.EcomProductServiceSandeep.Client;

import com.suunny.EcomProductServiceSandeep.Dto.FakeStoreResponseDto.FakeStoreCartResponseDto;
import com.suunny.EcomProductServiceSandeep.Dto.FakeStoreResponseDto.FakeStoreProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FakeStoreClient {


    //dependency injection and inversin of control example
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.base.url}")
    private String fakeStoreApiBaseUrl;
    @Value("${fakestore.api.product.path}")
    private String fakeStoreApiProductPath;

    @Value("${fakestore.api.cart.path}")
    private String fakeStoreApiCartPath;


    public List<FakeStoreProductResponseDto> getAllProducts(){
        String fakeStoreGetAllProductUrl = fakeStoreApiBaseUrl.concat(fakeStoreApiProductPath);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDto[]> productResponseList = restTemplate.getForEntity(fakeStoreGetAllProductUrl , FakeStoreProductResponseDto[].class);
        return List.of(productResponseList.getBody());
    }

    public FakeStoreProductResponseDto getProduct(int id){
        String fakeStoreGetProductUrl = fakeStoreApiBaseUrl.concat(fakeStoreApiProductPath).concat("/" + id);
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductResponseDto>  productResponseDtoResponseEntity =
                restTemplate.getForEntity(fakeStoreGetProductUrl , FakeStoreProductResponseDto.class);

        return productResponseDtoResponseEntity.getBody();

    }


    public List<FakeStoreCartResponseDto> getCartForUser(int userId){
        String fakeStoreGetCartUrl = fakeStoreApiBaseUrl.concat(fakeStoreApiCartPath).concat(String.valueOf(userId));
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreCartResponseDto[]>  cartResponseDtoResponseEntity =
                restTemplate.getForEntity(fakeStoreGetCartUrl , FakeStoreCartResponseDto[].class);

        return List.of(cartResponseDtoResponseEntity.getBody());

    }
}
