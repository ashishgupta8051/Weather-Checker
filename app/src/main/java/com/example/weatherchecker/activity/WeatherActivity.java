package com.example.weatherchecker.activity;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.weatherchecker.R;
import com.example.weatherchecker.utils.SharedPrefManager;
import com.example.weatherchecker.viewmodel.WeatherDetailsViewModel;

public class WeatherActivity extends AppCompatActivity {
    private SharedPrefManager sharedPrefManager;
    private ImageView logoutImg,profileDetails;
    private EditText countryNameEdt;
    private Button checkBtn;
    private AutoCompleteTextView tempInCTxt,tempInFTxt,latitudeTxt,longitude;
    private String countryNameStr;
    private String key = "35c9f92ac5bf4df0811144140212307";
    private String aqi = "no";
    private WeatherDetailsViewModel weatherDetailsViewModel;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        setUpUI();

        logoutImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefManager.logout();
                startActivity(new Intent(getApplicationContext(),RegistrationActivity.class));
                finish();
            }
        });

        profileDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),UserDetailsActivity.class));
            }
        });

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countryNameStr = countryNameEdt.getText().toString();
                if (countryNameStr.isEmpty()){
                    countryNameEdt.setError("Enter country Name");
                    countryNameEdt.requestFocus();
                }else {
                    createDialogBox();
                    getDetails(countryNameStr);
                }
            }
        });

    }

    private void createDialogBox() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.lodingbar,null);
        builder.setView(view);

        alertDialog = builder.setCancelable(false).create();
        alertDialog.show();
    }

    @SuppressLint("SetTextI18n")
    private void getDetails(String countryNameStr) {
        weatherDetailsViewModel.getWeatherDetails(key,countryNameStr,aqi).observe(this,response ->{
            if (response != null){
                alertDialog.dismiss();
                tempInCTxt.setText(response.getCurrent().getTempC().toString());
                tempInFTxt.setText(response.getCurrent().getTempF().toString());
                latitudeTxt.setText(response.getLocation().getLat().toString());
                longitude.setText(response.getLocation().getLon().toString());
            }else {
                alertDialog.dismiss();
                tempInCTxt.setText(null);
                tempInFTxt.setText(null);
                latitudeTxt.setText(null);
                longitude.setText(null);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }

    private void setUpUI() {
        sharedPrefManager = new SharedPrefManager(this);

        weatherDetailsViewModel = new ViewModelProvider(this).get(WeatherDetailsViewModel.class);

        logoutImg = findViewById(R.id.logout);
        profileDetails = findViewById(R.id.details);

        countryNameEdt = findViewById(R.id.countryName);
        checkBtn = findViewById(R.id.checkButton);

        tempInCTxt = findViewById(R.id.tempinC);
        tempInFTxt = findViewById(R.id.tempinF);
        latitudeTxt = findViewById(R.id.latitude);
        longitude = findViewById(R.id.longitude);
    }
}