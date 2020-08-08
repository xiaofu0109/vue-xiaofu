package com.xiaofu.vuessmbms.Common;

public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult(){}

    public CommonResult(Integer code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResult(T data){
        this.code = 200;
        this.message = "执行成功";
        this.data = data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
