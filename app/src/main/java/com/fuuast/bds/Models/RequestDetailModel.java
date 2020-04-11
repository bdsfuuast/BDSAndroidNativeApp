package com.fuuast.bds.Models;


public class RequestDetailModel {

    private String Type;
    private String Date;
    private String Time;
    private String BloodGroup;
    private Integer SentTo;
    private Integer SeenBy;
    private Integer AcceptedBy;
    private String DonorName;
    private String CurrentStatus;

    public String getType() {
        return Type;
    }

    public String getDate() {
        return Date;
    }

    public String getTime() {
        return Time;
    }

    public String getBloodGroup() {
        return BloodGroup;
    }

    public Integer getSentTo() {
        return SentTo;
    }

    public Integer getSeenBy() {
        return SeenBy;
    }

    public Integer getAcceptedBy() {
        return AcceptedBy;
    }

    public String getDonorName() {
        return DonorName;
    }

    public String getCurrentStatus() {
        return CurrentStatus;
    }


}