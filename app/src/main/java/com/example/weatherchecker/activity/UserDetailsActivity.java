package com.example.weatherchecker.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.weatherchecker.R;
import com.example.weatherchecker.model.UserDetails;
import com.example.weatherchecker.utils.SharedPrefManager;
import com.example.weatherchecker.viewmodel.UserDetailsViewModel;

public class UserDetailsActivity extends AppCompatActivity {
    private SharedPrefManager sharedPrefManager;
    private long numberStr;
    private AutoCompleteTextView mobileNumberTxt,fullNameTxt,genderTxt,dobTxt,addressOneTxt,addressTwoTxt,pincodeTxt,districtTxt,stateTxt;
    private UserDetailsViewModel userDetailsViewModel;
    private UserDetails userDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        setUpUI();

        numberStr = Long.parseLong(sharedPrefManager.getPhoneNumber());
        userDetails = userDetailsViewModel.getSingleUserDetails(numberStr);

        mobileNumberTxt.setText(String.valueOf(userDetails.getPhoneNumber()));

        getUserDetails(userDetails);

    }

    private void getUserDetails(UserDetails userDetails) {
        mobileNumberTxt.setText(String.valueOf(userDetails.getPhoneNumber()));
        fullNameTxt.setText(userDetails.getFullName());
        genderTxt.setText(userDetails.getGender());
        dobTxt.setText(userDetails.getDateOfBirth());
        addressOneTxt.setText(userDetails.getAddressLineOne());
        addressTwoTxt.setText(userDetails.getAddressLineTwo());
        pincodeTxt.setText(String.valueOf(userDetails.getPincode()));
        districtTxt.setText(userDetails.getDistrict());
        stateTxt.setText(userDetails.getState());
    }

    private void setUpUI() {
        sharedPrefManager = new SharedPrefManager(this);

        userDetailsViewModel = new ViewModelProvider(this).get(UserDetailsViewModel.class);

        mobileNumberTxt = findViewById(R.id.getMobileNumber);
        fullNameTxt = findViewById(R.id.getFullName);
        genderTxt = findViewById(R.id.getGender);
        dobTxt = findViewById(R.id.getDob);
        addressOneTxt = findViewById(R.id.getAddress1);
        addressTwoTxt = findViewById(R.id.getAddress2);
        pincodeTxt = findViewById(R.id.getPincode);
        districtTxt = findViewById(R.id.getDistrict);
        stateTxt = findViewById(R.id.getState);
    }

}