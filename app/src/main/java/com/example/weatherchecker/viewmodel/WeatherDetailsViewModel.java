package com.example.weatherchecker.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.weatherchecker.repository.WeatherRepository;
import com.example.weatherchecker.response.WeatherDetailsResponse;

public class WeatherDetailsViewModel extends ViewModel {
    private WeatherRepository weatherRepository;

    public WeatherDetailsViewModel() {
        weatherRepository = new WeatherRepository();
    }

    public LiveData<WeatherDetailsResponse> getWeatherDetails(String key, String query, String aqi){
        return weatherRepository.getWeatherDetails(key,query,aqi);
    }
}
