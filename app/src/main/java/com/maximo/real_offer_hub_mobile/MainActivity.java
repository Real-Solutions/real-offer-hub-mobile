package com.maximo.real_offer_hub_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.maximo.real_offer_hub_mobile.activities.DataTest;


import com.maximo.real_offer_hub_mobile.activities.DrawerBaseActivity;
import com.maximo.real_offer_hub_mobile.databinding.ActivityMainBinding;

public class MainActivity extends DrawerBaseActivity {
    public static final String TAG = "mainActivity";
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        allocateActivityTitle("Main Activity");
    }

    @Override
    protected void onResume() {
        super.onResume();
//        setupButtons();
    }

//    public void setupButtons(){
//
//        Button goToDataTestButton = this.findViewById(R.id.MainActivityButtonDataTest);
//        goToDataTestButton.setOnClickListener(view ->
//            startActivity(new Intent(this, DataTest.class))
//        );
//    }
}