package com.suunny.EcomProductServiceSandeep.Exception;
import com.suunny.EcomProductServiceSandeep.Controller.CartController;
import com.suunny.EcomProductServiceSandeep.Controller.ProductController;
import com.suunny.EcomProductServiceSandeep.Dto.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = ProductController.class)
public class ProductServiceExceptionHandler {

    @ExceptionHandler({NoProductFoundException.class , ProductNotFoundException.class})
    public ResponseEntity handleNoProductFoundException(NoProductFoundException noProductFoundException){
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                noProductFoundException.getMessage(),
                404
        );

        return new ResponseEntity<>(exceptionResponseDto , HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(RandomException.class)
    public ResponseEntity handleProductRandomException(RandomException randomException){
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                randomException.getMessage(),
                404
        );

        return new ResponseEntity<>(exceptionResponseDto , HttpStatus.NOT_FOUND);
    }


//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity handleProductNotFoundException(ProductNotFoundException productNotFoundException){
//        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
//          productNotFoundException.getMessage(),
//                404
//        );
//
//        return new ResponseEntity<>(exceptionResponseDto , HttpStatus.NOT_FOUND);
//    }


}
