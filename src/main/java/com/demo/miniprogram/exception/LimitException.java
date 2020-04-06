package com.demo.miniprogram.exception;

public class LimitException extends RuntimeException {

    public LimitException(){
        super();
    }

    public LimitException(String msg){
        super(msg);
    }


}
