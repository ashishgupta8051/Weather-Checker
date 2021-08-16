package com.example.weatherchecker.apiclient;

import com.example.weatherchecker.utils.Credentials;
import com.example.weatherchecker.utils.DataApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherApiClient {
    private static WeatherApiClient apiClient;
    private static Retrofit retrofit;

    private WeatherApiClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Credentials.BASE_URL2)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized WeatherApiClient getWeatherApiClient(){
        if (apiClient == null){
            apiClient = new WeatherApiClient();
        }
        return apiClient;
    }

    public DataApi getDataInterface(){
        return retrofit.create(DataApi.class);
    }
}
