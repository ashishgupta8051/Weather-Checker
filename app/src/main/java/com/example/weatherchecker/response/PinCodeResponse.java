
package com.example.weatherchecker.response;

import com.example.weatherchecker.model.PostOffice;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PinCodeResponse {

    @SerializedName("Message")
    private String mMessage;
    @SerializedName("PostOffice")
    private List<PostOffice> mPostOffice;
    @SerializedName("Status")
    private String mStatus;

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public List<PostOffice> getPostOffice() {
        return mPostOffice;
    }

    public void setPostOffice(List<PostOffice> postOffice) {
        mPostOffice = postOffice;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
