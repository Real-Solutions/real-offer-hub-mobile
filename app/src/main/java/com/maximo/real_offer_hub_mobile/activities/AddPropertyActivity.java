package com.maximo.real_offer_hub_mobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.maximo.real_offer_hub_mobile.R;
import com.maximo.real_offer_hub_mobile.databinding.ActivityAddPropertyBinding;

public class AddPropertyActivity extends DrawerBaseActivity {

    ActivityAddPropertyBinding activityAddPropertyBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAddPropertyBinding = ActivityAddPropertyBinding.inflate(getLayoutInflater());
        setContentView(activityAddPropertyBinding.getRoot());
        allocateActivityTitle("Add Property");
    }
}