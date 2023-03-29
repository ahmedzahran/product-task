package com.producttask.task.exception;

public class BusinessExceptions extends Exception{

    public Object[] args;
    public String message;

    public BusinessExceptions(String message){
        super(message);
        this.message=message;
        this.args=new Object[]{};
    }
}
