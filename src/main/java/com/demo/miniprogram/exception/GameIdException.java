package com.demo.miniprogram.exception;

public class GameIdException extends RuntimeException {

    public GameIdException(){
        super();
    }

    public GameIdException(String msg){
        super(msg);
    }
}
