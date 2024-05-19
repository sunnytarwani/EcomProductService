package com.suunny.EcomProductServiceSandeep.Exception;


import com.suunny.EcomProductServiceSandeep.Controller.CartController;
import com.suunny.EcomProductServiceSandeep.Dto.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = CartController.class)
public class CartControllerExceptionHandler {

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity handleNoCartFoundException(CartNotFoundException cartNotFoundException){
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                cartNotFoundException.getMessage(),
                404
        );

        return new ResponseEntity<>(exceptionResponseDto , HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(RandomException.class)
    public ResponseEntity handleCartRandomException(RandomException randomException){
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                randomException.getMessage(),
                404
        );

        return new ResponseEntity<>(exceptionResponseDto , HttpStatus.NOT_FOUND);
    }
}
