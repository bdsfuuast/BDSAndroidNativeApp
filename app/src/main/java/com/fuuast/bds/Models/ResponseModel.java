package com.fuuast.bds.Models;

public class ResponseModel {
    private int Code ;
    private String Message ;
    private String error ;
    private String error_description ;
    private Object Data ;

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

    public Object getData() {
        return Data;
    }
}
