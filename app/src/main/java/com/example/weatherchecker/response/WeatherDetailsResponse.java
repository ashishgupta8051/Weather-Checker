
package com.example.weatherchecker.response;


import com.example.weatherchecker.model.Current;
import com.example.weatherchecker.model.Location;
import com.google.gson.annotations.SerializedName;

public class WeatherDetailsResponse {
    @SerializedName("current")
    private Current mCurrent;
    @SerializedName("location")
    private Location mLocation;

    public Current getCurrent() {
        return mCurrent;
    }

    public void setCurrent(Current current) {
        mCurrent = current;
    }

    public Location getLocation() {
        return mLocation;
    }

    public void setLocation(Location location) {
        mLocation = location;
    }

}
