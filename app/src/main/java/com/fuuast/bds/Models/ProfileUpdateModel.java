package com.fuuast.bds.Models;

public class ProfileUpdateModel {

    private String OldPassword;
    private String NewPassword;
    private String RepeatPassword;
    private String Contact;
    private String Email;

    public String getOldPassword() {
        return OldPassword;
    }

    public String getNewPassword() {
        return NewPassword;
    }

    public String getRepeatPassword() {
        return RepeatPassword;
    }

    public String getContact() {
        return Contact;
    }

    public String getEmail() {
        return Email;
    }

}