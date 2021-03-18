package com.lqwd.restaurant.pojos;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private T data;
    private String message;

    public ApiResponse(T data, String message){
        this.data = data;
        this.message = message;
    }
}
