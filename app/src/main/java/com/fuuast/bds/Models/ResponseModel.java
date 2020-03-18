package com.fuuast.bds.Models;

public class ResponseModel<T> {
    private int Code ;
    private String Message ;
    private String error ;
    private String error_description ;
    private T Data ;

    public int getCode() {
        return Code;
    }

    public String getMessage() {
        return Message;
    }

    public String getError() {
        return error;
    }

    public String getError_description() {
        return error_description;
    }

    public T getData() {
        return Data;
    }
}
