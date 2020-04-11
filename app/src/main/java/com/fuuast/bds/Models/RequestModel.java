package com.fuuast.bds.Models;

public class RequestModel {

    private Integer ID;
    private String Name;
    private String Location;
    private Boolean Accepted;

    public Integer getID() {
        return ID;
    }
    public String getName() {
        return Name;
    }

    public String getLocation() {
        return Location;
    }

    public Boolean getAccepted() {
        return Accepted;
    }
}