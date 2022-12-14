package com.sjx.springcloud.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CommonResult<T>{

    private Integer code;
    private String message;
    private T data;
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResult() {
    }

}
