package com.example.weatherchecker.repository;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.weatherchecker.apiclient.PinCodeApiClient;
import com.example.weatherchecker.response.PinCodeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PinCodeRepository {
    private MutableLiveData<List<PinCodeResponse>> pincodeLiveData = new MutableLiveData<>();

    public LiveData<List<PinCodeResponse>> getPinCode (int pincode){
        Call<List<PinCodeResponse>> pinCodeCall = PinCodeApiClient.getPinCodeApiClient().getDataInterface().getPinCode(pincode);
        pinCodeCall.enqueue(new Callback<List<PinCodeResponse>>() {
            @Override
            public void onResponse(Call<List<PinCodeResponse>> call, Response<List<PinCodeResponse>> response) {
                pincodeLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PinCodeResponse>> call, Throwable t) {
                Log.e(TAG,t.getMessage());
            }
        });
        return  pincodeLiveData;
    }
}
