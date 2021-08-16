package com.example.weatherchecker.repository;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.weatherchecker.apiclient.PinCodeApiClient;
import com.example.weatherchecker.apiclient.WeatherApiClient;
import com.example.weatherchecker.response.PinCodeResponse;
import com.example.weatherchecker.response.WeatherDetailsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {
    private MutableLiveData<WeatherDetailsResponse> data = new MutableLiveData<>();

    public LiveData<WeatherDetailsResponse> getWeatherDetails (String key,String query,String aqi){
        Call<WeatherDetailsResponse> call = WeatherApiClient.getWeatherApiClient().getDataInterface().getWeatherDetails(key, query, aqi);
        call.enqueue(new Callback<WeatherDetailsResponse>() {
            @Override
            public void onResponse(Call<WeatherDetailsResponse> call, Response<WeatherDetailsResponse> response) {
                data.postValue(response.body());
            }

            @Override
            public void onFailure(Call<WeatherDetailsResponse> call, Throwable t) {
                Log.e(TAG,t.getMessage());
            }
        });
        return data;
    }
}
