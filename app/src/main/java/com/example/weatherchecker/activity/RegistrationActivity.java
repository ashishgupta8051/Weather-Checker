package com.example.weatherchecker.activity;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.weatherchecker.R;
import com.example.weatherchecker.model.PostOffice;
import com.example.weatherchecker.model.UserDetails;
import com.example.weatherchecker.response.PinCodeResponse;
import com.example.weatherchecker.utils.SharedPrefManager;
import com.example.weatherchecker.viewmodel.PinCodeViewModel;
import com.example.weatherchecker.viewmodel.UserDetailsViewModel;

import java.util.Calendar;

public class RegistrationActivity extends AppCompatActivity {
    private EditText mobileNumberEdt,fullNameEdt,addressLineOneEdt,addressLineTwoEdt,pincodeEdt;
    private AutoCompleteTextView dobTxt, districtTxt, stateTxt, genderSpinnerTxt;
    private Button pincodeCheckBtn,registerBtn;
    private String[] gender;
    private ArrayAdapter arrayAdapter;
    private String fullNameStr,genderStr,dobStr,address1Str,address2Str,districtStr,stateStr, mobileNumberStr, pincodeStr;
    private PinCodeViewModel pinCodeViewModel;
    private AlertDialog alertDialog;
    private UserDetailsViewModel userDetailsViewModel;
    private SharedPrefManager sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //bind data
        setUpUI();

        //hide softinput keyboard
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        gender = getResources().getStringArray(R.array.gender);
        arrayAdapter = new ArrayAdapter(this,R.layout.dropdownmenu,gender);
        genderSpinnerTxt.setAdapter(arrayAdapter);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        dobTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        RegistrationActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
                        String date = day + "/" + month + "/" + year;
                        dobTxt.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        pincodeCheckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create dialog box
                createDialogBox();
                pincodeStr = pincodeEdt.getText().toString();
                if (pincodeStr.isEmpty()){
                    pincodeEdt.setError("Enter pincode");
                    pincodeEdt.requestFocus();
                }else if (!(pincodeStr.length() == 6)){
                    pincodeEdt.setError("Enter 6 digit pincode");
                    pincodeEdt.requestFocus();
                }else {
                    alertDialog.show();
                    pinCodeViewModel.getPinCode(Integer.parseInt(pincodeStr)).observe(RegistrationActivity.this, response ->{
                        if (response != null){
                            for (int i = 0; i < response.size(); i++){
                                PinCodeResponse pinCodeResponse = response.get(i);
                                if (pinCodeResponse.getStatus().contentEquals("Success")){
                                    for (int j = 0; j < pinCodeResponse.getPostOffice().size(); j++){
                                        PostOffice postOffice = pinCodeResponse.getPostOffice().get(j);
                                        districtTxt.setText(postOffice.getDistrict());
                                        stateTxt.setText(postOffice.getState());
                                        alertDialog.dismiss();
                                    }
                                }else {
                                    alertDialog.dismiss();
                                    districtTxt.setText(null);
                                    stateTxt.setText(null);
                                }
                            }
                        }else {
                            alertDialog.dismiss();
                            Log.e(TAG,"PincodeResponse is null");
                        }
                    });
                }
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mobileNumberStr = mobileNumberEdt.getText().toString();
                fullNameStr = fullNameEdt.getText().toString();
                genderStr = genderSpinnerTxt.getText().toString();
                dobStr = dobTxt.getText().toString();
                address1Str = addressLineOneEdt.getText().toString();
                address2Str = addressLineTwoEdt.getText().toString();
                pincodeStr = pincodeEdt.getText().toString();
                districtStr = districtTxt.getText().toString();
                stateStr = stateTxt.getText().toString();

                if (mobileNumberStr.isEmpty()){
                    mobileNumberEdt.setError("Enter mobile number");
                    mobileNumberEdt.requestFocus();
                }else if (!(mobileNumberStr.length() == 10)){
                    mobileNumberEdt.setError("Enter 10 digit mobile number");
                    mobileNumberEdt.requestFocus();
                } else if (fullNameStr.isEmpty()){
                    fullNameEdt.setError("Enter full name");
                    fullNameEdt.requestFocus();
                }else if (genderStr.equals("Select Gender")){
                    genderSpinnerTxt.setError("Select gender");
                    genderSpinnerTxt.requestFocus();
                }else if (dobStr.isEmpty()){
                    dobTxt.setError("Enter mobile number");
                    dobTxt.requestFocus();
                }else if (address1Str.isEmpty()){
                    addressLineOneEdt.setError("Enter address");
                    addressLineOneEdt.requestFocus();
                }else if (!(address1Str.length() >= 3)){
                    addressLineOneEdt.setError("Address must be greater then and equal to 3 character and lesser then 50 character");
                    addressLineOneEdt.requestFocus();
                }else if (pincodeStr.isEmpty()){
                    pincodeEdt.setError("Enter pincode");
                    pincodeEdt.requestFocus();
                }else if (!(pincodeStr.length() == 6)){
                    pincodeEdt.setError("Enter 6 digit pincode");
                    pincodeEdt.requestFocus();
                }else if (districtStr.isEmpty()){
                    districtTxt.setError("District can't be empty");
                    districtTxt.requestFocus();
                }else if (stateStr.isEmpty()){
                    stateTxt.setError("State can't be empty");
                    stateTxt.requestFocus();
                }else {
                    if (address2Str.isEmpty()){
                        address2Str = " ";
                    }
                    registerUser(mobileNumberStr,fullNameStr,genderStr,dobStr,address1Str,address2Str,pincodeStr,districtStr,stateStr);
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (sharedPreferences.isLoggedIn()) {
            startActivity(new Intent(getApplicationContext(),WeatherActivity.class));
            finish();
        }
    }

    private void createDialogBox() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.lodingbar,null);
        builder.setView(view);

        alertDialog = builder.setCancelable(false).create();
    }

    private void registerUser(String mobileNumberStr, String fullNameStr, String genderStr, String dobStr, String address1Str, String address2Str, String pincodeStr, String districtStr, String stateStr) {
        long phoneLong = Long.parseLong(mobileNumberStr);
        long pincode = Integer.parseInt(pincodeStr);

        UserDetails userDetails = new UserDetails(phoneLong,fullNameStr,genderStr,dobStr,address1Str,address2Str,pincode,districtStr,stateStr);
        userDetailsViewModel.addUserDetails(userDetails);
        sharedPreferences.savePhoneNumber(mobileNumberStr);
        startActivity(new Intent(getApplicationContext(),WeatherActivity.class));
        finish();
    }

    private void setUpUI() {
        sharedPreferences = new SharedPrefManager(this);
        userDetailsViewModel = new ViewModelProvider(this).get(UserDetailsViewModel.class);
        pinCodeViewModel = new ViewModelProvider(this).get(PinCodeViewModel.class);
        mobileNumberEdt = findViewById(R.id.mobileNumber);
        fullNameEdt = findViewById(R.id.fullName);
        addressLineOneEdt = findViewById(R.id.addressLineOneEdt);
        addressLineTwoEdt = findViewById(R.id.addressLineTwoEdt);
        pincodeEdt = findViewById(R.id.pincodeEdt);

        genderSpinnerTxt = findViewById(R.id.gender);
        dobTxt = findViewById(R.id.date_of_birth);
        districtTxt = findViewById(R.id.district);
        stateTxt = findViewById(R.id.state);


        pincodeCheckBtn = findViewById(R.id.pincodeCheckBtn);
        registerBtn = findViewById(R.id.resgister);
    }
}