package com.example.weatherchecker.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_details_table")
public class UserDetails {
    @PrimaryKey
    private long phoneNumber;
    private String fullName;
    private String gender;
    private String dateOfBirth;
    private String addressLineOne;
    private String addressLineTwo;
    private long pincode;
    private String district;
    private String state;

    public UserDetails(long phoneNumber, String fullName, String gender, String dateOfBirth, String addressLineOne, String addressLineTwo, long pincode, String district, String state) {
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.addressLineOne = addressLineOne;
        this.addressLineTwo = addressLineTwo;
        this.pincode = pincode;
        this.district = district;
        this.state = state;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    public void setAddressLineTwo(String addressLineTwo) {
        this.addressLineTwo = addressLineTwo;
    }

    public long getPincode() {
        return pincode;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
