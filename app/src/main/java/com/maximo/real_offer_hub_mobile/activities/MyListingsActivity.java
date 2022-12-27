package com.maximo.real_offer_hub_mobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.maximo.real_offer_hub_mobile.R;
import com.maximo.real_offer_hub_mobile.databinding.ActivityMyListingsBinding;

public class MyListingsActivity extends DrawerBaseActivity {

    ActivityMyListingsBinding activityMyListingsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMyListingsBinding = ActivityMyListingsBinding.inflate(getLayoutInflater());
        setContentView(activityMyListingsBinding.getRoot());
        allocateActivityTitle("My Listings");
    }
}