package com.maximo.real_offer_hub_mobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.maximo.real_offer_hub_mobile.R;
import com.maximo.real_offer_hub_mobile.databinding.ActivityOfferDetailBinding;

public class OfferDetailActivity extends DrawerBaseActivity {

    ActivityOfferDetailBinding activityOfferDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOfferDetailBinding = ActivityOfferDetailBinding.inflate(getLayoutInflater());
        setContentView(activityOfferDetailBinding.getRoot());
        allocateActivityTitle("Offer Details");
    }
}