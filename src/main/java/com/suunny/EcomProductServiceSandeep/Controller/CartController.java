package com.suunny.EcomProductServiceSandeep.Controller;


import com.suunny.EcomProductServiceSandeep.Client.FakeStoreClient;
import com.suunny.EcomProductServiceSandeep.Dto.FakeStoreResponseDto.FakeStoreCartResponseDto;
import com.suunny.EcomProductServiceSandeep.Exception.CartNotFoundException;
import com.suunny.EcomProductServiceSandeep.Exception.RandomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * This cart controller is used only for learning purpose to understand the use of
 * controller advice.
 */


@RestController
public class CartController {

    @Autowired
    private FakeStoreClient fakeStoreClient;

    @GetMapping("/cart/{userId}")
    public ResponseEntity getCartForUser(@PathVariable("userId") int userId){
        List<FakeStoreCartResponseDto> fakeStoreCartResponseDtos = fakeStoreClient.getCartForUser(userId);
        if (fakeStoreCartResponseDtos == null){
            throw new CartNotFoundException("User Id " + userId + " not present in the DB!");
        }
        return ResponseEntity.ok(fakeStoreCartResponseDtos);
    }

    @GetMapping("/cartexception")
    public ResponseEntity getCartException(){
        throw new RandomException("Exception from Cart");
    }

}
