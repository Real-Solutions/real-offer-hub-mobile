package com.maximo.real_offer_hub_mobile.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.maximo.real_offer_hub_mobile.R;
import com.maximo.real_offer_hub_mobile.databinding.ActivityClientsBinding;

public class ClientsActivity extends DrawerBaseActivity {

    ActivityClientsBinding activityClientsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityClientsBinding = ActivityClientsBinding.inflate(getLayoutInflater());
        setContentView(activityClientsBinding.getRoot());
        allocateActivityTitle("Clients");
    }

}