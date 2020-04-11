package com.fuuast.bds.Models;

import com.google.gson.annotations.SerializedName;

public class DonationDetailModel {

    private String Type;
    private String Location;
    private String Time;
    private String RequestTime;
    private String AcceptTime;
    private String BloodGroup;
    private String RequestBy;
    private String CurrentStatus;

    public String getType() {
        return Type;
    }

    public String getLocation() {
        return Location;
    }

    public String getTime() {
        return Time;
    }

    public String getRequestTime() {
        return RequestTime;
    }

    public String getAcceptTime() {
        return AcceptTime;
    }

    public String getBloodGroup() {
        return BloodGroup;
    }

    public String getRequestBy() {
        return RequestBy;
    }

    public String getCurrentStatus() {
        return CurrentStatus;
    }
}