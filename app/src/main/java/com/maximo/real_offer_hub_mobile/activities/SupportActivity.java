package com.maximo.real_offer_hub_mobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.maximo.real_offer_hub_mobile.R;
import com.maximo.real_offer_hub_mobile.databinding.ActivitySupportBinding;

public class SupportActivity extends DrawerBaseActivity {

    ActivitySupportBinding activitySupportBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySupportBinding = ActivitySupportBinding.inflate(getLayoutInflater());
        setContentView(activitySupportBinding.getRoot());
        allocateActivityTitle("Support");
    }
}