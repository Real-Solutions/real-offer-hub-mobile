package com.maximo.real_offer_hub_mobile.activities;

import androidx.appcompat.app.AppCompatActivity;
import com.maximo.real_offer_hub_mobile.R;
import com.maximo.real_offer_hub_mobile.databinding.ActivityOfferFormBinding;

import android.os.Bundle;



public class OfferFormActivity extends DrawerBaseActivity {

    ActivityOfferFormBinding activityOfferFormBinding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOfferFormBinding = ActivityOfferFormBinding.inflate(getLayoutInflater());
        setContentView(activityOfferFormBinding.getRoot());
        allocateActivityTitle("Submit Offer");
    }
}