package com.fuuast.bds.Models;

public class NotificationModel {
    public int ID ;
    public int NotificationActivity;
    public String Title;
    public String Body ;
    public Boolean Confirmed ;
    public String Time ;

    public int getID() {
        return ID;
    }

    public int getNotificationActivity() {
        return NotificationActivity;
    }

    public String getTitle() {
        return Title;
    }

    public String getBody() {
        return Body;
    }

    public Boolean getConfirmed() {
        return Confirmed;
    }

    public String getTime() {
        return Time;
    }
}
