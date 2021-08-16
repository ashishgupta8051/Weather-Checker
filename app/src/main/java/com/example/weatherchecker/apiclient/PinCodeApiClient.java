package com.example.weatherchecker.apiclient;

import com.example.weatherchecker.utils.Credentials;
import com.example.weatherchecker.utils.DataApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PinCodeApiClient {
    private static PinCodeApiClient apiClient;
    private static Retrofit retrofit;

    private PinCodeApiClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(Credentials.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized PinCodeApiClient getPinCodeApiClient(){
        if (apiClient == null){
            apiClient = new PinCodeApiClient();
        }
        return apiClient;
    }

    public DataApi getDataInterface(){
        return retrofit.create(DataApi.class);
    }
}
