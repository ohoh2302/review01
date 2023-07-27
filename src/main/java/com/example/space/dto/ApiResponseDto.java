package com.example.space.dto;

import lombok.Getter;

@Getter
public class ApiResponseDto {
    private String msg;
    private Integer status;


    public ApiResponseDto(String msg, Integer status) {
        this.msg = msg;
        this.status = status;
    }
}
