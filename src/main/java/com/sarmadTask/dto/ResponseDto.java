package com.sarmadTask.dto;


import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ResponseDto {
    String message;
    boolean status;
    Integer code;
    Object data;
    
    public ResponseDto(String message, boolean status, Integer code) 
    {
        this.message = message;
        this.status = status;
        this.code = code;
    }
}
