package com.wix.traitsoft.tpo_mnnit;

import java.util.Date;

/**
 * Created by shiva on 25-09-2017.
 */

public class Profile extends Student {

    private String name;
    private String course;
    private String branch;
    private String dob;
    private String email;
    private String skypeid;
    private String linkedinid;
    private int gender;
    private String category;
    private int physical;
    private int resident;
    private String guardian;
    private String presentaddress;
    private String permanentaddress;
    private int maritalstatus;
    private String state;
    private String country;

    Profile(String name,String course,String branch,String dob,String email,String skypeid,String linkedinid,int gender,String category,int physical,int resident,String guardian,String presentaddress,String permanentaddress,int maritalstatus,String state,String country)
    {
        this.name = name;
        this.course = course;
        this.branch = branch;
        this.dob = dob;
        this.email = email;
        this.skypeid = skypeid;
        this.linkedinid = linkedinid;
        this.gender = gender;
        this.category = category;
        this.physical = physical;
        this.resident = resident;
        this.guardian = guardian;
        this.presentaddress = presentaddress;
        this.permanentaddress = permanentaddress;
        this.maritalstatus = maritalstatus;
        this.state = state;
        this.country = country;
    }



    public boolean isCompleted()
    {
        return true;
    }

    public void dispalyProfile()
    {

    }

    @Override
    public void completeProfile() {

    }

    public String getPermanentaddress() {
        return permanentaddress;
    }

    public String getCountry() {
        return country;
    }

    public int getMaritalstatus() {
        return maritalstatus;
    }

    public String getPresentaddress() {
        return presentaddress;
    }

    public String getState() {
        return state;
    }

    public String getGuardian() {
        return guardian;
    }

    public int getResident() {
        return resident;
    }

    public int getPhysical() {
        return physical;
    }

    public String getCategory() {
        return category;
    }

    public int getGender() {
        return gender;
    }

    public String getLinkedinid() {
        return linkedinid;
    }

    public String getSkypeid() {
        return skypeid;
    }

    public void setSkypeid(String skypeid) {
        this.skypeid = skypeid;
    }

    public String getEmail() {
        return email;
    }

    public String getDob() {
        return dob;
    }

    public String getBranch() {
        return branch;
    }

    public String getCourse() {
        return course;
    }

    public String getName() {
        return name;
    }
}
