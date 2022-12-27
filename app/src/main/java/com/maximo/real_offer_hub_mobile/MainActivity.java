package com.maximo.real_offer_hub_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.maximo.real_offer_hub_mobile.activities.DrawerBaseActivity;
import com.maximo.real_offer_hub_mobile.databinding.ActivityMainBinding;

public class MainActivity extends DrawerBaseActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        allocateActivityTitle("Main Activity");
    }
}