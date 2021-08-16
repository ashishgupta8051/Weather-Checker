
package com.example.weatherchecker.model;

import com.google.gson.annotations.SerializedName;

public class Current {
    @SerializedName("cloud")
    private Long mCloud;
    @SerializedName("condition")
    private Condition mCondition;
    @SerializedName("feelslike_c")
    private Double mFeelslikeC;
    @SerializedName("feelslike_f")
    private Double mFeelslikeF;
    @SerializedName("gust_kph")
    private Double mGustKph;
    @SerializedName("gust_mph")
    private Double mGustMph;
    @SerializedName("humidity")
    private Long mHumidity;
    @SerializedName("is_day")
    private Long mIsDay;
    @SerializedName("last_updated")
    private String mLastUpdated;
    @SerializedName("last_updated_epoch")
    private Long mLastUpdatedEpoch;
    @SerializedName("precip_in")
    private Double mPrecipIn;
    @SerializedName("precip_mm")
    private Double mPrecipMm;
    @SerializedName("pressure_in")
    private Double mPressureIn;
    @SerializedName("pressure_mb")
    private Double mPressureMb;
    @SerializedName("temp_c")
    private Double mTempC;
    @SerializedName("temp_f")
    private Double mTempF;
    @SerializedName("uv")
    private Double mUv;
    @SerializedName("vis_km")
    private Double mVisKm;
    @SerializedName("vis_miles")
    private Double mVisMiles;
    @SerializedName("wind_degree")
    private Long mWindDegree;
    @SerializedName("wind_dir")
    private String mWindDir;
    @SerializedName("wind_kph")
    private Double mWindKph;
    @SerializedName("wind_mph")
    private Double mWindMph;

    public Long getCloud() {
        return mCloud;
    }

    public void setCloud(Long cloud) {
        mCloud = cloud;
    }

    public Condition getCondition() {
        return mCondition;
    }

    public void setCondition(Condition condition) {
        mCondition = condition;
    }

    public Double getFeelslikeC() {
        return mFeelslikeC;
    }

    public void setFeelslikeC(Double feelslikeC) {
        mFeelslikeC = feelslikeC;
    }

    public Double getFeelslikeF() {
        return mFeelslikeF;
    }

    public void setFeelslikeF(Double feelslikeF) {
        mFeelslikeF = feelslikeF;
    }

    public Double getGustKph() {
        return mGustKph;
    }

    public void setGustKph(Double gustKph) {
        mGustKph = gustKph;
    }

    public Double getGustMph() {
        return mGustMph;
    }

    public void setGustMph(Double gustMph) {
        mGustMph = gustMph;
    }

    public Long getHumidity() {
        return mHumidity;
    }

    public void setHumidity(Long humidity) {
        mHumidity = humidity;
    }

    public Long getIsDay() {
        return mIsDay;
    }

    public void setIsDay(Long isDay) {
        mIsDay = isDay;
    }

    public String getLastUpdated() {
        return mLastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        mLastUpdated = lastUpdated;
    }

    public Long getLastUpdatedEpoch() {
        return mLastUpdatedEpoch;
    }

    public void setLastUpdatedEpoch(Long lastUpdatedEpoch) {
        mLastUpdatedEpoch = lastUpdatedEpoch;
    }

    public Double getPrecipIn() {
        return mPrecipIn;
    }

    public void setPrecipIn(Double precipIn) {
        mPrecipIn = precipIn;
    }

    public Double getPrecipMm() {
        return mPrecipMm;
    }

    public void setPrecipMm(Double precipMm) {
        mPrecipMm = precipMm;
    }

    public Double getPressureIn() {
        return mPressureIn;
    }

    public void setPressureIn(Double pressureIn) {
        mPressureIn = pressureIn;
    }

    public Double getPressureMb() {
        return mPressureMb;
    }

    public void setPressureMb(Double pressureMb) {
        mPressureMb = pressureMb;
    }

    public Double getTempC() {
        return mTempC;
    }

    public void setTempC(Double tempC) {
        mTempC = tempC;
    }

    public Double getTempF() {
        return mTempF;
    }

    public void setTempF(Double tempF) {
        mTempF = tempF;
    }

    public Double getUv() {
        return mUv;
    }

    public void setUv(Double uv) {
        mUv = uv;
    }

    public Double getVisKm() {
        return mVisKm;
    }

    public void setVisKm(Double visKm) {
        mVisKm = visKm;
    }

    public Double getVisMiles() {
        return mVisMiles;
    }

    public void setVisMiles(Double visMiles) {
        mVisMiles = visMiles;
    }

    public Long getWindDegree() {
        return mWindDegree;
    }

    public void setWindDegree(Long windDegree) {
        mWindDegree = windDegree;
    }

    public String getWindDir() {
        return mWindDir;
    }

    public void setWindDir(String windDir) {
        mWindDir = windDir;
    }

    public Double getWindKph() {
        return mWindKph;
    }

    public void setWindKph(Double windKph) {
        mWindKph = windKph;
    }

    public Double getWindMph() {
        return mWindMph;
    }

    public void setWindMph(Double windMph) {
        mWindMph = windMph;
    }

}
