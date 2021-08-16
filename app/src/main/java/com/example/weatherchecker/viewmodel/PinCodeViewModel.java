package com.example.weatherchecker.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.weatherchecker.response.PinCodeResponse;
import com.example.weatherchecker.repository.PinCodeRepository;

import java.util.List;

public class PinCodeViewModel extends ViewModel {

    private PinCodeRepository pinCodeRepository;

    public PinCodeViewModel() {
        pinCodeRepository = new PinCodeRepository();
    }

    public LiveData<List<PinCodeResponse>> getPinCode(int pincode){
        return pinCodeRepository.getPinCode(pincode);
    }

}
