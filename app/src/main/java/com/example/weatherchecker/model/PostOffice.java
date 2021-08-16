
package com.example.weatherchecker.model;

import com.google.gson.annotations.SerializedName;

public class PostOffice {
    @SerializedName("Block")
    private String mBlock;
    @SerializedName("BranchType")
    private String mBranchType;
    @SerializedName("Circle")
    private String mCircle;
    @SerializedName("Country")
    private String mCountry;
    @SerializedName("DeliveryStatus")
    private String mDeliveryStatus;
    @SerializedName("Description")
    private Object mDescription;
    @SerializedName("District")
    private String mDistrict;
    @SerializedName("Division")
    private String mDivision;
    @SerializedName("Name")
    private String mName;
    @SerializedName("Pincode")
    private String mPincode;
    @SerializedName("Region")
    private String mRegion;
    @SerializedName("State")
    private String mState;

    public String getBlock() {
        return mBlock;
    }

    public void setBlock(String block) {
        mBlock = block;
    }

    public String getBranchType() {
        return mBranchType;
    }

    public void setBranchType(String branchType) {
        mBranchType = branchType;
    }

    public String getCircle() {
        return mCircle;
    }

    public void setCircle(String circle) {
        mCircle = circle;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public String getDeliveryStatus() {
        return mDeliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        mDeliveryStatus = deliveryStatus;
    }

    public Object getDescription() {
        return mDescription;
    }

    public void setDescription(Object description) {
        mDescription = description;
    }

    public String getDistrict() {
        return mDistrict;
    }

    public void setDistrict(String district) {
        mDistrict = district;
    }

    public String getDivision() {
        return mDivision;
    }

    public void setDivision(String division) {
        mDivision = division;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPincode() {
        return mPincode;
    }

    public void setPincode(String pincode) {
        mPincode = pincode;
    }

    public String getRegion() {
        return mRegion;
    }

    public void setRegion(String region) {
        mRegion = region;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

}
