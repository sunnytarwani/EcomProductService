package com.suunny.EcomProductServiceSandeep.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionResponseDto {
    private String message;
    private int code;
}
