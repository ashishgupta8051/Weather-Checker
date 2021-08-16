package com.example.weatherchecker.utils;

import com.example.weatherchecker.response.PinCodeResponse;
import com.example.weatherchecker.response.WeatherDetailsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DataApi {

    @GET("pincode/{pincode}")
    Call<List<PinCodeResponse>> getPinCode(
      @Path("pincode") int pincode
    );

    @GET("current.json")
    Call<WeatherDetailsResponse> getWeatherDetails(
            @Query("key") String key,
            @Query("q") String query,
            @Query("aqi") String aqi
    );
}
